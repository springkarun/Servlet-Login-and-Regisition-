package com.sawan.dao;

import com.sawan.model.RegisterModel;
import util.Constant;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {

    public String registerUser(RegisterModel model) {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        try {
            con = DBConnection.createConnection();
            String query = "insert into "+Constant.TableName+" values(?,?,?,?,?,?,?,?,?,?)";
            preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data


            preparedStatement.setString(1, model.getUser_id());
            preparedStatement.setString(2, model.getFname());
            preparedStatement.setString(3, model.getLname());
            preparedStatement.setString(4, model.getEmail());
            preparedStatement.setString(5, model.getMobile());
            preparedStatement.setInt(6, Integer.parseInt(model.getAge()));
            preparedStatement.setString(7, model.getSex());
            preparedStatement.setString(8, model.getPassword());
            preparedStatement.setString(9, model.getCity());
            preparedStatement.setString(10, model.getAddress());

            int i = preparedStatement.executeUpdate();
            if (i != 0)
                return "SUCCESS";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
    }
}