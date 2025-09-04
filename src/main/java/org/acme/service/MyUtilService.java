package org.acme.service;

import org.acme.util.CalcUtil;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MyUtilService {

    @Inject
    CalcUtil calcUtil;

    public boolean isPrimeNumber(int number){
        return calcUtil.verifyPrimeNumber(number);
    }

    public int countCharacters(String input){
        return input.length();
    } 
}
