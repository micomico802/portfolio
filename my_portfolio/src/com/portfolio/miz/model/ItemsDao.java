package com.portfolio.miz.model;

import java.util.List;

public interface ItemsDao {
    public int doInsert(Items items) throws Exception;
    public int doUpdate(Items items) throws Exception;
    public int doDelete(String itemId) throws Exception;
    public List<Items> fetch(Items items) throws Exception;
}
