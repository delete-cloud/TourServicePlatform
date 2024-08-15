package me.kinaz.tourserviceplatform.service;

import me.kinaz.tourserviceplatform.dao.ReservationDAO;
import me.kinaz.tourserviceplatform.dto.ReservationDTO;
import me.kinaz.tourserviceplatform.entity.Reservation;
import me.kinaz.tourserviceplatform.entity.User;
import jakarta.ejb.Stateful;
import jakarta.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Stateful
public class ReservationSessionBean {

    @Inject
    private ReservationDAO reservationDAO;

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
        reservationDTO.setReservationTime(reservation.getReservationTime());
        reservationDTO.setScenicSpotName(reservation.getScenicSpot().getName());
        reservationDTO.setScenicSpotDescription(reservation.getScenicSpot().getDescription());
        reservationDTO.setScenicSpotImageUrl(reservation.getScenicSpot().getImageUrl());
        return reservationDTO;
    }
}
