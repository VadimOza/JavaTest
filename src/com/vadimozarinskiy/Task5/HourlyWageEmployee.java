package com.vadimozarinskiy.Task5;

/**
 * Created by root on 02.01.17.
 */
public class HourlyWageEmployee extends AbstractEmployee {

    public HourlyWageEmployee(int id, double hourlySalary, String firstname, String lastname) {
        super(id,hourlySalary, firstname, lastname);
    }

    @Override
    public double getAvarageMonthlySalary() {
        return 20.8*8*getSalary();
    }
}
