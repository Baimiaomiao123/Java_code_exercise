package Set.Map.HashMap;

import java.util.Objects;

public class Product {
    private int no;
    private String number;

    public Product() {
    }

    public Product(int no, String number) {
        this.no = no;
        this.number = number;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public int getNo() {
        return no;
    }

    public String getNumber() {
        return number;
    }

    //重写equals方法
    //假设业务要求：商品编号相同，并且名字相同表示同一个商品


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return no == product.no && Objects.equals(number, product.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, number);
    }
}
