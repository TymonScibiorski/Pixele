import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {

        int[][] out = readData();
        System.out.println(findMax(out));
        System.out.println(findMin(out));

        String AssymetricRowsCount = countAssymerticRows(out)+"";
        System.out.println("The amount of assymetric rows is: " + AssymetricRowsCount);

//        int contrastingPixelsCount = howManyContrastingPixels(out);

    }

    public static int lengthOfLongestVerticalContinuousCombinationOfPixelsOfTheSameBrightness(int[][] matrix){
        int out = 0;

        for (int i = 0; matrix.length>i; i++){
            for (int j = 0; matrix.length>j; j++){
                int currentNumberOfVerticalPixels = checkingTheLengthOfASingleVerticalColumnWithPixelsOfTheSameBrightness(matrix, j, i);
                if (out<currentNumberOfVerticalPixels){
                    out = currentNumberOfVerticalPixels;
                }
            }

        }
        return out;
    }
    public static int checkingTheLengthOfASingleVerticalColumnWithPixelsOfTheSameBrightness(int[][] matrix, int x, int y){
        int counter = 1;
        for (int ndY = y+1; ndY<matrix.length; ndY++){
            if (matrix[y][x] == matrix[ndY][x]) {
                counter++;
            }
        }
        return counter;
    }

    public static boolean arePixelsOfTheSameBrightness(int pixel1, int pixel2){
        return pixel1 == pixel2;
    }

    public static int howManyContrastingPixels(int[][] matrix){
        int count = 0;

        for(int i = 0; matrix.length>i; i++){
            for(int j = 0; matrix[i].length>j; j++){

                if(checkingNeighbouringPixeles(matrix, i, j)){
                    count++;
                }

            }
        }

        return count;
    }

    public static boolean checkingNeighbouringPixeles(int[][] matrix, int x, int y){
        int pixel = matrix[y][x];

         return hasContrastingNeighbour(matrix, pixel, x, y-1) ||
                 hasContrastingNeighbour(matrix, pixel, x, y+1) ||
                 hasContrastingNeighbour(matrix, pixel, x-1, y) ||
                 hasContrastingNeighbour(matrix, pixel, x+1, y);
    }

    public static boolean hasContrastingNeighbour(int[][] matrix, int pixel, int neighbourY, int neighbourX) {
        if(neighbourX<0 || neighbourY<0 || neighbourY >= matrix.length || neighbourX >= matrix[0].length) return false;
//        checking if the pixels are not exceeding the matrix

        int neighbour = matrix[neighbourX][neighbourY]; //taking the brightness of the pixel
        return isPixelContrasting(pixel, neighbour); //checking if the pixels are contrasting
    }

    public static boolean isPixelContrasting(int originalPixel, int checkedPixel) {
        return Math.abs(originalPixel-checkedPixel)>=128;
    }

    public static int countAssymerticRows(int[][] matrix){
        int count = 0;

        for(int[] row : matrix){
            if(!isRowSymetric(row)){
                count++;
            }
        }

        return count;
    }

    public static boolean isRowSymetric(int[] row){
        for(int i=0; row.length/2>i; i++){
            if(row[i]!=row[row.length-i-1]){
                return false;
            }
        }

        return true;
    }

    public static int findMax(int[][] macierz){
        int max = macierz[0][0];
        for(int i=0; i<macierz.length; i++){
            for(int j = 0; macierz[i].length>j; j++){
                if (macierz[i][j]>max){
                    max=macierz[i][j];
                }
            }
        }
        return max;
    }
    public static int findMin(int[][] macierz){
        int min = macierz[0][0];
        for(int i=0; i<macierz.length; i++){
            for(int j = 0; macierz[i].length>j; j++){
                if (macierz[i][j]<min){
                    min=macierz[i][j];
                }
            }
        }
        return min;
    }

    public static int[][] readData(){
        try{
            int[][] macierz = new int[200][320];
            FileReader fr = new FileReader("dane_2/dane.txt");
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            int wierszIndx = 0;
            while(line != null) {
                String[] liczby = line.split(" ");

                int[] wierszLiczby = parseRowIntoInts(liczby);

                macierz[wierszIndx++]=wierszLiczby;

                line = br.readLine();
            }


            return macierz;
        }
        catch (FileNotFoundException exc) {
            System.out.println("Couldn't load the file");
        }
        catch (Exception exc) {
            System.out.println("Dupa");
        }
        return null;
    }

    public static int[] parseRowIntoInts(String[] nums){
        int[] result = new int[320];

        for(int i = 0; i<nums.length; i++) {
            int n = Integer.parseInt(nums[i]);
            result[i] = n;
        }

        return result;
    }


}