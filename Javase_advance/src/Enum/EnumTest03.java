package Enum;

public class EnumTest03 {
    public static void main(String[] args) {
        // Swith语句支持枚举类型
        // Swith语句也支持String，int
        // 低版本的JDK，只支持int
        // 高版本的JDK，同时支持String,int,枚举类型
        // byte,short,char也可以，因为存在自动类型转换
        switch (Season.SUMMER){
            case SPRING:
                System.out.println("春天");
                break;
            case SUMMER:
                System.out.println("夏天");
                break;
            case AUTUMN:
                System.out.println("秋天");
                break;
            case WINTER:
                System.out.println("冬天");
                break;
        }
    }
}
