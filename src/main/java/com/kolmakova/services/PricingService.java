package com.kolmakova.services;

import com.kolmakova.entities.Pricing;

public interface PricingService {

    Pricing getById(int pricingId);

    Pricing save(Pricing pricing);
}
