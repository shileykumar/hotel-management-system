package com.sunglowsys.controller;

import com.sunglowsys.domain.Hotel;
import com.sunglowsys.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HotelController {

    @Autowired
    HotelService hotelService;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("hotel",hotelService.findAll());
        return "index";
    }

    @GetMapping("/addHotel")
    public String addHotelForm(Model model){
        Hotel hotel = new Hotel();
        model.addAttribute("hotel",hotel);
        return "add_hotel";
    }

    @PostMapping("/saveHotel")
    public String saveHotel(@ModelAttribute("hotel") Hotel hotel){
        hotelService.save(hotel);
        return "redirect:/";
    }

    @GetMapping("updateHotel/{id}")
    public String updateHotel(@PathVariable("id") Integer id, Model model){
        Hotel hotel = hotelService.findById(id);
        model.addAttribute("hotel",hotel);
        return "update_hotel";
    }

    @GetMapping("/deleteHotel/{id}")
    public String deleteHotel(@PathVariable("id") Integer id){
        hotelService.delete(id);
        return "redirect:/";
    }
}
