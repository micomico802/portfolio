package com.portfolio.miz.model;

import java.util.List;

public interface ItemsDao {
    public boolean doInsert(Items items);
    public boolean doUpdate(Items items);
    public boolean doDelete(String itemId);
    public List<Items> fetch(Items items);
}
