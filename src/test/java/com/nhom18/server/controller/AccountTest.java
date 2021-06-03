package com.nhom18.server.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhom18.server.controller.account.dto.LoginRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class AccountTest {

    @Autowired
    private MockMvc mockMvc;

    private String getJsonRequest(LoginRequest login){
        try {
            String request = new ObjectMapper().writeValueAsString(login);
            return request;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Test
    public void testFindAdmin(){
        LoginRequest login = new LoginRequest();
        login.setUsername("Admin");
        login.setPassword("User_1234");
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/account/login")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(getJsonRequest(login));
        try {
            mockMvc.perform(requestBuilder)
                    .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindTeacher1(){
        LoginRequest login = new LoginRequest();
        login.setUsername("Teacher1");
        login.setPassword("User_1234");
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/account/login")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(getJsonRequest(login));
        try {
            mockMvc.perform(requestBuilder)
                    .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindEmployee1(){
        LoginRequest login = new LoginRequest();
        login.setUsername("Employee1");
        login.setPassword("User_1234");
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/account/login")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(getJsonRequest(login));
        try {
            mockMvc.perform(requestBuilder)
                    .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}