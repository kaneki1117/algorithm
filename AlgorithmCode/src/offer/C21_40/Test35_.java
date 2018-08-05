package offer.C21_40;

public class Test35_ {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,0};
        System.out.println(InversePairs(arr));
    }

    public static int InversePairs(int [] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        int[] assist = new int[array.length];
        return mergeSort(array,0,array.length-1,assist);
    }

    public static int mergeSort(int[] array,int start,int end, int[] assist){
        if(start >= end) return 0;

        int mid = (end - start) / 2 + start;
        int left = mergeSort(array,start,mid,assist);
        int right = mergeSort(array,mid+1,end,assist);
        int count = merge(array,start,mid,end,assist);
        return (left+right+count)%1000000007;
    }

    public static int merge(int[] array,int start,int mid,int end, int[] assist){
        int left = start;
        int right = mid+1;
        int index = start;
        int count = 0;
        while (left <= mid && right <= end){
            if(array[left] > array[right]){
                assist[index++] = array[right++];
                count+= mid - left+1;
                //注意此处 是防止溢出的重要代码 之前只过50%只是因为这里
                if(count > 1000000007){
                    count = count%1000000007;
                }

            }else {
                assist[index++] = array[left++];
            }
        }

        while (left <= mid){
            assist[index++] = array[left++];
        }
        while (right <= end){
            assist[index++] = array[right++];
        }

        for (int i = start; i <=end ; i++) {
            array[i] = assist[i];
        }
        return count;
    }
}
