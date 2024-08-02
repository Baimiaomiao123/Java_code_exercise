package Array;
/*
    一位数组的深入，数据中存储的类型为：引用数据类型
        对于数组来说，实际上只能储存java对象的内存地址
        数组中的对象元素中也可以有继承
 */
public class ArrayTest06 {

    public static void main(String[] args) {
        //创建一个Animal类型的数据
        Animal a1 = new Animal();
        Animal a2 = new Animal();
        Animal[] a = {a1,a2};
        for (int i = 0; i < a.length; i++) {
            a[i].move();
        }

        //动态初始化一个长度为2，类型为animal的数组
        Animal[] ans = new Animal[2];
        ans[0] = new Animal();

        //Cat是Animal的子类，所以可以直接将Cat对象装入Animal的数组当中（类似于向上转型）
        ans[1] = new Cat();
        for (int i = 0; i < ans.length; i++) {
            ans[i].move();
        }
        System.out.println("==============================");

        Animal[] anim = {new Cat(),new Bird(),new Animal()};
        for (int i = 0; i < anim.length; i++) {
            //如果调用的父类中的方法，可以自动调用父类的方法
            //如果调用子类的方法，必须要进行强制类型转换
            if (anim[i] instanceof Bird){
                Bird b = (Bird) anim[i];
                b.Sing();
            }else if (anim[i] instanceof Cat){
                Cat c = (Cat) anim[i];
                c.CatchMouse();
            }

        }
    }
}

class Animal{
    public void move(){
        System.out.println("Animal move");
    }
}

class Cat extends Animal{
    @Override
    public void move() {
        System.out.println("猫在走猫步");
    }

    public void CatchMouse(){
        System.out.println("猫在抓老鼠");
    }
}

class Bird extends Animal{
    @Override
    public void move() {
        System.out.println("鸟儿在飞翔");
    }

    public void Sing(){
        System.out.println("鸟儿在唱歌");
    }
}
