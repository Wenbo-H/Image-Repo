package com.wenbo.imagerepo;

import com.wenbo.imagerepo.db.dao.InventoryDao;
import com.wenbo.imagerepo.db.dao.UserDao;
import com.wenbo.imagerepo.db.mappers.ImagesProductsMapper;
import com.wenbo.imagerepo.db.mappers.UsersMapper;
import com.wenbo.imagerepo.db.po.ImagesProducts;
import com.wenbo.imagerepo.db.po.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class DaoTest {
    @Resource
    private ImagesProductsMapper imagesProductsMapper;

    @Autowired
    private InventoryDao inventoryDao;

    @Test
    void ImagesProductsTest() {
        ImagesProducts imagesProducts = new ImagesProducts();
        imagesProducts.setCommodityName("hello");
        imagesProducts.setCommodityDesc("this is a very beautiful picture");
        imagesProducts.setCommodityPrice(1000L);
        imagesProducts.setImagePath("abcdefg");
        imagesProducts.setSellId(20);
        imagesProducts.setTotalStock(100L);
        imagesProducts.setAvailableStock(100);
        imagesProducts.setLockStock(0L);
        imagesProductsMapper.insert(imagesProducts);
        System.out.println("====>>>>" +
                imagesProductsMapper.selectByPrimaryKey(2L));
    }

    @Test
    void setSeckillActivityQuery(){
        List<ImagesProducts> imagesProducts =
                inventoryDao.queryImageProductsByUserId(20);
        System.out.println(imagesProducts.size());
        imagesProducts.stream().forEach(imagesProduct ->
                System.out.println(imagesProduct.toString()));
    }

    @Autowired
    private UserDao userDao;

    @Resource
    private UsersMapper usersMapper;

    @Test
    void addAnUser(){
        Users testUser = new Users();
        testUser.setUserRole(0);
        testUser.setUserName("Zhixian");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        testUser.setPassword(encoder.encode("li"));
        testUser.setUserId(2);
        usersMapper.insert(testUser);
    }
}

