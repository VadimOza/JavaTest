package com.vadimozarinskiy.Task5;

import java.io.Serializable;

/**
 * Created by root on 02.01.17.
 */
public abstract class AbstractEmployee implements Serializable{
    private int id;
    private double salary;
    private String firstname;
    private String lastname;

    public AbstractEmployee(int id,double salary, String firstname, String lastname) {
        this.id = id;
        this.salary = salary;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public AbstractEmployee setId(int id) {
        this.id = id;
        return this;
    }

    public double getSalary() {
        return salary;
    }

    public AbstractEmployee setSalary(double salary) {
        this.salary = salary;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public AbstractEmployee setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public AbstractEmployee setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    @Override
    public String toString() {
        return "" + id + ' ' + firstname + ' ' + getAvarageMonthlySalary();
    }

    public abstract double getAvarageMonthlySalary();
}
