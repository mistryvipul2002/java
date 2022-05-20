package com.programming.exercises.practice.misc;

import java.util.Random;

public class ExceptionHandling {

    public static void main(String[] args) {
        try {
            String employee = getEmployee(1);
            bookTicket(employee);
        } catch (Exception e) {
            System.out.println("Sorry cannot book tickets for now. Reason=" + e.getMessage());
        }
        
    }

    private static String getEmployee(int empId) {
        if (new Random().nextBoolean()) {
            // call service to get employee
            throw new RuntimeException("GET EMPLOYEE SERVICE ERROR");
        }
        return "Bob";
    }

    private static void bookTicket(String employee) {
        if (new Random().nextBoolean()) {
            // call service to get employee
            throw new RuntimeException("BOOK TICKET SERVICE ERROR");
        }
        
        System.out.println("Ticket booked for " + employee);
    }

}
