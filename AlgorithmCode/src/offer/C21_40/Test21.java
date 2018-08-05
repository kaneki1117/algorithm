package offer.C21_40;

import java.util.Stack;

public class Test21 {
    public static void main(String[] args) {
        int[] push = {1,2,3,4,5};
        int[] pop = {4,3,5,1,2};
        System.out.println(IsPopOrder(push,pop));
    }
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA == null || popA == null||pushA.length != popA.length){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < pushA.length; i++) {
            if(pushA[i] != popA[index]){
                stack.push(pushA[i]);
            }else {
                index++;
            }
        }

        for (int i = index; i <popA.length ; i++) {
            if(stack.pop() != popA[i]){
                return false;
            }
        }

        return stack.empty();
    }

    /**
     * 参考解法 但时间慢于自己的answer
     * if(pushA.length == 0 || popA.length == 0)
     *             return false;
     *         Stack<Integer> s = new Stack<Integer>();
     *         //用于标识弹出序列的位置
     *         int popIndex = 0;
     *         for(int i = 0; i< pushA.length;i++){
     *             s.push(pushA[i]);
     *             //如果栈不为空，且栈顶元素等于弹出序列
     *             while(!s.empty() &&s.peek() == popA[popIndex]){
     *                 //出栈
     *                 s.pop();
     *                 //弹出序列向后一位
     *                 popIndex++;
     *             }
     *         }
     *         return s.empty();
     */
}
