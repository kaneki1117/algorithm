package others.sort;
//归并排序 时间O（nlogn） 空间O（n）
//注意在开始的时候 创建temp数组 复用空间比较节省 以及注意merge函数几个下标。

public class MergeSort {
    public static void main(String[] args) {
        int[] array = { 19, 38, 7, 36, 5, 5, 3, 2, 1, 0, 56 };
        int[] temp = new int[array.length];
        mergeSort(array,0,array.length-1,temp);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }

    public static void mergeSort(int[] array, int start ,int end,int[] temp){
        if(start >= end){
            return;
        }
        int mid = (end - start) / 2 + start;
        mergeSort(array,start,mid,temp);
        mergeSort(array,mid+1,end,temp);
        merge(array,start,mid,end,temp);
    }

    public static void merge(int[] array,int start, int mid, int end,int[] temp){
        /** 开始的写法 不够准备 更浪费空间
         * int[] res = new int[array.length];
         *         int index = start;
         *         int left = start;
         *         int right = mid + 1;
         */
        int index = start;
        int left = start;
        int right = mid + 1;
        while (left <= mid && right <= end){
            if(array[left] <= array[right]){
                temp[index++] = array[left++];
            }else {
                temp[index++] = array[right++];
            }
        }

        while (left<= mid){
            temp[index++] = array[left++];
        }
        while (right<= end){
            temp[index++] = array[right++];
        }

//        for (int i = start; i <= end ; i++) {
//            array[i] = res[i];
//        }
        for (int i = start; i <= end ; i++) {
            array[i] = temp[i];
        }
    }
}
