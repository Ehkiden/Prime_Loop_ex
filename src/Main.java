/*
Project:    Exercise 01
Class:      CS 335
Author:     Jared Rigdon
Date:       9/14/2018
Purpose:    Part 1: Loop through 10000 numbers and  find odd numbers that are abundant
            Part 2: Loops through a boolean array of 10000 elements. Starting from 2, if the element is divisable,
                    mark all elements, including itself, that are a multiple of that number to false
 */

import java.util.Arrays;

public class Main {

    public static void main(String[] args)
    {
        //Part 1
        System.out.print("Numbers that are abundant: \n");
        int loops =10000;
        Main Driver=new Main();
        Driver.abundant(loops);

        //Part 2
        System.out.print("\nSieve Primes: \n");
        boolean[] barray=new boolean[10000];
        Arrays.fill(barray, Boolean.TRUE);  //initialize boolean array to true
        int len=barray.length;
        for (int x=2; x<len;x++){
            if (barray[x]==Boolean.TRUE){
                //starting at the first multiple of x, change each multiple to false in the array
                for(int y=(2*x); y<len; y=(y+x)){
                    barray[y]=Boolean.FALSE;
                }
            }
        }

        //print out the array
        int count =10;  //print out 10 numbers

        while(count !=0){
            //print array location if the value is true
            if (barray[len-1]==Boolean.TRUE){
                System.out.print(len-1 +"  ");
                count--;
            }
            len--;      // count down from the end of the array
        }
    }

    public void abundant(int loops){
        for (int i=1; i<=loops; i++){
            if ((i%2)!=0){  //check if the number is odd
                int abun=0;
                for (int j=1; j<i;j++){ //loop and exit before reaching the current number
                    if ((i%j)==0){  //check if the there is a remainder
                        abun=abun+j;
                    }
                }
                //if the sum of the divisors is greater than the current number, then display the number
                if(abun>i){
                    System.out.print(i+"\n");   //print out the number
                }
            }
        }
    }
}
