package com.sawan.dao;

import com.sawan.model.LoginModel;
import com.sawan.model.RegisterModel;
import util.Constant;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginDao {

    public List<LoginModel> loginUser(String id,String pass) {
        var list=new ArrayList<LoginModel>();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBConnection.createConnection();
            String query = "SELECT * FROM "+Constant.TableName+" WHERE email=? and password=?";
            ps = con.prepareStatement(query);
            ps.setString(1,id);
            ps.setString(2,pass);
            var rs=ps.executeQuery();
            if(rs.next()){
                list.add(new LoginModel(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}