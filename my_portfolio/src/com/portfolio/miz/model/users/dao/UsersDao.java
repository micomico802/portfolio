package com.portfolio.miz.model.users.dao;

import com.portfolio.miz.model.users.entity.Users;

public interface UsersDao {
    public boolean registrationCheck(Users users);
    public boolean doInsert(Users users);
}
