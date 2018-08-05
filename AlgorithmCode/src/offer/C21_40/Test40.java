package offer.C21_40;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test40 {
    public static void main(String[] args) {

    }

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length == 0){
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if(set.contains(array[i])){
                set.remove(array[i]);
            }else {
                set.add(array[i]);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(Integer i : set){
            list.add(i);
        }
        num1[0] = list.get(0);
        num2[0] = list.get(1);

    }

    /**
     *
     * 可以用位运算实现，如果将所有所有数字相异或，则最后的结果肯定是那两个只出现一次的数字异或
     *  的结果，所以根据异或的结果1所在的最低位，把数字分成两半，每一半里都还有只出现一次的数据和成对出现的数据
     *  这样继续对每一半相异或则可以分别求出两个只出现一次的数字
     *主要逻辑如下：
     *  for(int i=0;i<size;i++)
     *   {
     *    if(IsBit(data[i],index))
     *     *num1^=data[i];
     *    else
     *     *num2^=data[i];
     *   }
     *     }
     *  bool IsBit(int num,int index)
     *  {
     *   num=num>>index;
     *   return (num&1);
     *  }
     */
}
