package org.delta.bank;

import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;
import org.delta.bank.person.OwnerToJsonInterface;
import org.delta.bank.person.OwnerToJsonService;
import print.ConsoleLogger;
import print.LoggerInterface;

import java.util.EventListener;

public class BankInjector extends AbstractModule {

    private EventBus eventBus = new EventBus("Default EventBus");

    protected void configure(){
    this.bind(LoggerInterface.class).to(ConsoleLogger.class);
    this.bind(OwnerToJsonInterface.class).to(OwnerToJsonService.class);
    this.bind(EventBus.class).toInstance(eventBus);

    bindListener(Matchers.any(), new TypeListener() {
        @Override
        public <I> void hear(TypeLiteral<I> type, TypeEncounter<I> typeEncounter) {
            typeEncounter.register(new InjectionListener<I>(){
                public void afterInjection(I i){ eventBus.register(i);}
            });
        }
    });
    }

}
