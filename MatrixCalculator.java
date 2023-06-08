package Matrices;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MatrixCalculator {
    public static void main(String[] args) {
        String inputA = "matrixA.txt";
        String inputC = "matrixC.txt";
        String outputB = "matrixB.txt";

        try {
            int[][] matrixA = readMatrixFromFile(inputA);
            int[][] matrixC = readMatrixFromFile(inputC);

            int[][] matrixB = calculateMatrixB(matrixA, matrixC);

            writeMatrixToFile(matrixB, outputB);

            System.out.println("Matrix B calculated and saved to " + outputB);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static int[][] readMatrixFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();
        String[] dimensions = line.split(",");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            line = reader.readLine();
            String[] values = line.split(",");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(values[j]);
            }
        }

        reader.close();
        return matrix;
    }

    private static void writeMatrixToFile(int[][] matrix, String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write(matrix.length + "," + matrix[0].length);
        writer.newLine();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                writer.write(matrix[i][j] + ",");
            }
            writer.newLine();
        }

        writer.close();
    }

    private static int[][] calculateMatrixB(int[][] matrixA, int[][] matrixC) {
        int rows = matrixA.length;
        int cols = matrixA[0].length;

        int[][] matrixB = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrixB[i][j] = matrixC[i][j] - matrixA[i][j];
            }
        }

        return matrixB;
    }
}
