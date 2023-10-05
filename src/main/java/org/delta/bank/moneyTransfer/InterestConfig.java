package org.delta.bank.moneyTransfer;

import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.account.StudentBankAccount;

public class InterestConfig {

    static final double STUDENTS_INTEREST = 2;
    static final  double SAVINGS_INTEREST = 8;
    public  double countInterest(BaseBankAccount bankAccount){

        if(bankAccount instanceof StudentBankAccount){

            return bankAccount.getBalance() / 100 * STUDENTS_INTEREST;

        }

        else {

            return bankAccount.getBalance() / 100 * SAVINGS_INTEREST;

        }
    }

}
