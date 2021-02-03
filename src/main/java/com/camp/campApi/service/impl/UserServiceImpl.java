package com.camp.campApi.service.impl;

import com.camp.campApi.entity.AppUser;
import com.camp.campApi.entity.UserRole;
import com.camp.campApi.repository.RoleRepo;
import com.camp.campApi.repository.UserRepo;
import com.camp.campApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public AppUser register(AppUser appUser) {
        //appUser=new AppUser();
        String pass=bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(pass);
        appUser.setUserRoles(new UserRole(appUser,roleRepo.findRoleByRoleName("USER")));
        AppUser user=userRepo.save(appUser);
        return user;
    }

    @Override
    public AppUser updateProfile() {
        return  null;
    }

    @Override
    public AppUser resetPassword() {
        return null;
    }

    @Override
    public List<AppUser> findAllUser() {
       List<AppUser> users= userRepo.findAll();
       return users;
    }

    @Override
    public AppUser findByEmail(String email) {
        AppUser user=userRepo.findAppUserByEmail(email);
        return user;
    }

    @Override
    public AppUser findByUserId(long id) {
        AppUser user=userRepo.findAppUserById(id);
        return user;
    }
}
