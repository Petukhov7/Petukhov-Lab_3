import java.io.IOException;

public class Main {
    public static final int ROWS = 4;
    public static final int COLUMNS = 4;
    public static void main(String[] args) {

        int[][] array_good = {
                {22, 4, 4, 52},
                {4, 4, 6, 4},
                {4, 7, 12, 4},
                {4, 4, 4}};
        try {
            try {
                int result = method_array(array_good);
                System.out.println("Результат: " + result);
            } catch (MyArraySizeException e) {
                //System.out.println("Размер массива должен быть 4х4!");
                e.printStackTrace();
            }
        } catch (MyArrayDataException e) {

            System.out.println("В яичейке: " + e.i + "x" + e.j + " должно быть число");
        } catch (MyArrayCountException e) {
            System.out.println("В вашем массиве число больше 2х значного");
        } catch (MyArrayFibonacciNumberException e) {
            // System.out.println("В матрице есть число Фибоначчи");
            e.printStackTrace();
        }
    }

    public static int method_array(int[][] arr) throws MyArraySizeException, MyArrayDataException, MyArrayFibonacciNumberException, MyArrayCountException {
        //int a = 4;
        int count = 0;
        int num = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i].length != 4) {
                throw new MyArraySizeException("Длинна массива должна быть 4х4");
            }

            for (int j = 0; j < arr[i].length; j++) {
                try {
                    num = Integer.parseInt(String.valueOf(arr[i][j]));
                    count = count + num;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(1 + i, 1 + j);
                }
                if (num > 99) {
                    throw new MyArrayCountException();
                }
                int[] f = new int[num];
                //f[0] = 0;
                //f[1] = 1;
                int l=2;
                while (l != num) {
                    //f[l] = f[l - 1] + f[l - 2];
                    //System.out.println(f[l]);
                    if (num == 0)
                    {
                        throw new MyArrayFibonacciNumberException(num + " - число Фибоначчи в " + (i + 1) + " строке " + (j + 1) + " столбце");
                    }
                    if (num == 1)
                    {
                        throw new MyArrayFibonacciNumberException(num + " - число Фибоначчи в " + (i + 1) + " строке " + (j + 1) + " столбце");
                    }
                    if (num == f[l]) {
                        //System.out.println(num + " число фибонач");
                        throw new MyArrayFibonacciNumberException(num + " - число Фибоначчи в " + (i + 1) + " строке " + (j + 1) + " столбце");
                    }
                    if (f[l] > num) {
                        //System.out.println(num + " - не является числом Фибоначчи");
                        break;
                    }
                    l++;
                }
            }
        }
        return count;
    }

}