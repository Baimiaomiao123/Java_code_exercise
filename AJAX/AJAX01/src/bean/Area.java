package bean;

import java.util.Objects;

/**
 * 区域
 */
public class Area {
    private String code;
    private String name;

    public Area() {
    }

    public Area(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area area = (Area) o;
        return Objects.equals(code, area.code) && Objects.equals(name, area.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name);
    }

    @Override
    public String toString() {
        return "Area{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
