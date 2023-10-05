package org.delta.bank.moneyTransfer;

import org.delta.bank.account.BaseBankAccount;

public class InterestTransferService {

    InterestCalculationService interestCalculationService = new InterestCalculationService();
    public void transferMoney(BaseBankAccount bankAccount){

        bankAccount.setBalance(interestCalculationService.setInterest(bankAccount));

    }
}
