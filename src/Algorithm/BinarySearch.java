package Algorithm;

/**
 * @program: JavaTest
 * @description: ${二叉树的查找}
 * @author: Mr.ZeroCamel
 * @create: 2020-09-15 10:58
 **/
public class BinarySearch {
    public static void main(String[] args) {
        int[] a={0,2,5,8,10,15,30,40,55};
        int result = binaryFun(a,0,a.length-1,55);
        System.out.println(result);
        int resultLoop = binaryFunLoop(a,0,a.length-1,15);
        System.out.println(resultLoop);
    }

    /*
     递归
     */
    public static int binaryFun(int[] array, int start, int end, int key) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (array[mid] > key) {
            return binaryFun(array, 0, mid - 1, key);
        } else if (array[mid] < key) {
            return binaryFun(array, mid + 1, end, key);
        }
        return mid;
    }

    /*
    循环
     */
    public static int binaryFunLoop(int[] array,int start,int end,int key)
    {
        while (start<=end)
        {
            int mid=(start+end)/2;
            if (array[mid]==key)
            {
                return mid;
            } else if (array[mid]>key)
            {
                end = mid-1;
            } else if(array[mid]<key)
            {
                start = mid+1;
            }
        }
        return  -1;
    }

}
