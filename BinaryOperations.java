package test_Ground;

import java.util.Scanner;

public class BinaryOperations {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int a = in.nextInt();// this just ensures only digits are given, up to 10 inclusive
    int b = in.nextInt();
    //System.out.println(sum(a, b));
    System.out.println(mult(a, b));
  }

  public static String mult(int a, int b) {
    String result = "";
    int powerOfTen = 0;
    if (a > b) {// make the smallest number to be A instead of coding for both cases
      int tmp = a;
      a = b;
      b = tmp;
    } // so we have fewer multiplication operations
    //aka no of digits of A
    while (a != 0) {
      int aMod = a % 10;// last digit of A
      a = a / 10;//discard last digit
      //  need B intact for each step
      int bTmp = b;
      String tmpResult = "";
      while (bTmp != 0) {
        int bMod = b % 10;// last digit of B
        bTmp = bTmp / 10; //discard last digit
        // concatenate the product of the last digits with our temp result
        tmpResult = "" + (aMod * bMod) + tmpResult;
      }
      // multiply each temp result by 10 at the power of the digit we are at
      int multiplied = Integer.valueOf(tmpResult) * (int) Math.pow(10, powerOfTen++);
      // then add to main result
      result = sum(Integer.valueOf(result), multiplied);
    }
    return result;
  }

  public static String sum(int a, int b) {
    int crossover = 0;// what we keep from last step
    int digit = 0;
    String result = "";
    boolean ok = true;
    while (ok) {//til both numbers reach 0
      int aLast = a % 10;// last digit of A
      int bLast = b % 10;// last digit of B
      int sum = aLast + bLast + crossover;
      if (sum > 1) {// when temp result is 2 or 3
        crossover = 1;// we have crossover
        digit = sum - 1 - crossover;//digit can be 1 or 0
      } else {// when temp result is 0 or 1
        crossover = 0;//no crossover
        digit = sum;//the digit is the temp result
      }
      a = a / 10;//discard last digit
      b = b / 10;
      if (a != 0 || b != 0) {
        // concatenate current digit with main result
        result = "" + digit + result;
      } else {// when both numbers are 0
        ok = false;
        // if we have crossover, put it in front of digit and main result 
        result = "" + (crossover == 0 ? "" : "1") + digit + result;
      }
    }
    return result;
  }

}
