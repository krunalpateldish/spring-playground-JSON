package com.example;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by trainer2 on 4/8/17.
 */

@RestController
public class FlightController {

    @PostMapping("/flights/tickets/total")
    public Flights.Result calculateTotalPrice(@RequestBody String FlightJsonString) {
        Gson gson = new Gson();
        Double totalPrice=0.0;
        Flights flightJson = gson.fromJson(FlightJsonString, Flights.class);
        List<Flights.Tickets> tickets = flightJson.getTickets();
        if(tickets!=null) {
            for (int i = 0; i < tickets.size(); i++) {

                double currentTicketPrice = tickets.get(i).getPrice();

                totalPrice = totalPrice + currentTicketPrice;
            }
        }

        Flights.Result result = new Flights.Result(totalPrice);
        return result;
    }
}