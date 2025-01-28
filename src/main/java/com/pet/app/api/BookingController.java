package com.pet.app.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.pet.app.booking.Booking;
import com.pet.app.booking.BookingService;
import com.pet.app.fare.FareService;

@Controller
@RequestMapping("/pet-bookings")
public class BookingController {

    private final BookingService bookingService;
    private final FareService fareService;

    public BookingController(BookingService bookingService, FareService fareService) {
        this.bookingService = bookingService;
        this.fareService = fareService;
    }
    
    // Display the booking page
    @GetMapping("/schedule-appointment")
    public String showBookingPage() {
        return "schedule-appointment"; // Ensure this template exists
    }

    // Process the booking form
    @PostMapping("/schedule-appointment")
    public String createBooking(@RequestParam String ownerName,
                                @RequestParam String petName,
                                @RequestParam String petBreed,
                                @RequestParam String appointmentDate,
                                @RequestParam String serviceType,
                                Model model) {
        Booking booking = new Booking();
        booking.setOwnerName(ownerName);
        booking.setPetName(petName);
        booking.setPetBreed(petBreed);
        booking.setAppointmentDate(appointmentDate);
        booking.setServiceType(serviceType);

        bookingService.createBooking(booking);

        double cost = fareService.calculateCost(petBreed);
        model.addAttribute("cost", cost);

        return "display-cost"; // Ensure display-cost.html exists
    }
}
