package com.camp.campApi.service;

import com.camp.campApi.entity.AppUser;
import com.camp.campApi.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

  public AppUser register(AppUser appUser);
  public AppUser updateProfile();
  public AppUser resetPassword();
  public List<AppUser> findAllUser();
  public AppUser findByEmail(String email);
  public AppUser findByUserId(long id);


}
