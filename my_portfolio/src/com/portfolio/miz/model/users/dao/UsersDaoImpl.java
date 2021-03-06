package com.portfolio.miz.model.users.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;

import com.portfolio.miz.model.users.entity.Users;

public class UsersDaoImpl implements UsersDao {
    protected Connection conn;
    protected PreparedStatement ps;
    protected ResultSet rset;

    public UsersDaoImpl(Connection conn) throws ServletException {
        this.conn = conn;
    }

    @Override
    public Users fetch(String userId, String password) {
        Users users = null;

        String sql = "SELECT * FROM users_master WHERE "
                + "login_address = ? "
                + "AND login_password = ?"
                + "AND deleted_at IS NULL ;";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, userId);
            ps.setString(2, password);
            rset = ps.executeQuery();

            while (rset.next()) {
                users = new Users();
                users.setLoginAddress(rset.getString("login_address"));
                users.setLoginPassword(rset.getString("login_password"));
                users.setUserName(rset.getString("user_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return users;
    }

    @Override
    public boolean registrationCheck(Users users) {
        String sql = "SELECT * FROM users_master WHERE login_address = ? ;";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, users.getLoginAddress());
            rset = ps.executeQuery();

            if (rset.next()) {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return true;
    }

    @Override
    public boolean doInsert(Users users) {
        boolean isResult = false;
        int resultCounter = 0;

        String sql = "INSERT INTO users_master("
                + "login_address, "
                + "login_password, "
                + "user_name"
                + ") VALUES (?, ?, ?)";

        try {
            ps = conn.prepareStatement(new String(sql));
            ps.setString(1, users.getLoginAddress());
            ps.setString(2, users.getLoginPassword());
            ps.setString(3, users.getUserName());
            resultCounter = ps.executeUpdate();

            if (resultCounter != 0) {
                isResult = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isResult;
    }

}
