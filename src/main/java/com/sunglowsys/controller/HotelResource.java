package com.sunglowsys.controller;

import com.sunglowsys.domain.Hotel;
import com.sunglowsys.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiHotel")
public class HotelResource {

    @Autowired
    HotelService hotelService;

    @PostMapping("/save")
    public Hotel save(@RequestBody Hotel hotel){
        return hotelService.save(hotel);
    }

    @GetMapping("/get")
    public List<Hotel> getAll(){
        List<Hotel> hotels = hotelService.findAll();
        return hotels;
    }

    @GetMapping("get/{id}")
    public Hotel getById(@PathVariable("id") Integer id){
        return hotelService.findById(id);
    }

    @PutMapping("/update/{id}")
    public Hotel update(@RequestBody Hotel hotel, @PathVariable("id") Integer id){
        return hotelService.update(hotel,id);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        hotelService.delete(id);
    }
}
