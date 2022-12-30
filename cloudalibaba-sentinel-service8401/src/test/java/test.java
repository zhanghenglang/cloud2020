import org.junit.jupiter.api.Test;

public class test {

    int test1(int[][] matrix, int k){
        int m = matrix.length, n = matrix[0].length;
        int lo = matrix[0][0], hi = matrix[m - 1][n - 1];
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n && matrix[i][j] <= mid; j++) {
                    cnt++;
                }
            }
            if (cnt < k) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }
    @Test
    void test2(){
        int[] ints = test3(5, 4);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }
    int[] test3(int n, int k){
        int[] ret = new int[n];
        ret[0] = 1;
        for (int i = 1, interval = k; i <= k; i++, interval--) {
            ret[i] = i % 2 == 1 ? ret[i - 1] + interval : ret[i - 1] - interval;
        }
        for (int i = k + 1; i < n; i++) {
            ret[i] = i + 1;
        }
        return ret;
    }
}
