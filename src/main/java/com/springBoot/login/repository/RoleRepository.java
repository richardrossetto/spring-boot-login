package com.springBoot.login.repository;

import com.springBoot.login.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Richard Rossetto on 03/09/19.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}
