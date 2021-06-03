//package com.nhom18.server.controller;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import com.nhom18.server.controller.term.TermController;
//import com.nhom18.server.controller.term.service.TermService;
//import com.nhom18.server.exception.RegTimeException;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//@ContextConfiguration(classes = {TermController.class})
//@ExtendWith(SpringExtension.class)
//
//    public class TermControllerTest {
//    @Autowired
//    private TermController termController;
//
//    @MockBean
//    private TermService termService;
//
//    //Khi không có kì mới
//    @Test
//    public void HandleTermNotFoundExceptionTest() {
//        ResponseEntity<String> rs = this.termController.handleTermNotFoundException();
//        assertEquals(HttpStatus.BAD_REQUEST, rs.getStatusCode());
//        assertEquals("Không có kì mới!", rs.getBody());
//    }
//
//    //Khi thời gian nhâp vào bị lỗi
//    @Test
//    public void HandleRegTimeExceptionTest() {
//        RegTimeException e = new RegTimeException("Thời gian nhập vào bị lỗi");
//        ResponseEntity<String> rs = this.termController.handleRegTimeException(new RegTimeException(e.getMessage()));
//        assertEquals(HttpStatus.BAD_REQUEST, rs.getStatusCode());
//}
//}
//
//
