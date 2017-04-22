package com.schmauder.spring.boot.example;

import com.schmauder.spring.boot.example.data.Hotel;
import com.schmauder.spring.boot.example.data.HotelRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringBootMongoExampleApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private HotelRepository repository;

    @Before
    public void clearDb(){
        repository.deleteAll();
    }

    @Test
    public void insertHotelSavesHotelToDb() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/hotel")
                .content("{" +
                        "\"key\": \"2314\","+
                        "\"code\": \"Abc\","+
                        "\"name\": \"Fancy Hotel\""+
                        "}")
                .contentType("application/json"))
                .andExpect(status().isOk());

        List<Hotel> hotels = repository.findAll();
        assertThat(hotels, contains(new Hotel("2314","Abc","Fancy Hotel")));
    }

    @Test
    public void getsHotelsFromDb() throws Exception {
        repository.insert(new Hotel("2314","Abc","Fancy Hotel") );
        mockMvc.perform(MockMvcRequestBuilders.get("/hotel"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{" +
                        "\"key\": \"2314\","+
                        "\"code\": \"Abc\","+
                        "\"name\": \"Fancy Hotel\""+
                        "}]"));
    }

}
