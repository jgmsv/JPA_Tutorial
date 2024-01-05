package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "parking_spot")
public class ParkingSpot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne

    private Teacher teacherSpot;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Teacher getTeacherSpot() {
        return teacherSpot;
    }

    public void setTeacherSpot(Teacher teacherSpot) {
        this.teacherSpot = teacherSpot;
    }


}