package com.company.polymorph;

/**
 * Created by tdiprima on 12/28/15.
 */
public class Main {
    // This is just a sanity-check.

    public static void main(String[] args)
    {
        System.out.println("In main");

        Circle myCircle = new Circle();
        myCircle.set("myCircle");
        doSomething(myCircle);

        Square mySquare = new Square();
        mySquare.set("mySquare");
        doSomething(mySquare);

    }

    public static void doSomething(Thing x)
    {
        x.identify();
        System.out.println(x.getWhatever());
    }
}
