package Array;

public class ArrayTest02 {

    public static void main(String[] args) {

        //动态数组初始化
        int[] a = new int[4];

        for (int i = 0; i <= a.length-1; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println();

        Object[] obj = new Object[3];
        for (int i = 0; i <= obj.length-1; i++) {
            System.out.print(obj[i] + " ");
        }

        System.out.println();

        //储存Object。采用静态初始化
        Object o1 = new Object();
        Object o2 = new Object();
        Object o3 = new Object();
        Object[] o = {o1,o2,o3};
        for (int i = 0; i <= o.length-1 ; i++) {
            System.out.print(o[i] + " ");
        }
    }
}
