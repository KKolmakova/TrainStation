package com.kolmakova.services;

import com.kolmakova.entities.Pricing;

public interface PricingService {
    Pricing getOne(int pricingId);

    Pricing save(Pricing pricing);
}
