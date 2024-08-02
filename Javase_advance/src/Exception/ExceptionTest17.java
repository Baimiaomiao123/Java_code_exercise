package Exception;
/*
    之前在讲解方法覆盖的时候，当时遗留了一个问题？
        重写之后的方法不能比重写之前的方法抛出更多（更宽泛），可以更少，更小等级的异常，甚至可以不抛出
 */
public class ExceptionTest17 {

}

class Aminal{
    public void doSome(){

    }

    public void doOther() throws Exception{

    }
}

class Cat extends Aminal{

    /*不能这样做，因为父类的doSome方法声明中没有抛出异常
    @Override
    public void doSome() throws Exception{

    }
     */

    /*编译正常
    @Override
    public void doOther() {
    }
     */

    /*编译正常
    @Override
    public void doOther() throws Exception {
        super.doOther();
    }
     */

    /*编译正常
    @Override
    public void doOther() throws NullPointerException {
    }
     */
}
