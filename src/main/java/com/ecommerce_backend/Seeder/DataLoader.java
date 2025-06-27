package com.ecommerce_backend.Seeder;

import com.ecommerce_backend.Entity.Role;
import com.ecommerce_backend.Enum.ERole;
import com.ecommerce_backend.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.findAll().isEmpty()){
            roleRepository.save(new Role(ERole.ROLE_USER));
            roleRepository.save(new Role(ERole.ROLE_ADMIN));
        }
    }
}
