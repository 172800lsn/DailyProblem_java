class Solution{
    public int findLucky(int[] arr) {
        Arrays.sort(arr);
        int ans = -1;
        for (int i = 0; i < arr.length; ) {
            int j = i;
            while (j < arr.length && arr[j] == arr[i]) j++;
            int cnt = j - i;
            if (cnt == arr[i]) ans = arr[i];
            i = j;
        }
        return ans;
    }
}

