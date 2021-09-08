package company.boss;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * @author ywg
 * @version 1.0
 * @description 删除List中年龄大于20的
 * @date 2021/9/8 21:30
 */
public class RmFromList {


    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(2));
        list.add(new Student(23));
        list.add(new Student(25));
        list.add(new Student(12));
        list.add(new Student(6));
        System.out.println(list);
        Student student = new Student();
        // 方法一
//        student.rmAge(list);
        // 方法二
        List<Student> students = student.rmAge1(list);
        System.out.println(students);
        // 方法三
        List<Student> result = list.stream().filter(item -> item.getAge()>3).collect(Collectors.toList());
        System.out.println(result);

    }
}
class Student{
    private Integer age;
    public Student(){
    }
    public Student(int age){
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }
    public void rmAge(List<Student> list){
        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()){
            if(iterator.next().getAge()>20){
                iterator.remove();
            }
        }
    }

    public List<Student> rmAge1(List<Student> list){
        CopyOnWriteArrayList<Student> cowList = new CopyOnWriteArrayList<>(list);
        for (Student item : cowList) {
            if (item.getAge()>20) {
                cowList.remove(item);
            }
        }
        return cowList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                '}';
    }
}