/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryption;

import java.util.Scanner;
import javax.xml.bind.DatatypeConverter;
/**
 *
 * @author dexterz
 */
public class Encryption {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       intro();
       String start = "hello";
       String reSults =  userInput(start);
       int methodResults = whichMethod(0);
      //if user selects base64 method, call encrypt and decrypt method
       if (methodResults ==1){
          String bas64_esults= base64_Encryption(reSults);
          base64_Decryption(bas64_esults);
      }
       //if user enters 2, call caeser method
      else if (methodResults==2)
      {
          caesar(reSults.toLowerCase(),2);
      }
       System.out.println("Thanks for using this application! Ta Ta For Now!");
       
       
       
    }
    //say hello to the user!
    private static void intro(){
        System.out.print("Hello! Thanks for using the Encryption Program!\n\tPlease enter the string you'd like encrypted: ");
    }
    
    //collect the users string and return it 
    private static String userInput(String s){
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        System.out.println("You Entered\t\t" +input + "\n\n");
        return input;
    }
    
    //encrypt the string and spit out the encrypted string
    private static String base64_Encryption(String s){
          String encoded = DatatypeConverter.printBase64Binary(s.getBytes());
System.out.println("Your encrypted String is: " + encoded);
        return encoded;
    }
    
    //decrypt the encrypted string and spit it out
    private static String base64_Decryption(String s){
        String decoded = new String(DatatypeConverter.parseBase64Binary(s));
        System.out.println("Your decoded string is: " + decoded);
        return decoded;
    }
    
    
    //which method do you want to encrypt/hash with? 1 for base64, 2 for caesar
    private static int whichMethod(int r){
        int answer= 0;

        //keep loops false until the user uses a int
        boolean loops = false;
        while(loops ==false){
        System.out.println("Which Method would you like to use for encryption and decryption?\n\t(1) for Base64\n\t(2) for Caeser");
        Scanner s = new Scanner(System.in);
        
        //make sure the user tries a valid input or retry
        try{
         answer = s.nextInt();
        loops = true;
        switch(answer){
            case 1: System.out.println("You chose 1");
            return 1;
            
            case 2: System.out.println("You chose 2");
            return 2;
            
            default: System.out.println("You used a incorrect choice... come on man"); 
            loops = false;
         
        }
        }
        catch(Exception e){
            System.out.println("error. please only use one of the valid choices.");
            s.nextLine();
        }
        }
       
        return r;
    }
    
    
    //Caesar method
  static String caesar(String value, int shift) {
        // Convert to char array.
        char[] zbuffer = value.toCharArray();

        // Loop over characters.
        for (int i = 0; i < zbuffer.length; i++) {

            // Shift letter, moving back or forward 26 places if needed.
            char letter = zbuffer[i];
            letter = (char) (letter + shift);
            if (letter > 'z') {
                letter = (char) (letter - 26);
            } else if (letter < 'a') {
                letter = (char) (letter + 26);
            }
            zbuffer[i] = letter;
        }
        // Return final string.
        System.out. print("\nYour new Caesar Value is: ");
        System.out.print(zbuffer);
        System.out.println("");
        return new String(zbuffer);
    }
  
    
}
