package com.portfolio.miz.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

public class ItemDao {
    protected Connection conn = null;
    protected PreparedStatement ps = null;
    protected ResultSet rset = null;


    public ItemDao() throws ServletException,
        ClassNotFoundException,
        SQLException,
        Exception{
        DBConnector connection = new DBConnector();
        conn = connection.connect();
    }

    public int doInsert(ItemBeans beans)  throws Exception{
        StringBuffer sql = new StringBuffer();
        int resultCounter;

        sql.append("INSERT INTO items_master VALUES(" );
        sql.append(beans.getItemId());
        sql.append(", '" + beans.getItemName() + "'");
        sql.append(", '" + beans.getArrivalDate() + "'");
        sql.append(", '" + beans.getMakerName() + "' );");
        System.out.println(sql);

        ps = conn.prepareStatement(new String(sql));
        resultCounter = ps.executeUpdate();
        return resultCounter;
    }

    public int doUpdate(ItemBeans beans)  throws Exception{
        StringBuffer sql = new StringBuffer();
        int resultCounter;

        sql.append("UPDATE items_master SET item_name = '");
        sql.append(beans.getItemName() + "'");
        sql.append(", arrival_date = '" + beans.getArrivalDate() + "'");
        sql.append(", maker_name = '" + beans.getMakerName() + "'");
        sql.append(" where item_id = " + beans.getItemId() + ";");
        System.out.println(sql);

        ps = conn.prepareStatement(new String(sql));
        resultCounter = ps.executeUpdate();
        return resultCounter;

    }

    public int doDelete(String itemId) throws Exception{
        String sql = "DELETE FROM items_master WHERE item_id = " + itemId;
        System.out.println(sql);

        int resultCounter;

        ps = conn.prepareStatement(sql);
        resultCounter = ps.executeUpdate();
        return resultCounter;
    }

    public List<ItemBeans> fetch(ItemBeans itemBeans) throws Exception{
        StringBuffer sql = new StringBuffer();
        List<ItemBeans> list = new ArrayList<ItemBeans>();

        sql.append("select * from items_master where item_name like '%");
        sql.append(itemBeans.getItemName() + "%'");

        if(itemBeans.getItemId() != "") {
            sql.append("and item_id =" + itemBeans.getItemId());
        }

        if(itemBeans.getMakerName() != "") {
            sql.append("and maker_name = '" + itemBeans.getMakerName() + "'" );
        }
        sql.append("order by item_id;" );

        System.out.println(sql);

        ps = conn.prepareStatement(new String(sql));
        ps.execute();
        rset = ps.executeQuery();

        while(rset.next()) {
            ItemBeans beans = new ItemBeans();
                   beans.setItemId(String.valueOf(rset.getLong("item_id")));
                   beans.setItemName(rset.getString("item_name"));
                   beans.setArrivalDate(String.valueOf(rset.getTimestamp("arrival_date")));
                   beans.setMakerName(rset.getString("maker_name"));
           list.add(beans);
        }

        return list;
    }
}
