import java.util.Scanner;
/**
 * Write a description of class FractionDriver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FractionDriver
{
   public static void main (String[]args){
       
       Scanner keyboard = new Scanner(System.in);
       boolean running = true;
       Fraction current = new Fraction(1, 1);
       current.printMenu();
       System.out.println("Choice: ");
       int choice = keyboard.nextInt();
       while(running = true){
       if(choice == 1){
         System.out.println("New Numerator: ");
         int newNumerator = keyboard.nextInt();
         current.setNumerator(newNumerator);
         System.out.println("New Denominator: ");
         int newDenominator = keyboard.nextInt();
         current.setDenominator(newDenominator);
         current.printMenu();
         System.out.println("Choice: ");
         choice = keyboard.nextInt();
        }else if(choice == 2){
         current.toDouble(current.getNumerator(), current.getDenominator());
         current.printMenu();
         System.out.println("Choice: ");
         choice = keyboard.nextInt();
        }else if(choice == 3){
         current.gcd(current.getNumerator(), current.getDenominator());
         
         current.printMenu();
         System.out.println("Choice: ");
         choice = keyboard.nextInt();
        }else if(choice == 0){
         running = false;
         System.exit(0);
        }
    }
    }
}
