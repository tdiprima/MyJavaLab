package com.tdiprima.crunchify;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Crunchify.com
 */

public class CrunchifyIterateThroughList {

    public static void main(String[] argv) {

        // create list
        List<String> CrunchifyList = new ArrayList<String>();

        // add 4 different values to list
        CrunchifyList.add("eBay");
        CrunchifyList.add("Paypal");
        CrunchifyList.add("Google");
        CrunchifyList.add("Yahoo");

        // iterate via "for loop"
        System.out.println("==> For Loop Example.");
        for (int i = 0; i < CrunchifyList.size(); i++) {
            System.out.println(CrunchifyList.get(i));
        }

        // iterate via "enhanced for loop", aka "for-each loop"
        System.out.println("\n==> Advanced For-Loop Example..");
        for (String temp : CrunchifyList) {
            System.out.println(temp);
        }

        // iterate via "iterator loop"
        System.out.println("\n==> Iterator Example...");
        Iterator<String> CrunchifyIterator = CrunchifyList.iterator();
        while (CrunchifyIterator.hasNext()) {
            System.out.println(CrunchifyIterator.next());
        }

        // iterate via "while loop"
        System.out.println("\n==> While Loop Example....");
        int i = 0;
        while (i < CrunchifyList.size()) {
            System.out.println(CrunchifyList.get(i));
            i++;
        }

        // collection stream() util: Returns a sequential Stream with this collection as its source
        System.out.println("\n==> collection stream() util....");
        CrunchifyList.forEach((temp) -> {
            System.out.println(temp);
        });
    }
}
