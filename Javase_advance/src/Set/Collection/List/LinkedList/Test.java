package Set.Collection.List.LinkedList;

public class Test {
    public static void main(String[] args) {
        SingleLink link = new SingleLink();
        System.out.println(link.getSize()); // 默认节点数为0

        link.add(100);
        link.add(200);
        link.add(300);

        System.out.println(link.getSize()); // 3
    }
}
