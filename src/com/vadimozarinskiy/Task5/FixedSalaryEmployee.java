package com.vadimozarinskiy.Task5;

/**
 * Created by root on 02.01.17.
 */
public class FixedSalaryEmployee extends AbstractEmployee{


    public FixedSalaryEmployee(int id,double salary, String firstname, String lastname) {
        super(id, salary, firstname, lastname);
    }

    @Override
    public double getAvarageMonthlySalary() {
        return getSalary();
    }
}
