public class Work2 {

    public static boolean proofBothSidesArrayAmount(int[] array, int middle, int i, int firstAmount, int secondAmount) {
        if (i < middle) {
            firstAmount += array[i];
        } else {
            secondAmount += array[i];
        }

        if (i == array.length - 1) {
            return firstAmount == secondAmount;
        }
        return proofBothSidesArrayAmount(array, middle, i += 1, firstAmount, secondAmount);
    }

    public static int getNumbersBiggerThanArrayLastValue(int[] array, int lastValue, int i, int amount) {

        if (array[i] > lastValue) {
            amount += array[i];
        }

        if (i == array.length - 1) {
            return amount;
        }
        return getNumbersBiggerThanArrayLastValue(array, lastValue, i += 1, amount);
    }

    public static int getMatrixBiggerNumber(int[][] array, int i, int j, int bigger) {

        if (array[i][j] > bigger) {
            bigger = array[i][j];
        }

        if (i == 0 && j == 0) {
            return bigger;
        }

        if (j == 0) {
            j = array[0].length;
            i -= 1;
        }
        return getMatrixBiggerNumber(array, i, j -= 1, bigger);
    }

    public static String getAmountBetweenTwoMatrix(int[][] matrixA, int[][] matrixB, int i, int j) {
        int operator = matrixA[i][j] + matrixB[i][j];

        System.out.print("[ " + operator + " ]");

        if (i == matrixA.length - 1 && j == matrixA[0].length - 1) {
            return "";
        }

        if (j == matrixA[0].length - 1) {
            j = -1;
            i += 1;
            System.out.println();
        }
        return getAmountBetweenTwoMatrix(matrixA, matrixB, i, j += 1);
    }

    public static boolean proofPalindromaWord(String word, int counter, int secondCounter, boolean proofment) {

        if (word.charAt(counter) == word.charAt(secondCounter)) {
            proofment = true;
        } else {
            proofment = false;
            return proofment;
        }

        if (counter == 0 && secondCounter == word.length() - 1) {
            return proofment;
        }
        return proofPalindromaWord(word, counter -= 1, secondCounter += 1, proofment);
    }

    public static void main(String[] args) throws Exception {
        /*
         * int[] array = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
         * System.out.println(proofBothSidesArrayAmount(array, array.length / 2, 0, 0,
         * 0)); FIRST
         */

        /*
         * int[] array = new int[] { 2, 1, 2, 1, 43, 1, 1, 1, 1, 10 };
         * System.out.println(getNumbersBiggerThanArrayLastValue(array,
         * array[array.length - 1], 0, 0)); POINT2
         */

        /*
         * int[][] matrix = new int[3][2];
         * 
         * matrix[0][0] = 1; matrix[0][1] = 23; matrix[1][0] = 44; matrix[1][1] = 55;
         * matrix[2][0] = 200; matrix[2][1] = 0;
         * System.out.println(getMatrixBiggerNumber(matrix, matrix.length - 1,
         * matrix[0].length - 1, 0));
         */

        /*
         * int[][] matrix = new int[3][2];
         * 
         * matrix[0][0] = 1; matrix[0][1] = 1; matrix[1][0] = 1; matrix[1][1] = 1;
         * matrix[2][0] = 1; matrix[2][1] = 1;
         * 
         * int[][] matrix2 = new int[3][2];
         * 
         * matrix2[0][0] = 1; matrix2[0][1] = 1; matrix2[1][0] = 1; matrix2[1][1] = 1;
         * matrix2[2][0] = 1; matrix2[2][1] = 1;
         * System.out.println(getAmountBetweenTwoMatrix(matrix, matrix2, 0, 0));
         */

        /*
         * System.out.println(proofPalindromaWord("oooox", "ooooo".length() - 1, 0,
         * false));
         */

    }
}
