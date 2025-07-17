public class Utility {

   public static boolean  validNumberBetween(String input,int num1,int num2){
      try {
         int num = Integer.parseInt(input);
         return num >= num1 && num <= num2;
      } catch (NumberFormatException e) {
         return false; // Not a valid integer
      }
   }
   public static boolean isTenDigitNumber(String input) {
      return input.matches("\\d{10}");
   }

   public static boolean isInteger(String input) {
      try {
         Integer.parseInt(input);
         return true;
      } catch (NumberFormatException e) {
         return false;
      }
   }
}
