import java.util.Scanner;
/**
 * Write a description of class NFactorial here.
 *
 * @author SRB 
 * @version March 2, 2016
 */
public class NFactorial
{
   public static void main (String[]args){
       
       Scanner keyboard = new Scanner(System.in);
       
       System.out.println("Pick a number to find the factorial of");
       int x = keyboard.nextInt();
       int factorial = x;
       int degree = 1;
       while(degree < x){
           
           int answer = (degree+1) * degree;
           degree++;
           System.out.println(answer);
           
        }
        }
       
       
    }
