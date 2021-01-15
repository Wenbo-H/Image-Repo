package com.wenbo.imagerepo.db.mappers;

import com.wenbo.imagerepo.db.po.ImagesProducts;

public interface ImagesProductsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ImagesProducts record);

    int insertSelective(ImagesProducts record);

    ImagesProducts selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ImagesProducts record);

    int updateByPrimaryKey(ImagesProducts record);
}