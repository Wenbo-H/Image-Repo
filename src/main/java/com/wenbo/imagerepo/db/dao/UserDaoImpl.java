package com.wenbo.imagerepo.db.dao;


import com.wenbo.imagerepo.db.mappers.UsersMapper;
import com.wenbo.imagerepo.db.po.Users;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao{
    @Resource
    private UsersMapper usersMapper;

    @Override
    public List<Users> selectAllUsers(){
        return usersMapper.selectAllUsers();
    }

}
