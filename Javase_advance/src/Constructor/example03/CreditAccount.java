package Constructor.example03;

/*
    super：可以用来修饰属性，方法，构造器

1、当子类与父类有同名的属性时，可以通过super。属性的方式调用父类中生命的属性。

2、当子类重写父类的方法后，在子类中若想调用父类中被重写的方法时，需用super.的方法

3、super修饰构造器，通过在子类中使用super列表参数的形式调用父类中制定的构造器：

        a、在构造器内部，super（参数列表）必须声明在首行

        b、在构造器内部，this（参数列表）或super（参数列表）只能出现一个

        c、当构造器中不显示的调用this（参数列表）或super（参数列表）默认调用父类中的空参构造器

 */
public class CreditAccount extends Account {

    //子类独有的属性
    private double credit;

    //super——继承父类的属性和方法
    public CreditAccount() {
        super();
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }
}
