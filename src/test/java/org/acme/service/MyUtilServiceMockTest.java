package org.acme.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.acme.util.CalcUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class MyUtilServiceMockTest {

    @Inject
    MyUtilService myUtilService;

    @Mock
    private CalcUtil calcUtilMock;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testVerifyPimeNumberWichMocks(){
        when(calcUtilMock.verifyPrimeNumber(5)).thenReturn(true);
        when(calcUtilMock.verifyPrimeNumber(0)).thenReturn(false);

        boolean result1 = myUtilService.isPrimeNumber(5);
        boolean result2 = myUtilService.isPrimeNumber(0);
        
        assertEquals(true, result1);
        assertEquals(false, result2);
    }
}
