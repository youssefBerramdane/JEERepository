package com.TransfertNational.demo.Services.ServicesImpl;

import com.TransfertNational.demo.Entities.Admin;
import com.TransfertNational.demo.Repositorys.AdminRepository;
import com.TransfertNational.demo.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Override
    public void signUp(Admin admin) throws Exception {
        if(checkAdminExiste(admin.getAdminName())){
            throw new Exception("Admin Account already exists for this AdminName");
        }
        adminRepository.save(admin);
    }

    @Override
    public Admin logIn(String adminName, String password) throws Exception {
        if(!checkAdminExiste(adminName)){
            throw new Exception("AdminName n'existe pas");
        }
        else {
            Admin admin = adminRepository.findByAdminName(adminName);
            if(!admin.getPassword().equals(password)){
                throw new Exception("Mot de passe incorrect");
            }
            return admin;
        }

    }


    private boolean checkAdminExiste(String adminName) {
        return adminRepository.findByAdminName(adminName)!=null ? true : false;
    }
}
