
import java.util.*;

class QuadrapletSum {
    static int[] findArrayQuadruplet(int[] arr, int s) {

        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int f = 0;
                int l = arr.length - 1;
                while (f < l) {
                    if (!(i == j && j == l && l == f)) {
                        if ((arr[i] + arr[j] + arr[l] + arr[f]) == s) {
                            System.out.println(arr[i] + " " + arr[j] + " " + arr[l] + " " + arr[f]);
                        }
                    }
                    if (arr[l] + arr[f] > s) {
                        l--;
                    } else {
                        f++;
                    }
                }

            }
        }
        return null;
    }
    static void findSum(int[] arr, int s) {

        int indexFromBeg = 0;
        int indexFromEnd = arr.length - 1;
        while (indexFromBeg >= indexFromEnd) {
            if (arr[indexFromEnd] + arr[indexFromBeg] > s) {
                indexFromEnd--;
            } else if (arr[indexFromEnd] + arr[indexFromBeg] < s) {
                indexFromBeg++;
            } else {
                System.out.println("Sum" + arr[indexFromBeg] + " " + arr[indexFromEnd]);
                break;
            }
        }
        System.out.println("Sum" + arr[indexFromBeg] + " " + arr[indexFromEnd]);

    }

    public static void main(String[] args) {
        int[] arr = {2 ,4 ,7 ,8 ,9};
        findArrayQuadruplet(arr, 21);
    }

}