package Array.homework;
/*
    练习题：第一题：编写程序：使用一维数组，模拟栈数据结构
                要求：
                1.这个栈可以存储java中任何引用数据类型[Object数组]
                2.在栈中提供push方法模拟压栈（栈满需要有提示信息）
                3.在栈中提供pop方法模拟弹栈（栈空需要有提示信息）
                4.编写测试程序，new栈对象，调用push pop方法来模拟压栈、弹栈的动作
 */
public class Test01 {
    public static void main(String[] args) {

        Mystack stack = new Mystack(10);

        for (int i = 0; i < 10; i++) {
            stack.push(new Object());
            System.out.println("打印第" + (stack.getStack_top()+1) + "个栈" + stack.getElements()[i]);
            System.out.println();
        }


        for (int i = 0; i < 10; i++) {
            System.out.println("执行第"+ (i+1) +"次弹栈");
            stack.pop();
            if (stack.getStack_top() >= 0) {
                System.out.println("打印第" + (stack.getStack_top()+1) + "个栈" + stack.getElements()[i]);
            }else {
                System.out.println("栈已空");
            }
            System.out.println();
        }
    }
}

class Mystack{
    //提供一个数组来储存栈中的元素
    private  Object[] elements;
    //栈桢(用于判断)
    private int Stack_top;


    public Object[] getElements() {
        return elements;
    }

    public void setElements(Object[] elements) {
        this.elements = elements;
    }

    public int getStack_top() {
        return Stack_top;
    }

    public void setStack_top(int stack_top) {
        this.Stack_top =stack_top ;
    }

    //构造方法
    public Mystack(int i) {
        this.elements = new Object[i];
        this.Stack_top = -1;
    }

    //push方法（增添元素）
    public void push(Object obj){

        if(Stack_top >= this.elements.length - 1){
            System.out.println("对不起，您的栈已满");
        }

        //向栈中加1个元素，栈桢向上移动一个位置
        elements[++Stack_top] = obj;
        System.out.println("压栈" + elements[Stack_top] + "成功，栈桢指向" + Stack_top);


    }

    //pop方法（减少元素）
    public void pop(){
        if(Stack_top < 0){
            System.out.println("对不起，您的栈内已经没有对象");
        }

        //向栈中加1个元素，栈桢向上移动一个位置
        elements[Stack_top] = null;
        System.out.println("弹栈" + elements[Stack_top] + "成功，栈桢指向" + -- Stack_top);
    }

}

