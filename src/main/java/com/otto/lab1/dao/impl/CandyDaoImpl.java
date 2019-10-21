package com.otto.lab1.dao.impl;

import com.otto.lab1.dao.CandyDao;
import com.otto.lab1.model.Candy;
import com.otto.lab1.model.Sweetness;
import org.apache.log4j.Logger;

import java.lang.invoke.MethodHandles;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CandyDaoImpl implements CandyDao {

    private static final Logger LOG = Logger.getLogger(MethodHandles.lookup().lookupClass());

    private Connection connection;

    private static final String TABLE_NAME = "candys";

    private static final String ID_COLUMN = "id";
    private static final String NAME_COLUMN = "name";
    private static final String WEIGHT_COLUMN = "weight";
    private static final String SUGAR_COLUMN = "sugarpercent";
    private static final String STICK_COLUMN = "hasstick";
    private static final String GIFT_ID_COLUMN = "nygift_id";

    private static final String PERSIST_ALL_CANDYS = "INSERT INTO candys" +
            " (name, weight, sugarpercent, hasstick, nygift_id)" +
            " VALUES (?, ?, ?, ?, ?);";

    private static final String UPDATE_CANDY = "UPDATE candys " +
            "SET name = ?, weight = ?, sugarpercent = ?, hasstick = ?, nygift_id = ? " +
            "WHERE id = ?;";

    private static final String DELETE_CANDY = "DELETE FROM candys "+
            "WHERE id = ?;";

    private static final String GET_CANDYS_BY_GIFT_ID = "SELECT * FROM candys " +
        "WHERE nygift_id = ?;";


    public CandyDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void persistCandys(List<Sweetness> sweetnesses, int giftId) {

        try (PreparedStatement statement = connection.prepareStatement(PERSIST_ALL_CANDYS,
                Statement.RETURN_GENERATED_KEYS)) {

            List<Candy> candies = sweetnesses.stream().
                    filter(s -> s instanceof Candy).
                    map(s -> (Candy) s).
                    collect(Collectors.toList());

            for (Candy candy : candies) {

                statement.setString(1, candy.getName());
                statement.setInt(2, candy.getWeightInGr());
                statement.setDouble(3, candy.getSugarPerCent());
                statement.setBoolean(4, candy.isHasStick());
                statement.setInt(5, giftId);
                statement.executeUpdate();

            }

        } catch (SQLException e) {
            LOG.error("Could not persist candies!");
        }
    }

    @Override
    public void updateCandy(Candy candy) {

        try (PreparedStatement statement = connection.prepareStatement(UPDATE_CANDY)) {

            statement.setString(1, candy.getName());
            statement.setInt(2, candy.getWeightInGr());
            statement.setDouble(3, candy.getSugarPerCent());
            statement.setBoolean(4, candy.isHasStick());
            statement.setInt(5, candy.getGiftId());
            statement.setInt(6, candy.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            LOG.error("Could not update candy " + candy.getId());
        }

    }

    @Override
    public void deleteCandy(int id) {

        try (PreparedStatement statement = connection.prepareStatement(DELETE_CANDY)) {

            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            LOG.error("Could not delete candy" + id);
        }
    }

    @Override
    public List<Candy> getCandysByGiftId(int id) {

        List<Candy> candies = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(GET_CANDYS_BY_GIFT_ID)){

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Candy candy = new Candy();
                candy.setId(resultSet.getInt(ID_COLUMN));
                candy.setName(resultSet.getString(NAME_COLUMN));
                candy.setWeightInGr(resultSet.getInt(WEIGHT_COLUMN));
                candy.setSugarPerCent(resultSet.getDouble(SUGAR_COLUMN));
                candy.setHasStick(resultSet.getBoolean(STICK_COLUMN));
                candy.setGiftId(id);

                candies.add(candy);
            }

        } catch (SQLException e) {
            LOG.error("Could not get candies");
        }
        return candies;
    }

}
