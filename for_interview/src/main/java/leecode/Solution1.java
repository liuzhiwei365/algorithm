package leecode;

import java.util.Hashtable;

public class Solution1 {


    public static void main(String[] args) {

        int nums[] = {3,2,4}; int target = 6;

        int[] ints = new Solution1().twoSum2(nums, target);

        System.out.println(ints[0]+"--"+ints[1]);

    }


    public  int[] twoSum(int[] nums, int target) {

        for(int i =0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public  int[] twoSum2(int[] nums, int target) {
        Hashtable<Integer,Integer> table = new Hashtable<>();
        for(int i =0;i<nums.length;i++){

            table.get(target-nums[i]);
            if(table.get(target-nums[i])!=null){
                return new int[]{i,table.get(target-nums[i])};
            }else {
                table.put(nums[i],i);
            }
        }

        return null;
    }

}
