package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {



        //
//        binh.add(new FullTime("name1", "id1", 18, "HN", 01,
//                "dang lam", "use1", 01, 1000, 300, 100));
//        binh.add(new FullTime("name2", "id2", 19, "Hp", 02,
//                "da nghi", "use2", 01, 1000, 200, 100));
//        binh.add(new FullTime("name3", "id3", 18, "HN", 03,
//                "dang lam", "use3", 01, 1000, 400, 100));
//
//        binh.add(new PartTime("name2", "id4", 20, "QN", 04,
//                "dang lam", "use04", 04, 10, 100));
//        binh.add(new PartTime("name5", "id5", 22, "QN", 05,
//                "da nghi", "use05", 05, 10, 100));
//        binh.add(new PartTime("name6", "id6", 21, "QN", 06,
//                "dang lam", "use06", 06, 10, 100));






//        Scanner scanner = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        Integer input = null;
        do {

            System.out.println("Please enter number: ");

            String s = in.nextLine();

            try {


                input = Integer.parseInt(s);

            } catch (NumberFormatException e) {

                System.out.println("ERROR: " + s + " is not a number.");
            }

        } while (input == null);
//        String name = checkEmpty();
//        System.out.println( name);
//        int i = scanner.nextInt();
//        System.out.println(i);
//        name.isEmpty();

    }



}
