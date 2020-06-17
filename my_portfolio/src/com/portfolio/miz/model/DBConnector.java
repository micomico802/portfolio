package com.portfolio.miz.model;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.sql.DataSource;

public class DBConnector {
    DataSource ds;

    public void init() throws ServletException{
        try {
            InitialContext ic = new InitialContext();

            ds = (DataSource) ic.lookup("java:comp/env/jdbc/items");
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    //SQL実行用変数
    protected Connection conn = null;

    public Connection connect()
        throws ServletException,
        ClassNotFoundException,
        SQLException,
        Exception{
        init();
        conn = ds.getConnection();

        return conn;
    }

    public void dbClose(Connection conn)
            throws ServletException,
            SQLException,
            Exception{
        this.conn = conn;
            if(conn != null) conn.close();
     }
}
