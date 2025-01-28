package com.pet.app.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pet.app.fare.FareService;

@RestController
@RequestMapping("/api/fares")
public class FareController {

    private final FareService fareService;

    public FareController(FareService fareService) {
        this.fareService = fareService;
    }

    @GetMapping("/calculate")
    public ResponseEntity<Double> calculateCost(@RequestParam String petBreed) {
        try {
            double cost = fareService.calculateCost(petBreed);
            return ResponseEntity.ok(cost);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
