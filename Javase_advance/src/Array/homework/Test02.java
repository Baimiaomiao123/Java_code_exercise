package Array.homework;

import javax.swing.*;
import java.util.Objects;
import java.util.Scanner;

/*
      第二题：为某个酒店编写酒店管理系统：模拟订房、退房、打印所有房间状态
            要求：
            1.该系统的用户是：酒店前台
            2.酒店中所有房间使用一个二维数组来模拟 Object[][] Room = new Room[][];
            3.九点钟的每一个房间应该是一个java对象：Room
            4.每一个房间Room应该有：房间编号(int id)、房间类型属性(String type)、房间是否空闲(String Vacant/booked)
            5.系统应该对外提供的功能：
                可以预定房间：用户输入房间编号，订房
                可以退房：用户输入房间编号，退房
                可以查看所有房间的状态：输入某个指令可以查看所有房间的状态
 */
public class Test02 {

    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        System.out.println("欢迎使用订房/退房系统！");
        System.out.println("请输入对应的功能编号：[0] 表示退出系统；[1] 表示查看房间列表；[2] 表示订房；[3] 表示退房");
        Scanner s = new Scanner(System.in);


        while (true){

            System.out.print("请输入功能编号：");
            int i = s.nextInt();

            if (i == 1){
                System.out.println("查看房间列表：");
                hotel.print();
            } else if (i == 2) {
                System.out.println("请输入订房号");
                int roomNo = s.nextInt();
                hotel.order(roomNo);
            } else if (i == 3) {
                System.out.println("请输入退房号");
                int roomNo = s.nextInt();
                hotel.exit(roomNo);
            } else if(i == 0){
                //退出系统
                System.out.println("已退出系统");
                return;
            }else {
                System.out.println("出错了");
            }
        }
    }
}

/*
    酒店房间
 */
class Room {
    //编号：101，201，303，....
    private int no;
    //类型：装准间，单人间，总统套房
    private String type;
    //是否空闲（状态）：true表示房间空闲，false表示房间占用
    private boolean status;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Room() {
    }

    public Room(int no, String type, boolean status) {
        this.no = no;
        this.type = type;
        this.status = status;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return no == room.no && status == room.status && Objects.equals(type, room.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, type, status);
    }


    @Override
    public String toString() {
        return "[" + no + "," + type + "," + (status ? "空闲" : "占用") + "]";
    }
}
