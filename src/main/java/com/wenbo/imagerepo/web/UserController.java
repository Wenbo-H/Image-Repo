package com.wenbo.imagerepo.web;

import com.wenbo.imagerepo.db.mappers.UsersMapper;
import com.wenbo.imagerepo.db.po.Users;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;


@Controller
public class UserController {

    @RequestMapping("/")
    public String Login(){
        return "redirect:" + "/login";
    }

//    @RequestMapping("/login")
//    public String Login() {
//        return "login";
//    }

    @Resource
    private UsersMapper usersMapper;
    @GetMapping("/users")
    public String listUsers(Model model, Authentication auth) {
        String user_name = auth.getName();
        Users loggedUser = usersMapper.selectByUsername(user_name);
        int role = loggedUser.getUserRole();
        if(role == 1){
            return "post_products";
        }
        model.addAttribute("loggedUser", loggedUser);
        return "hello";
    }
}
