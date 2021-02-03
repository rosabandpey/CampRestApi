package com.camp.campApi.repository;

import com.camp.campApi.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo  extends JpaRepository<AppUser,Long> {

    public AppUser findAppUserByEmail(String email);

    //@Query("select  appuser from AppUser appuser where appuser.id=:id")
    public AppUser findAppUserById(long id);

}
