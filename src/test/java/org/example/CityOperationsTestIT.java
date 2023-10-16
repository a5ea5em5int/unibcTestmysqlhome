package org.example;

import org.example.Cities;
import org.example.CityOperations;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CityOperationsTestIT {
    static CityOperations op;


    @BeforeAll
   static  void connect() throws SQLException {

        op = new CityOperations();
        op.connect();
        
    }

    @Test
    void getCitesBetween() throws SQLException {

       ArrayList<Cities> cities = op.getCitesBetween(1,3);
       Cities cities1 = cities.get(1);
       assertEquals("Arinsal",cities1.getName()," are not equal");

    }

    @Test
    void getCitiesbyName() {
    }

    @Test
    void getCitiesbyCountryCode() {
    }

    @Test
    void display() {
    }
}