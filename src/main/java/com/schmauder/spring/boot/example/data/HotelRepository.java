package com.schmauder.spring.boot.example.data;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface HotelRepository extends MongoRepository<Hotel,String>{
}
