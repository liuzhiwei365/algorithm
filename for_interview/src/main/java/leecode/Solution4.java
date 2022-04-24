package leecode;
class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length+nums2.length;

        int[] nums = new int[total];

        int cur1=0;
        int cur2=0;
        int cur=0;

        while (cur1<nums1.length  &&  cur2<nums2.length ){
            nums[cur++]= nums1[cur1]<nums2[cur2]?nums1[cur1++]:nums2[cur2++];
        }

        while (cur1<nums1.length ){
            nums[cur++]= nums1[cur1++];
        }

        while (cur2<nums2.length ){
            nums[cur++]= nums2[cur2++];
        }

        return total % 2 == 0 ? (0.5 * (nums[total / 2-1] + nums[total / 2 ])) : nums[total / 2];
    }
}