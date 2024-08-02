package MethodOverride;

/**
 *      1.方法覆盖又称为方法重写，英语单词：override/overwrite
 *
 *      2.使用：
 *          当父类中的方法已经无法满足当前子类的业务需求，子类有必要将父类中继承过来的方法进行重新编写，这个重新编写的过程称为方法的重写/覆盖
 *          【子类的范围比父类的范围更大】
 *
 *      3.满足的条件：
 *          方法的重写发生在具有继承关系的父子类之间
 *          方法名相同返回值类型相同，返回值列表相同（尽量复制粘贴）
 *          访问权限不能更低，可以更高
 *          抛出异常可以更多，可以更少
 *
 *      4.注意：
 *          私有方法不能继承，所以不能覆盖
 *          构造方法不能继承，所以不能覆盖
 *          静态方法不存在覆盖
 *          覆盖只针对方法，不谈属性
 *
 */
public class MethodOverrideTest {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.move();

        Cat c = new Cat();
        c.move();

        Bird b = new Bird();
        b.move();
    }
}
