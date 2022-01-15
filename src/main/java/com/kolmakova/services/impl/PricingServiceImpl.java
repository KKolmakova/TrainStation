package com.kolmakova.services.impl;

import com.kolmakova.entities.Pricing;
import com.kolmakova.repositories.PricingRepository;
import com.kolmakova.services.PricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PricingServiceImpl implements PricingService {

    @Autowired
    private PricingRepository pricingRepository;

    @Override
    public Pricing getById(int pricingId) {
        return pricingRepository.getOne(pricingId);
    }

    @Override
    public Pricing save(Pricing pricing) {
        return pricingRepository.save(pricing);
    }
}
