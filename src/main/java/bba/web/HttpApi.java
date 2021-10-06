package bba.web;

import bba.business.FirstBusinessService;

public class HttpApi {
    private final FirstBusinessService firstService;
    private final FirstBusinessService secondService;

    public HttpApi(FirstBusinessService firstService, FirstBusinessService secondService) {
        this.firstService = firstService;
        this.secondService = secondService;
    }

    public void startApplication() {
        System.out.println("Application is running...");
    }
}
