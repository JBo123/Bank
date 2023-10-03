package org.delta.bank.moneyTransfer;

import org.delta.bank.account.BaseBankAccount;

public class MoneyTransferService {

    private final ValidationService validationService = new ValidationService();
    private final FeeCalculator feeCalculator = new FeeCalculator();



    public void transferMoney(BaseBankAccount sourceAccount,
                              BaseBankAccount destinationAccount,
                              double value) throws Exception {

        validationService.validate(sourceAccount, value);

        sourceAccount.setBalance(sourceAccount.getBalance() - value);
        destinationAccount.setBalance(sourceAccount.getBalance() + value);
    }

    public void transferMoneyByATM(BaseBankAccount sourceAccount, double value) throws Exception{
        validationService.validate(sourceAccount, value);
        value -= feeCalculator.transferFee(sourceAccount, value);
        sourceAccount.setBalance(sourceAccount.getBalance() - value);
    }
}
