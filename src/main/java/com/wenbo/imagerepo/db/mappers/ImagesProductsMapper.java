package com.wenbo.imagerepo.db.mappers;

import com.wenbo.imagerepo.db.po.ImagesProducts;

import java.util.List;

public interface ImagesProductsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ImagesProducts record);

    int insertSelective(ImagesProducts record);

    ImagesProducts selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ImagesProducts record);

    int updateByPrimaryKey(ImagesProducts record);

    int deductStock(Long productId);

    int lockStock(Long productId);

    List<ImagesProducts> queryImageProductsByUserId(int userId);
}