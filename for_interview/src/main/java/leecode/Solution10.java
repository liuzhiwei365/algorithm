package leecode;

public class Solution10 {
    public static void main(String[] args) {

    }


    public boolean isMatch(String s,String p){
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];

        dp[0][0]=true;

        for(int j=1;j<p.length()+1;j++){
            char ch = p.charAt(j-1);

            if(j>1){
                if(ch == '*'){
                    dp[0][j]=dp[0][j-2];
                }
            }else {   //j==1
                if(ch == '*'){  // 这个地方为什么填* 号 ？？
                    dp[0][j]=true;
                }
            }
        }

        for(int i =1;i<s.length()+1;i++){
            int ch1 = s.charAt(i-1);
            for(int j=1;j<p.length()+1;j++){
                int ch2 = p.charAt(j-1);

                if(ch1 == ch2 || ch2=='.'){
                    dp[i][j]=dp[i-1][j-1];
                }else if(ch2=='*'){
                    if(j>1){
                        if(dp[i][j-2]){
                            dp[i][j]=true;   // 前面的字符出现0次
                        }else {
                            int tmp = p.charAt(j-2);
                            if(tmp == ch1 || tmp =='.'){
                                dp[i][j]=dp[i-1][j];
                            }
                        }
                    }
                }

            }

        }

        return dp[s.length()][p.length()];
    }



    public boolean isMatch1(String s,String p){

        boolean[][] table = new boolean[s.length()][p.length()];

        if(s.charAt(0)==p.charAt(0) || '.'==p.charAt(0)){
            table[0][0]=true;
        }else {
            return false;
        }


        for(int i = 1;i<s.length();i++){

            for(int j=1;j<=i;i++){

                if(s.charAt(i)==p.charAt(j) ||
                        '.'==p.charAt(j) ||
                        ( '*'==p.charAt(j) && s.charAt(i-1)==s.charAt(j-1) )
                                                      ){
                    table[i][j]=table[i-1][j-1]&&true;
                }


            }

        }


        return table[s.length()-1][p.length()-1];
    }
}
