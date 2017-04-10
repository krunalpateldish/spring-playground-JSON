package com.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by trainer2 on 4/9/17.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(FlightController.class)
public class FlightControllerTest {


    @Autowired
    private MockMvc mvc;


    @Test
    public void getFlightTotalPriceWithSingleTicket() throws Exception {
        MockHttpServletRequestBuilder request = post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"tickets\":[{\"passenger\":{\"firstName\":\"Seb\",\"lastName\":\"Vet\"},\"price\":200.0}]}\t");

        this.mvc.perform(request)
                .andExpect(status().isOk());
    }

    @Test
    public void getFlightTotalPrice() throws Exception{

        List<Flights.Tickets> allTickets= new ArrayList<Flights.Tickets>();

        Flights.Tickets ticket = new Flights.Tickets();
        Flights.Tickets ticket1 = new Flights.Tickets();
        Flights.Tickets ticket2 = new Flights.Tickets();

        Flights flights = new Flights();
        Flights.Person person = new Flights.Person();
        Flights.Person person1 = new Flights.Person();
        Flights.Person person2 = new Flights.Person();

        person.setFirstName("Seb");
        person.setLastName("Vet");
        ticket.setPrice(200);
        ticket.setPassenger(person);

        person1.setFirstName("Max");
        person1.setLastName("Ves");
        ticket1.setPrice(300);
        ticket1.setPassenger(person1);

        person2.setFirstName("Dan");
        person2.setLastName("Ric");
        ticket2.setPrice(400);
        ticket2.setPassenger(person2);

        allTickets.add(ticket);
        allTickets.add(ticket1);
        allTickets.add(ticket2);
        flights.setTickets(allTickets);

        Gson builder = new GsonBuilder().create();
        String jsonString = builder.toJson(flights);
        System.out.println(jsonString);

        MockHttpServletRequestBuilder request = post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString);

        this.mvc.perform(request).andExpect(status().isOk());
    }


}

