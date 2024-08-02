package Set.Collection.List.LinkedList;

/*
    单链表中的节点
        节点是单向链表中基本的单元
        每一个节点Node都有两个属性：
            一个属性是：存储的数据；另一个属性是：下一个节点的内存地址

 */
public class Node {
    //存储的数据
    Object element;

    //下一个节点的内存地址
    Node location;

    public Node(){

    }

    public Node(Object element,Node location){
        this.element = element;
        this.location = location;
    }

}
