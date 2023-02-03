package io.github.jihch.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

@RestController
public class IndexController {

    @RequestMapping("/")
    public void index(HttpServletRequest request) throws IOException {

        System.out.println(request.toString());

        String requestURI = request.getRequestURI();
        System.out.printf("requestURI:%s\n\n", requestURI);


        String method = request.getMethod();
        System.out.printf("method:%s\n\n", method);

        String queryString = request.getQueryString();
        System.out.printf("queryString:%s\n\n", queryString);

        System.out.println("cookies:");
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.printf("%s=%s\n", cookie.getName(), cookie.getValue());
            }
        }

        System.out.println();

        System.out.println("headers:");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String s = headerNames.nextElement();
            String header = request.getHeader(s);
            System.out.printf("%s:%s\n", s, header);
        }
        System.out.println();

        System.out.println("body:");
        // 直接从HttpServletRequest的Reader流中获取RequestBody
        BufferedReader reader = request.getReader();
        StringBuilder builder = new StringBuilder();
        String line = reader.readLine();
        while(line != null){
            builder.append(line);
            line = reader.readLine();
        }
        reader.close();

        String reqBody = builder.toString();
        System.out.println(reqBody);


    }


}
