package com.kolmakova.controllers;

import com.kolmakova.dto.PassengerDTO;
import com.kolmakova.responseServices.CreatePaymentResponseService;
import com.kolmakova.responseServices.ReceiptListResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private CreatePaymentResponseService createPaymentResponseService;
    @Autowired
    private ReceiptListResponseService receiptListResponseService;

    @GetMapping("{id}")
    public String getOne(Model model,
                         @PathVariable("id") Integer paymentId) {
        model.addAttribute("payment", true);
        model.addAttribute("response", createPaymentResponseService.getResponse(paymentId));

        return "trainStation";
    }

    @PostMapping("/create")
    public String createPayment(PassengerDTO passengerDTO,
                                @RequestParam("trainId") Integer trainId,
                                @RequestParam("pricingId") Integer pricingId) {
        return "redirect:" + createPaymentResponseService.create(passengerDTO, trainId, pricingId).getPaymentDTO().getId();
    }

    @GetMapping("/passenger/{passengerId}/receipts")
    private String printAllPayments(Model model,
                                    @PathVariable("passengerId") Integer passengerId) {
        model.addAttribute("receipts", true);
        model.addAttribute("response", receiptListResponseService.getResponse(passengerId));

        return "trainStation";
    }
}
