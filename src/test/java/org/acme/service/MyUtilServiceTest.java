package org.acme.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class MyUtilServiceTest {

    @Inject
    MyUtilService myUtilService;

    @Test
    public void testPimeNumberValitaion(){
        Assertions.assertEquals(true, myUtilService.isPrimeNumber(5));
        Assertions.assertEquals(false, myUtilService.isPrimeNumber(0));
    }

    @Test
    public void testSizeValitaion(){
        Assertions.assertEquals(10, myUtilService.countCharacters("dinossauro"));
        Assertions.assertEquals(12, myUtilService.countCharacters("ola tudo bem"));
    }
}
