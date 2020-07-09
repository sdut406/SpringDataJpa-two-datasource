package com.xing.springDataJpa.controller;

import com.xing.springDataJpa.dto.UserDto;
import com.xing.springDataJpa.first.FirstEntity;
import com.xing.springDataJpa.first.FirstRepository;
import com.xing.springDataJpa.two.TwoEntity;
import com.xing.springDataJpa.two.TwoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @since 2020 -07-03
 */
@RestController
@RequestMapping("/v1/jpa/")
public class SpringDataJpaController {
    
    @Autowired
    private FirstRepository firstRepository;
    @Autowired
    private TwoRepository twoRepository;
    
    
    @PostMapping(value = "save1",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveFirst(@RequestBody UserDto userDto) {
        FirstEntity usersEntity = new FirstEntity();
        usersEntity.setUserName(userDto.getUsername());
        usersEntity.setUserPhone(userDto.getUserphone());
        usersEntity.setUserAge(userDto.getUserage());
        FirstEntity save = firstRepository.save(usersEntity);
        return ResponseEntity.ok(save);
    }

    @PostMapping(value = "save2",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveTwo(@RequestBody UserDto userDto) {
        TwoEntity usersEntity = new TwoEntity();
        usersEntity.setUsername(userDto.getUsername());
        usersEntity.setUserphone(userDto.getUserphone());
        usersEntity.setUserage(userDto.getUserage());
        TwoEntity save = twoRepository.save(usersEntity);
        return ResponseEntity.ok(save);
    }
}
