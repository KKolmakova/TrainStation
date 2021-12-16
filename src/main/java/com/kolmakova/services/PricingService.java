package com.kolmakova.services;

import com.kolmakova.entities.Pricing;
import com.kolmakova.repositories.PricingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PricingService {

    @Autowired
    private PricingRepository pricingRepository;

    public Pricing getPricingById(int pricingId) {
        return pricingRepository.getOne(pricingId);
    }

    public Pricing savePricing(Pricing pricing){
        return pricingRepository.save(pricing);
    }
}
