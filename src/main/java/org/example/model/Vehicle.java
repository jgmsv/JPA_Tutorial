package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String vehiclePlate;

    @ManyToOne
    Teacher teacher;

    public Vehicle(String vehiclePlate){
        this.vehiclePlate = vehiclePlate;
    }
    public Vehicle() {
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    public String getVehiclePlate() {
        return vehiclePlate;
    }
    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", carRegistration='" + vehiclePlate + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
