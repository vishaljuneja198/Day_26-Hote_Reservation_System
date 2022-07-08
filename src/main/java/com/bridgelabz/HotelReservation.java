package com.bridgelabz;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;



public class HotelReservation {
    ArrayList<HotelDetails> listOfHotels = new ArrayList<HotelDetails>();

    public void addHotel(HotelDetails obj) {
        listOfHotels.add(obj);
    }


    public long getTotalNoOfDays(String start, String end) throws ParseException {
        Date startDate = new SimpleDateFormat("ddMMMyyyy").parse(start);
        Date endDate = new SimpleDateFormat("ddMMMyyyy").parse(end);
        long TotalNoOfDays = 1 + (endDate.getTime() - startDate.getTime()) / 1000 / 60 / 60 / 24;
        return TotalNoOfDays;
    }


    public HotelDetails findCheapestHotel() {
        HotelDetails cheapestHotel = listOfHotels.stream().min(Comparator.comparingDouble(HotelDetails::getWeekDayRateRegCus))
                .orElse(null);
        return cheapestHotel;
    }


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Hotel Reservation System!");
        HotelDetails hotel1 = new HotelDetails("Lakewood", 110);
        HotelDetails hotel2 = new HotelDetails("Bridgewood", 160);
        HotelDetails hotel3 = new HotelDetails("Ridgewood", 220);
        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addHotel(hotel1);
        hotelReservation.addHotel(hotel2);
        hotelReservation.addHotel(hotel3);
        System.out.println("Enter the check in date in proper format(ddMMMyyyy) ex.7july2022");
        String startDate = sc.nextLine();
        System.out.println("Enter the check out date in proper format(ddMMMyyyy) ex.29july2020");
        String endDate = sc.nextLine();
        HotelDetails cheapestHotel = hotelReservation.findCheapestHotel();
        long totalDays = hotelReservation.getTotalNoOfDays("10Sep2020", "11Sep2020");
        long totalCost = cheapestHotel.getWeekDayRateRegCus() * totalDays;

        System.out.println("Cheapest Hotel for your stay: " + cheapestHotel.getHotelName());
        System.out.println("Total expense: " + totalCost);

    }
}