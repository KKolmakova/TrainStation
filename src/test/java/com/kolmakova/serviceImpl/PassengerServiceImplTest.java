package com.kolmakova.serviceImpl;

import com.kolmakova.entities.Document;
import com.kolmakova.entities.Passenger;
import com.kolmakova.entities.Payment;
import com.kolmakova.repositories.PassengerRepository;
import com.kolmakova.services.impl.PassengerServiceImpl;
import com.kolmakova.types.DocumentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PassengerServiceImplTest {

    @Mock
    private PassengerRepository passengerRepository;

    @InjectMocks
    private PassengerServiceImpl passengerServiceImpl;

    @Test
    public void savePassenger() {
        //GIVEN
        Passenger passenger = createPassenger(1,
                "Olga",
                "Severina",
                createDocument(DocumentType.CERTIFICATE),
                "TK009764",
                null);

        //WHEN
        when(passengerRepository.save(passenger)).thenReturn(passenger);
        Passenger savedPassenger = passengerServiceImpl.save(passenger);

        //THEN
        verify(passengerRepository).save(passenger);
    }

    @Test
    public void containsPayment() {
        //GIVEN
        Passenger passenger = createPassenger(null, null,
                null,
                null,
                null,
                createSmallPaymentList());

        List<Passenger> passengerList = new ArrayList<>();
        passengerList.add(passenger);

        //WHEN
        int containsId = 1;
        int notContainsId = 3;

        boolean containsPayment = passengerServiceImpl.containsPayment(passengerList, containsId);
        boolean notContainsPayment = !passengerServiceImpl.containsPayment(passengerList, notContainsId);

        //THEN
        assert (containsPayment);
        assert (notContainsPayment);

    }

    @Test
    public void containsPassenger() {
        //GIVEN
        Passenger passenger1 = createPassenger(1, null, null, null, null, null);
        Passenger passenger2 = createPassenger(2, null, null, null, null, null);

        List<Passenger> passengerList = new ArrayList<>();
        passengerList.add(passenger1);
        passengerList.add(passenger2);

        //WHEN
        int containsId = 1;
        int notContainsId = 3;

        boolean containsPayment = passengerServiceImpl.containsPassenger(passengerList, containsId);
        boolean notContainsPayment = !passengerServiceImpl.containsPassenger(passengerList, notContainsId);

        //THEN
        assert (containsPayment);
        assert (notContainsPayment);
    }

    private Passenger createPassenger(Integer id, String name, String surname, Document document, String documentSeries, List<Payment> paymentList) {
        Passenger passenger = new Passenger();

        passenger.setId(id);
        passenger.setName(name);
        passenger.setSurname(surname);
        passenger.setDocumentType(document);
        passenger.setDocumentSeries(documentSeries);
        passenger.setPaymentList(paymentList);

        return passenger;
    }

    private Document createDocument(DocumentType documentType) {
        Document document = new Document();
        document.setType(documentType);

        return document;
    }

    private List<Payment> createSmallPaymentList() {
        List<Payment> paymentList = new ArrayList<>();

        Payment payment1 = new Payment();
        payment1.setId(1);
        Payment payment2 = new Payment();
        payment2.setId(2);

        paymentList.add(payment1);
        paymentList.add(payment2);

        return paymentList;
    }
}
