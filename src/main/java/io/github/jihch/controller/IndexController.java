package io.github.jihch.controller;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

@RestController
public class IndexController {

    @RequestMapping("/")
    public void index(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        System.out.printf("requestURI:%s\n", requestURI);

        String queryString = request.getQueryString();
        System.out.printf("queryString:%s\n", queryString);

        System.out.println("headers:");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String s = headerNames.nextElement();
            String header = request.getHeader(s);
            System.out.printf("%s:%s\n", s, header);
        }

    }

}
