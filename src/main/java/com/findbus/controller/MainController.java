package com.findbus.controller;

import com.findbus.service.CoordinateParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @Autowired
    CoordinateParser coordinateParser;

    @RequestMapping("/index")
    public String mainPage(){
        return "index";
    }
    @RequestMapping("/parseNewRoad")
    public ResponseEntity<Void> parseRoate(){
        coordinateParser.parseRoute("23");
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
