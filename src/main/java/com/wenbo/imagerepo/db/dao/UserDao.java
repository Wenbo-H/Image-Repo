package com.wenbo.imagerepo.db.dao;

import com.wenbo.imagerepo.db.po.Users;

import java.util.List;

public interface UserDao {
    public List<Users> selectAllUsers();
}
