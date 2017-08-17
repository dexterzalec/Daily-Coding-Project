
package number.guesser;

import java.util.Scanner;

/**
 *
 * @author dexterz
 */
public class NumberGuesser {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Start the game and tell the user to think of a number
        System.out.println("Hello & Welcoome to the Number Guessing Game!\n=====================================\nPlease Think of a Number Between 1-100\n\n");
        
        //start out with 50, cuz why not?
        int guess = 50;
        guesserGame(guess);
        
        
    }
    
    
    public static int guesserGame(int guess){
        try{
            //have the program wait 2.5 seconds and pretend to have it think
            Thread.sleep(2500);
            //if number is somehow greater than 100, return 100
            if (guess >=100)
                guess =100;
            //if number is somehow lower than zero, return 0
            else if (guess <=0)
                guess =0;
            System.out.println("Is your number " +guess + " ?\n (y)for yes\n (h) for higher\n (l) for lower");
        }
        
        catch(Exception e){
            //if the program isnt running properly and cannot wait 2.5 seconds, use this catch to print out error
            System.out.println("Error Sleeping!");
        }
        
        Scanner s = new Scanner(System.in);
        String g = s.next();
        boolean contin = false;
        while (contin == false){
            switch (g){
                //higher case
                case "h" : guess = guess + (guess/2);
                guesserGame(guess);
                break;
                
                //lower case
                case"l" : guess = guess - (guess/2);
                guesserGame(guess);
                break;
                
                //yes case
                case "y" :System.out.println("I knew your number was: " + guess +"!!!!!!!");
                contin =true;
                
                System.out.println("Thanks for playing! Better luck next time noob!");
                System.exit(0);
                //if the user doesnt provide one of the three valid options, prompt them again
                default: System.out.println("Wrong choice.... is " + guess+ " your number? ");
                g =s.next();
                
            }
            
            
        }
        
        
        return guess;
    }
    
    
}

