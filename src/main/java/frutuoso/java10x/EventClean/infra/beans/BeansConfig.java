package frutuoso.java10x.EventClean.infra.beans;
import frutuoso.java10x.EventClean.core.gateway.EventGateway;
import frutuoso.java10x.EventClean.core.useCases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public CreateEventCase createEventCase(EventGateway eventGateway) {
        return new CreateEventCaseImpl(eventGateway);
    }

    @Bean
    public SearchEventCase searchEventCase(EventGateway eventGateway){
        return new SearchEventCaseImpl(eventGateway);
    }

    @Bean
    public FilterIdentifierCase filterIdentifierCase(EventGateway eventGateway){
        return new FilterIdentifierCaseImpl(eventGateway);
    }

    @Bean
    public FilterNameCase filterNameCase(EventGateway eventGateway){
        return new FilterNameCaseImpl(eventGateway);
    }
}
