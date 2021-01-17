package com.wenbo.imagerepo.db.mappers;

import com.wenbo.imagerepo.db.po.Users;

import java.util.List;

public interface UsersMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    List<Users> selectAllUsers();

    Users selectByUsername(String username);
}