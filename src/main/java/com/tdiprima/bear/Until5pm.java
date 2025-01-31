/**
 * Extend the Until5pm.java program to report the number
 * of hours and minutes until 5pm today (or tomorrow if it is past 5pm).
 * Creation date: (11/14/2002 9:08:47 AM)
 *
 * @author: Tammy DiPrima
 */
package com.tdiprima.bear;

class Until5pm {
  /**
   * Until5pm constructor comment.
   */
  public Until5pm() {
    super();
  }

  /**
   * Main method.
   * Creation date: (11/25/2002 3:18:06 PM)
   *
   * @param args java.lang.String[]
   */
  public static void main(String[] args) {
    java.util.Date d = new java.util.Date();
    String datestr = d.toString();

    int colon = datestr.indexOf(":");
    String hrstr = datestr.substring(colon - 2, colon);

    // Integer hourInt = new Integer(hrstr);
    // Integer iVar = Integer.parseInt(s);
    Integer hourInt = Integer.parseInt(hrstr);

    int hour = hourInt.intValue();
    // int minutes = new Integer(datestr.substring(colon + 1, colon + 3)).intValue();
    int minutes = Integer.parseInt(datestr.substring(colon + 1, colon + 3));
    int fivepm = 17; // date uses 24-hour clock
    int hourCorrection = 1; // don't subtract 1 from hour if minutes == 0

    if (minutes == 0) {
      hourCorrection = 0;
    }

    if (hour < fivepm) {
      System.out.print("There are ");

      if ((fivepm - hour - hourCorrection) != 0) {
        System.out.print((fivepm - hour - hourCorrection) + " hours");
      }

      if (minutes != 0) {
        if ((fivepm - hour - hourCorrection) != 0)
          System.out.print(" and ");

        System.out.print((60 - minutes));
        System.out.print(" minutes");
      }
      System.out.println(" until 5pm, today");
    } else {
      System.out.print(
        "There are " + (24 - (hour - fivepm) - hourCorrection) + " hours");
      if (minutes != 0) {
        System.out.print(" and ");
        System.out.print((60 - minutes));
        System.out.print(" minutes");
      }
      System.out.println(" until 5pm, tomorrow");
    }
  }
}
