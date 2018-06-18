package others.sort;

public class Test {

    public static void main(String[] args) {
        int[] array = new int[]{19, 38, 7, 36, 5, 5, 3, 2, 1, 0, 56};
        heapSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

    public static void heapSort(int[] array){
        if(array == null || array.length < 2){
            return;
        }
        int start = array.length /2 - 1;
        for(int i = start ; i>= 0 ; i--){
            maxHeap(array,array.length - 1,i);
        }

        for (int i = array.length - 1; i >=1 ; i--) {
            swap(array,0,i);
            maxHeap(array,i,0);
        }
    }

    public static void maxHeap(int[] array,int heapsize,int index){
        int left = 2*index + 1;
        int right = 2*index + 2;
        int idx = index;
        if(left < heapsize && array[idx] < array[left]){
            idx = left;
        }
        if(right < heapsize && array[idx] < array[right]){
            idx = right;
        }

        if(index != idx){
            swap(array,idx,index);
            maxHeap(array,heapsize,idx);
        }
    }


    public static void swap(int[] array,int i ,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
