package others.sort;
//插入排序 时间O（n^2） 空间O（1）
//注意内循环的写法
public class InsertSort {
    public static void main(String[] args) {
        int[] array = { 19, 38, 7, 36, 5, 5, 3, 2, 1, 0, 56 };
        insertSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }

    public static void insertSort(int[] array){
        if(array == null || array.length < 2){
            return;
        }
        for (int i = 1; i <array.length ; i++) {
            for (int j = i - 1; j >= 0 && array[j] > array[j + 1]; j--) {
                swap(array, j, j + 1);
            }
        }
    }

    public static void swap(int[] array, int i ,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
