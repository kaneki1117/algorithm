package offer.C1_20;
//空间换时间的方法
//如果不借助额外空间 则需要O（n^2），类似 插入排序的思想。
public class Test13 {
    public void reOrderArray(int [] array) {
        if(array == null || array.length == 0){
            return;
        }
        int index = 0;
        int[] arr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                arr[index++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            if(array[i] % 2 == 0){
                arr[index++] = array[i];
            }
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = arr[i];
        }
    }

}
