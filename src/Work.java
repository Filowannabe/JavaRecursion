public class Work {

    public static boolean getPerfectNumber(int number, int subNumber, int amount) {
        if ((number % subNumber) == 0) {
            amount += subNumber;
        }

        if (subNumber == 1 && amount == number) {
            return true;
        }
        if (subNumber == 1 && !(amount == number)) {
            return false;
        }
        return getPerfectNumber(number, subNumber -= 1, amount);
    }

    public static int getBiggerNumberFromArray(int[] array, int i, int biggerNumber) {

        if (array[i] > biggerNumber) {
            biggerNumber = array[i];
        }
        if (i == array.length - 1) {
            return biggerNumber;
        }
        return getBiggerNumberFromArray(array, i += 1, biggerNumber);
    }

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

    public static boolean proofSymmetricalMatrix(int[][] matrix, int i, int j, int rows, int columns,
            boolean proofment) {
        if (j == matrix[0].length - 1 && i == matrix.length - 1) {
            return proofment;
        }
        if (j == matrix[0].length) {
            j = -1;
            i += 1;

        } else {
            if ((matrix[i][j] != matrix[j][i]) || (rows != columns)) {
                return (proofment = false);
            }
        }
        return (proofSymmetricalMatrix(matrix, i, j += 1, rows, columns, proofment));
    }

    public static int getTotalVowelsFromString(String chain, int i, int counter) {

        if (Character.toLowerCase(chain.charAt(i)) == 'a') {
            counter++;
        }
        if (Character.toLowerCase(chain.charAt(i)) == 'e') {
            counter++;
        }
        if (Character.toLowerCase(chain.charAt(i)) == 'i') {
            counter++;
        }
        if (Character.toLowerCase(chain.charAt(i)) == 'o') {
            counter++;
        }
        if (Character.toLowerCase(chain.charAt(i)) == 'u') {
            counter++;
        }
        if (i == chain.length() - 1) {
            return counter;
        }
        return getTotalVowelsFromString(chain, i += 1, counter);
    }

    public static int getArrayPositiveValuesAmount(int[] array, int i, int amount) {
        if (array[i] >= 0) {
            amount += array[i];
        }

        if (i == array.length - 1) {
            return amount;
        }
        return getArrayPositiveValuesAmount(array, i += 1, amount);
    }

    public static boolean proofEAN8Code(String code, int amount, int counter, int factor) {
        amount += ((code.charAt(counter - 1) - 48) * factor);

        counter -= 1;
        if (factor == 3) {
            factor = 1;
        } else if (factor == 1) {
            factor = 3;
        }

        if (counter == 0) {
            amount = amount + (code.charAt(code.length() - 1) - 48);
            return amount % 10 == 0;
        }
        return proofEAN8Code(code, amount, counter, factor);
    }

    public static int[][] getClosestSquareMatrix(int matrix[][], int i, int j, int[][] newMatrix, int counter) {

        if (Math.sqrt(matrix[i][j] * counter) % 1 == 0) {
            newMatrix[i][j] = counter;
            counter = 1;
        } else {
            return getClosestSquareMatrix(matrix, i, j, newMatrix, counter += 1);
        }

        if (j == matrix[0].length - 1 && i == matrix.length - 1) {
            return newMatrix;
        }

        if (j == matrix[0].length - 1) {
            j = -1;
            i += 1;
        }
        return getClosestSquareMatrix(matrix, i, j += 1, newMatrix, counter);
    }

    public static String getLucasSequence(int actualPosition, int numberBefore, int currentNumber) {

        if (actualPosition == 0) {
            numberBefore = 2;
            System.out.print(numberBefore + " ");
        }
        if (actualPosition == 1) {
            currentNumber = 1;
            System.out.print(currentNumber + " ");
        }

        if (actualPosition > 1) {
            int aux = currentNumber;
            System.out.print(currentNumber + numberBefore + " ");
            currentNumber = currentNumber + numberBefore;
            numberBefore = aux;
        }
        if (actualPosition == 10) {
            return "";
        }
        return getLucasSequence(actualPosition += 1, numberBefore, currentNumber);
    }

    public static int getLucasSequenceClass(int n) {
        if ((n == 0)) {
            return 2;
        } else if (n == 1) {
            return 1;
        } else {
            return getLucasSequenceClass(n - 1) + getLucasSequenceClass(n - 2);
        }
    }

    public static void main(String[] args) throws Exception {
        // System.out.println(getPerfectNumber(number, number - 1, 0)); POINT 1
        /*
         * int[] array = new int[] { 1, 2, 20, 4, 5, 36, 7, 8, 9, 10 };
         * System.out.println(getBiggerNumberFromArray(array, 0, 0)); // POINT 2
         */
        // System.out.println(isPrime(19, 2)); POINT 3

        /*
         * int[][] matrix = new int[3][3];
         * 
         * //case true
         * 
         * matrix[0][0] = 0; matrix[0][1] = 1; matrix[0][2] = -2; matrix[1][0] = 1;
         * matrix[1][1] = 3; matrix[1][2] = 0; matrix[2][0] = -2; matrix[2][1] = 0;
         * matrix[2][2] = 5;
         * 
         * //case false matrix[0][0] = 3; matrix[0][1] = 2; matrix[0][2] = 1;
         * matrix[1][0] = 1; matrix[1][1] = -4; matrix[1][2] = 0; matrix[2][0] = 1;
         * matrix[2][1] = 0; matrix[2][2] = 5;
         * 
         * System.out.println(proofSymmetricalMatrix(matrix, 0, 0, matrix.length - 1,
         * matrix[0].length - 1, true)); // POINT 4
         */

        // System.out.println(getTotalVowelsFromString("AEibC", 0, 0)); POINT 5
        /*
         * int[] array = new int[] { 1, 2, -20, -4, -5, -36, -7, -8, 2, 10 };
         * System.out.println(getArrayPositiveValuesAmount(array, 0, 0)); //POINT 6
         */

        /*
         * System.out.println(proofEAN8Code("65839522", 0, "65839522".length() - 1, 3));
         * //POINT 7
         */

        /*
         * int[][] matrix = new int[2][2];
         * 
         * matrix[0][0] = 4; matrix[0][1] = 8; matrix[1][0] = 12; matrix[1][1] = 4;
         * 
         * int[][] newMatrix = getClosestSquareMatrix(matrix, 0, 0, new int[2][2], 1);
         * 
         * for (int i = 0; i < newMatrix.length; i++) { for (int j = 0; j <
         * newMatrix[0].length; j++) { System.out.print("[ " + newMatrix[i][j] + " ]");
         * } System.out.println(); } //POINT 8
         */

        /*
         * System.out.println(getLucasSequence(0, 0, 0)); lucas sequence
         * 
         * System.out.println(getLucasSequenceClass(10));
         */

    }
}
