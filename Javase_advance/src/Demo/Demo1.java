package Demo;

/**
 * @author baimiaomiao
 * @version 1.0
 * @className Demo1
 * @since 1.0
 */

//R语言中的类的定义、方法、继承等再熟悉
/*
> setClass("Person", slots = list(name = "character", age = "numeric"))
> setClass("Employee", slots = list(boss = "Person"), contains = "Person")
> alice <- new("Person",name="Alice",age=40)
> View(alice)
> john <- new("Employee", name="John", age=20, boss = alice)
> str(alice)
Formal class 'Person' [package ".GlobalEnv"] with 2 slots
  ..@ name: chr "Alice"
  ..@ age : num 40
> help(str)
> str(john)
Formal class 'Employee' [package ".GlobalEnv"] with 3 slots
  ..@ boss:Formal class 'Person' [package ".GlobalEnv"] with 2 slots
  .. .. ..@ name: chr "Alice"
  .. .. ..@ age : num 40
  ..@ name: chr "John"
  ..@ age : num 20
 */
public class Demo1 {
    private String name;
    private Number age;

    //无参构造
    public Demo1() {
    }

    //有参构造
    public Demo1(String name, Number age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getAge() {
        return age;
    }

    public void setAge(Number age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Demo1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
