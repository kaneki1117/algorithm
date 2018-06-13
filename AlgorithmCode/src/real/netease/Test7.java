package real.netease;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test7 {
    /**
     * 牛牛总是睡过头，所以他定了很多闹钟，只有在闹钟响的时候他才会醒过来并且决定起不起床。从他起床算起他需要X分钟到达教室，上课时间为当天的A时B分，请问他最晚可以什么时间起床
     * 输入描述:
     * 每个输入包含一个测试用例。
     * 每个测试用例的第一行包含一个正整数，表示闹钟的数量N(N<=100)。
     * 接下来的N行每行包含两个整数，表示这个闹钟响起的时间为Hi(0<=A<24)时Mi(0<=B<60)分。
     * 接下来的一行包含一个整数，表示从起床算起他需要X(0<=X<=100)分钟到达教室。
     * 接下来的一行包含两个整数，表示上课时间为A(0<=A<24)时B(0<=B<60)分。
     * 数据保证至少有一个闹钟可以让牛牛及时到达教室。
     *
     *
     * 输出描述:
     * 输出两个整数表示牛牛最晚起床时间。
     *
     * 输入例子1:
     * 3
     * 5 0
     * 6 0
     * 7 0
     * 59
     * 6 59
     *
     * 输出例子1:
     * 6 0
     */
//已ac 注意这种新建static类  实现Comparable<T>接口 实现compareto方法。
    public static class Clock implements Comparable<Clock>{
        int hour;
        int minutes;

        public Clock(int hour, int minutes) {
            this.hour = hour;
            this.minutes = minutes;
        }

        @Override
        public int compareTo(Clock clock) {
            if(this.hour > clock.hour){
                return 1;
            }else if(this.hour < clock.hour){
                return -1;
            }else {
                if (this.minutes > clock.minutes) {
                    return 1;
                } else if (this.minutes < clock.minutes) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        List<Clock> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Clock clock = new Clock(sc.nextInt(),sc.nextInt());
            list.add(clock);
        }
        int time = sc.nextInt();
        int hour = sc.nextInt();
        int minutes = sc.nextInt();
        Clock arriveTime;
        if(minutes >= time ){
            arriveTime = new Clock(hour,minutes - time);
        }else{
            arriveTime = new Clock(hour -1 ,minutes + 60 - time);
        }

        Collections.sort(list);
        for(int i = list.size()-1 ; i >=0 ; i--){
            Clock clock = list.get(i);
            if(clock.compareTo(arriveTime) <= 0){
                System.out.println(clock.hour+" " + clock.minutes);
                break;
            }
        }
    }
}
