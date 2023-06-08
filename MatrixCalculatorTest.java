import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class MatrixCalculatorTest {

    @Test
    public void testMatrixCalculation() throws IOException {
        int[][] matrixA = {
                {1, 2},
                {3, 4}
        };

        int[][] matrixC = {
                {5, 6},
                {7, 8}
        };

        int[][] expectedMatrixB = {
                {4, 4},
                {4, 4}
        };

        int[][] actualMatrixB = MatrixCalculator.calculateMatrixB(matrixA, matrixC);

        Assertions.assertArrayEquals(expectedMatrixB, actualMatrixB);
    }

    @Test
    public void testMatrixFileIO() throws IOException {
        String inputA = "testMatrixA.txt";
        String inputC = "testMatrixC.txt";
        String outputB = "testMatrixB.txt";

        int[][] matrixA = {
                {1, 2},
                {3, 4}
        };

        int[][] matrixC = {
                {5, 6},
                {7, 8}
        };

        MatrixCalculator.writeMatrixToFile(matrixA, inputA);
        MatrixCalculator.writeMatrixToFile(matrixC, inputC);

        MatrixCalculator.main(new String[0]);

        int[][] expectedMatrixB = {
                {4, 4},
                {4, 4}
        };

        int[][] actualMatrixB = MatrixCalculator.readMatrixFromFile(outputB);

        Assertions.assertArrayEquals(expectedMatrixB, actualMatrixB);
    }
}
