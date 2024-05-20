package me.kinaz.tourserviceplatform.service;

import me.kinaz.tourserviceplatform.dao.ReservationDAO;
import me.kinaz.tourserviceplatform.dto.ReservationDTO;
import me.kinaz.tourserviceplatform.entity.Reservation;
import me.kinaz.tourserviceplatform.entity.User;
import me.kinaz.tourserviceplatform.entity.ScenicSpot;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class ReservationService {
    @Inject
    private ReservationDAO reservationDAO;

    public void addReservation(ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();
        reservation.setUser(new User());
        reservation.getUser().setId(reservationDTO.getUserId());
        reservation.setScenicSpot(new ScenicSpot());
        reservation.getScenicSpot().setId(reservationDTO.getScenicSpotId());
        reservation.setVisitTime(reservationDTO.getVisitTime());
        reservationDAO.createReservation(reservation);
    }

    public List<ReservationDTO> findReservationsByUserId(Long userId) {
        User user = new User();
        user.setId(userId);
        List<Reservation> reservations = reservationDAO.findReservationsByUser(user);
        return reservations.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private ReservationDTO convertToDTO(Reservation reservation) {
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setId(reservation.getId());
        reservationDTO.setUserId(reservation.getUser().getId());
        reservationDTO.setScenicSpotId(reservation.getScenicSpot().getId());
        reservationDTO.setVisitTime(reservation.getVisitTime());
        return reservationDTO;
    }
}
