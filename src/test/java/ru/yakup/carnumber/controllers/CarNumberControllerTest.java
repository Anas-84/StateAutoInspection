package ru.yakup.carnumber.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.yakup.carnumber.services.CarNumberService;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.http.RequestEntity.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.yakup.carnumber.prototype.CarNumberPrototype.testListCarNumber;

class CarNumberControllerTest {

    MockMvc mockMvc;
    CarNumberService carNumberService;
    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        carNumberService = mock(CarNumberService.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new CarNumberController(carNumberService)).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void showCarNumbers() throws Exception {
        when(carNumberService.findAll()).thenReturn(testListCarNumber());
        mockMvc.perform((RequestBuilder) get("/number"))
                .andExpect(content().json(objectMapper.writeValueAsString(testListCarNumber())))
                .andExpect(status().isOk());
    }
}