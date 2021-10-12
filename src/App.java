import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {

    public static int misterio(int matriz[][]) {
        int i, j, n = matriz.length, suma = 0;
        for (i = 0; i < n; i++) {
            for (j = 0; j < matriz[0].length; j++) {
                /*
                 * System.out.println(!(i == 0) + " A1"); System.out.println(!(i == (n - 1)) +
                 * " A2"); System.out.println(!(j == 0) + " B1"); System.out.println(!(j == (n -
                 * 1)) + " B2"); System.out.println(!((i == 0) || i == (n - 1)) + " A");
                 * System.out.println(!(j == 0 || j == (n - 1)) + " B1");
                 */
                if (!((i == 0) || i == (n - 1)) && !(j == 0 || j == (n - 1))) {
                    suma = suma + matriz[i][j];
                    matriz[i][j] = 0;
                } else {
                    matriz[i][j] = 1;
                }
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        return suma;
    }

    public static int orden(int prueba[][]) {
        int sumatoria = 0;
        for (int i = prueba.length - 1; i >= 0; i--) {
            for (int j = prueba[0].length - 1; j >= 0; j--) {
                sumatoria += prueba[i][j];
                System.out.print(prueba[i][j] + " ");
            }
            System.out.println();
        }
        return sumatoria;
    }

    public static int[][] fillMatrix() {
        Random random = new Random();
        int array[][] = new int[2][4];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = random.nextInt(9 - 1) + 1;
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        return array;
    }

    public static String[][] fillStringMatrix() {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt(), columns = scanner.nextInt();
        String array[][] = new String[rows][columns];
        System.out.println("Rellene la matriz de palabras\n");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print("Posicion " + "[" + i + "]" + "[" + j + "]" + ": ");
                array[i][j] = scanner.next();
            }
        }
        return array;
    }

    public static boolean playWordGame(String[][] array) {
        String lastWord = "";
        String currentWord = array[0][0];
        boolean status = true;

        for (int i = 0; i < array.length; i++) {
            for (int j = (i == 0) ? 1 : 0; j < array[0].length; j++) {
                lastWord = array[i][j];
                if ((lastWord.charAt(0) == currentWord.charAt(currentWord.length() - 2))
                        && (lastWord.charAt(1) == currentWord.charAt(currentWord.length() - 1))) {
                    currentWord = lastWord;
                } else {
                    status = false;
                    break;
                }
            }
        }

        return status;
    }

    public static int getTotalFromEvens(int[] array, int counter, int total) {
        if (counter == 0) {
            return total;
        }
        if (array[counter] % 2 == 0) {
            total += array[counter];
            counter--;
            return (getTotalFromEvens(array, counter, total));
        }
        return 0;
    }

    public static int getTotalFromMatrixValues(int[][] array, int i, int j, int total) {
        total += array[i][j];
        if (j >= 0) {
            j--;
        }
        if ((i == 0 && j == 0)) {
            total += array[i][j];
            return total;
        }
        if (j < 0) {
            j = (array[0].length - 1);
            i--;
        }
        return getTotalFromMatrixValues(array, i, j, total);
    }

    public static boolean proofPolidivisible(String number, int limit, int i, boolean proofment) {
        if (i > limit) {
            return true;
        }
        if (Integer.parseInt((number.substring(0, i))) % i == 0) {
            proofment = true;
        } else {
            proofment = false;
        }
        if (!proofment) {
            return false;
        }
        i++;
        return proofPolidivisible(number, limit, i, proofment);
    }

    public static ArrayList<Integer> getPolidivisibleNumbersFromMatrix(int[][] matrix, int i, int j,
            ArrayList<Integer> array, boolean proofment) {
        if ((i == 0 && j == 0)) {
            int currentNumber = matrix[i][j];
            String stringNumber = String.valueOf(currentNumber);
            proofment = proofPolidivisible(stringNumber, stringNumber.length(), 1, true);

            if (proofment) {
                array.add(currentNumber);
            }
            return array;
        }
        int currentNumber = matrix[i][j];
        String stringNumber = String.valueOf(currentNumber);
        proofment = proofPolidivisible(stringNumber, stringNumber.length(), 1, true);

        if (proofment) {
            array.add(currentNumber);
        }
        if (j >= 0) {
            j--;
        }
        if (j < 0) {
            j = matrix[0].length - 1;
            i--;
        }
        return getPolidivisibleNumbersFromMatrix(matrix, i, j, array, proofment);
    }

    public static int[][] getSnailMatrix(int[][] matrix, int i, int j, int content, boolean increaseJ,
            boolean increaseI, boolean decreaseJ, boolean decreaseI, int limit, int initLimit) {
        matrix[i][j] = content;
        if (content == matrix.length * matrix[0].length) {
            return matrix;
        }
        if ((i == limit && j == limit) && !decreaseI) {
            decreaseI = true;
            increaseJ = false;
        }
        if (i == initLimit && matrix[1][0] != 0 && !increaseI) {
            decreaseI = false;
            decreaseJ = true;
        }
        if ((j == initLimit + 1 && i == initLimit) && matrix[1][0] != 0) {
            limit -= 1;
            initLimit += 1;
            decreaseJ = false;
            increaseI = true;
        }
        if (decreaseI) {
            i--;
        }
        if (decreaseJ) {
            j--;
        }
        if (i == limit && !increaseJ) {
            increaseI = false;
            increaseJ = true;
        }
        if (increaseI) {
            i++;
        }
        if (increaseJ) {
            j++;
        }
        return getSnailMatrix(matrix, i, j, content += 1, increaseJ, increaseI, decreaseJ, decreaseI, limit, initLimit);
    }

    public static char[][] getRightArrowMatrix(char[][] matrix, int i, int j, int decreaseCounter, int limit,
            int initLimit) {

        if (i == initLimit) {
            decreaseCounter += limit;
            if (decreaseCounter == limit * 2) {
                limit--;
                initLimit++;
                decreaseCounter = 0;
            }
            matrix[i][j] = '1';
            i = limit;
            j++;
            if (j == matrix.length - 1) {
                i = matrix[0].length / 2;
                matrix[i][j] = '1';
                return matrix;
            }
        }

        matrix[i][j] = '1';
        return getRightArrowMatrix(matrix, i -= 1, j, decreaseCounter, limit, initLimit);
    }

    public static boolean getValidBarCode(String code, int i, int firstSummatory, int secondSummatory, int limit,
            int init, int middle, int end) {
        int firstCharacter = code.charAt(0) - 48;

        String s1 = code.substring(init, middle);
        String s2 = code.substring(middle, end);

        if (i == limit) {
            boolean biggerProofment = firstSummatory > secondSummatory;
            boolean primeProofment = isPrime((firstSummatory + firstCharacter), 2);
            if (biggerProofment && primeProofment) {
                return true;
            }
            return false;
        } else {
            int actualNumberS1 = s1.charAt(i) - 48;
            int actualNumberS2 = s2.charAt(i) - 48;

            firstSummatory += (actualNumberS1 % 2 == 0 ? actualNumberS1 * 5 : actualNumberS1 * 3);

            secondSummatory += (actualNumberS2 % 2 == 0 ? actualNumberS2 * 5 : actualNumberS2 * 3);

            return getValidBarCode(code, i + 1, firstSummatory, secondSummatory, limit, init, middle, end);
        }
    }// 33456583722

    public static boolean isPrime(final int number, int divider) {
        if (number == 0 || number == 1 || number == 4) {

            return false;
        }

        if (divider > number / 2) {

            return true;
        } else {
            if (number % divider == 0) {

                return false;
            } else {
                return isPrime(number, divider + 1);
            }
        }
    }

    public static void main(String[] args) throws Exception {

        int[][] matrix = new int[3][2];

        matrix[0][0] = 2016;
        matrix[0][1] = 201;
        matrix[1][0] = 4233;
        matrix[1][1] = 423;
        matrix[2][0] = 3816;
        matrix[2][1] = 2017;

        ArrayList<Integer> algo = new ArrayList<>();

        algo = getPolidivisibleNumbersFromMatrix(matrix, matrix.length - 1, matrix[0].length - 1, new ArrayList<>(),
                false);

        algo.forEach(i -> System.out.println(i));

        
        /*
         * System.out.println(getValidBarCode("33456583722", 0, 0, 0, 5, 1, 6, 11) ?
         * "The code is correct" : "The code is incorrect");
         */
        /*
         * char[][] matrix = new char[9][9];
         * 
         * char[][] matrixToPrint = new char[9][9]; matrixToPrint =
         * getRightArrowMatrix(matrix, matrix.length - 1, 0, 0, matrix.length - 1, 0);
         */
        /*
         * int[][] matrix = new int[9][9];
         * 
         * int[][] matrixToPrint = new int[9][9];
         * 
         * matrixToPrint = getSnailMatrix(matrix, 0, 0, 1, false, true, false, false,
         * matrix.length - 1, 0);
         */

        /*
         * for (int i = 0; i < matrixToPrint.length; i++) { for (int j = 0; j <
         * matrixToPrint[0].length; j++) { if (matrixToPrint[i][j] < 10) {
         * System.out.print("[ " + matrixToPrint[i][j] + "] "); } else {
         * System.out.print("[" + matrixToPrint[i][j] + "] "); } }
         * System.out.println(" ");
         */
    }
}
