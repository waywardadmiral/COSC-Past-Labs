import java.util.Scanner;
/**
 * ASking the user for an imput and comuting the power they make
 * 
 * @author SRB 
 * @version March 2, 2016
 */
public class ComputeValueOfX
{
   public static void main (String[]args){
     
       Scanner keyboard = new Scanner(System.in);
       
       System.out.println("You will be asked to give two integers to compute the equation x^n. Please choose an X");
       double x = keyboard.nextDouble();
       
       System.out.println("Now please choose an n");
       double n = keyboard.nextDouble();
       boolean running = true;
       while (running){
        double answer = Math.pow(x,n);
        System.out.println("Answer is " + answer);
        running = false;
           
        }
    }
}
