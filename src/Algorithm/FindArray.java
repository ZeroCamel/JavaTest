package Algorithm;

/**
 * @program: JavaTest
 * @description: ${查找数组Arr中第K小的奇数，如果不存在则返回0}
 * @author: Mr.ZeroCamel
 * @create: 2020-07-20 20:40
 **/
public class FindArray {

    private static int partition(int[] arr, int low, int high) {
        // 左右哨兵
        int i = low;
        int j = high;

        // 设立基准值
        int x = arr[low];

        // 循环分区
        while(i < j){

            // 1、右哨兵左移，观察第一个小于基准值的值
            while(arr[j] >= x && i < j){
                j--;
            }
            // 2、找到小于基准的目标值 并填充到做分区；左哨兵向右进一
            if(i < j) {
                arr[i] = arr[j];
                i++;
            }
            // 3、左哨兵右移，观察第一个大于等于基准值的值
            while(arr[i] < x && i < j){
                i++;
            }
            // 4、找到大于等于基准的目标值 并填充到有分区；右哨兵向左进一
            if(i < j) {
                arr[j] = arr[i];
                j--;
            }
        }

        // 基准值最终位置回写
        arr[i] = x;

        //返回基准值的位置索引
        return i;
    }

    private static void quickSort(int[] arr, int low, int high) {

        // 递归结束出口
        if(low < high){

            //分区操作，将一个数组分成两个分区，返回分区界限索引
            int index = partition(arr, low, high);

            //左分区快排
            quickSort(arr, low,index-1);

            //右分区快排
            quickSort(arr,index+1, high);
        }

    }

    public static void quickSort(int[] arr) {
        int low = 0;
        int high = arr.length-1;
        quickSort(arr,low,high);
    }

    public int findKth(int[] arr,int k)
    {
        quickSort(arr);
        int count = 0;
        for (int i = 0;i < arr.length; i++) {
            if(arr[i]%2 != 0)
            {
                count++;
            }
            if (count == k) {
                return arr[i];
            }
        }
        // 没有找到合适的K
        return -1;
    }
}
