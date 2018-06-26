package others.sort;

//随机快排。。是对经典快排的优化，经典快排每次考虑一个数。
//避免了经典快排的最差情况：O(n^2)
//随机快排的时间O（NlogN） 空间是O（logN） 空间的消耗是数组p的一个记录 对数组而言 长期期望的空间消耗是O（logN）
public class QuickSort2 {
    public static void main(String[] args) {
        int[] array = { 19, 38, 7, 36, 5, 5, 3, 2, 1, 0, 56 };
        quickSort(array,0,array.length-1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            //随机选取任意一个数和最后一个数交换 从而避免最差情况On^2。
            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    public static int[] partition(int[] arr, int l, int r) {
        //之所以
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        //之所以要swap 是因为使用了最后一个数 只有将最后的x 和大于x的第一个数交换 才能达到 <x  =x  >x的效果。
        swap(arr, more, r);
        return new int[]{less + 1, more};
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}