package algorithm;

/**
 * @program: JavaTest
 * @description: ${description}
 * @author: Mr.ZeroCamel
 * @create: 2021-10-18 20:54
 **/
public class BubbleSortDemo {

    public static int[] bubbleSort(int[] array)
    {
        for (int j = array.length; j > 0 ; j--) {
            for (int i = 0; i < array.length-1; i++) {
                int temp = array[i];
                if (temp > array[i+1])
                {
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[]{10,9,14,7,68,53,42,33,222,11};
        int[] bubbleSort = bubbleSort(array);
        for (int i = 0; i < bubbleSort.length; i++) {
            System.out.println(bubbleSort[i]);
        }

    }
}
