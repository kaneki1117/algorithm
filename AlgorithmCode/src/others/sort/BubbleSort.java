package others.sort;
//冒泡排序 每次比较两个数，不满足递增则交换。每次至少能排好最后一个数。
//时间O(n^2) 空间O(1)
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = { 19, 38, 7, 36, 5, 5, 3, 2, 1, 0, 56 };
        bubbleSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }


    public static void bubbleSort(int[] array){
        if(array == null || array.length < 2){
            return;
        }
        for (int j = array.length; j >= 0 ; j--) {
            for (int i = 1; i < j; i++) {
                if(array[i] < array[i-1]){
                    swap(array,i,i-1);
                }
            }
        }
    }

    public static void swap(int[] array, int i ,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
