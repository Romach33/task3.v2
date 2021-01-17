package com.company.number2;

import java.util.Locale;
import java.util.Scanner;

public class Main {


    public static double inputDouble(String name) {
        Scanner scn = new Scanner(System.in);

        System.out.printf("Input %s: ", name);
        return scn.nextDouble();
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        ChoiseColor.Test();

        double x = inputDouble("X");
        double y = inputDouble("Y");
        ChoiseColor.printColorForPoint(x, y);
    }


}

class ChoiseColor {
    public static final HorizontalParabola P = new HorizontalParabola(-4, -3, -0.25);
    public static final Square S = new Square(-6, 3, -2, -2);
    public static final Square S2 = new Square(-2, 6, 1, 3);
    public static final Square S3 = new Square(1, 3, 2, -2);
    public static final Square S4 = new Square(-2, -2, 1, -4);


    public static SimpleColor getColor(double x, double y) {


        if ((S.isPointAboveSquare(x, y) && P.isPointInParabola(x, y)) || S2.isPointAboveSquare(x, y)) {
            return SimpleColor.BLUE;
        }
        if ((S.isPointAboveSquare(x, y) && !P.isPointInParabola(x, y)) || S3.isPointAboveSquare(x, y)) {
            return SimpleColor.GRAY;
        }
        if (S4.isPointAboveSquare(x, y)) {
            return SimpleColor.GREEN;
        }
        return SimpleColor.ORANGE;
    }

    public static void printColorForPoint(double x, double y) {
        SimpleColor color = getColor(x, y);
        System.out.printf("(%s, %s) -> %s%n", x, y, color);
    }

    public static void Test() {
        printColorForPoint(-1, 1); //ORANGE
        printColorForPoint(1.5, 2); //GRAY
        printColorForPoint(-1, -3); //GREEN
        printColorForPoint(-3, 2); //GRAY
        printColorForPoint(0, 4); //BLUE
        printColorForPoint(-9, -2); //ORANGE
        printColorForPoint(-5.5, -1.5); //BLUE
        printColorForPoint(-2, -2); //ORANGE,GRAY,GREEN
    }
}
