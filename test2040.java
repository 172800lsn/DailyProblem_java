class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        //定义最小负整数left
        long left = -10000000000L, right = 10000000000L;

        while(left < right) {
            long mid = left + (right - left) / 2;
            if (countNum(nums1, nums2, mid) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    public long countNum(int[] nums1, int[] nums2, long target) {
        long count = 0;
        for(int a: nums1) {
            if(a >0){
                int l = 0 ,r = nums2.length-1;
                while(l<=r){
                    int m = (l+r)/2;
                    if((long)nums2[m]*a <= target){
                        l = m+1;
                    }else{
                        r = m-1;
                    }
                }
                count += l;
            }else if(a < 0){
                int l = 0 ,r = nums2.length-1;
                while(l<=r){
                    int m = (l+r)/2;
                    if((long)nums2[m]*a <= target){
                        r = m-1;
                    }else{
                        l = m+1;
                    }
                    count += nums2.length - l;
                }
            }else{
                if(target >= 0) {
                    count += nums2.length;
                }
            }
        }
        return count;
    }
}
class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long left = -10000000000L, right = 10000000000L;  // 定义乘积的最小和最大值边界

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (countLessEqual(nums1, nums2, mid) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // 计算有多少对 (i, j) 使得 nums1[i] * nums2[j] <= target
    private long countLessEqual(int[] nums1, int[] nums2, long target) {
        long count = 0;
        for (int a : nums1) {
            if (a > 0) {
                int l = 0, r = nums2.length - 1;
                while (l <= r) {
                    int m = (l + r) / 2;
                    if ((long)a * nums2[m] <= target) {
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                }
                count += l;
            } else if (a < 0) {
                int l = 0, r = nums2.length - 1;
                while (l <= r) {
                    int m = (l + r) / 2;
                    if ((long)a * nums2[m] <= target) {
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                }
                count += nums2.length - l;
            } else { // a == 0
                if (target >= 0) {
                    count += nums2.length;
                }
            }
        }
        return count;
    }
}