package com.wenbo.imagerepo.db.dao;

import com.wenbo.imagerepo.db.mappers.ImagesProductsMapper;
import com.wenbo.imagerepo.db.po.ImagesProducts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;


@Slf4j
@Repository
public class InventoryDaoImpl implements InventoryDao{

    @Resource
    private ImagesProductsMapper ImagesProductsMapper;

    @Override
    public List<ImagesProducts> queryImageProductsByUserId(int userId){
        return ImagesProductsMapper.queryImageProductsByUserId(userId);
    }

    @Override
    public void insertImagesProducts(ImagesProducts imagesProducts) {
        ImagesProductsMapper.insert(imagesProducts);
    }

    @Override
    public ImagesProducts queryImagesProductsById(long productId) {
        return ImagesProductsMapper.selectByPrimaryKey(productId);
    }

    @Override
    public void updateImagesProductsById(ImagesProducts imagesProducts) {
        ImagesProductsMapper.updateByPrimaryKey(imagesProducts);
    }

    @Override
    public boolean lockStock(Long productId) {
        int result = ImagesProductsMapper.lockStock(productId);
        if (result < 1) {
            log.error("Sorry, this stock can't be locked now");
            return false;
        }
        return true;
    }

    @Override
    public boolean deductStock(Long productId) {
        int result = ImagesProductsMapper.deductStock(productId);
        if (result < 1) {
            log.error("Failed to deduct products");
            return false;
        } return true;
    }
}
