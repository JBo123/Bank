package org.delta.bank.moneyTransfer;

import com.google.inject.Inject;
import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.account.StudentBankAccount;

public class InterestCalculationService {

    @Inject private InterestConfig interestConfig;
    public double setInterest(BaseBankAccount bankAccount){

        return interestConfig.countInterest(bankAccount);

    }
}
