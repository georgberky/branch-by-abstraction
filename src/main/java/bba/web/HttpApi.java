package bba.web;

import bba.business.FirstBusinessService;
import bba.business.SecondBusinessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpApi {
    private static final Logger LOG = LoggerFactory.getLogger(HttpApi.class);

    private final FirstBusinessService firstService;
    private final SecondBusinessService secondService;

    public HttpApi(FirstBusinessService firstService, SecondBusinessService secondService) {
        this.firstService = firstService;
        this.secondService = secondService;

        LOG.info("Created: {}", this.getClass().getSimpleName());
    }

    public void startServing() {
        LOG.info("Accepting HTTP requests");
    }

    public Response handleRequest(Request request) {
        LOG.info("Received request: {}", request);

        firstService.doSomething();
        secondService.doSomething();

        return new Response(200, "OK");
    }
}
