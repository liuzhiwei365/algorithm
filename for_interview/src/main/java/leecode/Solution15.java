package leecode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution15 {
    public static void main(String[] args) {


        int[] nums = { 3,-4,7,2,0,1};

        IntStream sorted = Arrays.stream(nums).sorted();
        
        System.out.println(sorted.toArray()[0]);

    }




}
