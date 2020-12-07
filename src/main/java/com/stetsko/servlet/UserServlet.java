package com.stetsko.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stetsko.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@WebServlet (urlPatterns = "/users")
public class UserServlet extends HttpServlet {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static final List<User> users = new ArrayList<>();

    private AtomicLong idGenerator = new AtomicLong(1);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print(objectMapper.writeValueAsString(users));
        resp.setContentType("application/json");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var httpRequestBody = new String(req.getInputStream().readAllBytes());

        var newUser = objectMapper.readValue(httpRequestBody, User.class);

        newUser.setId(idGenerator.getAndIncrement());

        System.out.println("Создаю пользователя: " + newUser.getUsername() + ". Уникальный идентификатор " + newUser.getId());
        users.add(newUser);

        resp.getWriter().print(objectMapper.writeValueAsString(newUser));
        resp.setContentType("application/json");
        resp.setStatus(HttpServletResponse.SC_CREATED);
    }
}
