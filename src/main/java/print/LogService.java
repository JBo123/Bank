package print;

import jakarta.inject.Inject;
import org.delta.bank.account.BaseBankAccount;

public class LogService {
    @Inject LoggerInterface logger = new ConsoleLogger();

    public void log(String message) {
        logger.log(message);
    }

    public void logAccountInfo(BaseBankAccount account) {
        logger.logAccountInfo(account);
    }
}
