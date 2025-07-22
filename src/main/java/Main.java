import lombok.Getter;
import lombok.Setter;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {

    // 人
    @Getter
    @Setter
    public static class Person {
        // 获取姓名
        // 姓名
        private String name;
        // 获取年龄
        // 年龄
        private int age;
        // 构造方法
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        List<Person> persons = List.of(
                new Person("张三", 18),
                new Person("李四", 19),
                new Person("王五", 20)
        );
        Stream<Person> stream = persons.stream();
        Integer reduce = stream.map(Person::getAge).reduce(0, Integer::sum);
        TimeUnit.MINUTES.sleep(2);
        System.out.println(reduce);
    }
}