package com.portfolio.miz.model;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;

public class DBConnector {
    DataSource ds;

    public void init() throws ServletException{
        try {
            InitialContext ic = new InitialContext();

            ds = (DataSource) ic.lookup("java:comp/env/jdbc/items");
        }catch(NamingException e) {
            e.printStackTrace();
        }
    }
    //SQL実行用変数
    protected Connection conn = null;

    public  Connection connect() throws ServletException {
        init();
        try {
            conn = ds.getConnection();
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void destory(Connection conn)
            throws ServletException {
        this.conn = conn;
        try {
            if(conn != null) conn.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
     }
}
