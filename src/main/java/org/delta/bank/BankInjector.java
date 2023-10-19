package org.delta.bank;

import com.google.inject.AbstractModule;
import print.ConsoleLogger;
import print.LoggerInterface;

public class BankInjector extends AbstractModule {

    protected void configure(){
    //this.bind(LoggerInterface.class).to(ConsoleLogger.class);  // Did make logger differently so dont need this :)
    }

}
