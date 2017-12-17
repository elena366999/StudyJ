package Task2.FileWork;

import java.io.*;
import java.util.Scanner;

public class TransposingMatrix {

    public static void main(String[] args) throws IOException {
        String file1 = "C:\\Users\\Лена\\IdeaProjects\\StudyJ\\src\\Task2\\FileWork\\MatrixFile1";
        int columns = getNumberOfColumns(file1);
        int rows = getNumberOfRows(file1);

        double[][] matrix = readMatrix(file1, rows, columns);
        printMatrix(matrix, rows, columns);

        double[][] transposedMatrix = transposeMatrix(matrix);
        System.out.println();
        writeToTxt(transposedMatrix, "C:\\Users\\Лена\\IdeaProjects\\StudyJ\\src\\Task2\\FileWork\\MatrixFile2");
    }

    public static int getNumberOfColumns(String FileName) throws FileNotFoundException {
        Scanner scn = new Scanner(new File(FileName));
        int columns = scn.nextInt();
        scn.close();
        return columns;
    }

    public static int getNumberOfRows(String FileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(FileName));
        int countRows = 0;
        while (reader.readLine() != null) {
            countRows++;
        }
        reader.close();
        countRows--;
        return countRows;
    }

    public static double[][] readMatrix(String fileName,int row, int col) throws IOException {
        double[][] matrix = new double[row][col];
        BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
        reader.readLine();
        String line = reader.readLine();

        int i = 0, j = 0;
        while (line != null) {
            String strArray[] = line.split(" ");

            if (!line.trim().isEmpty()) {
                for (String s : strArray) {
                    if (!s.trim().isEmpty()) {
                        matrix[i][j++] = Double.valueOf(s);
                    }
                }
                line = reader.readLine();
                i++;
                j = 0;
            }
        }
        reader.close();
        return matrix;
    }

    public static void printMatrix(double[][] matrix, int row, int col) {
           for (int r = 0; r < row; r++){
               for (int c = 0; c < col; c++)
           System.out.print(matrix[r][c] + " ");
           System.out.println();
           }
    }
    public static double[][] transposeMatrix(double [][] matrix){
            double[][] transposedMatrix = new double[matrix[0].length][];
        for (int i = 0; i < matrix[0].length; i++) {
            transposedMatrix[i] = new double[matrix.length];
        }
        for (int i = 0; i < matrix.length; i++) {
            double[] tArr = matrix[i];
            for (int j = 0; j < matrix[0].length; j++) {
                transposedMatrix[j][i] = tArr[j];
            }
        }
        return transposedMatrix;
    }

    public static void writeToTxt (double[][] array, String filePathName) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filePathName)));
        writer.write(String.valueOf(array[0].length));
        writer.write("\r\n");

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                writer.write(String.valueOf(array[i][j]));
                writer.write(" ");
            }
            writer.write("\r\n");
        }
        writer.flush();
    }
}
