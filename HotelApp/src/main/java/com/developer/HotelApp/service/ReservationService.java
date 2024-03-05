package com.developer.HotelApp.service;

import com.developer.HotelApp.exceptions.UserNotFoundException;
import com.developer.HotelApp.model.Reservation;
import com.developer.HotelApp.repo.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepo reservationRepo;
    @Autowired
    public ReservationService(ReservationRepo reservationRepo){
        this.reservationRepo = reservationRepo;
    }

    public Reservation addReservation(Reservation reservation){
        return reservationRepo.save(reservation);
    }

    public List<Reservation> findAllReservations(){
        return reservationRepo.findAll();
    }
    public Reservation updateReservation(Reservation reservation){
        return reservationRepo.save(reservation);
    }

    @Transactional
    public void deleteReservation(Long id){
        reservationRepo.deleteReservationById(id);
    }

    public Reservation findReservationById(Long id){
        return reservationRepo.findReservationById(id).orElseThrow(
                () -> new UserNotFoundException("Reservation not found")
        );
    }
}
