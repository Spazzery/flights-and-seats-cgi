//package com.summer.flightsandseats;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//
//@WebMvcTest
//class FlightControllerTests {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    void testGetFlights() throws Exception {
//        mockMvc.perform(get("/flights"))
//                .andExpect(status().isOk()) // Expect HTTP 200 status
//                .andExpect(content().string("List of flights")); // Expect the correct content
//    }
//}
