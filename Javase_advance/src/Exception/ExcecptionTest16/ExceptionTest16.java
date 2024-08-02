package Exception.ExcecptionTest16;
//测试改良之后的Mystack
//最后这个例子一定要掌握！！
public class ExceptionTest16 {
    public static void main(String[] args) {
        Mystack stack = new Mystack(10);

        //压栈
        try {
            stack.push(new Object());
            stack.push(new Object());
            stack.push(new Object());
            stack.push(new Object());
            stack.push(new Object());
            stack.push(new Object());
            stack.push(new Object());
            stack.push(new Object());
            stack.push(new Object());
            stack.push(new Object());
            //这里栈就满了
            stack.push(new Object());
        } catch (MystackOperationException e) {
            //输出异常简单信息
            System.out.println(e.getMessage());
            //输出异常栈桢
            e.printStackTrace();
        }

        try {
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            //栈到此时已经空
            stack.pop();
        } catch (MystackOperationException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
