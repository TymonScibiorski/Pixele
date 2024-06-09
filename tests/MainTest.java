import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void TestingLengthOfLongestVerticalContinuousCombinationOfPixelsOfTheSameBrightness(){
        int[][] matrix = {
                {0, 225, 52},
                {225, 0, 127},
                {34, 44, 28}
        };
        Assert.assertEquals(1, Main.lengthOfLongestVerticalContinuousCombinationOfPixelsOfTheSameBrightness(matrix));

        int[][] matrix2 = {
                {0, 225, 52, 44},
                {0, 0, 127, 44},
                {0, 44, 28, 44}
        };
        Assert.assertEquals(3, Main.lengthOfLongestVerticalContinuousCombinationOfPixelsOfTheSameBrightness(matrix2));

        int[][] matrix3 = {
                {0, 225, 52, 44},
                {0, 0, 127, 44},
                {0, 44, 28, 44},
                {60, 9, 40, 44, 20}
        };
        Assert.assertEquals(4, Main.lengthOfLongestVerticalContinuousCombinationOfPixelsOfTheSameBrightness(matrix3));
    }

    @Test
    void TestingCheckingTheLengthOfASingleVerticalColumnWithPixelsOfTheSameBrightness(){
        int[][] matrix = {
                {0, 225, 52},
                {225, 0, 127},
                {34, 44, 28}
        };
        Assert.assertEquals(1, Main.checkingTheLengthOfASingleVerticalColumnWithPixelsOfTheSameBrightness(matrix, 0, 0));

        int[][] matrix2 = {
                {0, 225, 52, 44},
                {0, 0, 127, 44},
                {0, 44, 28, 44}
        };
        Assert.assertEquals(3, Main.checkingTheLengthOfASingleVerticalColumnWithPixelsOfTheSameBrightness(matrix2, 0, 0));

        int[][] matrix3 = {
                {0, 225, 52, 44},
                {0, 0, 127, 44},
                {0, 44, 28, 44},
                {60, 9, 40, 44, 20}
        };
        Assert.assertEquals(4, Main.checkingTheLengthOfASingleVerticalColumnWithPixelsOfTheSameBrightness(matrix3, 3, 0));
    }

    @Test
    void TestingArePixelsOfTheSameLength(){
        int pixel1 = 0;
        int pixel2 = 225;
        Assert.assertFalse(Main.arePixelsOfTheSameBrightness(pixel1, pixel2));
        pixel1 = 225;
        Assert.assertTrue(Main.arePixelsOfTheSameBrightness(pixel1, pixel2));

    }

    @Test
    void TestingHowManyContrastingPixels() {
        int[][] matrix = {
                {0, 225, 52},
                {225, 0, 127},
                {34, 44, 28}
        };

        Assert.assertEquals(6, Main.howManyContrastingPixels(matrix));
    }

    @Test
    void TestingCheckingNeigbhouringPixeles(){
        int[][] matrix = {
                {0, 225, 52},
                {225, 0, 127},
                {34, 44, 28}
        };

        Assert.assertTrue(Main.checkingNeighbouringPixeles(matrix,1, 0));
    }

    @Test
    void TestingHasContrastingNeighbour(){
        int[][] matrix = {
                {0, 225, 52},
                {225, 0, 127},
                {34, 44, 28}
        };

        Assert.assertTrue(Main.hasContrastingNeighbour(matrix, 0, 1, 0));
    }

    @Test
    void checkIfPixelsAreContrasting() {
        int pixel1 = 0;
        int pixel2 = 255;

        Assert.assertTrue(Main.isPixelContrasting(pixel1, pixel2));


    }

    @Test
    void countAssymetricRows() {
        int[][] matrix = new int[][]{
                {0, 8, 8, 0},
                {37, 48, 22, 44}
        };

        int AssymetricRowsCount = Main.countAssymerticRows(matrix);

        Assert.assertTrue(AssymetricRowsCount == 1);

    }

    @Test
    void parseRowIntoInts() {
        //        arrange
        String[] numStrArr = new String[]{"37", "42", "88", "5", "10", "15"};

//        act
        int[] result = Main.parseRowIntoInts(numStrArr);

//        assert
        Assert.assertNotNull(result);
        Assert.assertTrue(result.length==320);
        Assert.assertTrue(result[1]==42);

    }

    @Test
    void findMaxInMatrix() {
        int[][] macierz = new int[][]{
                {0, 2, 7},
                {8, 4}
            };
        int max = Main.findMax(macierz);
        Assert.assertTrue(max == 8);
    }

    @Test
    void findMin() {
        int[][] macierz = new int[][]{
                {0, 2, 7},
                {8, 4}
        };
        int max = Main.findMax(macierz);
        Assert.assertTrue(max == 0);
    }

    @Test
    void isRowSymetric() {
        int[] wierz = new int[]{37, 8, 8, 37};
        boolean wynik = Main.isRowSymetric(wierz);
        Assert.assertTrue(wynik);

        int[] wierz1 = new int[]{0, 2, 8, 4};
        boolean wynik1 = Main.isRowSymetric(wierz1);
        Assert.assertFalse(wynik1);
    }


}