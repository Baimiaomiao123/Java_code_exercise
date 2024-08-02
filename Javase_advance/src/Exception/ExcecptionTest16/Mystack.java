package Exception.ExcecptionTest16;
/*
    try..catch的实际应用
 */
class Mystack {
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
    public void push(Object obj) throws MystackOperationException {

        if(Stack_top >= this.elements.length - 1){
            //创建异常对象，手动抛出异常
            throw new MystackOperationException("栈已满，压栈失败"); //这里捕捉没有意义
        }

        //向栈中加1个元素，栈桢向上移动一个位置
        elements[++Stack_top] = obj;
        System.out.println("压栈" + elements[Stack_top] + "成功，栈桢指向" + Stack_top);


    }

    //pop方法（减少元素）
    public void pop() throws MystackOperationException {
        if(Stack_top < 0){
           //同理进行改进
            throw new MystackOperationException("弹栈失败，栈已空");
        }

        //向栈中加1个元素，栈桢向上移动一个位置
        elements[Stack_top] = null;
        System.out.println("弹栈" + elements[Stack_top] + "成功，栈桢指向" + -- Stack_top);
    }

}

