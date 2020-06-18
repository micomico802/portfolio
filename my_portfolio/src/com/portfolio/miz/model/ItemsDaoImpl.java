package com.portfolio.miz.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public int doInsert(Items items) throws Exception{
        StringBuffer sql = new StringBuffer();
        int resultCounter;

        sql.append("INSERT INTO items_master VALUES(" );
        sql.append(items.getItemId());
        sql.append(", '" + items.getItemName() + "'");
        sql.append(", '" + items.getArrivalDate() + "'");
        sql.append(", '" + items.getMakerName() + "' );");
        System.out.println(sql);

        ps = conn.prepareStatement(new String(sql));
        resultCounter = ps.executeUpdate();
        return resultCounter;
    }

    @Override
    public int doUpdate(Items items) throws Exception {
        StringBuffer sql = new StringBuffer();
        int resultCounter;

        sql.append("UPDATE items_master SET item_name = '");
        sql.append(items.getItemName() + "'");
        sql.append(", arrival_date = '" + items.getArrivalDate() + "'");
        sql.append(", maker_name = '" + items.getMakerName() + "'");
        sql.append(" where item_id = " + items.getItemId() + ";");
        System.out.println(sql);

        ps = conn.prepareStatement(new String(sql));
        resultCounter = ps.executeUpdate();
        return resultCounter;
    }

    @Override
    public int doDelete(String itemId) throws Exception {
        String sql = "DELETE FROM items_master WHERE item_id = " + itemId;
        System.out.println(sql);

        int resultCounter;

        ps = conn.prepareStatement(sql);
        resultCounter = ps.executeUpdate();
        return resultCounter;
    }

    @Override
    public List<Items> fetch(Items items) throws Exception {
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

        return list;
    }

}
