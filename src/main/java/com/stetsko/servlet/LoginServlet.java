package com.stetsko.servlet;

import com.stetsko.entity.User;
import com.stetsko.repository.InMemoryUserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        List<User> allUsers = InMemoryUserRepository.inMemoryUserRepository.getAllUsers();

        Optional<User> user = allUsers.stream().filter(u -> u.getEmail().equals(email) && u.getPassword().equals(password)).findAny();

        if (user.isPresent()) {
            req.getSession().setAttribute("email", user.get().getEmail());
            req.getSession().setAttribute("authorized", "true");
            resp.sendRedirect("jsp/index.jsp");
        } else {
            req.setAttribute("login_error", "Email or password is incorrect!");
            req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
        }
    }
}