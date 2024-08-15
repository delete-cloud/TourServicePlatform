package me.kinaz.tourserviceplatform.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.inject.Inject;
import java.io.IOException;

import me.kinaz.tourserviceplatform.dao.UserDAO;
import me.kinaz.tourserviceplatform.service.UserService;
import me.kinaz.tourserviceplatform.entity.User;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    @Inject
    private UserService userService;

    @Inject
    private UserDAO userDAO;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userDAO.findUserByUsername(username);
        if (user != null && user.getPassword().equals(userService.encryptPassword(password))) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("homepage.jsp"); // 跳转到主页
        } else {
            response.sendRedirect("login.jsp?error=true");
        }
    }
}
