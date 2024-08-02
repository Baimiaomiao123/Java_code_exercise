package bean;

import java.util.Objects;

/**
 * 符合javabean规范的一个java类
 */
public class User {

    private String username;
    private String password;
    private int age;
    private Address address;

    public User() {
    }


    public User(String username, String password, int age,Address addr) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.address = addr;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 这个方法只是一个get方法而已，类中并没有声明email属性
     * @return
     */
    public String getEmail(){
        return "baimiaomiao@stu.cqmu.edu.cn";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
