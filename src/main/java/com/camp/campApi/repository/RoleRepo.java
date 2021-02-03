package com.camp.campApi.repository;

import com.camp.campApi.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {

    public Role findRoleByRoleName(String name);
}
