package offer.C41_60;

public class Test50 {

    public static void main(String[] args) {

    }
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null || numbers.length == 0) return false;
        int[] counts = new int[length];
        for (int i = 0; i < length; i++) {
             int index = numbers[i];
            if(counts[index] == 0){
                counts[index]++;
            }else{
                duplication[0] = index;
                return true;
            }
        }

        return false;
    }
}
