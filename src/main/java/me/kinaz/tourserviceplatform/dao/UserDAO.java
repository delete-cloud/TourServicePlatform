package me.kinaz.tourserviceplatform.dao;

import me.kinaz.tourserviceplatform.entity.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.NoResultException;

@Stateless
public class UserDAO {
    @PersistenceContext
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
