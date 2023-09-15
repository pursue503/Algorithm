package algorithm;

public class Permutation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        permutation(arr, 0, arr.length, 3);
        System.out.println("-----------------------");
        permutation(arr, new int[arr.length], new boolean[arr.length], 0, 3, 3);
        System.out.println("-----------------------");
        permutation(arr, new int[arr.length], new boolean[arr.length], 0, 3, 1);
    }

    // 순서 없이 n개 중에 r개를 뽑는 경우
    static void permutation(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            print(arr, r);
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    static void permutation(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            print(output, r);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                permutation(arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }


    static void print(int[] arr, int r) {
        for (int i = 0; i < r; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
