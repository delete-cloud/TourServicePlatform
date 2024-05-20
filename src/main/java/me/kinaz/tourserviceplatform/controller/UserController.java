package me.kinaz.tourserviceplatform.controller;

import me.kinaz.tourserviceplatform.dto.UserDTO;
import me.kinaz.tourserviceplatform.service.UserService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class UserController extends HttpServlet {
    @Inject
    private UserService userService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(username);
        userDTO.setPassword(password); // Assumes password encryption is handled in service layer
        userDTO.setEmail(email);

        userService.registerUser(userDTO);

        response.sendRedirect("login.jsp");
    }
}
