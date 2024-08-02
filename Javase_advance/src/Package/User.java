package Package;
/*
    用户类
 */
public class User {

    //属性私有化：private关键字
    //set——用于修改值
    //get——用于获取值
    private int age;

    //set方法没有返回值，因为set方法只负责修改(settler)
    public void setAge(int a) {

        //限制
        if (a <= 0 || a >= 150){
            System.out.println("对不起，您输入的是不合法的");
            return;
        }

        age = a;
    }

    //get方法(gettler)

    public int getAge() {
        return age;
    }
}
