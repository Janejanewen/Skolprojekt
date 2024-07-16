package com.example.marstravels;


import javaClass.Cabin;
import javaClass.FoodPackage;

import java.time.LocalDate;

/**
 * A booking with a cabin, food package, etc.
 */
public class Booking {
    public Cabin _cabin;
    public FoodPackage _foodPackage;

    public LocalDate _departureDate;

    public int _movieTickets;
    public int _concertTickets;
    public int _theatreTickets;
}
