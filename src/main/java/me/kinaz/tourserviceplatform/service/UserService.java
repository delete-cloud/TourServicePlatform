package me.kinaz.tourserviceplatform.service;

import me.kinaz.tourserviceplatform.dao.UserDAO;
import me.kinaz.tourserviceplatform.dto.UserDTO;
import me.kinaz.tourserviceplatform.entity.User;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.math.BigInteger;

@Stateless
public class UserService {
    @Inject
    private UserDAO userDAO;

    public void registerUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(encryptPassword(userDTO.getPassword())); // Assume this method exists
        user.setEmail(userDTO.getEmail());
        userDAO.createUser(user);
    }

    public UserDTO findUserByUsername(String username) {
        User user = userDAO.findUserByUsername(username);
        if (user == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

    private String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
            BigInteger number = new BigInteger(1, hash);
            StringBuilder hexString = new StringBuilder(number.toString(16));
            while (hexString.length() < 32) {
                hexString.insert(0, '0');
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
