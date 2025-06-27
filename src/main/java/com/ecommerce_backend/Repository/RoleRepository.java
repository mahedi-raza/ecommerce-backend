package com.ecommerce_backend.Repository;

import com.ecommerce_backend.Entity.Role;
import com.ecommerce_backend.Enum.ERole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);
}
