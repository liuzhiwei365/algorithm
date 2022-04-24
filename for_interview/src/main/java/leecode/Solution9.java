package leecode;

public class Solution9 {
    public static void main(String[] args) {


        int base = 1234321;


        System.out.println(isPalindrome(base));


    }

    public static boolean isPalindrome(int base){
        String str = String.valueOf(base);

        int len = str.length();

        for(int i= 0 ;i<len/2;i++){
            if(str.charAt(i)!=str.charAt(len-1-i)){
                return false;
            }
        }
        return true;

    }


}
