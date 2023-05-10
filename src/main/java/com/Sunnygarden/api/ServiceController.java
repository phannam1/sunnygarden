package com.Sunnygarden.api;

import com.Sunnygarden.entity.SideBarEntity;
import com.Sunnygarden.repository.SideBarRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping(value = "/api")
@AllArgsConstructor
public class ServiceController {

    private final SideBarRepository sideBarRepository;

    @GetMapping(value = "/sidebar")
    ResponseEntity<String> sideBar(){
        SideBarEntity sideBar = sideBarRepository
            .findByRoleIdAndStatus(1L, true).get(0);
     return new ResponseEntity<>(sideBar.getSideBarName(), HttpStatus.OK);
    }
}
