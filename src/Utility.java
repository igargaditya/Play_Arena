public class Utility {

   public static boolean  validNumberBetween1_3(String input){
      try {
         int num = Integer.parseInt(input);
         return num >= 1 && num <= 3;
      } catch (NumberFormatException e) {
         return false; // Not a valid integer
      }
   }
}
