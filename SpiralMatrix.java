//https://www.interviewbit.com/problems/spiral-order-matrix-i/

import java.util.*;
class SpiralMatrix {
    int index = 0;

    public void insertIntoList(int[] list, int value) {
        list[index] = value;
        index++;
    }

    public static int[] getSpiralMatrix(int[][] ar) {
        int rows = ar.length;
        int cols = (rows == 0) ? 0 : ar[0].length;
        int left = 0;
        int right = cols - 1;
        int top = 0;
        int bottom = rows - 1;

        int[] list = new int[rows * cols];
        int flag = 1;

        while (left <= right && top <= bottom) {
            if (flag == 1) {
                for (int i = left ; i <= right; i++) {
                    insertIntoList(list, ar[top][i]);
                }
                top++;
                flag = 2;
            } else if (flag == 2) {
                for (int j = top ; j <= bottom; j++) {
                    insertIntoList(list, ar[j][right]);
                }
                right--;
                flag = 3;
            } else if (flag == 3) {
                for (int i = right; i >= left; i--) {
                    insertIntoList(list, ar[bottom][i]);
                }
                bottom--;
                flag = 4;
            } else if (flag == 4) {
                for (int j = bottom; j >= top; j--) {
                    insertIntoList(list, ar[j][left]);
                }
                left++;
                flag = 1;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] ar = new int[m][n];
        int value = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ar[i][j] = value;
                value++;
            }
        }

        int[] arr = getSpiralMatrix(ar);
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + " ");
        }
        System.out.println();
    }
}