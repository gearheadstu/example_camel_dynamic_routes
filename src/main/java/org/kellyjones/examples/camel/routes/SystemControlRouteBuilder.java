package org.kellyjones.examples.camel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SystemControlRouteBuilder extends RouteBuilder {

    public static final String ROUTE_ID_PREFIX_SYSCTRL = "_sysctrl";
    public static final String ROUTE_ID_SYSCTRL_TIMER = ROUTE_ID_PREFIX_SYSCTRL + "_timer";

    @Value("${application.sysctrl.timer.rateInMilliseconds}")
    private Long timerRate;

    @Override
    public void configure() throws Exception {
        from("timer:" + ROUTE_ID_SYSCTRL_TIMER + "?fixedRate=true&period=" + timerRate)
                .routeId(ROUTE_ID_SYSCTRL_TIMER)
                .log("Time to make the doughnuts")
        ;
    }

}
