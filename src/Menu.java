/**
 * Created by M4teo on 02.03.2017.
 */

import java.io.IOException;
import java.util.*;
import java.lang.*;

public class Menu
{
    public static void main(String[] args)
    {
        Figure aFigure = null;

        int choice = 0;
        int choice2 = 0;
        do
        {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Choose option:");
            System.out.println("1. Triangle");
            System.out.println("2. Square");
            System.out.println("3. Circle");
            System.out.println("0. Close programme");

            choice = scanner.nextInt();

            switch(choice)
            {
                case 1:
                    do
                    {
                        System.out.println("Choose option:");
                        System.out.println("1. Create new");
                        System.out.println("2. Print");
                        System.out.println("3. Calculate area");
                        System.out.println("4. Calculate perimeter");
                        System.out.println("0. Previous menu");

                        choice2 = scanner.nextInt();

                        switch(choice2)
                        {
                            case 1:
                                aFigure = EnterData.enterTriangle();
                                break;

                            case 2: // ten if do sprawdzania typu na ktory pokazuje aFigure to mi wyszedł bardzo crazy, ale działa haha :D
                                if( aFigure != null && ("class Triangle".equalsIgnoreCase(aFigure.getClass().toString())) )
                                    aFigure.print();
                                else
                                    System.out.println("Triangle may not have been initialized");
                                break;

                            case 3:
                                if( aFigure != null && ("class Triangle".equalsIgnoreCase(aFigure.getClass().toString())) )
                                    System.out.println("Area: " + aFigure.calculateArea());
                                else
                                    System.out.println("Triangle may not have been initialized");
                                break;

                            case 4:
                                if( aFigure != null && ("class Triangle".equalsIgnoreCase(aFigure.getClass().toString())) )
                                    System.out.println("Perimeter: " + aFigure.calculatePerimeter());
                                else
                                    System.out.println("Triangle may not have been initialized");
                                break;
                        }
                    }while(choice2 != 0);
                    break;

                case 2:
                    do
                    {
                        System.out.println("Choose option:");
                        System.out.println("1. Create new");
                        System.out.println("2. Print");
                        System.out.println("3. Calculate area");
                        System.out.println("4. Calculate perimeter");
                        System.out.println("0. Previous menu");

                        choice2 = scanner.nextInt();

                        switch(choice2)
                        {
                            case 1:
                                aFigure = EnterData.enterSquare();
                                break;

                            case 2:
                                if( aFigure != null && ("class Square".equalsIgnoreCase(aFigure.getClass().toString())) )
                                    aFigure.print();
                                else
                                    System.out.println("Square may not have been initialized");
                                break;

                            case 3:
                                if( aFigure != null && ("class Square".equalsIgnoreCase(aFigure.getClass().toString())) )
                                    System.out.println("Area: " + aFigure.calculateArea());
                                else
                                    System.out.println("Square may not have been initialized");
                                break;

                            case 4:
                                if( aFigure != null && ("class Square".equalsIgnoreCase(aFigure.getClass().toString())) )
                                    System.out.println("Perimeter: " + aFigure.calculatePerimeter());
                                else
                                    System.out.println("Square may not have been initialized");
                                break;
                        }
                    }while(choice2 != 0);
                    break;

                case 3:
                    do
                    {
                        System.out.println("Choose option:");
                        System.out.println("1. Create new");
                        System.out.println("2. Print");
                        System.out.println("3. Calculate area");
                        System.out.println("4. Calculate perimeter");
                        System.out.println("0. Previous menu");

                        choice2 = scanner.nextInt();

                        switch(choice2)
                        {
                            case 1:
                                aFigure = EnterData.enterCircle();
                                System.out.println(aFigure.getClass().toString());
                                break;

                            case 2:
                                if( aFigure != null && ("class Circle".equalsIgnoreCase(aFigure.getClass().toString())) )
                                    aFigure.print();
                                else
                                    System.out.println("Circle may not have been initialized");
                                break;

                            case 3:
                                if( aFigure != null && ("class Circle".equalsIgnoreCase(aFigure.getClass().toString())) )
                                    System.out.println("Area: " + aFigure.calculateArea());
                                else
                                    System.out.println("Circle may not have been initialized");
                                break;

                            case 4:
                                if( aFigure != null && ("class Circle".equalsIgnoreCase(aFigure.getClass().toString())) )
                                    System.out.println("Perimeter: " + aFigure.calculatePerimeter());
                                else
                                    System.out.println("Circle may not have been initialized");
                                break;
                        }
                    }while(choice2 != 0);
                    break;
            }
        }while(choice != 0);
    }
}

class EnterData
{
    static Triangle enterTriangle()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a: ");
        int a = scanner.nextInt();

        System.out.println("Enter b: ");
        int b = scanner.nextInt();

        System.out.println("Enter c: ");
        int c = scanner.nextInt();

        System.out.println("Enter h: ");
        int h = scanner.nextInt();

        return new Triangle(a,b,c,h);
    }

    static Circle enterCircle()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter r: ");
        int r = scanner.nextInt();

        return new Circle(r);
    }

    static Square enterSquare()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a: ");
        int a = scanner.nextInt();

        return new Square(a);
    }
}

abstract class Figure implements Print
{
    abstract protected double calculateArea();
    abstract protected double calculatePerimeter();
}

interface Print
{
    void print();
}

class Triangle extends Figure implements Print
{
    private boolean isTriangle()
    {
        if ( a < b )
            if ( a < c )
                if ( b < c )
                    if ( ( a + b ) > c )
                        return true;
                    else
                        return false;
                else
                    if ( ( a + c ) > b )
                        return true;
                    else
                        return false;
            else
                if ( ( a + c ) > b )
                    return true;
                else
                    return false;

        else
            if( c < b )
                if ( ( c + b ) > a )
                    return true;
                else
                    return false;
            else
                if ( c < a )
                    if ( ( c + b ) > a )
                        return true;
                    else
                        return false;
                else
                    if ( (a + b) > c )
                        return true;
                    else
                        return false;
    }

    public void print()
    {
        System.out.println( "a: " + a );
        System.out.println( "b: " + b );
        System.out.println( "c: " + c );
        System.out.println( "h: " + h );
    }

    int a = 0;
    int b = 0;
    int c = 0;
    int h = 0;

    Triangle(int a, int b, int c, int h)
    {
        this.a = a;
        this.b = b;
        this.c = c;
        this.h = h;

        try
        {
          if (a <= 0 || b <= 0 || c <= 0 || h <= 0 || (isTriangle() == false))
                throw new IOException("Values should be greater than zero");
        }

        catch(IOException exception)
        {
            System.out.print("Terminating programme");
            System.exit(1);
        }
    }

    protected double calculateArea()
    {
        return (double)a*h/2;
    }

    protected double calculatePerimeter()
    {
        return (double)(a+b+c);
    }
}

class Square extends Figure implements Print
{
    public void print()
    {
        System.out.println( "a: " + a );
    }

    int a = 0;

    Square(int a)
    {
        this.a = a;

        try
        {
            if (a <= 0 )
                throw new IOException("Value should be greater than zero");

        }

        catch(IOException exception)
        {
            System.out.print("Terminating programme");
            System.exit(1);
        }
    }

    protected double calculateArea()
    {
        return (double)a*a;
    }

    protected double calculatePerimeter()
    {
        return (double)(4*a);
    }
}

class Circle extends Figure implements Print
{
    public void print()
    {
        System.out.println( "r: " + r );
    }

    int r = 0;

    Circle(int r)
    {
        this.r = r;

        try
        {
            if (r <= 0 )
                throw new IOException("Value should be greater than zero");

        }

        catch(IOException exception)
        {
            System.out.print("Terminating programme");
            System.exit(1);
        }
    }

    protected double calculateArea()
    {
        return (double)r*r*Math.PI;
    }

    protected double calculatePerimeter()
    {
        return (double)2*r*Math.PI;
    }
}