class Solution {
    public int maximumLength(int[] nums) {
        int cntEven = 0, cntOdd = 0;
        int altLen = 0;
        int last = -1; // -1 表示尚未选择任何元素；否则存放 0(偶) / 1(奇)

        for (int x : nums) {
            int p = x & 1;
            if (p == 0) cntEven++;
            else cntOdd++;

            if (last == -1) {          // 选第一个
                altLen++;
                last = p;
            } else if (p != last) {     // 奇偶不同 => 可交替选入
                altLen++;
                last = p;
            } // 否则跳过（保持交替）
        }

        int sameParityBest = Math.max(cntEven, cntOdd);
        return Math.max(sameParityBest, altLen);
    }
}
