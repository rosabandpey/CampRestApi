package com.camp.campApi.controller;


import com.camp.campApi.entity.AppUser;
import com.camp.campApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?>  register(@ModelAttribute AppUser appUser){

        AppUser userEmail=userService.findByEmail(appUser.getEmail());
        if (userEmail!=null){
            return new ResponseEntity<>("User Exist", HttpStatus.BAD_REQUEST);
        }
        try {
            AppUser user=userService.register(appUser);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("User Can not be saved", HttpStatus.BAD_REQUEST);

        }

    }


    @GetMapping("/userList")
    public ResponseEntity<?>  userList() {

        try {
            List<AppUser> users=userService.findAllUser();
            return new ResponseEntity<>(users, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Could not find users", HttpStatus.BAD_REQUEST);
        }

    }



}
