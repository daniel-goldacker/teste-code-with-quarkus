package org.acme.util;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CalcUtil {

    public Boolean verifyPrimeNumber(int number){
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
}
