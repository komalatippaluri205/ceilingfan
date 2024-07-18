package com.ceilingfan.ceiling_fan.web;

import com.ceilingfan.ceiling_fan.pojo.CeilingFan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
public class CeilingFanController {

    @Autowired
    CeilingFan fan;

    @GetMapping("/pullcord1")
    public ResponseEntity<String> pullCord1(){
        return ResponseEntity.ok(fan.pullCord1());
    }

    @GetMapping("/pullcord2")
    public ResponseEntity<String> pullCord2(){
        return ResponseEntity.ok(fan.pullCord2());
    }

    @GetMapping("/reset-fan")
    public ResponseEntity<CeilingFan> resetFanSettings(){
        return ResponseEntity.ok(fan.reset());
    }
    @GetMapping("/status")
    public CeilingFan getStatus(){
        return fan;
    }

    @ExceptionHandler
    public ResponseEntity<String> handleException(Exception e ){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
