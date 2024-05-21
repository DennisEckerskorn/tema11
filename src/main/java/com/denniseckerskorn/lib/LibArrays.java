package com.denniseckerskorn.lib;

//Library which includes different methods for Arrays.
public class LibArrays {

    //********** Constants and Variables: **********
    private static final int IMINV = Integer.MIN_VALUE;
    private static final int IMAXV = Integer.MAX_VALUE;
    private static final double DMINV = Double.MIN_VALUE;
    private static final double DMAXV = Double.MAX_VALUE;



    //********** Methods to print arrays of different types on the screen(console): *********

    // [START]

    /**
     * Method to print an array in a special format: [position] = valuePosition \n.
     * Prints i and array[i].
     * @param array Integer.
     */
    public static void showArray(int[] array){
        for (int i = 0; i < array.length; i++){
            System.out.printf("array[%d] = %d ", i, array[i]);
        }
        System.out.println();
    }

    /**
     * Method to print an array in a special format: [position] = valuePosition \n.
     * Prints i and array[i].
     * @param array char.
     */
    public static void showArray(char[] array){
        for (int i = 0; i < array.length; i++){
            System.out.printf("array[%d] = %c\n", i, array[i]);
        }
    }

    /**
     * Method to print an array in a special format: [position] = valuePosition.2f \n.
     * Prints i and array[i].
     * @param array double.
     */
    public static void showArray(double[] array){
        for (int i = 0; i < array.length; i++){
            System.out.printf("array[%d] = %.2f\n", i, array[i]);
        }
    }

    /**
     * Method to print an array in a special format: [position] = valuePosition.2f in line.
     * Prints i and array[i].
     * @param array double.
     */
    public static void showArrayInLine(double[] array){
        for (int i = 0; i < array.length; i++){
            System.out.printf("[%d] = %.2f ", i, array[i]);
        }
        System.out.println();
    }

    public static String printMatrix(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        MatrixStats matrixStats = new MatrixStats(matrix);
        int min = matrixStats.getMin();
        int max = matrixStats.getMax();
        String minStr = String.valueOf(min);
        String maxStr = String.valueOf(max);
        int columnSize = Math.max(minStr.length(), maxStr.length()) + 1;
        String formatString = "%" + columnSize + "d";
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++){
                sb.append(String.format(formatString, matrix[i][j]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    //Falta adaptar!!!
    public static void printStringMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("Row " + i + ": ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("[" + j + "]=" + matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void printDoubleMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("Row " + i + ": ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("[" + j + "]=" + matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // [END]

    //********** Methods to fill arrays with user input of different types: **********

    // [START]

    /**
     * Method which requests user input to fill an array, the initialized array is passed as parameter.
     * The value which is introduced by the user is validated with a method of LibIO.java, usually min and max.
     * @param array Array int[]
     */
    public static void userInputArray(int[] array){
        for (int i = 0; i < array.length; i++){
            System.out.printf("array[%d]\n", i);
            array[i] = LibIO.requestInt("Please, introduce a Number:", IMINV, IMAXV );
        }
    }

    /**
     * Method which requests user input to fill an array, the initialized array is passed as parameter.
     * The value which is introduced by the user is validated with a method of LibIO.java, usually min and max.
     * @param array Array char[]
     */
    public static void userInputArray(char[] array){
        for (int i = 0; i < array.length; i++){
            System.out.printf("array[%d]\n", i);
            array[i] = LibIO.requestChar("Please, insert a Character:");
        }
    }

    /**
     * Method which requests user input to fill an array, the initialized array is passed as parameter.
     * The value which is introduced by the user is validated with a method of LibIO.java, usually min and max.
     * @param array Array String[]
     */
    public static void userInputArray(String[] array){
        for (int i = 0;i < array.length; i++){
            System.out.printf("array[%d]\n", i);
            array[i] = LibIO.requestString("Please, insert a Text::", 0, 100);
        }
    }

    /**
     * Method which requests user input to fill an array, the initialized array is passed as parameter.
     * The value which is introduced by the user is validated with a method of LibIO.java, usually min and max.
     * @param array Array double[]
     */
    public static void userInputArray(double[] array){
        for (int i = 0;i < array.length; i++){
            System.out.printf("array[%d]\n", i);
            array[i] = LibIO.requestDouble("Please, insert a Number:", DMINV, DMAXV);
        }
    }

    // [END]

    //*********** Methods to fill arrays with Random Values, LibRandom.java will be used: **********

    // [START]

    /**
     * Creates and initializes a new array with Random Numbers.
     * Size of array is passed as parameter.
     * Min and Max Random values are passed as parameter.
     * @param length given number for the size or length of the array.
     * @param min given minimum value (int).
     * @param max given maximum value (int).
     * @return return array r[] (result) with the given size and random values.
     */
    public static int[] randomIntArray(int length, int min, int max){
        if (length < 1){
            return null;
        }
        if (min > max){
            return null;
        }

        int[] r = new int[length];

        for (int i = 0; i < r.length; i++){
            r[i] = LibRandom.randomInt(min, max);
        }
        return r;
    }

    public static char[] randomCharArray(int length, int min, int max) {
        if (length < 1){
            return null;
        }
        if (min > max){
            return null;
        }

        char[] r = new char[length];

        for (int i = 0; i < r.length; i++){
            r[i] = LibRandom.randomChar(min, max);
        }
        return r;
    }


    /**
     * Method which receives the size of rows and columns for the matrix.
     * It also receives the min and max value for the random numbers.
     * @param rows int value for the rows.
     * @param cols int value for the columns.
     * @param min int value for the minimum of random numbers.
     * @param max int value for the maximum of random numbers.
     * @return int matrix[][] with random numbers.
     */
    public static int[][] randomIntMatrix(int rows, int cols, int min, int max) {
        int[][] m = new int[rows][cols];
        for(int i = 0; i < m.length; i++) {
            for(int j = 0; j < m[i].length; j++) {
                m[i][j] = LibRandom.randomInt(min, max);
            }
        }
        return m;
    }

    public static double[][] randomDoubleMatrix(int rows, int cols, int min, int max) {
        double[][] m = new double[rows][cols];
        for(int i = 0; i < m.length; i++) {
            for(int j = 0; j < m[i].length; j++) {
                m[i][j] = LibRandom.randomDouble(min, max);
            }
        }
        return m;
    }

    /**
     * Creates and initializes a new array with Random Numbers.
     * Size of array is passed as parameter.
     * Min and Max Random values are passed as parameter.
     * @param length given number for the size or length of the array.
     * @param min given minimum value (double).
     * @param max given maximum value (double).
     * @return return array r[] (result) with the given size and random values.
     */
    public static double[] randomDoubleArray(int length, double min, double max){
        if (length < 1){
            return null;
        }
        if (min > max){
            return null;
        }

        double[] r = new double[length];

        for (int i = 0; i < r.length; i++){
            r[i] = LibRandom.randomDouble(min, max);
        }
        return r;
    }

    // [END]

    //********** METHODS TO SEARCH IN ARRAYS **********

    // [START]

    /**
     * Method linearSearchUnsorted, receives an UNSORTED array and a number to find.
     * Runs through the array and compares the number with the value of the array.
     * If found, show message and ends the loop.
     * If not, shows a message.
     * @param array int[]
     * @param n int, parameter to find in array.
     * @return message with the position where the value is found or if it hasn't been found.
     */
    public static String linearSearchUnsorted(int[] array, int n) {
        StringBuilder sb = new StringBuilder();
        boolean found = false;
        for(int i = 0; i < array.length; i++) {
            if(array[i] == n){
                sb.append(n).append(" found at index = ").append(i);
                found = true;
                break;
            }
        }
        if(!found) {
            sb.append(n).append(" not found in array");
        }
        return sb.toString();
    }

    /**
     * Method linearSearchSorted, receives an SORTED array and a number to find.
     * Runs through the array and compares the number with the value of the array.
     * If found, show message and ends the loop.
     * If higher value is found, value doesn't exist in array, shows a message.
     * If not, shows a message.
     * @param array int[]
     * @param n int, parameter to find in array.
     * @return message with the position where the value is found, higher value is found or if it hasn't been found.
     */
    public static String linearSearchSorted(int[] array, int n) {
        StringBuilder sb = new StringBuilder();
        boolean found = false;
        for(int i = 0; i < array.length; i++) {
            if(array[i] == n){
                sb.append(n).append(" found at index = ").append(i);
                found = true;
                break;
            } else if(array[i] > n) {
                sb.append(n).append(" not found in array");
                found = true;
                break;
            }
        }
        if(!found) {
            sb.append(n).append(" not found in array");
        }
        return sb.toString();
    }

    /**
     * Method binarySearch: This method is specifically designed for searching in sorted arrays. It takes an integer array and a target number as parameters.
     * The algorithm employs a binary search approach, which involves dividing the array and recursively searching on both the left and right sides of values.
     * @param array int[] - The sorted array in which the search is performed.
     * @param n int - The target number to be found in the array.
     * @return String - A message indicating whether the target number was found or not in the array.
     *                The message includes the index of the target if found, or a notification that the target is not present.
     */
    public static String binarySearch(int[] array, int n){
        boolean found = false;
        int i = 0;

        for(int low = 0; low < array.length; low++) {
            int mid = low + (array.length - low) / 2;

            if(array[mid] == n) {
                found = true;
                break;
            } else if (array[mid] < n) {
                i = mid + 1;
            } else {
                i = mid;
            }
        }

        if(!found) {
            return n + " not found";
        } else {
            return n + " found at index = " + i;
        }
    }


    // [END]

    //********** METHODS TO ORGANIZE ARRAYS **********

    // [START]

    /**
     * Method countingSort
     * @param array int[]
     * @return array int[] sorted from min to max.
     */
    public static int[] countingSort(int[] array) {
        ArrayStats stats = new ArrayStats(array);
        if (stats.getNegativeCount() > 0){
            return null;
        }
        int[] result = new int[array.length];
        int[] counter = new int[stats.getMax() + 1];
        for (int i = 0; i < array.length; i++){
            int value = array[i];
            counter[value]++;
        }
        int index = 0;
        for (int i = 0; i < counter.length; i++){
            int value = counter[i];
            for (int j = 0; j < value; j++){
                result[index++] = i;
            }
        }
        return result;
    }

    /**
     * Method selectionSort
     * @param array int[]
     * @return array[] sorted with selection.
     */
    public static int[] selectionSort(int[] array) {
        int aux;
        int minValue;
        for (int i = 0; i < array.length - 1; i++){
            minValue = i;
            for(int j = i + 1; j < array.length; j++){
                if(array[j] < array[minValue]){
                    minValue = j;
                }
            }
            aux = array[minValue];
            array[minValue] = array[i];
            array[i] = aux;
        }
        return array;
    }

    public static void selectionSortCorrection(int[] array) {
        for(int i = 0; i < array.length; i++) {
            int min = array[i];
            int pos = i;
            for(int j = i + 1; j < array.length; j++) {
                if(array[j] < min) {
                    min = array[j];
                    pos = j;
                }
            }
            if (pos != i) {
                exchangeValues(array, i, pos);
            }
        }
    }

    public static void exchangeValues(int[] array, int index1, int index2) {
        int aux = array[index1];
        array[index1] = array[index2];
        array[index2] = aux;
    }

    /**
     * Method which receives an array and uses insertSort to organize the array.
      * @param array int[]
     */
    public static void insertSort(int[] array) {
        int aux;
        int j;
        for(int i = 1; i < array.length; i++) {
            aux = array[i];
            j = i - 1;
            while((aux < array[j]) && j >= 0){
                    array[j + 1] = array[j];
                    j--;
            }
            array[j + 1] = aux;
        }
    }

    /**
     * Method bubbleSort
     * @param array int[]
     * @return array sorted with bubbleSort
     */
    public static int[] bubbleSort(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++){
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j + 1] < array[j]){
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    /**
     * Method quickSort
     * Method is formed with 3 methods using recursion. quickSortHelper, partition are necessary.
     * @param array int[]
     * @return array[] with array sorted.
     */
    public static int[] quickSort(int[] array) {
        int[] sortedArray = new int[array.length];
        quickSortHelper(sortedArray, 0, sortedArray.length - 1);
        return sortedArray;
    }

    public static void quickSortHelper(int[] array, int lowValue, int highValue) {
        if(lowValue < highValue) {
            int partitionIndex = partition(array, lowValue, highValue);
            quickSortHelper(array, lowValue, partitionIndex - 1);
            quickSortHelper(array, partitionIndex + 1, highValue);
        }
    }

    public static int partition(int[] array, int lowValue, int highValue) {
        int pivot = array[highValue];
        int i = lowValue - 1;

        for(int j = lowValue; j < highValue; j++){
            if(array[j] < pivot) {
                i++;
                int tempOne = array[i];
                array[i] = array[j];
                array[j] = tempOne;
            }
        }

        int tempTwo = array[i + 1];
        array[i + 1] = array[highValue];
        array[highValue] = tempTwo;

        return i + 1;
    }

    // [END]

    //********** SUBCLASS WITH METHOD TO GET STATISTICS OF AN ARRAY **********

    // [START]

    /**
     * SubClass to obtain different statistics of an array.
     * min value of array
     * max value of array
     * addition of array
     * mean (average) of array
     * positive value count of array
     * negative value count of array
     */
    public static class ArrayStats{
        private int min;
        private int max;
        private long sum;
        private double mean;
        private int positiveCount;
        private int negativeCount;
        private final int[] array;
        public ArrayStats(int[] array){
            this.array = array;
            getStats();
        }
        private void getStats(){
            min = array[0];
            max = array[0];
            mean = 0;
            sum = 0;
            positiveCount = 0;
            negativeCount = 0;
            for(int value : array){
                sum += value;
                if (value > max){
                    max = value;
                }
                if (value < min){
                    min = value;
                }
                if (value < 0){
                    negativeCount++;
                } else if (value > 0){
                    positiveCount++;
                }
                mean = (double) sum / array.length;
            }
        }
        public int getMin(){
            return min;
        }
        public int getMax(){
            return max;
        }
        public long getSum(){
            return sum;
        }
        public double getMean(){
            return mean;
        }
        public int getPositiveCount(){
            return positiveCount;
        }
        public int getNegativeCount(){
            return negativeCount;
        }
    }

    /**
     * SubClass to obtain different statistics of an array.
     * min value of array
     * max value of array
     * addition of array
     * mean (average) of array
     * positive value count of array
     * negative value count of array
     */
    public static class MatrixStats {
        private int min;
        private int max;
        private long sum;
        private double mean;
        private int positiveCount;
        private int negativeCount;
        private final int[][] matrix;
        public MatrixStats(int[][] matrix){
            this.matrix = matrix;
            getStats();
        }

        private void getStats() {
            min = matrix[0][0];
            max = matrix[0][0];
            mean = 0;
            sum = 0;
            positiveCount = 0;
            negativeCount = 0;
            int elementCount = 0;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    int value = matrix[i][j];
                    sum += value;
                    if (value > max) {
                        max = value;
                    }
                    if (value < min) {
                        min = value;
                    }
                    if (value < 0) {
                        negativeCount++;
                    } else if (value > 0) {
                        positiveCount++;
                        elementCount++;
                    }
                    mean = (double) sum / (elementCount);
                }
            }
        }
        public int getMin() {
            return min;
        }

        public int getMax() {
            return max;
        }

        public long getSum() {
            return sum;
        }

        public double getMean() {
            return mean;
        }

        public int getPositiveCount() {
            return positiveCount;
        }

        public int getNegativeCount() {
            return negativeCount;
        }

        public int[][] getMatrix() {
            return matrix;
        }
    }

    // [END]

    //********** METHODS TO CALCULATE AND OBTAIN INFORMATION WITH/ABOUT ARRAYS **********

    // [START]

    //OBTAIN INFORMATION:

    /**
     * Method to calculate the average of the values of an array.
     * @param array Array int[].
     * @return float with value of the average of all the values of the array.
     */
    public static float calcAverageArray(int[] array){
        if(array.length == 0){
            return 0.0f;
        }
        int addition = 0;
        for (int i = 0; i < array.length; i++){
            addition += array[i];
        }
        return (float) addition / array.length;
    }

    /**
     * Method to calculate the average of the values of an array.
     * @param array Array double[].
     * @return double with value of the average of all the values of the array.
     */
    public static double calcAverageArray(double[] array){
        if(array.length == 0){
            return 0.0f;
        }
        int addition = 0;
        for (int i = 0; i < array.length; i++){
            addition += array[i];
        }
        return (double) addition / array.length;
    }

    /**
     * Method to calculate the average of the values of an array.
     * Only values >= n.
     * @param array Array double[].
     * @return double with value of the average of all the values of the array.
     */
    public static double calcAverageArray(double[] array, double n){
        if(array.length == 0){
            return 0.0f;
        }

        int addition = 0;
        int counter= 0;

        for (int i = 0; i < array.length; i++){
            if(array[i] >= n) {
                addition += array[i];
                counter++;
            }
        }
        if(counter == 0){
            return -1;
        }
        return (double) addition / array.length;
    }

    /**
     * Method to find a given number in the array passed as parameter.
     * If it finds the value, it assigns it to a new array.
     * @param array int[]
     * @param n int value to find.
     * @return int r[] with found values.
     */
    public static int[] containsNumber(int[] array, int n) {
        int counter = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] == n) {
                counter++;
            }
        }

        int[] r = new int[counter];
        counter = 0;

        for(int i = 0; i < array.length; i++) {
            if(array[i] == n){
                r[counter++] = array[i];
            }
        }
        return r;
    }

    //CALCULATIONS WITH ARRAYS:

    /**
     * Method to add the values of 2 arrays.
     * If array is empty returns new array 0.
     * If length is equal it does the operation, otherwise returns array with 0.
     * @param a1 int[]
     * @param a2 int[]
     * @return int[] with the result of the addition of each position.
     */
    public static int[] additionArrays(int[] a1, int[] a2) {
        if(a1.length == 0 && a2.length == 0) {
            return new int[0];
        }
        int[] r = new int[a1.length];
        if(a1.length == a2.length) {
            for(int i = 0; i < r.length; i++) {
                r[i] = a1[i] + a2[i];
            }
        }
        return r;
    }

    /**
     * Method to divide the values of 2 arrays.
     * If array is empty returns new array 0.
     * If length is equal it does the operation, otherwise returns array with 0.
     * @param a1 int[]
     * @param a2 int[]
     * @return int[] with the result of the division of each position.
     */
    public static int[] divisionArrays(int[] a1, int[] a2) {
        if(a1.length == 0 && a2.length == 0) {
            return new int[0];
        }
        int[] r = new int[a1.length];
        if(a1.length == a2.length) {
            for(int i = 0; i < r.length; i++) {
                r[i] = a1[i] / a2[i];
            }
        }
        return r;
    }

    // [END]


}
