package me.kinaz.tourserviceplatform.service;

import me.kinaz.tourserviceplatform.dao.ReservationDAO;
import me.kinaz.tourserviceplatform.dto.ReservationDTO;
import me.kinaz.tourserviceplatform.entity.Reservation;
import me.kinaz.tourserviceplatform.entity.User;
import me.kinaz.tourserviceplatform.entity.ScenicSpot;
import me.kinaz.tourserviceplatform.entity.Ticket;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Stateless
public class ReservationService {
    @Inject
    private ReservationDAO reservationDAO;

    @Inject
    private TicketService ticketService;

    public void addOrUpdateReservation(ReservationDTO reservationDTO) {
        User user = new User();
        user.setId(reservationDTO.getUserId());

        ScenicSpot scenicSpot = new ScenicSpot();
        scenicSpot.setId(reservationDTO.getScenicSpotId());

        Reservation existingReservation = reservationDAO.findReservationByUserAndScenicSpot(user, scenicSpot);

        if (existingReservation == null) {
            Reservation reservation = new Reservation();
            reservation.setUser(user);
            reservation.setScenicSpot(scenicSpot);
            reservation.setReservationTime(reservationDTO.getReservationTime());
            reservationDAO.createReservation(reservation);

            // 创建ticket
            String ticketCode = UUID.randomUUID().toString();
            Ticket ticket = new Ticket();
            ticket.setUser(user);
            ticket.setScenicSpot(scenicSpot);
            ticket.setTicketCode(ticketCode);
            ticket.setCheckedIn(false);
            ticket.setCheckinTime(null);
            ticketService.createTicket(ticket);
        } else {
            existingReservation.setReservationTime(reservationDTO.getReservationTime());
            reservationDAO.updateReservation(existingReservation);
        }
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
        reservationDTO.setReservationTime(reservation.getReservationTime());
        reservationDTO.setScenicSpotName(reservation.getScenicSpot().getName());
        reservationDTO.setScenicSpotDescription(reservation.getScenicSpot().getDescription());
        reservationDTO.setScenicSpotImageUrl(reservation.getScenicSpot().getImageUrl());
        return reservationDTO;
    }
}
