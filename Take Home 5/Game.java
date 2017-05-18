import java.util.Scanner;
/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game
{
   public static void main (String[]args){
       Scanner keyboard = new Scanner(System.in);
       System.out.println("What is your choice?");
       String choice = keyboard.next();
       boolean running = true;
       if(choice.equals("shuffle")){
         for(int i = 0; i < 52; i++){
             int temp = 0;
             int change =(int) Math.random()*52;
             deck[i] = temp;
             deck[i] = deck[change];
             deck[change] = temp;
             
          }
         System.out.println("What is your choice?");
         choice = keyboard.next();
       }else if(choice.equals("draw")){
         System.out.println(deck[0]);
         System.out.println("What is your choice?");
         choice = keyboard.next();
       }else if(choice.equals("hand")){
         System.out.println(deck[0]);
         System.out.println(deck[1]);
         System.out.println(deck[2]);
         System.out.println(deck[3]);
         System.out.println(deck[4]);
         System.out.println("What is your choice?");
         choice = keyboard.next();
       }else if(choice.equals("exit")){
         running = false;
         System.exit(0);
      }
    }
}
