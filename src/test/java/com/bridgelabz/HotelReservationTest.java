package com.bridgelabz;


import org.junit.jupiter.api.Test;

public class HotelReservationTest {

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

     class HotelReservationTest {



        @Test
        public void test() {

            HotelReservation.HotelReservation hotels = new HotelReservation();

            hotels.addNewHotel("Lakewood", 110);
            hotels.addNewHotel("Bridgewood", 160);
            hotels.addNewHotel("Ridgewood", 220);

            Assertion.assertEquals(3, hotels.countNoOfHotels());
        }

    }
}
