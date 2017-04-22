package com.schmauder.spring.boot.example.controller;

import com.schmauder.spring.boot.example.data.Hotel;
import com.schmauder.spring.boot.example.service.HotelService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    private final HotelService service;

    public HotelController(HotelService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    void save(@RequestBody Hotel hotel){
        service.save(hotel);
    }

    @RequestMapping( method = RequestMethod.GET)
    List<Hotel> getHotels() {
        return service.getHotels();
    }
}
