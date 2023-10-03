package org.delta.bank.moneyTransfer;

import org.delta.bank.account.BaseBankAccount;

public class ValidationService {

    public void validate(BaseBankAccount sourceAccount, double value) throws Exception{
        if(sourceAccount.getBalance() < value){
            throw new Exception("");
        }
        else return;
    }
}
