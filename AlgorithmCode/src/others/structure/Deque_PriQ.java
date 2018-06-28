package others.structure;

import java.util.Comparator;
import java.util.PriorityQueue;

class Student{
    int id;
    String name;
    public Student(int id,String name){
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class Deque_PriQ {


    public static void main(String[] args) {
        PriorityQueue<Student> queue = new PriorityQueue<>(5, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.id - o1.id;
            }
        });

        queue.offer(new Student(1,"haha"));
        queue.offer(new Student(5,"hehe"));
        queue.offer(new Student(2,"hihi"));
        queue.offer(new Student(4,"hoho"));
        queue.offer(new Student(3,"huhu"));
        System.out.println(queue.poll().getId());
        System.out.println(queue.poll().getId());
        System.out.println(queue.poll().getId());
        System.out.println(queue.poll().getId());
        System.out.println(queue.poll().getId());
    }
}
