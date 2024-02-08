package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        IShape[] shapes = {
                new Circle(2),
                new Circle(5),
                new Rectangle(2, 4),
                new Rectangle(4, 7)
        };

        for (IShape shape : shapes) {
            System.out.println(shape.determineArea());
        }

        Circle[] circles = {
                new Circle(4),
                new Circle(6),
                new Circle(2),
                new Circle(15),
                new Circle(7)
        };

        System.out.println(circles[0].compareTo(circles[1]));
        Arrays.sort(circles);

        for(Circle c : circles ) {
            System.out.println(c.determineArea());
        }
    }
}