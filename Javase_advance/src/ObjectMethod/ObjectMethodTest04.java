package ObjectMethod;

public class ObjectMethodTest04 {

    public static void main(String[] args) {
        Student s1 = new Student(985,"Chongqing Medical University");
        Student s2 = new Student(985,"Chongqing Medical University");

        System.out.println(s1 == s2); //false
        System.out.println(s1.equals(s2)); //true
    }
}

class Student{

    //学号
    int no;
    //所在学校
    String school;

    public Student() {
    }

    public Student(int no, String school) {
        this.no = no;
        this.school = school;
    }

    //重写toString方法
    public String toString(){
        return "学号" + no + ",所在学校名称" + school;
    }

    //重写equals方法
    //需求：当一个学生的学号相等，并且学校相同时，表示同一个学生
    //这里需要注意，学校的类型是String，比较是否相同的要用equals方法
    public boolean equals(Object obj){
        if(obj == null || !(obj instanceof Student)) return false;
        if(this == obj) return true;
        Student s = (Student) obj;
        //no是基本数据类型，比较时使用==
        //school是引用数据类型，比较时使用equals()
        /*
        school的比较只能采用equals方法，因为school是一个引用数据类型(字符串)，
        是一个类，可以通过new String("xxx")创建出字符串，
        此时如果写==进行比较，则this.school == s.school永远不想等，equals方法返回值一定是false

         */
        if(this.no == s.no && this.school.equals(s.school)){
            return true;
        }
        return false;
    }

}
