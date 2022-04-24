package leecode;

import java.util.concurrent.LinkedBlockingQueue;

public class Solution3 {

    public static void main(String[] args) throws Exception{
       String s ="pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {

        if("".equals(s) || s==null){
            return 0;
        }

        int max=1;
       // int pre=0;

        LinkedBlockingQueue<Character> queue = new LinkedBlockingQueue<>();
        queue.add(s.charAt(0));

        for(int i=1;i<s.length();i++){

            if(queue.contains(s.charAt(i))){
                try {
                    while (queue.take()!=s.charAt(i)){
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }

            }
                queue.add(s.charAt(i));

            max = queue.size()>=max?queue.size():max;
        }
        return max;
    }

}
