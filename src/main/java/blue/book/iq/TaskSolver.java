package blue.book.iq;

public class TaskSolver {
    /*
    input
    mainSeriesLength - length of the main series
    1 <= mainSeriesLength <= 1M
    mainSeries_1, ..., mainSeries_m - main series
    1 <= mainSeries_i <= 1M
    subSeriesCount - sub-series count
    subSeriesLength_i - ith sub-series length
    1 <= subSeriesLength_i <= 1M
    subSeries_i1, ..., subSeries_i,subSeriesLength_i - ith sub-series
    1 <= subSeries_ij <= 1M
    1 <= sum subSeriesLength_i <= 1M

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
    allSubSeriesLength - sum subSeriesLength_i
    maxValue - biggest value in all series
    possibleValues - {1, ..., maxValue}
    value - element of possibleValues
    indices_value - indices of occurrences of possibleValue in mainSeries


     */

    private int[][] indices;

    private boolean isSubSeries(final int[] subSeries_i) {
        int positionInMainSeries = 0;
        int subSeriesLength_i = subSeries_i.length;
        for (final int k : subSeries_i) {
            positionInMainSeries = findFirstBigger(indices[k], positionInMainSeries);
            if (-1 == positionInMainSeries) return false;
        }
        return true;
    }

    private int findFirstBigger(int[] indices_value, int currentIndex) {
        int left = 0;
        int right = indices_value.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (indices_value[mid] <= currentIndex) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return indices_value[left] > currentIndex ? indices_value[left] : -1;
    }
}
