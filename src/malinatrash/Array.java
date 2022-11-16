package malinatrash;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Array {
    private int[][] matrix;
    private int line;
    private int post;

    public Array(int row, int collumn) {
        this.line = row;
        this.post = collumn;
        this.matrix = new int[row][collumn];
    }

    public Array(int size) {
        this.line = size;
        this.post = size;
        this.matrix = new int[line][post];
    }

    public Array() {
        this.line = 3;
        this.post = 3;
        this.matrix = new int[line][post];
        this.setRandom();
    }

    public Array(int[][] matrix) {
        this.line = matrix.length;
        this.post = matrix.length;
        this.matrix = new int[matrix.length][matrix.length];
        setArray(matrix);
    }

    public void setArray(int[][] array) {
        for(int i = 0; i < line; ++i) {
            for(int j = 0; j < post; ++j) {
                this.matrix[i][j] = array[i][j];
            }
        }
    }

    public void fill() {
        Scanner in = new Scanner(System.in);

        for(int i = 0; i < this.line; ++i) {
            for(int j = 0; j < this.post; ++j) {
                int t = in.nextInt();
                this.matrix[i][j] = t;
            }
        }
    }

    public void setRandom() {
        Random r = new Random();
        for (int i = 0; i < this.matrix.length; i++) {
            for(int j = 0; j < this.matrix[i].length; j++) {
                this.matrix[i][j] = r.nextInt(11) - 5;
            }
        }
    }

    public int[][] getArray() {
        return this.matrix;
    }

    public void printMatrix() {
        System.out.println("Ваш массив: ");

        for(int i = 0; i < this.line; ++i) {
            for(int j = 0; j < this.post; ++j) {
                System.out.print(this.matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public int doTask() {
        int count = 0;
        int maximum = 0;

        for(int i = 0; i < this.line; ++i) {
            for(int j = 0; j < this.post; ++j) {
                for(int z = 0; z < this.line; ++z) {
                    for(int k = 0; k < this.post; ++k) {
                        if (this.matrix[i][j] == this.matrix[z][k]) {
                            ++count;
                        }
                    }
                }
                if (maximum < count) {
                    maximum = count;
                }
                count = 0;
            }
        }
        return maximum;
    }
}
