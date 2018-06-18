package others.sort;

//选择排序 时间O（n^2） 空间O（1）
//一般是选最小的放前面（一开始自己写的是选最大的从后往前）
public class SelectSort {
    public static void main(String[] args) {
        int[] array = { 19, 38, 7, 36, 5, 5, 3, 2, 1, 0, 56 };
        selectSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }

    public static void selectSort(int[] array){
        if(array == null || array.length < 2){
            return;
        }
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                minIndex = array[j] < array[minIndex] ? j : minIndex;
            }
            swap(array, i, minIndex);
        }
        //personal
//        for (int i = array.length-1 ; i > 0; i--){
//            int max = 0;
//            for (int j = 0; j <= i; j++) {
//                if(array[j]  > array[max]){
//                    max = j;
//                }
//            }
//            swap(array,max,i);
//        }
    }

    public static void swap(int[] array, int i ,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
