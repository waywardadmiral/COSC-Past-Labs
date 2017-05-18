
/**
 * First take home lab, making change with the biggest coins first.
 * 
 * @author  
 * @1/27/16
 */
public class Coins
{
   public static void main (String[] args) {
       
       int change = 67;
       int quarter = 25;
       int dime = 10;
       int nickel = 5;
       int penny = 1;
       
       System.out.println("Initial Change : "+ change + " cents");
       int quartersGiven = 67/25;
       System.out.println("Quarters : " + quartersGiven);
       int changeAfterQuarters = 67%25;
       int dimesGiven = changeAfterQuarters/10;
       System.out.println("Dimes : " + dimesGiven);
       int changeAfterDimes = changeAfterQuarters%10;
       int nickelsGiven = changeAfterDimes/5;
       System.out.println("Nickels : "+ nickelsGiven);
       int changeAfterNickels = changeAfterDimes%5;
       int penniesGiven = changeAfterNickels/1;
       System.out.println("Pennies : "+ penniesGiven);
      
  
       
    }
}
