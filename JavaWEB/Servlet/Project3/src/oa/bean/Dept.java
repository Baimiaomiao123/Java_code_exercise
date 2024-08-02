package oa.bean;

import java.util.Objects;

/**
 * 一个普通的java类，这个java类可以封装零散的数据，代表了一个部门对象
 */
public class Dept {
    private String deptno;
    private String name;
    private String loc;

    public Dept() {
    }

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return name;
    }

    public void setDname(String name) {
        this.name = name;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dept dept = (Dept) o;
        return Objects.equals(deptno, dept.deptno) && Objects.equals(name, dept.name) && Objects.equals(loc, dept.loc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptno, name, loc);
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno='" + deptno + '\'' +
                ", name='" + name + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }
}
