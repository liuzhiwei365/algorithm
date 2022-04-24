package leecode;

public class Solution7 {


    public static void main(String[] args) {
        int reverse = new Solution7().reverse(123);

        System.out.println(reverse);

    }

    public int reverse(int x) {

        // 把这串数字看作一个队列

        int res=0;

        while (x!=0){

           int tmp = res*10+x%10;

           // 判断是否溢出
           if(tmp/10 != res){
               return 0;
           }

           res =  tmp;

           x /= 10;

        }

       return res;
    }
}


