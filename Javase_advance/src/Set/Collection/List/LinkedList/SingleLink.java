package Set.Collection.List.LinkedList;
/*
    单项链表类
 */
public class SingleLink {

    //头节点（默认为空）
    Node header = null;

    int size = 0;

    public int getSize() {
        return size;
    }

    //向链表中添加元素的方法
    public void add(Object data){
        //创建一个新的节点对象，让之前的单链表的末尾节点next指向新节点对象
        //有可能这个元素是第一个，也可能是第二个，也可能是第三个
        if (header == null){
            //说明还没有节点
            //创建一个新的起始节点
            //这个时候的节点既是一个头节点也是一个末尾节点
            header = new Node(data,null);
        }else {
            //说明已经有节点了
            //找出末尾节点，然后让当前的末尾节点的next是新节点
            Node CurrentLastNode = findLast(header);
            CurrentLastNode.location = new Node(data,null);

        }

        //添加目前节点个数
        size ++;
    }



    /**
     *  专门查找末尾节点的方法
     * @return
     */
    private Node findLast(Node node) {
        if(node.location ==null){
            //如果一个节点的location是null，即内存地址为null，说明这个节点就是末尾节点
            return node;
        }
        return findLast(node.location); //递归算法
    }

    //删除链表中某个元素的方法
    public void remove(Object obj){

    }

    //修改链表中某个元素的方法
    public void modify(Object obj){

    }

    //查找链表中某个元素的方法
    public int find(Object obj){
        return 1;
    }

    //打印链表中某个元素的方法
    public void printLink(Object obj){

    }
}
