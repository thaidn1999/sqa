package com.nhom18.server.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.nhom18.server.controller.term.dto.TermDTO;
import com.nhom18.server.controller.term.service.TermServiceImpl;
import com.nhom18.server.dao.RegistrationDAO;
import com.nhom18.server.dao.TermDAO;
import com.nhom18.server.entity.group.Term;
import com.nhom18.server.exception.TermNotFoundException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TermServiceImpl.class})
@ExtendWith(SpringExtension.class)
public class TermSeviceTest {
    @MockBean
    private RegistrationDAO registrationDAO;

    @MockBean
    private TermDAO termDAO;

    @Autowired
    private TermServiceImpl termServiceImpl;

    @Test
    public void GetLastTermTest() throws TermNotFoundException {
        Term term = new Term();
        Timestamp timestamp1 = new Timestamp(1621879200);   // 2021-05-25 01:00:00.000000
        term.setStartRegTime(timestamp1);
        Date date1 = new Date(1627862400);       // 2021-08-02
        term.setStartDate(date1);
        Timestamp timestamp2 = new Timestamp(1626498000);    // 2021-07-17 12:00:00.000000
        term.setEndRegTime(timestamp2);
        term.setId(1);
        Date date2 = new Date(1641686400);      // 2022-01-09
        term.setEndDate(date2);
        Optional<Term> rs = Optional.<Term>of(term);        // Optional[1]
        when(this.termDAO.getLastTerm()).thenReturn(rs);
        TermDTO termDTO = this.termServiceImpl.getLastTerm();
        assertEquals(date1, termDTO.getStartDate());
        assertEquals(date2, termDTO.getEndDate());
        assertEquals(timestamp1, termDTO.getStartRegTime());
        assertEquals(timestamp2, termDTO.getEndRegTime());
        verify(this.termDAO).getLastTerm();
    }
}

