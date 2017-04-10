package com.example;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;
/**
 * Created by trainer2 on 4/8/17.
 */
public class Flights {


    private Date departs;


    private List<Tickets> tickets;


  @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd hh:mm", timezone="America/Denver")
    public Date getDeparts() { return departs; }

    public void setDeparts(Date dateTime) { this.departs = dateTime; }

    public List<Tickets> getTickets() {
        return tickets;
    }

    public void setTickets(List<Tickets> tickets) {
        this.tickets = tickets;
    }


    static class Person {
        private String firstName;
        private String lastName;

        public String getFirstName() { return firstName; }

        public void setFirstName(String firstName) { this.firstName = firstName; }

        public String getLastName() { return lastName; }

        public void setLastName(String lastName) { this.lastName = lastName; }
    }
    static class Tickets {
        private Person passenger;
        private double price;

        public Person getPassenger() { return passenger; }

        public void setPassenger(Person passenger) { this.passenger = passenger; }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

    }

}
