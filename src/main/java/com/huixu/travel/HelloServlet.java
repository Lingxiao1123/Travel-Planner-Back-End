package com.huixu.travel;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huixu.travel.entity.User;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
//        Customer customer= new Customer();
//        customer.setEmail("sun@laioffer.com");
//        customer.setPassword("123456");
//        customer.setFirstName("rick");
//        customer.setLastName("sun");
//        customer.setEnabled(true);
        User user = new User();
        user.setEmail("sun@laioffer.com");
        user.setPassword("123456");
        user.setFirstName("rick");
        user.setLastName("sun");
        user.setEnabled(true);


        response.getWriter().print(mapper.writeValueAsString(user));

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Read customer information from request body
        JSONObject jsonRequest = new JSONObject(IOUtils.toString(request.getReader()));
        String email = jsonRequest.getString("email");
        String firstName = jsonRequest.getString("first_name");
        String lastName = jsonRequest.getString("last_name");
        //int age = jsonRequest.getInt("age");
        // Print customer information to IDE console
        System.out.println("Email is: " + email);
        System.out.println("First name is: " + firstName);
        System.out.println("Last name is: " + lastName);
        //System.out.println("Age is: " + age);
        // Return status = ok as response body to the client
        response.setContentType("application/json");
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("status", "ok");
        response.getWriter().print(jsonResponse);
    }

    public void destroy() {
    }
}