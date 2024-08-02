package Set.Collection;

/*
    自定义泛型可以吗？ 可以

 */
public class GenericTest03<E> {
    public void doSome(E e){ //规定输入数据的类型
        System.out.println(e);
    }

    public static void main(String[] args) {
        GenericTest03<String> gt = new GenericTest03<>(); //指定String类型
        gt.doSome("String");   //括号里只能指定String类型

        GenericTest03<Integer> gt2 = new GenericTest03<>(); //指定Integer类型
        gt2.doSome(100);    //括号里只能指定Integer类型


        MyIterator<String> mi = new MyIterator<>();
        String s1 = mi.get();

    }
}

class MyIterator<T> {
    public T get(){ //规定返回的类型
        return null;
    }
}

class doOther<T> {
    public T doOther(T t){ //规定输入的类型 同时 也规定返回的类型 且输入的类型与返回的类型一致
        return null;
    }
}
