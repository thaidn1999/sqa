package com.nhom18.server.service;

import com.nhom18.server.controller.account.dto.LoginRequest;
import com.nhom18.server.controller.account.service.AccountServiceImpl;
import com.nhom18.server.entity.user.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AccountServiceTest {
    @Autowired
    private AccountServiceImpl accountService;

    @Test
    public void testFindUserName1(){
        Account acc = new Account();
        acc.setUsername("Admin");
        acc.setPassword("User_1234");
        LoginRequest rq = new LoginRequest();
        rq.setUsername("Admin");
        rq.setPassword("User_1234");
        Assertions.assertEquals(acc.getPassword(),rq.getPassword());
    }
//    @Test
//    public void testFindUserName2(){
//        Account acc = new Account();
//        acc.setUsername("Admin");
//        acc.setPassword("User_1234");
//        LoginRequest rq = new LoginRequest();
//        rq.setUsername("Admin");
//        rq.setPassword("User1234");
//        Assertions.assertEquals(acc.getPassword(),rq.getPassword());
//    }
}
