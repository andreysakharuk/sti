package sqvr;

public class ChapterOne {

  public static void main (String[] args) {
      int beerNum = 99;
      String word = "bottles";
      while (beerNum >= 1) {
          if (beerNum == 1) {
              word = "bottle";

          }
          System.out.println(beerNum + " " + word + " of the beer on the table.  ");
          System.out.println(beerNum + " " + word + " of the beer on the table. ");
          System.out.println("Take one. ");
          System.out.println("Ride round. ");
          beerNum = beerNum - 1;
          if (beerNum > 0) {
              System.out.println(beerNum + " " + word + " of the beer on the table. ");
          } else {
              System.out.println("There are no bottles on the table.  ");
          }
      }
  }
}
