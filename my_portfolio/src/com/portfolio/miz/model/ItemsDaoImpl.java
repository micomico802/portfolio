package com.portfolio.miz.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

public class ItemsDaoImpl implements ItemsDao {
    protected Connection conn = null;
    protected PreparedStatement ps = null;
    protected ResultSet rset = null;


    public ItemsDaoImpl(Connection conn) throws ServletException {
        this.conn = conn;
    }
    @Override
    public boolean doInsert(Items items){
        boolean isResult = false;
        int resultCounter = 0;

        StringBuffer sql = new StringBuffer();
        sql.append("INSERT INTO items_master VALUES(" );
        sql.append(items.getItemId());
        sql.append(", '" + items.getItemName() + "'");
        sql.append(", '" + items.getArrivalDate() + "'");
        sql.append(", '" + items.getMakerName() + "' );");
        System.out.println(sql);

        try {
        ps = conn.prepareStatement(new String(sql));
        resultCounter = ps.executeUpdate();

        if(resultCounter != 0) {
            isResult = true;
        }

        }catch(SQLException e) {
            e.printStackTrace();
        }
        return isResult;
    }

    @Override
    public boolean doUpdate(Items items){
        StringBuffer sql = new StringBuffer();
        boolean isResult = false;

        sql.append("UPDATE items_master SET item_name = '");
        sql.append(items.getItemName() + "'");
        sql.append(", arrival_date = '" + items.getArrivalDate() + "'");
        sql.append(", maker_name = '" + items.getMakerName() + "'");
        sql.append(" where item_id = " + items.getItemId() + ";");
        System.out.println(sql);

        try {
        ps = conn.prepareStatement(new String(sql));
        int resultCounter = ps.executeUpdate();

        if(resultCounter != 0) {
            isResult = true;
        }

        }catch(SQLException e) {
            e.printStackTrace();
        }
        return isResult;
    }

    @Override
    public boolean doDelete(String itemId) {
        boolean isResult = false;

        String sql = "DELETE FROM items_master WHERE item_id = " + itemId;
        System.out.println(sql);

        try {
        ps = conn.prepareStatement(new String(sql));
        int resultCounter = ps.executeUpdate();

        if(resultCounter != 0) {
            isResult = true;
        }

        }catch(SQLException e) {
            e.printStackTrace();
        }
        return isResult;
    }

    @Override
    public List<Items> fetch(Items items){
        StringBuffer sql = new StringBuffer();
        List<Items> list = new ArrayList<Items>();

        sql.append("select * from items_master where item_name like '%");
        sql.append(items.getItemName() + "%'");

        if(items.getItemId() != "") {
            sql.append("and item_id =" + items.getItemId());
        }

        if(items.getMakerName() != "") {
            sql.append("and maker_name = '" + items.getMakerName() + "'" );
        }
        sql.append("order by item_id;" );

        System.out.println(sql);

        try {
            ps = conn.prepareStatement(new String(sql));
            ps.execute();
            rset = ps.executeQuery();

            while(rset.next()) {
                Items itemsSearch = new Items();
                       itemsSearch.setItemId(String.valueOf(rset.getLong("item_id")));
                       itemsSearch.setItemName(rset.getString("item_name"));
                       itemsSearch.setArrivalDate(String.valueOf(rset.getTimestamp("arrival_date")));
                       itemsSearch.setMakerName(rset.getString("maker_name"));
               list.add(itemsSearch);
            }

        }catch(SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
