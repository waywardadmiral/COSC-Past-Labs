
/**
 * Write a description of class Card here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Card
{
    public static void main(String[] args) {
        
        char[] suits = {'\u2660', '\u2661', '\u2662', '\u2663'};
        String[] faceValue = new String[13];
        
        for (int i = 0; i < 9; i++) {
            faceValue[i] = "" + (i + 2);
        }
        faceValue[9] = "J";
        faceValue[10] = "Q";
        faceValue[11] = "K";
        faceValue[12] = "A";
        
        for (int suit = 0; suit < suits.length; suit++) {
            
            for (int value = 0; value < faceValue.length; value++) {
                System.out.println(suits[suit] + faceValue[value]);
            }
            
        }
    
    
    
   }
   
   public static void getSuit(int a, int b){
       System.out.printf(faceValue[b]);
    }
}
