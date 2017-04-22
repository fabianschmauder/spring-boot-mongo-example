package com.schmauder.spring.boot.example.service;

import com.schmauder.spring.boot.example.data.Hotel;
import com.schmauder.spring.boot.example.data.HotelRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    private final HotelRepository repository;

    public HotelService(HotelRepository repository) {
        this.repository = repository;
    }

    public void save(Hotel hotel) {
        repository.save(hotel);
    }

    public List<Hotel> getHotels() {
        return repository.findAll(new Sort(Sort.Direction.ASC,"key"));
    }
}
