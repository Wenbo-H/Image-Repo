package com.wenbo.imagerepo.web;

import com.wenbo.imagerepo.db.dao.InventoryDao;
import com.wenbo.imagerepo.db.mappers.UsersMapper;
import com.wenbo.imagerepo.db.po.ImagesProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Map;


@Controller
public class ImageProductsController {
//    public String addImagesProducts(@PathVariable String userid) {

    @RequestMapping("/addimages")
    public String addImagesProducts(Authentication auth, Model model) {
        System.out.println("hello world, 你是shui");
        String user_name = auth.getName();
        System.out.println(user_name);
        model.addAttribute("user_name", user_name);
        if(user_name.equals("Wenbo")){
            return "add_images";
        }
        return "hello";
    }

    @Autowired
    private InventoryDao inventoryDao;
    @Resource
    private UsersMapper usersMapper;
    @RequestMapping("/addImageProductAction")
    public String addImageProductAction(
            @RequestParam("commodity_name") String name,
            @RequestParam("commodity_desc") String description,
            @RequestParam("commodity_price") long price,
            @RequestParam("total_stock") long totalStock,
            Authentication auth,
            Map<String, Object> resultMap) throws ParseException {
        int userid = usersMapper.selectByUsername(auth.getName()).getUserId();
        ImagesProducts imagesProducts = new ImagesProducts();
        imagesProducts.setCommodityName(name);
        imagesProducts.setCommodityDesc(description);
        imagesProducts.setCommodityPrice(price);
        imagesProducts.setSellId(userid);
        imagesProducts.setImagePath("abcdedfge记得修改");
        imagesProducts.setTotalStock(totalStock);
        imagesProducts.setAvailableStock(new Integer("" + totalStock));
        imagesProducts.setLockStock(0L);
        inventoryDao.insertImagesProducts(imagesProducts);
        resultMap.put("imagesProducts", imagesProducts);
        return "add_success";
    }


}
