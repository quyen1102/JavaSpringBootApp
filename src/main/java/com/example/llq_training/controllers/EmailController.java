package com.example.llq_training.controllers;

import com.example.llq_training.dto.Filter;
import com.example.llq_training.models.EmailThongTinNguoiGui;
import com.example.llq_training.repositories.EmailRepository;
import com.example.llq_training.services.EmailServices;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/email")
public class EmailController {
    @Autowired
    EmailServices emailService;
    @Autowired
    private EmailRepository emailRepo;
    EmailController(EmailServices emailService) {
        this.emailService = emailService;
    }


    @PostMapping(value = "/insert")
    public void insert(@RequestBody EmailThongTinNguoiGui email) {
        emailService.insert(email);
    }

    @GetMapping(value = "/get")
    public List<EmailThongTinNguoiGui> findAll() {
        List<EmailThongTinNguoiGui> list = emailService.findAll();
        return list;
    }
//    @GetMapping(value = )
//    public Optional<EmailThongTinNguoiGui> findById(@RequestParam long id){
//        Optional<EmailThongTinNguoiGui> email = emailService.findById(id);
//        return email;
//    }

    @GetMapping(value = "/getId")
    public Map<String,Object> getByIdName(@RequestBody EmailThongTinNguoiGui emailFind) {
        Map<String,Object> map = new HashMap<String,Object>();
        EmailThongTinNguoiGui email = emailService.findById(emailFind);
        if(email!= null){
            map.put("code","Success");
            map.put("content",email);
        }else{
            map.put("code","Failed");
        }
        return map;
    }

    @PostMapping(value = "/page")
    public Page<EmailThongTinNguoiGui> getPage(@RequestBody Filter filter) {
        Page<EmailThongTinNguoiGui> emails = emailService.filter(filter);
        return emails;
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> deleteById(@RequestBody EmailThongTinNguoiGui emailDelete){
       try {
            emailRepo.deleteById(emailDelete.getId());
           return new ResponseEntity<>("Deleted email id : " + emailDelete.getId(),HttpStatus.OK);
       }catch (Exception e){
           return new ResponseEntity<>("Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    @PutMapping(value="/put")
    public ResponseEntity<EmailThongTinNguoiGui> updateById(@RequestBody EmailThongTinNguoiGui emailUpdate){
        Optional<EmailThongTinNguoiGui> emailOptional = emailRepo.findById(emailUpdate.getId());
        if(emailOptional.isPresent()){
            EmailThongTinNguoiGui _email = emailOptional.get();
            _email.setEmailTo(emailUpdate.getEmailTo());
            _email.setEmailCc(emailUpdate.getEmailCc());
            _email.setChucNang(emailUpdate.getChucNang());
            _email.setNgayGui(emailUpdate.getNgayGui());
            _email.setNgayTao(emailUpdate.getNgayTao());
            _email.setNoiDung(emailUpdate.getNoiDung());
            _email.setTrangThaiGui(emailUpdate.getTrangThaiGui());
            return new ResponseEntity<>(emailRepo.save(_email), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
