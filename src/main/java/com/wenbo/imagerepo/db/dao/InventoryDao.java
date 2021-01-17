package com.wenbo.imagerepo.db.dao;

import com.wenbo.imagerepo.db.po.ImagesProducts;

import java.util.List;

public interface InventoryDao{

    public void insertImagesProducts(ImagesProducts imagesProducts);

    public ImagesProducts queryImagesProductsById(long productId);

    public void updateImagesProductsById(ImagesProducts imagesProducts);

    public boolean lockStock(Long productId);

    public boolean deductStock(Long productId);

    public List<ImagesProducts> queryImageProductsByUserId(int userId);



}