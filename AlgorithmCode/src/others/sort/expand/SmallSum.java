package others.sort.expand;
//在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组 的小和。
public class SmallSum {
    public static void main(String[] args) {

        int[] array = {1,3,4,2,5 };
        int[] temp = new int[array.length];
        System.out.println(mergeSort(array,0,array.length-1,temp));

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }
    public static int mergeSort(int[] arr, int l, int r,int[] temp) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return mergeSort(arr, l, mid,temp) + mergeSort(arr, mid + 1, r,temp) + merge(arr, l, mid, r,temp);
    }

    public static int merge(int[] arr, int l, int m, int r,int[] temp) {
        int i = l;
        int p1 = l;
        int p2 = m + 1;
        int res = 0;
        while (p1 <= m && p2 <= r) {
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            temp[i++] = arr[p1++];
        }
        while (p2 <= r) {
            temp[i++] = arr[p2++];
        }
        for (i = l; i <=r; i++) {
            arr[i] = temp[i];
        }
        return res;
    }
}
