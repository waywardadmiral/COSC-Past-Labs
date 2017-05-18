
/**
 * Write a description of class Fraction here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fraction
{
   private int numerator = 1;
   private int denominator = 1;
   
   public Fraction(int numerator, int denominator){
       this.numerator = numerator;
       this.denominator = denominator;
    }
   
   public int getNumerator(){
       return numerator;
    }
    
   public int getDenominator(){
       return denominator;
    }
    
   public int setNumerator(int numerator){
       this.numerator = numerator;
       return numerator;
    }
    
   public int setDenominator(int denominator){
       this.denominator = denominator;
       return denominator;
    }
    
   public void toDouble(int a, int b){
      double toDouble =(double) a / (double) b;
      System.out.println(toDouble);
    }
    
   public String toString(){
       String data;
       data = numerator + " / " + denominator;
       return data;
    }
    
   static int gcd(int a, int b)
   {
    while(a!=0 && b!=0) // until either one of them is 0
    {
     int c = b;
     b = a%b;
     a = c;
    }
    return a+b; // either one is 0, so return the non-zero value
   }
   
   public void printMenu(){
      System.out.println("Current " + this.numerator + " / " + this.denominator);
      System.out.println("Menu");
      System.out.println("[1] Set values");
      System.out.println("[2] To double");
      System.out.println("[3] Get lowest terms");
      System.out.println("[0] Quit");
    }
    
   public void returnLowest(){
       
    }
}
