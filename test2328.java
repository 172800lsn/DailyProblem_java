public class test2328 {
//    int[][] result;
//    public int countPaths(int[][] grid) {
//        int row = grid.length;
//        int col = grid[0].length;
//        result = new int[row][col];
//        int sum = 0;
//
//        for(int i=0;i<row;i++) {
//            for(int j=0;j<col;j++) {
//                result[i][j] = 1;
//                result = result(grid,result,i,j,i,j);
//                sum += result[i][j];
//            }
//        }
//
//        sum = sum % 1000000007;
//        return sum;
//    }
//
//    public int[][] result(int[][]grid, int[][]result, int m, int n,int i,int j) {
//        if(j-1>=0 && grid[i][j-1]>grid[i][j]){
//            result[m][n]++;
//            result = result(grid,result,m,n,i,j-1);
//        }
//        if(i+1<grid.length && grid[i+1][j]>grid[i][j]){
//            result[m][n]++;
//            result = result(grid,result,m,n,i+1,j);
//        }
//        if(j+1<grid[0].length && grid[i][j+1]>grid[i][j]){
//            result[m][n]++;
//            result = result(grid,result,m,n,i,j+1);
//        }
//        if(i-1>=0 && grid[i-1][j]>grid[i][j]){
//            result[m][n]++;
//            result = result(grid,result,m,n,i-1,j);
//        }else{
//            return result;
//        }
//        return result;
//    }
    static final int MOD = 1_000_000_007;
    int[][] memo;
    int[][] grid;
    int m, n;

    public int countPaths(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        memo = new int[m][n];
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum = (sum + result(i, j)) % MOD;
            }
        }
        return sum;
    }

    public int result(int i, int j) {
        if (memo[i][j] != 0) return memo[i][j];

        long count = 1; // 本格子本身就是1条路径

        // 四个方向
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        for (int[] dir : dirs) {
            int ni = i + dir[0], nj = j + dir[1];
            if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] > grid[i][j]) {
                count = (count + result(ni, nj)) % MOD;
            }
        }
        memo[i][j] = (int)count;
        return memo[i][j];
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{1},{2}};
        int resutl = new test2328().countPaths(test);
        System.out.println(resutl);
    }
}
