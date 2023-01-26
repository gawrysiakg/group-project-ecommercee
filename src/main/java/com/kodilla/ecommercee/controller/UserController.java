package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.UserAddDto;
import com.kodilla.ecommercee.service.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserDbService userDbService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addUser(@RequestBody UserAddDto userAddDto) throws Exception {
        userDbService.saveUser(userAddDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "block/{userId}")
    public ResponseEntity<String> blockUser(@PathVariable long userId) throws Exception {
        userDbService.setBlocked(userId);
        return new ResponseEntity<>("Block user: " + userId , HttpStatus.OK);
    }

}
