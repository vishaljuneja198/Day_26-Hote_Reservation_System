package com.bridgelabz;

import org.junit.jupiter.api.Test;
import java.text.ParseException;
import static org.junit.jupiter.api.Assertions.assertEquals;


     class HotelReservationTest {



         @Test
         public void WhenHotelsAreAddedReturnSize() throws ParseException {
             HotelDetails hotel1 = new HotelDetails("Lakewood", 110);
             HotelDetails hotel2 = new HotelDetails("Bridgewood", 160);
             HotelDetails hotel3 = new HotelDetails("Ridgewood", 220);


             HotelReservation hotelReservation = new HotelReservation();
             hotelReservation.addHotel(hotel1);
             hotelReservation.addHotel(hotel2);
             hotelReservation.addHotel(hotel3);

             HotelDetails cheapestHotel = hotelReservation.findCheapestHotel();
             long totalDays = hotelReservation.getTotalNoOfDays("10Sep2020", "11Sep2020");
             long totalCost = cheapestHotel.getWeekDayRateRegCus() * totalDays;
             assertEquals(220, totalCost);
             assertEquals("Lakewood", cheapestHotel.getHotelName());

             @Test
             public void WhenHotelsAreAddedReturnSize() {
                 HotelDetails hotel1 = new HotelDetails("Lakewood", 110, 90);
                 HotelDetails hotel2 = new HotelDetails("Bridgewood", 160, 60);
                 HotelDetails hotel3 = new HotelDetails("Ridgewood", 220, 150);

                 HotelReservation hotelReservation = new HotelReservation();
                 hotelReservation.addHotel(hotel1);
                 hotelReservation.addHotel(hotel2);
                 hotelReservation.addHotel(hotel3);
                 assertEquals(3, hotelReservation.totalHotels());
             }
         }