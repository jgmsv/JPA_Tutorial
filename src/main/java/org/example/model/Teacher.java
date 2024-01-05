package org.example.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "teacher")
    List<Vehicle> vehicles;

    @OneToOne(mappedBy = "teacherSpot")
    private ParkingSpot parkingSpot;

    public Teacher(String name) {
        this.name = name;
    }

    public Teacher() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void addVehicle(Vehicle vehicle) {
        if (vehicles == null) {
            vehicles = new ArrayList<>();
        }
        vehicles.add(vehicle);
        vehicle.setTeacher(this);
    }
    public List<Vehicle> getVehicles() {

        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return
                " id=" + id +
                ", name='" + name + '\''
                ;
    }

    public ParkingSpot getParkingSpot(){return parkingSpot;}

    public void setParkingSpot(ParkingSpot parkingSpot){this.parkingSpot = parkingSpot;}
}



