package me.kinaz.tourserviceplatform.dao;

import me.kinaz.tourserviceplatform.entity.Reservation;
import me.kinaz.tourserviceplatform.entity.User;
import me.kinaz.tourserviceplatform.entity.ScenicSpot;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ReservationDAO {
    @PersistenceContext
    private EntityManager em;

    public void createReservation(Reservation reservation) {
        em.persist(reservation);
    }

    public List<Reservation> findReservationsByUser(User user) {
        return em.createQuery("SELECT r FROM Reservation r WHERE r.user = :user", Reservation.class)
                .setParameter("user", user)
                .getResultList();
    }

    public List<Reservation> findReservationsByScenicSpot(ScenicSpot scenicSpot) {
        return em.createQuery("SELECT r FROM Reservation r WHERE r.scenicSpot = :scenicSpot", Reservation.class)
                .setParameter("scenicSpot", scenicSpot)
                .getResultList();
    }

    public Reservation findReservationById(Long id) {
        return em.find(Reservation.class, id);
    }
}
