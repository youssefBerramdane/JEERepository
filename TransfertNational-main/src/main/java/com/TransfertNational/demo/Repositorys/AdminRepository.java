package com.TransfertNational.demo.Repositorys;

import com.TransfertNational.demo.Entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    Admin findByAdminName(String adminName);
}
