package com.kolmakova.services.impl;

import com.kolmakova.entities.Pricing;
import com.kolmakova.repositories.PricingRepository;
import com.kolmakova.services.PassengerService;
import com.kolmakova.services.PricingService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PricingServiceImpl implements PricingService {

    private static final Logger LOG = Logger.getLogger(PricingService.class);

    @Autowired
    private PricingRepository pricingRepository;

    @Override
    public Pricing getById(int pricingId) {
        return pricingRepository.getOne(pricingId);
    }

    @Override
    public Pricing save(Pricing pricing) {
        LOG.info(String.format("Prising number %s was update", pricing.getId()));

        return pricingRepository.save(pricing);
    }
}
