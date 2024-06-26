package com.example;

import com.google.gson.Gson;
import java.util.*;

public class App {

    // Full file:
    private static String dataFilePath = "C:/Users/Brendan/Documents/GitHub/class-lab-week9/demo/src/main/java/com/example/mapTestData.json";
    // Test file:
    // private static String dataFilePath =
    // "C:/Users/Brendan/Documents/GitHub/class-lab-week9/demo/src/main/java/com/example/mapTest7.json";

    public static SinglyLinkedList process(SinglyLinkedList input) {
        SinglyLinkedList answer = new SinglyLinkedList();

        /*
         * STUDENTS NEED TO ADD/EDIT CODE STARTING HERE
         */

        LinkedListNode curr = input.head;
        int counter1 = 0;
        while (curr != null) {
            answer.insert(curr.turnRight, curr.street, curr.distance);
            curr = curr.next;
            counter1++;
        }
        int halfway = counter1 / 2;
        LinkedListNode prev = null;
        LinkedListNode next = null;
        curr = answer.head;
        int counter2 = 0;
        while (curr != null) {
            curr.turnRight = curr.turnRight ? false : true;
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            counter2++;
            if (counter2 == halfway) {
                break;
            }
        }
        answer.head = prev;
        //
        /*
         * STUDENTS DO NOT NEED TO EDIT ANY CODE AFTER THIS
         */

        // return the answer
        return answer;
    }

    public static void main(String[] args) {
        LabTestData td = new LabTestData();

        // read data
        String jsonStr = td.readJSON(dataFilePath);

        // convert data to obj
        Gson gson = new Gson();
        LabTestData testData = gson.fromJson(jsonStr, LabTestData.class);

        // run each test
        for (int i = 0; i < testData.tests.length; i += 1) {
            SinglyLinkedList input = testData.tests[i].input;
            SinglyLinkedList answer = process(input);
            SinglyLinkedList correctAnswer = testData.tests[i].output;

            System.out.printf("--------------------------------------\n");

            // if answer is correct, report results
            if (answer.equals(correctAnswer)) {
                System.out.printf("PASSED test %d :\n", i);
                // if answer is incorrect, report the error
            } else {
                System.out.printf("FAILED test %d\n", i);
            }

            System.out.printf("\ninput:\n");
            input.print();
            System.out.printf("\noutput:\n");
            answer.print();

            System.out.printf("--------------------------------------\n\n");
        }
    }
}
