package others.sort;

public class HeapSort {
    public static void main(String[] args) {
        int[] array = { 19, 38, 7, 36, 5, 5, 3, 2, 1, 0, 56 };
        heapSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }

    public static void heapSort(int[] array) {
        if (array == null || array.length == 1)
            return;
        //构建堆,注意循环起始条件 ，
        int cursor = array.length / 2;
        for (int i = cursor; i >= 0; i--) {
            maxHeap(array, array.length, i);
        }
        //此处>=1 最准确
        for (int i = array.length - 1; i >= 1; i--) {
            // 经过上面的一些列操作，目前array[0]是当前数组里最大的元素，需要和末尾的元素交换
            swap(array, 0, i);
            // 交换完后，下次遍历的时候，就应该跳过最后一个元素，
            maxHeap(array, i, 0);
        }
    }

    // 最大堆
    public static void maxHeap(int[] array, int heapSize, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int maxValue = index;
        //注意此处比较的时候用maxValue 而不是 index 最后交换位置 用index。
        if (left < heapSize && array[left] > array[maxValue]) {
            maxValue = left;
        }
        if (right < heapSize && array[right] > array[maxValue]) {
            maxValue = right;
        }
        // 如果不相等，说明啊，这个子节点的值有比自己大的，位置发生了交换了位置
        if (maxValue != index) {
            swap(array, index, maxValue); // 就要交换位置元素
            // 交换完位置后还需要判断子节点是否打破了最大堆的性质。最大堆性质：两个子节点都比父节点小。
            maxHeap(array, heapSize, maxValue);
        }
    }


    // 数组元素交换
    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}
