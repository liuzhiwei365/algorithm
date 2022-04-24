package leecode;

class Solution5 {


    public static void main(String[] args) {
        String s = "babad";
        int len = s.toCharArray().length;

        String maxs = "";

        boolean[][] bools= new boolean[len][len];

        for (int i = 0; i < len; i++) {
            bools[i][i]= true;
            maxs=s.substring(i,i+1);
        }

        for (int i = 0;i< len -1 ;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                bools[i][i+1]=true;
                maxs = s.substring(i,i+2);
            }else{
                bools[i][i+1]=false;
            }
        }


        for(int j = 2;j<len;j++){
            for(int i= 0;i<len-j;i++){

                if(s.charAt(i) == s.charAt(i+j) && bools[i+1][i+j-1]==true){
                    bools[i][i+j]=true;
                    maxs = s.substring(i,i+j+1);
                }else {
                    bools[i][i+j]=false;
                }

            }
        }


        System.out.println(maxs);


    }


    public static String longestPalindrome(String s) {
        int len = s.toCharArray().length;

        s.length();

        l(s.length()%2==0?(s.length()/2-1):(s.length()/2),s);


        return null;
    }


    public static int l(int step , String s){
        if(step==0){
            if(s.length()%2==0 ){
                return s.charAt(s.length()/2)==s.charAt(s.length()/2+1)?2:1;
            }else{
                return 1;
            }
        }


        l(step-1,s) ;


        return 0;
    }










}