package mytx.class06;

import java.util.Arrays;
import java.util.Comparator;

public class Code01_Comparator {

    public static class Student {
        public String name;
        public int id;
        public int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    // 任何比较器：（官方）
    // compare方法里，遵循一个统一的规范：
    // 返回负数的时候，认为第一个参数应该排在前面
    // 返回正数的时候，认为第二个参数应该排在前面
    // 返回0的时候，认为无所谓谁放前面
    //
    // 自己比较好理解：默认从小到大排序。只有大于零才能进行调整顺序。
    public static class MyComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }
    }


    public static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println("Name : " + student.name + ", Id : " + student.id + ", Age : " + student.age);
        }
    }

    public static void printArray(Integer[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Student student1 = new Student("A", 4, 40);
        Student student2 = new Student("B", 4, 21);
        Student student3 = new Student("C", 3, 12);
        Student student4 = new Student("D", 3, 62);
        Student student5 = new Student("E", 3, 42);
        // D E C A B

        Student[] students = new Student[]{student1, student2, student3, student4, student5};
        System.out.println("第一条打印");

        Arrays.sort(students, new MyComparator());
        for (int i = 0; i < students.length; i++) {
            Student s = students[i];
            System.out.println(s.name + "," + s.id + "," + s.age);
        }
    }
}
