package Polymorphy;

/**
 *  关于java语言当中的多态语法机制
 *      1.Animal、Cat、Bird三个类之间的关系
 *          Cat继承Animal
 *          Bird继承Animal
 *          Cat和Bird之间没有任何继承关系
 * <p>
 *      2.面向对象三大特征：封装、继承、多态
 * <p>-
 *      3.关于多态中涉及到的几个概念：
 *          * 向上转型(up-casting)
 *              子类型 --> 父类型
 *              子类的实例对象赋给父类的引用变量
 *              又被称为：自动类型转换
 * <p>
 *          * 向下转型(down-casting)
 *              父类型 --> 子类型
 *              又被称为：强制类型转换【需要加强制类型转换】
 *
 *          * 不论是向上转型还是向下转型，都必须需要继承关系
 *            没有继承关系，编译无法通过
 *
 *
 */
public class PolymorphyTest {
    public static void main(String[] args) {

        //以前编写的程序
        Animal a1 = new Animal();
        a1.move();

        Cat c1 = new Cat();
        c1.move();

        Bird b1 = new Bird();
        b1.move();
        System.out.println("===========");
        //使用多态语法机制
        //Animal是父类，Cat是子类；Cat is a Animal
        //new Cat()创建的对象类型是Cat，a2的这个引用数据类型是Animal，可见之间进行了转换
        //可见是子类型转换为父类型，即向上转型、自动类型转换
        //java允许这种语法，即父类型引用指向子类型对象
        //这种语法是因为java编译阶段和运行阶段绑定两种不同的形态/状态（多态）

        Animal a2 = new Cat();  //可以理解成首先new Cat()，创建了一个cat类型对象，然后再向上转型，转成Animal类型对象
        a2.move(); //这里调用的方法必须是父类型所拥有的方法，否则编译就会报错

        //但是无法通过a2.catchMouse();，因为父类没有子类特有的方法
        //如果需要完成这种需求，可以将a2类型强制转换为Cat类型（向下转型）
        //即当调用的方法是子类型中特有的，父类型中不存在，必须进行向下转型

        Cat c2 = (Cat)a2;
        c2.catMouse();

        //Bird和Cat没有继承关系，故不能进行强制类型转换
        //即 Animal a3 = new Bird();


        //以下程序编译阶段没有问题（a3在编译阶段属于Animal类型，Animal可以向下转型成Cat（有继承关系）），但是运行阶段会出现报错（JVM堆内存真实存在的对象a3的类型是Bird，Bird和Cat没有继承关系）
//        Animal a3 = new Bird();
//        Cat c3 = (Cat)a3; //java.lang.ClassCastException错误类型，因为运行阶段a3是bird类型，由于bird类型和cat类型不存在继承关系，故无法进行转化

        //如何避免？——使用instanceof运算符可以避免
            //instanceof的作用就是判断一个数据类型
            //语法格式：引用 instanceof 数据类型名
            //以上运算符的执行结果为布尔型，结果可能是true或false
            //true表示引用指向的对象是后面的数据类型；false则不是

        Animal a3 = new Bird();

        if (a3 instanceof Cat){
            Cat c3 = (Cat)a3;
            System.out.println("如果a3是cat类型，则转化为cat类型");
            c3.catMouse();
        }else if (a3 instanceof Bird){
            Bird c3 = (Bird)a3;
            System.out.println("如果a3是bird类型，则转化为bird类型");
            c3.fly();
        }
    }
}
