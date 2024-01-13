package com.TransfertNational.demo.Controllers;

import com.TransfertNational.demo.Entities.Admin;
import com.TransfertNational.demo.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping
    public String welcome() {
        return "Welcome to our Transfert National Application :) ";
    }


    @PostMapping(path = "/signUp", consumes= MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Admin> signUp(@RequestBody Admin admin) throws Exception{

        adminService.signUp(admin);

        return new ResponseEntity<Admin>(admin,HttpStatus.CREATED);
    }

    @PostMapping(path = "/logIn", consumes= MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Admin> logIn(@RequestBody Admin admin) throws Exception{

        admin=adminService.logIn(admin.getAdminName(),admin.getPassword());

        return new ResponseEntity<Admin>(admin,HttpStatus.OK);
    }



}
