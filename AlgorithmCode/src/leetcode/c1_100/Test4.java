package leetcode.c1_100;

//注意的点：
//1,
public class Test4 {
    public static void main(String[] args) {
        int[] nums1 = {1,3,5};
        int[] nums2 = {2,4,5,6};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null && nums2 == null) return 0.0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        if((len1 + len2)%2 == 1){
            return findK(nums1,nums2,0,0,(len1+len2)/2 + 1);
        }else {
            return (findK(nums1,nums2,0,0,(len1+len2)/2) + findK(nums1,nums2,0,0,(len1+len2)/2+1))/2.0;
        }
    }

    public static double findK(int[] nums1,int[] nums2,int st1,int st2,int k){

        if(st1  >= nums1.length){
            return nums2[st2 + k -1];
        }

        if(st2  >= nums2.length){
           return nums1[st1 + k -1];
        }

        if(k == 1){
            return Math.min(nums1[st1],nums2[st2]);
        }
        int A = Integer.MAX_VALUE;
        int B = Integer.MAX_VALUE;
        if(st1+k/2-1 < nums1.length){
             A = nums1[st1+k/2-1];
        }

        if(st2+k/2-1 < nums2.length){
             B = nums2[st2+k/2-1];
        }

        if(A < B){
            return findK(nums1,nums2,st1+k/2,st2,k-k/2);
        }else {
            return findK(nums1,nums2,st1,st2+k/2,k-k/2);
        }
    }
}
