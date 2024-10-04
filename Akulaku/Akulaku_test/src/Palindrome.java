public class Palindrome {
    public static boolean isPalindrome(String input){
        input = input.replaceAll("\\s+", "").toLowerCase().trim();
        int wordLength = input.length();
        for (int p=0;p<wordLength;p++){
            if (input.charAt(p)!=input.charAt(wordLength-1-p)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        // String example = "Panama";
        // String city = "Jakarta";
        // String food = "Ufo Tofu";
        // if (isPalindrome(food)){
        //     System.out.println("\""+food+"\" are the same backwards");
        // } else {
        //     System.out.println("\""+food+"\" are not the same read backwards");
        // }
        String s = "42";
        try{
            s = s.concat(".5");
            double d=Double.parseDouble(s);
            s = Double.toString(d);
            int x = (int) Math.ceil(Double.valueOf(s).doubleValue());
            System.out.println(x);
        }catch(NumberFormatException e){
            System.out.println("bad number");
        }
    }
}
