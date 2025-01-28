package com.pet.app.fare;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class FareService {

	private static final double DEFAULT_PRICE = 25.0; // Default price for breeds not listed
    private static final Map<String, Double> BREED_PRICES = new HashMap<>();

    static {
        BREED_PRICES.put("Golden Retriever", 50.0);
        BREED_PRICES.put("German Shepherd", 45.0);
        BREED_PRICES.put("Labrador Retriever", 40.0);
        BREED_PRICES.put("Poodle", 35.0);
        BREED_PRICES.put("Bulldog", 30.0);
    }

    public double calculateCost(String petBreed) {
        // Return the price based on breed or the default price if not listed
        return BREED_PRICES.getOrDefault(petBreed, DEFAULT_PRICE);
    }
}
