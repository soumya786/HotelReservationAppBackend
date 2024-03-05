package com.developer.HotelApp.repo;

import com.developer.HotelApp.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationRepo extends JpaRepository<Reservation, Long> {
    void deleteReservationById(Long id);

    Optional<Reservation> findReservationById(Long id);
}
