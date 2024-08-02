package Constructor.example02;

public class Customer {
    private int no;
    private String name;
    private String birth;

    //可以直接通过command+N中得constructor直接生成

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public Customer(int no, String name, String birth) {
        this.no = no;
        this.name = name;
        this.birth = birth;
    }
}
