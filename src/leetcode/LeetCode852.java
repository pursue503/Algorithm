package leetcode;

public class LeetCode852 {
    public int peakIndexInMountainArray(int[] arr) {
        for (int i=1; i<arr.length; i++) {
            if (arr[i - 1] > arr[i]) return i - 1;
        }
        return 0;
    }
    public int peakIndexInMountainArray2(int[] arr) {
        int index = 1;
        while (arr[index - 1] < arr[index]) index++;
        return index - 1;
    }
}
