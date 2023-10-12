package print;

import org.delta.bank.account.BaseBankAccount;

public class LogService {
    private final LoggerInterface logger = new ConsoleLogger();

    public void log(String message) {
        logger.log(message);
    }

    public void logAccountInfo(BaseBankAccount account) {
        logger.logAccountInfo(account);
    }
}
