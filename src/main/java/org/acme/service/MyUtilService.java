package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MyUtilService {

    public boolean isPrimeNumber(int number){
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0){
                return false;
            }
            
        }
        return true;
    }

    public int countCharacters(String input){
        return input.length();
    } 
}
