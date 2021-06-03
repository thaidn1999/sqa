package com.nhom18.server.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhom18.server.controller.account.dto.ForgotRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ForgotUserTest {
    @Autowired
    private MockMvc mockMvc;

    private String getJsonRequest( ForgotRequest forgotRequest){
        try {
            String request = new ObjectMapper().writeValueAsString(forgotRequest);
            return request;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Test
    public void testDoForgot(){
        ForgotRequest forgotRequest  = new ForgotRequest();
        forgotRequest.setUsername("Admin");
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/account/forgot")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(getJsonRequest(forgotRequest));
        try {
            mockMvc.perform(requestBuilder)
                    .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}