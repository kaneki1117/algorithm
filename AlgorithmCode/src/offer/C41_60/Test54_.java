package offer.C41_60;

import java.util.*;
//已ac  然而此类题目做的较少 需要多关注 有更省空间的思路
public class Test54_ {
    public static void main(String[] args) {
        Test54_ test = new Test54_();
        test.Insert('g');
        System.out.println(test.FirstAppearingOnce());
    }
    //Insert one char from stringstream
    Queue<Character> queue = new LinkedList<>();
    Map<Character,Boolean> map = new HashMap<>();
    public  void Insert(char ch) {
        if(map.get(ch) == null){
            queue.offer(ch);
            map.put(ch,true);
            return;
        }

        if(map.get(ch) == false){
            return;
        }
        if(map.get(ch) == true){
            map.put(ch,false);
        }

    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        while (!queue.isEmpty() && !map.get(queue.peek())){
            queue.poll();
        }
        Character result = queue.isEmpty()?'#':queue.peek();
        return result;
    }
}
