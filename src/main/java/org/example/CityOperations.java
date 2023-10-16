package org.example;

import java.sql.*;
import java.util.ArrayList;

public class CityOperations {
   public Connection conn;

   public void connect() {
        String url = "jdbc:mysql://localhost:3307/worldtest";
        String user = "root";
        String password = "";
        int retries = 20;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {Thread.sleep(3000);
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("succesffully connected ");
                break;
            } catch (SQLException e) {
                System.out.println(e+"  trying to reconnect connection faili");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }

    public ArrayList<Cities> getCitesBetween(int id1, int id2) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("select id,name,country_id,country_code,state_id,latitude,longitude from cities where id between ? and ?");
        pstmt.setInt(1, id1);
        pstmt.setInt(2, id2);
        ResultSet rset = pstmt.executeQuery();
        ArrayList<Cities> cities = new ArrayList<>();
        while (rset.next()) {
            Cities citi = new Cities(rset.getInt("id"), rset.getString("name"), rset.getInt("country_id"), rset.getString("country_code"),
                    rset.getInt("state_id"), rset.getFloat("latitude"), rset.getFloat("longitude"));
            cities.add(citi);
        }
        return cities;
    }

    public ArrayList<Cities> getCitiesbyName(String word) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("select id,name,country_id,country_code,state_id,latitude,longitude from cities where name like ?");
        pstmt.setString(1, word + "%");
        ResultSet rset = pstmt.executeQuery();
        ArrayList<Cities> cities = new ArrayList<>();
        while (rset.next()) {
            Cities citi = new Cities(rset.getInt("id"), rset.getString("name"), rset.getInt("country_id"), rset.getString("country_code"),
                    rset.getInt("state_id"), rset.getFloat("latitude"), rset.getFloat("longitude"));
            cities.add(citi);
        }
        return cities;
    }

    public ArrayList<Cities> getCitiesbyCountryCode(int code) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("select cities.id,cities.name,country_id,country_code,state_id,cities.latitude,cities.longitude from cities, countries where cities.country_id=countries.id and countries.id=?");
        pstmt.setInt(1, code);
        ResultSet rset = pstmt.executeQuery();
        ArrayList<Cities> cities = new ArrayList<>();
        while (rset.next()) {//int id, String name, int cid, String code,int state_code, float latitude, float longitude
            Cities citi = new Cities(rset.getInt("id"), rset.getString("name"), rset.getInt("country_id"), rset.getString("country_code"),
                    rset.getInt("state_id"), rset.getFloat("latitude"), rset.getFloat("longitude"));
            cities.add(citi);
        }
        return cities;


    }

  public  void display(ArrayList<Cities> cities) {
        if (cities != null) {
            for (Cities c : cities) {
               if(c!=null) {
                   System.out.print(c);
                   System.out.println();
               }
               else
                   System.out.println(" city is null ");
            }
        }
        else System.out.println("no cities");

    }

    public static void main(String[] args) throws SQLException {
        CityOperations city = new CityOperations();
        city.connect();
        ArrayList<Cities> cities = city.getCitesBetween(5, 10);
        city.display(cities);
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println(" displaying cities by name");
        cities = city.getCitiesbyName("AI");
        city.display(cities);
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("city by country code");
        cities = city.getCitiesbyCountryCode(10);
        city.display(cities);
    }

}
