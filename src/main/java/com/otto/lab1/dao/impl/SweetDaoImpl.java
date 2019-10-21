package com.otto.lab1.dao.impl;

import com.otto.lab1.dao.SweetDao;
import com.otto.lab1.model.Candy;
import com.otto.lab1.model.Sweet;
import com.otto.lab1.model.Sweetness;
import org.apache.log4j.Logger;

import java.lang.invoke.MethodHandles;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SweetDaoImpl implements SweetDao {

    private static final Logger LOG = Logger.getLogger(MethodHandles.lookup().lookupClass());

    private Connection connection;

    private static final String TABLE_NAME = "sweets";

    private static final String ID_COLUMN = "id";
    private static final String NAME_COLUMN = "name";
    private static final String WEIGHT_COLUMN = "weight";
    private static final String SUGAR_COLUMN = "sugarpercent";
    private static final String CHOCOLATE_COLUMN = "ischocolate";
    private static final String GIFT_ID_COLUMN = "nygift_id";

    private static final String PERSIST_ALL_SWEETS = "INSERT INTO sweets" +
            " (name, weight, sugarpercent, ischocolate, nygift_id)" +
            " VALUES (?, ?, ?, ?, ?);";

    private static final String UPDATE_SWEET = "UPDATE sweets " +
            "SET name = ?, weight = ?, sugarpercent = ?, ischocolate = ?, nygift_id = ? " +
            "WHERE id = ?;";

    private static final String DELETE_SWEET = "DELETE FROM sweets " +
            "WHERE id = ?;";

    private static final String GET_SWEETS_BY_GIFT_ID = "SELECT * FROM sweets " +
            "WHERE nygift_id = ?;";


    public SweetDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void persistSweets(List<Sweetness> sweetnesses, int giftId) {

        try (PreparedStatement statement = connection.prepareStatement(PERSIST_ALL_SWEETS,
                Statement.RETURN_GENERATED_KEYS)) {

            List<Sweet> sweets = sweetnesses.stream().
                    filter(s -> s instanceof Sweet).
                    map(s -> (Sweet) s).
                    collect(Collectors.toList());

            for (Sweet sweet : sweets) {

                statement.setString(1, sweet.getName());
                statement.setInt(2, sweet.getWeightInGr());
                statement.setDouble(3, sweet.getSugarPerCent());
                statement.setBoolean(4, sweet.isChocolate());
                statement.setInt(5, giftId);
                statement.executeUpdate();

            }

        } catch (SQLException e) {
            LOG.error("Could not persist sweets!");
        }
    }

    @Override
    public void updateSweet(Sweet sweet) {

        try (PreparedStatement statement = connection.prepareStatement(UPDATE_SWEET)) {

            statement.setString(1, sweet.getName());
            statement.setInt(2, sweet.getWeightInGr());
            statement.setDouble(3, sweet.getSugarPerCent());
            statement.setBoolean(4, sweet.isChocolate());
            statement.setInt(5, sweet.getGiftId());
            statement.setInt(6, sweet.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            LOG.error("Could not update sweet " + sweet.getId());
        }

    }

    @Override
    public void deleteSweet(int id) {

        try (PreparedStatement statement = connection.prepareStatement(DELETE_SWEET)) {

            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            LOG.error("Could not delete sweet" + id);
        }
    }

    @Override
    public List<Sweet> getSweetsByGiftId(int id) {

        List<Sweet> sweets = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(GET_SWEETS_BY_GIFT_ID)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Sweet sweet = new Sweet();
                sweet.setId(resultSet.getInt(ID_COLUMN));
                sweet.setName(resultSet.getString(NAME_COLUMN));
                sweet.setWeightInGr(resultSet.getInt(WEIGHT_COLUMN));
                sweet.setSugarPerCent(resultSet.getDouble(SUGAR_COLUMN));
                sweet.setChocolate(resultSet.getBoolean(CHOCOLATE_COLUMN));
                sweet.setGiftId(id);

                sweets.add(sweet);
            }

        } catch (SQLException e) {
            LOG.error("Could not get sweets");
        }
        return sweets;
    }
}
