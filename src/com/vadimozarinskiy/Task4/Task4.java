package com.vadimozarinskiy.Task4;

/**
 * Created by root on 02.01.17.
 */
public class Task4 {
}

class Customer {

    private String name;

    // Other fields, constructors, get, set, etc. //
    public Customer(String name) {
        this.name=name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

// Other methods.
}

class Rental {
    private int kind;
    private int days;

    // Other fields, constructors, get, set, etc. //
    public Rental(int kind, int days) {
        this.kind = kind;
        this.days = days;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    private double amountFor() {
        double result;
// Another code.
        result=days*getBasePrice();
        if (kind==1) {
            result=result*1.5;
        }
        if (kind==2) {
            result=result*2;
        }
        if (kind==3) {
            result=result*2.5;
        }
        if (kind>7) {
            result=result*3;
        }
        // Other calculation.
        return result;
    }

    public double getBasePrice() {
        // Calculation of Price.
        // . . .
        return 2.0;
    }
    // Other methods.
}

/*When we moving method amountFor to the Rental class, we decrease dependency between Rental and Customer classes.
* For more readability, kind may change from int to ENUM.
*/

