package com.example.llq_training;

import com.example.llq_training.models.Calendars;
import com.example.llq_training.models.EmailThongTinNguoiGui;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@SpringBootApplication
@RestController
public class LlqTrainingApplication {

    public static void main(String[] args) {
        SpringApplication.run(LlqTrainingApplication.class, args);
    }




}
