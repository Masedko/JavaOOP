package lab2;

import java.util.Random;
import java.util.Scanner;

/**
 * Number of student's book is 4
 * C5 = 4 -> С = AxB
 * C7 = 4 -> Тип матриці long
 * C11 = 4 -> Дія з матрицею С: обчислити суму найбільших елементів в рядках матриці
 *            з парними номерами та найменших елементів в рядках матриці з непарними номерами
 */
public class Main {
    private static int take_number(Scanner in){
        int K;
        while (true) {
            try {
                String K_str = in.nextLine();
                K = Integer.parseInt(K_str);
                if (K < 0) {
                    System.out.println("Array length cannot be negative, try once more time.");
                    continue;
                }
                break;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Array length should be positive integer");
            }
        }
        return K;
    }
    private static void print_out_matrix(long[][] matrix, String name_of_matrix){
        System.out.printf("Matrix: %s\n", name_of_matrix);
        for (long[] longs : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("| %20s |", longs[j]);
            }
            System.out.println();
        }
    }
    // Generate array with random longs
    private static long[][] random_array(Scanner in, Random rm){

        System.out.println("Print length of column of the matrix: ");
        int row = take_number(in);
        System.out.println("Print length of row of the matrix: ");
        int column = take_number(in);

        long[][] rand_arr = new long[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                rand_arr[i][j] = rm.nextLong();
            }
        }
        return rand_arr;
    }
    private static long[][] multiply_matrix(long [][] array_1,long [][] array_2){
        long[][] result = new long[array_1.length][array_2[0].length];
        for (int i = 0; i < array_1.length; i++) {
            for (int j = 0; j < array_2[0].length; j++) {
                for (int k = 0; k < array_1[0].length; k++) {
                    result[i][j] += array_1[i][k] * array_2[k][j];
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        long[][] matrix_A = random_array(sc, rd);
        long[][] matrix_B = random_array(sc, rd);

        print_out_matrix(matrix_A, "A");
        print_out_matrix(matrix_B, "B");


        // Testing multiplying condition
        while (true) {
            if (matrix_A.length != matrix_B[0].length) {
                System.out.println("Your column length of first matrix isn't equal to row length of second matrix." +
                        "Try to enter new matrices");
                matrix_A = random_array(sc, rd);
                matrix_B = random_array(sc, rd);

                print_out_matrix(matrix_A, "A");
                print_out_matrix(matrix_B, "B");
            }
            else break;
        }
        long[][] C_matrix = multiply_matrix(matrix_A, matrix_B);
        print_out_matrix(C_matrix, "C");

        // Finding sums of maximums and minimums according to condition of the problem
        long[] matrix_of_sums = new long[C_matrix.length];
        for (int i = 1; i < C_matrix.length; i = i + 2){
            long max = C_matrix[i][0];
            int max_counter = 1;
            for (int j = 1; j < C_matrix.length; j++) {
                if (C_matrix[i][j] == max) {
                    max_counter += 1;
                }
                if (C_matrix[i][j] > max) {
                    max_counter = 1;
                    max = C_matrix[i][j];
                }
            }
            matrix_of_sums[i] = max * max_counter;
        }
        for (int i = 0; i < C_matrix.length; i = i + 2){
            long max = C_matrix[i][0];
            int max_counter = 1;
            for (int j = 1; j < C_matrix.length; j++) {
                if (C_matrix[i][j] == max) {
                    max_counter += 1;
                }
                if (C_matrix[i][j] > max) {
                    max_counter = 1;
                    max = C_matrix[i][j];
                }
            }
            matrix_of_sums[i] = max * max_counter;
        }

//        for (int i = 0; i < C_matrix.length; i ++) {
//            // Sum of maximums in even row
//            if (i % 2 != 0) {
//            }
//            // Sum of minimums in odd row
//            if (i % 2 == 0){
//                long min = C_matrix[i][0];
//                int min_counter = 1;
//                for (int j = 1; j < C_matrix.length; j++) {
//                    if (C_matrix[i][j] == min) {
//                        min_counter += 1;
//                    }
//                    if (C_matrix[i][j] < min) {
//                        min_counter = 1;
//                        min = C_matrix[i][j];
//                    }
//                }
//                matrix_of_sums[i] = min * min_counter;
//            }
//        }

        // Output sums
        for (int i = 0; i < C_matrix.length; i++){
            if (i % 2 == 0){
                System.out.printf("Sum of minimums of the %d row:\n %d\n", i + 1, matrix_of_sums[i]);
            }
            if (i % 2 != 0){
                System.out.printf("Sum of maximums of the %d row:\n %d\n", i + 1, matrix_of_sums[i]);
            }
        }
    }
}