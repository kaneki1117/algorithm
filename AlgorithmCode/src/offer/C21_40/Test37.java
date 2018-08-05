package offer.C21_40;

public class Test37 {
    public static void main(String[] args) {

    }
    public int GetNumberOfK(int [] array , int k) {
        if(array== null || array.length == 0){
            return -1;
        }
        int first = findFirst(array,k);
        int last = findLast(array,k);
        return first == -1 ? 0:last-first+1;
    }

    public int findFirst(int[] arr,int k){
        int start  = 0 ; int end = arr.length - 1;

        while (start + 1 < end){
            int mid = (end - start) / 2 + start;
            if(arr[mid] == k){
                end = mid;
            }else if(arr[mid] < k){
                start = mid;
            }else {
                end = mid;
            }
        }

        if(arr[start] == k) return start;
        if(arr[end] == k) return end;
        return -1;
    }

    public int findLast(int[] arr,int k){
        int start  = 0 ; int end = arr.length - 1;

        while (start + 1 < end){
            int mid = (end - start) / 2 + start;
            if(arr[mid] == k){
                start = mid;
            }else if(arr[mid] < k){
                start = mid;
            }else {
                end = mid;
            }
        }

        if(arr[end] == k) return end;
        if(arr[start] == k) return start;
        return -1;
    }
}
