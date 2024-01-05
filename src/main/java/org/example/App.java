package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.example.model.ParkingSpot;
import org.example.model.Teacher;
import org.example.model.Vehicle;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class App {

    public static void main( String[] args ) throws SQLException {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("database");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        // Exercise 1.1 listing all the vehicles
        String queryString = "SELECT vehicles FROM Vehicle vehicles";

        TypedQuery<Vehicle> query = entityManager.createQuery(queryString, Vehicle.class);

        List<Vehicle> vehicles = query.getResultList();

        System.out.println(vehicles);

        System.out.println("#".repeat(20) + " ----1");

        // Exercise 1.2 finding the vehicle assigned to an particular spot
        String queryString1 = "SELECT vehicle.vehiclePlate FROM Vehicle vehicle WHERE vehicle.teacher.parkingSpot.id = 1";

        TypedQuery<String> query1 = entityManager.createQuery(queryString1, String.class);

        List<String> vehiclePlates = query1.getResultList();

        System.out.println(vehiclePlates);

        System.out.println("#".repeat(20) + " ----2");


        // Exercise 1.3 finding the owner of a particular vehicle

        String queryString2 = "SELECT teacher.name FROM Vehicle vehicle WHERE vehicle.vehiclePlate = 'AA-BB-CC'";

        TypedQuery<Teacher> query2 = entityManager.createQuery(queryString2, Teacher.class);

        List<Teacher> teachers = query2.getResultList();

        System.out.println(teachers);

        System.out.println("#".repeat(20) + " ----3");

        entityManager.close();
        entityManagerFactory.close();


 /*
        Teacher teacher1 = new Teacher();
        teacher1.setName("Jose");
        Teacher teacher2 = new Teacher();
        teacher2.setName("Joana");

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehiclePlate("AA-BB-CC");
        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehiclePlate("AA-DD-CC");
        Vehicle vehicle3 = new Vehicle();
        vehicle3.setVehiclePlate("AA-EE-CC");
        Vehicle vehicle4 = new Vehicle();
        vehicle4.setVehiclePlate("AA-FF-CC");

        ParkingSpot parkingSpot1 = new ParkingSpot();
        ParkingSpot parkingSpot2 = new ParkingSpot();
        ParkingSpot parkingSpot3 = new ParkingSpot();


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("database");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        teacher1.addVehicle(vehicle1);
        teacher1.addVehicle(vehicle2);
        teacher2.addVehicle(vehicle3);
        teacher2.addVehicle(vehicle4);

        entityManager.persist(teacher1);
        entityManager.persist(teacher2);
        entityManager.persist(vehicle1);
        entityManager.persist(vehicle2);
        entityManager.persist(vehicle3);
        entityManager.persist(vehicle4);
        entityManager.persist(parkingSpot1);
        entityManager.persist(parkingSpot2);
        entityManager.persist(parkingSpot3);

        parkingSpot1.setTeacherSpot(teacher1);
        parkingSpot2.setTeacherSpot(teacher2);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

  */


    }



    }

