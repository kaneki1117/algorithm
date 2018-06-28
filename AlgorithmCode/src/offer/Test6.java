package offer;

public class Test6 {
    public int minNumberInRotateArray(int [] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        int start = 0 ;
        int end = array.length - 1;
        int num = array[end];
        while (start + 1 < end){
            int mid = (end - start) / 2 + start;
            if (array[mid] <= num){
                end = mid;
            }else {
                start = mid;
            }
        }

        if(array[start] < array[end]){
            return array[start];
        }

        return array[end];
    }
}
