package me.kinaz.tourserviceplatform.dao;

import me.kinaz.tourserviceplatform.entity.Reservation;
import me.kinaz.tourserviceplatform.entity.User;
import me.kinaz.tourserviceplatform.entity.ScenicSpot;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ReservationDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void createReservation(Reservation reservation) {
        entityManager.persist(reservation);
    }

    @Transactional
    public void updateReservation(Reservation reservation) {
        entityManager.merge(reservation);
    }

    public List<Reservation> findReservationsByUser(User user) {
        return entityManager.createQuery("SELECT r FROM Reservation r WHERE r.user = :user", Reservation.class)
                .setParameter("user", user)
                .getResultList();
    }

    public Reservation findReservationByUserAndScenicSpot(User user, ScenicSpot scenicSpot) {
        try {
            return entityManager.createQuery("SELECT r FROM Reservation r WHERE r.user.id = :userId AND r.scenicSpot.id = :scenicSpotId", Reservation.class)
                    .setParameter("userId", user.getId())
                    .setParameter("scenicSpotId", scenicSpot.getId())
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
