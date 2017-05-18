
/**
 * Write a description of class pigLatin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class pigLatin
{
   public static void main (String[]args){
       
       String original = "Java";
       String pigLatin = original.substring(1) + original.substring(0,1) + "ay";
       
       System.out.println(original + " is " + pigLatin + " in pig latin.");
       
    }
}
