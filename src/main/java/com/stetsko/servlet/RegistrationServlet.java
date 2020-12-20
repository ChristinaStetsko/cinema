package com.stetsko.servlet;

import com.stetsko.entity.User;
import com.stetsko.repository.InMemoryUserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String doubleCheckPassword = req.getParameter("checkPassword");

        if (!password.equals(doubleCheckPassword)) {
            req.setAttribute("not_equal_passwords_error", "Password and double check password are not equal");
            req.getRequestDispatcher("/jsp/registration.jsp").forward(req, resp);
        } else {
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);

            InMemoryUserRepository.inMemoryUserRepository.saveUser(user);

            resp.sendRedirect("/login");
        }
    }
}