package Array.homework;

import Array.ArrayTest09;

public class Hotel {
    //构建存放房间的二维数组
    private  Room[][] Rooms;

    //构造酒店中的房间
    public Hotel() {
        //一共有几层，每层的房间类型是什么，每个房间编号是什么
        //如一共三层楼，一层单人间，二层标准间，三层总统套房
        this.Rooms = new Room[3][10]; //3层楼，每层10个房间

        for (int i = 0; i < Rooms.length; i++) {

            for (int j = 0; j < Rooms[i].length; j++) {
                if (i == 0) {
                    Rooms[i][j] = new Room((i+1)*100+j+1,"单人间",true);
                } else if (i == 1) {
                    Rooms[i][j] = new Room((i+1)*100+j+1,"双人间",true);
                } else if (i ==2) {
                    Rooms[i][j] = new Room((i+1)*100+j+1,"单人间",true);
                }
            }
                
            }
        }

    //打印酒店所有的房间
    public void print(){
        for (int i = 0; i < Rooms.length; i++) {

            for (int j = 0; j < Rooms[i].length; j++) {
                System.out.print(Rooms[i][j] + "\t");
            }

            System.out.println();
        }
    }

    //订房方法：调用此方法的时候需要传递一个编号房间过来
    public void order(int roomNo){
        //通过输入的roomNO回找房间号
        Room room =  Rooms[roomNo / 100- 1][roomNo % 100 - 1 ];
        room.setStatus(false);
        System.out.println(roomNo + "订房完成！");
    }

    public void exit(int roomNo){
        Room room =  Rooms[roomNo / 100- 1][roomNo % 100 - 1 ];

        if(room.getStatus()){
            System.out.println("该房间没有订房，为空闲状态");
            return;
        }
        room.setStatus(true);
        System.out.println(roomNo + "退房完成！");
    }

    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        hotel.print();
    }
}
