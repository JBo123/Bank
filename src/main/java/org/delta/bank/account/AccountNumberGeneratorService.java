package org.delta.bank.account;

import java.util.Random;

public class AccountNumberGeneratorService {

    public String generateAccountNumber(){
        Random random = new Random();
        StringBuilder bankAccountNumber = new StringBuilder();

        // Generate a 10-digit bank account number
        for (int i = 0; i < 10; i++) {
            bankAccountNumber.append(random.nextInt(10));
        }

        return bankAccountNumber.toString();
    }

}
