/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Scanner;

/**
 *
 * @author dexterz
 */
public class JavaApplication1 {
private static Scanner stdin = new Scanner(System.in);
    public static void main(String[] args) {
        int reversenum = 0;
        //Get number (to be reversed) from user and return it
        int r = JavaApplication1.intro(1);
        //figure out which method the user wants to use
        int s = JavaApplication1.methodChoice(1);

        if (s == 1) {
            while (r != 0) {
                reversenum = reversenum * 10;
                reversenum = reversenum + r % 10;
                r = r / 10;
            }
            System.out.println("Reverse of input number is: " + reversenum);
        }
        
        else if (s ==2)
        {
                  for( ;r != 0; )
      {
          reversenum = reversenum * 10;
          reversenum = reversenum + r%10;
          r = r/10;
      }

      System.out.println("Reverse of specified number is: "+reversenum);
        }
        
       
        
        

    } //public static void

    public static int intro(int r) {
        System.out.print("Hello, what is the number you'd like reversed? ");
        Scanner input = new Scanner(System.in);
        boolean done = false;
        while (done == false) {
            try {
                r = input.nextInt();
                done = true;
            } //try
            catch (Exception e) {
                System.out.print("Please Try again sir, that wasnt a number.... ");
                input.nextLine();
            }       //catch exception E
        }       // While Loop
        return r;
    }

    public static int methodChoice(int s) {
        System.out.println("Please Enter Which method you'd like to use to have the number reversed, \n (1) for while loop\n (2) for for loop\n");
        Scanner input = new Scanner(System.in);

        boolean continues = false;
        while (continues != true) {
            try {
                int value = input.nextInt();

                if (value == 1 || value == 2) {
                    switch (value) {
                        case 1:
                            System.out.println("you chose 1");
                            return value;
                        case 2:
                            System.out.println("you chose 2");
                            return value;
                     
                    }
                } else {
                    System.out.println("Uhh, that wasnt an option sir, please try again");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Uhh, that wasnt an option sir, please try again");
                input.nextLine();
                continue;
            }

            return 3;

        }
        return 3;
    }
}//class 

