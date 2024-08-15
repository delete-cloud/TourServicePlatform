package me.kinaz.tourserviceplatform.dao;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import me.kinaz.tourserviceplatform.entity.User;

@Stateless
public class UserDAO {
    @Inject
    private EntityManager em;

    public void createUser(User user) {
        em.persist(user);
    }

    public User findUserByUsername(String username) {
        try {
            return em.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public User findUserById(Long id) {
        return em.find(User.class, id);
    }
}
