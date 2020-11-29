package com.programming.exercises.practice.linkedList;

/**
 * You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1’s digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
 * EXAMPLE
 * Input: (3 -> 1 -> 5) + (5 -> 9 -> 2)
 * Output: 8 -> 0 -> 8
 */
public class Add {

    public static void main(String[] args) {
        Node num1 = Util.createRandomLinkedList(4);
        System.out.println(num1);
        Node num2 = Util.createRandomLinkedList(4);
        System.out.println(num2);

        System.out.println("Add = " + add(num1, num2));
    }

    private static Node add(Node num1, Node num2) {
        if (num1 == null) return num2;
        if (num2 == null) return num1;

        Node curr1 = num1;
        Node curr2 = num2;

        Node sum = null;

        int carry = 0;
        do {
            final int addition = (curr1 == null ? 0 : curr1.data) + (curr2 == null ? 0 : curr2.data) + carry;
            if (addition > 9) carry = 1;
            else carry = 0;

            final int digit = addition % 10;
            if (sum == null) {
                sum = new Node(digit);
            } else {
                sum.appendToLast(digit);
            }

            curr1 = curr1 == null ? null : curr1.next;
            curr2 = curr2 == null ? null : curr2.next;
        } while (curr1 != null || curr2 != null);

        if (carry > 0) sum.appendToLast(carry);

        return sum;
    }
}
