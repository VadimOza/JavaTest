package com.vadimozarinskiy.Task5;

import java.io.*;
import java.util.*;

/**
 * Created by root on 02.01.17.
 */
public class SortEmployee {

    public static void main(String[] args) throws IOException {
        //Creating collection of Abstarc employees and add test value for it
        List<AbstractEmployee> collection = new LinkedList<AbstractEmployee>();
        collection.add(new FixedSalaryEmployee(1,2000,"aaaaa","bbbbbb"));
        collection.add(new FixedSalaryEmployee(2,3000,"cccc","ddddd"));
        collection.add(new FixedSalaryEmployee(3,4000,"eeeee","fffff"));
        collection.add(new HourlyWageEmployee(4,8.2,"gggggg","hhhhhhh"));
        collection.add(new HourlyWageEmployee(5,8.2,"kkkkkk","lllllll"));
        collection.add(new HourlyWageEmployee(6,5.2,"mmmmmm","nnnnnnn"));

        //Sorting collection via method sort. Creating Comparator for comparing values;
        collection.sort((emp1, emp2) -> {
            if (emp1.getAvarageMonthlySalary() > emp2.getAvarageMonthlySalary())
                return -1;
            if (emp1.getAvarageMonthlySalary() < emp2.getAvarageMonthlySalary())
                return 1;
            return emp1.getFirstname().compareTo(emp2.getFirstname());
        });
        collection.forEach(System.out::println);

        /*
        ----------------------PROBLEM A--------------WRITE FIRST 5 EMPLOYEES
         */
        //Getting iterator of a collection and step 5 times to print values
        System.out.println("-------PROBLEM A, first five ------------");
        Iterator<AbstractEmployee> iter =  collection.iterator();
        for (int i = 0; i < 5;i++){
            if(iter.hasNext()){
                System.out.println(iter.next());
            } else break;
        }

        /*
        ----------------------PROBLEM A--------------WRITE FIRST 5 EMPLOYEES
         */
        //Getting iterator with pointer after the last element, and step back 3 times for print values
        System.out.println("-------PROBLEM B, last three ------------");
        ListIterator<AbstractEmployee> listIter = collection.listIterator(collection.size());
        for (int i = 0;i<3;i++){
            if(listIter.hasPrevious()){
                System.out.println(listIter.previous().getId());
            } else break;
        }

         /*
        ----------------------reading and writing collection from (into) file--------------------
         */
         //Creating OOS and OIS for writing/reading objects into/from file
        System.out.println("-------------reading and writing collection from (into) file-----------");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Saved_Employees"));
        //this is test values fom collection above which writing to the file
        out.writeObject(collection.get(0));
        out.writeObject(collection.get(1));
        out.writeObject(collection.get(2));
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Saved_Employees"));
        try {
            //trying to read values from file and print it
            AbstractEmployee emp1 =  (AbstractEmployee) in.readObject();
            System.out.println(emp1);
            AbstractEmployee emp2 =  (AbstractEmployee) in.readObject();
            System.out.println(emp2);
            AbstractEmployee emp3 =  (AbstractEmployee) in.readObject();
            System.out.println(emp3);
        } catch (ClassNotFoundException e) {
            //If there was an exception writing 'Wrong format of file!'
            System.out.println("Wrong format of file!");
        }

    }
}
