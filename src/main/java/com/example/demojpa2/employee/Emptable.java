package com.example.demojpa2.employee;

import javax.persistence.*;

@Entity
@Table(name="emptable")
public class Emptable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "empid")
    private int id;
    @Column(name = "empfirstname")
    private String FirstName;
    @Column(name = "emplastname")
    private String LastName;
    @Column(name = "empage")
    private int age;
    @Column(name= "empsalary")
    private int salary;

    public String getFirstName() {
        return FirstName;
    }

    public  void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "emptable{" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}

