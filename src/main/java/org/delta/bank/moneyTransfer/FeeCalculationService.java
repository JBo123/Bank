package org.delta.bank.moneyTransfer;

import org.delta.bank.account.BaseBankAccount;
import org.delta.bank.account.SavingBankAccount;
import org.delta.bank.account.StudentBankAccount;

public class FeeCalculationService {

    public double calculateFee(BaseBankAccount bankAccount, double transferValue) {

        if (bankAccount instanceof StudentBankAccount) {
            return 0;
        }

        if (bankAccount instanceof SavingBankAccount) {

            return calculateFee(
                    transferValue,
                    Fees.Savings.MINIMUM_FOR_PERCENTAGE_FEE,
                    Fees.Savings.FEE,
                    Fees.Savings.PERCENTAGE
            );
        }

        return calculateFee(
                transferValue,
                Fees.Base.MINIMUM_FOR_PERCENTAGE_FEE,
                Fees.Base.FEE,
                Fees.Base.PERCENTAGE
        );
    }

    private double calculateFee(
            double transferValue,
            double minimumForPercentage,
            double fee,
            double percentage
    ) {

        if (transferValue < minimumForPercentage) {

            return fee;
        }

        return ((transferValue / 100) * percentage) - fee;
    }
}

enum Fees {
    ;
    enum Savings {
        ;
        static final double MINIMUM_FOR_PERCENTAGE_FEE = 500;
        static final double PERCENTAGE = 50;
        static final double FEE = 50;
    }
    enum Base {
        ;
        static final double MINIMUM_FOR_PERCENTAGE_FEE = 1000;
        static final double PERCENTAGE = 1;
        static final double FEE = 5;
    }
}