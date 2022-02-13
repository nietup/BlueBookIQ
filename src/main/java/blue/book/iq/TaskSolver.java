package blue.book.iq;

public class TaskSolver {
    /*
    input
    m - length of the main series
    1 <= m <= 1M
    a_1, ..., a_m - main series
    1 <= a_i <= 1M
    n - sub-series count
    m_i - ith sub-series length
    1 <= m_i <= 1M
    b_i1, ..., b_im_i - ith sub-series
    1 <= b_ij <= 1M
    1 <= sum m_i <= 1M

    input example
    7
    1 5 4 5 7 8 6
    4
    5
    1 5 5 8 6
    3
    2 2 2
    3
    5 7 8
    4
    1 5 7 4

    output
    for sub-series - whether it is a sub-series of the main series

    output example
    YES
    NO
    YES
    NO

    notation
    len - sum m_i
    s - biggest value in all series
    S - {1, ..., s}
    c - element of S
    l_c - indices of occurrences of c in a
     */

    private int[][] l;

    private boolean isSubSeries(final int[] b_i, final int m_i) {
        int j = 0;
        for (int k = 0; k < m_i; k++) {
            j = findFirstBigger(l[b_i[k]], j);
            if (-1 == j) return false;
        }
        return true;
    }

    private int findFirstBigger(int[] l_c, int j) {
        int left = 0;
        int right = l_c.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (l_c[mid] <= j) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return l_c[left] > j ? l_c[left] : -1;
    }
}
