package org.delta.bank.moneyTransfer;

import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.account.StudentBankAccount;

public class InterestCalculationService {

    InterestConfig interestConfig = new InterestConfig();
    public double setInterest(BaseBankAccount bankAccount){

        return interestConfig.countInterest(bankAccount);

    }
}
