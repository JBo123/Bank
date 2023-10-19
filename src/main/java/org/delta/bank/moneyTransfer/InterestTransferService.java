package org.delta.bank.moneyTransfer;

import com.google.inject.Inject;
import org.delta.bank.account.BaseBankAccount;

public class InterestTransferService {
@Inject private InterestCalculationService interestCalculationService;

    public void transferMoney(BaseBankAccount bankAccount){

        bankAccount.setBalance(interestCalculationService.setInterest(bankAccount));

    }
}
