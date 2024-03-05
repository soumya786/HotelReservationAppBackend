package com.developer.HotelApp;

import com.developer.HotelApp.model.Reservation;
import com.developer.HotelApp.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationResource {
    private final ReservationService reservationService;

    public ReservationResource(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    @GetMapping("/allReservations")
    public ResponseEntity<List<Reservation>> getAllReservations(){
        List<Reservation> reservations = reservationService.findAllReservations();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }
    @GetMapping("/reservation/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable("id") Long id){
        Reservation reservation = reservationService.findReservationById(id);
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }
    @PostMapping("/addReservation")
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation){
        Reservation reservation1 = reservationService.addReservation(reservation);
        return new ResponseEntity<>(reservation1,HttpStatus.CREATED);
    }
    @PutMapping("/updateReservation/{id}")
    public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation){
        Reservation reservation1 = reservationService.updateReservation(reservation);
        return new ResponseEntity<>(reservation1,HttpStatus.OK);
    }

    @DeleteMapping("/deleteReservation/{id}")
    public ResponseEntity<?> deleteReservation(@PathVariable("id") Long id){
        reservationService.deleteReservation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
