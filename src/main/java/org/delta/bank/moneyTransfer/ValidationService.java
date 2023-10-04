package org.delta.bank.moneyTransfer;

import org.delta.bank.account.BaseBankAccount;

public class ValidationService {
    public void validateAccountBalanceAfterTransfer(
            double accountValue,
            double transferValue
    ) throws Exception {

        if (accountValue < transferValue) {
            throw new Exception("");
        }
    }
}
