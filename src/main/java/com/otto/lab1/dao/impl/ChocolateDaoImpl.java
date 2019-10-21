package com.otto.lab1.dao.impl;

import com.otto.lab1.dao.ChocolateDao;
import com.otto.lab1.model.Candy;
import com.otto.lab1.model.Chocolate;
import com.otto.lab1.model.Sweetness;
import org.apache.log4j.Logger;

import java.lang.invoke.MethodHandles;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChocolateDaoImpl implements ChocolateDao {

    private static final Logger LOG = Logger.getLogger(MethodHandles.lookup().lookupClass());

    private Connection connection;

    private static final String TABLE_NAME = "chocolates";

    private static final String ID_COLUMN = "id";
    private static final String NAME_COLUMN = "name";
    private static final String WEIGHT_COLUMN = "weight";
    private static final String SUGAR_COLUMN = "sugarpercent";
    private static final String COCOA_COLUMN = "cocoapercent";
    private static final String FILLER_COLUMN = "hasfiller";
    private static final String GIFT_ID_COLUMN = "nygift_id";

    private static final String PERSIST_ALL_CHOCOLATES = "INSERT INTO chocolates" +
            " (name, weight, sugarpercent, cocoapercent, hasfiller, nygift_id)" +
            " VALUES (?, ?, ?, ?, ?, ?);";

    private static final String UPDATE_CHOCOLATE = "UPDATE chocolates " +
            "SET name = ?, weight = ?, sugarpercent = ?, cocoapercent = ?, hasfiller = ?, nygift_id = ? " +
            "WHERE id = ?;";

    private static final String DELETE_CHOCOLATE = "DELETE FROM chocolates " +
            "WHERE id = ?;";

    private static final String GET_CHOCOLATES_BY_GIFT_ID = "SELECT * FROM chocolates " +
            "WHERE nygift_id = ?;";


    public ChocolateDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void persistChocolates(List<Sweetness> sweetnesses, int giftId) {

        try (PreparedStatement statement = connection.prepareStatement(PERSIST_ALL_CHOCOLATES,
                Statement.RETURN_GENERATED_KEYS)) {

            List<Chocolate> chocolates = sweetnesses.stream().
                    filter(s -> s instanceof Chocolate).
                    map(s -> (Chocolate) s).
                    collect(Collectors.toList());

            for (Chocolate chocolate : chocolates) {

                statement.setString(1, chocolate.getName());
                statement.setInt(2, chocolate.getWeightInGr());
                statement.setDouble(3, chocolate.getSugarPerCent());
                statement.setDouble(4, chocolate.getCocoaPercent());
                statement.setBoolean(5, chocolate.isHasFiller());
                statement.setInt(6, giftId);
                statement.executeUpdate();

            }

        } catch (SQLException e) {
            LOG.error("Could not persist chocolates!");
        }
    }

    @Override
    public void updateChocolate(Chocolate chocolate) {

        try (PreparedStatement statement = connection.prepareStatement(UPDATE_CHOCOLATE)) {

            statement.setString(1, chocolate.getName());
            statement.setInt(2, chocolate.getWeightInGr());
            statement.setDouble(3, chocolate.getSugarPerCent());
            statement.setDouble(4, chocolate.getCocoaPercent());
            statement.setBoolean(5, chocolate.isHasFiller());
            statement.setInt(6, chocolate.getGiftId());
            statement.setInt(7, chocolate.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            LOG.error("Could not update candy " + chocolate.getId());
        }
    }

    @Override
    public void deleteChocolate(int id) {

        try (PreparedStatement statement = connection.prepareStatement(DELETE_CHOCOLATE)) {

            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            LOG.error("Could not delete chocolate" + id);
        }
    }

    @Override
    public List<Chocolate> getChocolatesByGiftId(int id) {

        List<Chocolate> chocolates = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(GET_CHOCOLATES_BY_GIFT_ID)){

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Chocolate chocolate = new Chocolate();
                chocolate.setId(resultSet.getInt(ID_COLUMN));
                chocolate.setName(resultSet.getString(NAME_COLUMN));
                chocolate.setWeightInGr(resultSet.getInt(WEIGHT_COLUMN));
                chocolate.setSugarPerCent(resultSet.getDouble(SUGAR_COLUMN));
                chocolate.setCocoaPercent(resultSet.getDouble(COCOA_COLUMN));
                chocolate.setHasFiller(resultSet.getBoolean(FILLER_COLUMN));
                chocolate.setGiftId(id);

                chocolates.add(chocolate);
            }

        } catch (SQLException e) {
            LOG.error("Could not get chocolates");
        }
        return chocolates;
    }
}
