package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CityOperationsTest {
    static CityOperations coperations;
    static ArrayList<Cities> cities;

    @BeforeEach
    void setUp() {
        coperations = new CityOperations();
        cities = new ArrayList<Cities>();
        //int id, String name, int cid, String code,int state_code, float latitude, float longitude
        cities.add(new Cities(135335, "Airole",  107, "IT",1768, 43.0f, 7.0f));
        cities.add(new Cities(135336, "Airuno",  107, "IT",1705, 45.0f, 9.0f));
        cities.add(new Cities(135337, "Aisone",  107, "IT",1702, 44.0f, 7.0f));
        cities.add(new Cities(141853, "Aistala",  107, "IT",4853, 23.0f, 88.0f));
        cities.add(null);
    }

    @Test
    void getCitesBetween() {
    }

    @Test
    void getCitiesbyName() {
    }

    @Test
    void getCitiesbyCountryCode() {
    }

    @Test
    void display() {
        coperations.display(null);
        coperations.display(cities);
    }
}