package org.delta.bank.moneyTransfer;

import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.account.StudentBankAccount;

public class FeeCalculator {

    public double baseAccountTransferFee(BaseBankAccount sourceAccount, double value){

        double fee = Accounts.Savings.BASE_FEE;

        if (sourceAccount instanceof StudentBankAccount) {
            return 0;
        } else if (sourceAccount instanceof BaseBankAccount){
        feeCalculator(Accounts.Base.BASE_FEE, Accounts.Base.PERCENT_FEE_LIMIT, Accounts.Base.PERCENT_FEE, value);
        } else {
            feeCalculator(Accounts.Savings.BASE_FEE, Accounts.Savings.PERCENT_FEE_LIMIT, Accounts.Savings.PERCENT_FEE, value);

        }


        if (value >= Accounts.Savings.PERCENT_FEE_LIMIT){
            fee += Accounts.Savings.PERCENT_FEE;
        }
        return fee;
    }
    public double feeCalculator( double baseFee, double percentFeeLimit, double percentFee, double value){
        double fee = baseFee;

        if (value >= percentFeeLimit){
            fee += percentFee;
        } else {
            return 0;
        }

        return fee;

    }
    enum Accounts{
        ;
        enum Savings{;
            static final double BASE_FEE = 50;
            static final double PERCENT_FEE_LIMIT = 500;
            static final double PERCENT_FEE = PERCENT_FEE_LIMIT / 100 * 5;
        }
        enum Students{;
            static final double BASE_FEE = 0;
            static final double PERCENT_FEELIMIT = 0;
            static final double PERCENT_FEE = 0;
        }
        enum Base{;
            static final double BASE_FEE = 5;
            static final double PERCENT_FEE_LIMIT = 1000;
            static final double PERCENT_FEE = PERCENT_FEE_LIMIT / 100 * 1;
        }
    }
}
