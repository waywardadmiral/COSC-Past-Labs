import java.util.Scanner;
/**
 * Finding the Fibonacci sequence to the nth degree
 * 
 * @author SRB 
 * @version March 2, 2016
 */
public class Fibonacci
{
  public static void main (String[]args){
      
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Which # of the sequence do you want to know?");
      int sequenceNumber = keyboard.nextInt();
      int past=0,current=1,next,run,count=10;    
      System.out.print(past+" "+current);    
    
    for(run=2;run<sequenceNumber;++run)   
    {    
        next=past+current;    
        System.out.print(" "+next);    
        past=current;    
        current=next;   
    }  
      
    }
}
