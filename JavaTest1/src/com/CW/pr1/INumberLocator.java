package com.CW.pr1;

/**
 * Created by Tejveer on 15/03/2015.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class NumberLocator implements INumberLocator {

    @Override
    public int AddSeqExcept(int max, List<Integer> except) {
        //int num;
        int sum = 0;
        Scanner in = new Scanner(System.in);
        //System.out.println("Enter the Integer...");
        //num = in.nextInt();
        //int actual=0;
        if (max < 0) {
            throw new IllegalArgumentException("Less Than Zero");
        } else {
            for (int i = 1; i <= max; i++) {
                for (int j = 0; j < except.size(); ) {
                    int currentElement = except.get(j);
                    if (i % currentElement != 0) {
                        sum = sum + i;
                    }
                }

            }
//System.out.println("Sum is "+sum);
            return sum;
        }
//    public int AddSeqExcept(int max,A {
//        int num;
//        int sum = 0;
//        Scanner in = new Scanner(System.in);
//        System.out.println("Enter an integer");
//        num = in.nextInt();
//        for(int i=1;i<=num;i++)
//        {
//            if(num%i != 0 && num%i != 0)
//            {
//                 sum = sum + i;
//            }
//        }
//    }System.out.println("The Sum is" +sum);
    }
}