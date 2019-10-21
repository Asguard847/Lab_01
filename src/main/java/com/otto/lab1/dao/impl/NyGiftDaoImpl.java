package com.otto.lab1.dao.impl;

import com.otto.lab1.dao.*;
import com.otto.lab1.model.NYGift;
import com.otto.lab1.model.Sweetness;
import org.apache.log4j.Logger;

import java.lang.invoke.MethodHandles;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NyGiftDaoImpl implements NyGiftDao {

    private static final Logger LOG = Logger.getLogger(MethodHandles.lookup().lookupClass());

    private CandyDao candyDao;
    private ChocolateDao chocolateDao;
    private SweetDao sweetDao;

    private static final String GET_NYGIFT = "SELECT * FROM nygifts WHERE id = ?";
    private static final String INSERT_NYGIFT = "INSERT INTO nygifts" +
            " (totalweight) VALUES (?);";

    public NyGiftDaoImpl(CandyDao candyDao,
                         ChocolateDao chocolateDao,
                         SweetDao sweetDao) {
        this.candyDao = candyDao;
        this.chocolateDao = chocolateDao;
        this.sweetDao = sweetDao;
    }

    @Override
    public int persistNyGift(NYGift gift, Connection connection) {

        List<Sweetness> sweetnesses = gift.getGiftContents();
        int giftId = -1;

        try {

            connection.setAutoCommit(false);
            LOG.info("Got database connection");

            giftId = persistWeightGetId(gift.getTotalWeightInGr(), connection);
            LOG.info("NyGift weight persisted. Gift id = " + giftId);

            candyDao.persistCandys(sweetnesses, giftId);
            LOG.info("Candys persisted");

            chocolateDao.persistChocolates(sweetnesses, giftId);
            LOG.info("Chocolates persisted");

            sweetDao.persistSweets(sweetnesses, giftId);
            LOG.info("Sweets persisted");

            connection.commit();
            connection.setAutoCommit(true);

        } catch (SQLException e) {
            LOG.error(e.getMessage());
        }
        return giftId;
    }

    @Override
    public NYGift getNYGift(int id, Connection connection) {

        NYGift gift = null;

        try (PreparedStatement statement = connection.prepareStatement(GET_NYGIFT)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                gift = new NYGift();
                gift.setGiftId(id);
                gift.setTotalWeightInGr(resultSet.getInt("totalweight"));
                gift.setGiftContents(getGiftContents(id));
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        }
        return gift;
    }

    private int persistWeightGetId(int weight, Connection connection) throws SQLException {

        int autoIncKey = -1;

        try(PreparedStatement statement = connection.prepareStatement(INSERT_NYGIFT,
                Statement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, weight);
            statement.executeUpdate();


            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                autoIncKey = resultSet.getInt(1);
            } else {
                throw new SQLException("Could not get auto generated key");
            }
            return autoIncKey;
        }catch (SQLException e){
            LOG.error(e.getMessage());
        }
        return autoIncKey;
    }

    private List<Sweetness> getGiftContents(int id){

        List<Sweetness> giftContents = new ArrayList<>();
        giftContents.addAll(candyDao.getCandysByGiftId(id));
        giftContents.addAll(chocolateDao.getChocolatesByGiftId(id));
        giftContents.addAll(sweetDao.getSweetsByGiftId(id));
        return giftContents;

    }

}
