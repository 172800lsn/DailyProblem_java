class Solution {
    public int maxEvents(int[][] events) {
        // 1. 按 start 升序排列
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 存 end
        int i = 0, n = events.length;
        int ans = 0;

        // 从最早的 startDay 扫到可能的最后一天
        int day = 0;
        if (n > 0) day = events[0][0];
        while (i < n || !pq.isEmpty()) {
            // 2. 把今天开始的会议全部入堆（按 end 排序）
            while (i < n && events[i][0] == day) {
                pq.offer(events[i][1]);
                i++;
            }
            // 3. 弹出已过期会议
            while (!pq.isEmpty() && pq.peek() < day) pq.poll();

            // 4. 选择今天能参加的会议（end 最小）
            if (!pq.isEmpty()) {
                pq.poll();
                ans++;
            }

            // 5. 终止条件：堆空且无剩余会议
            if (pq.isEmpty() && i < n && day < events[i][0]) {
                // 跳到下一场会议的 start，可跳过空白日
                day = events[i][0];
            } else {
                day++;  // 正常递增一天
            }
        }
        return ans;
    }
}