package com.baimiaomiao.mybatis.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class Car implements Serializable {
    private Integer id;

    private String carNum;

    private String brand;

    private BigDecimal guidePrice;

    private String produceTime;

    private String carType;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum == null ? null : carNum.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public BigDecimal getGuidePrice() {
        return guidePrice;
    }

    public void setGuidePrice(BigDecimal guidePrice) {
        this.guidePrice = guidePrice;
    }

    public String getProduceTime() {
        return produceTime;
    }

    public void setProduceTime(String produceTime) {
        this.produceTime = produceTime == null ? null : produceTime.trim();
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType == null ? null : carType.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Car other = (Car) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCarNum() == null ? other.getCarNum() == null : this.getCarNum().equals(other.getCarNum()))
            && (this.getBrand() == null ? other.getBrand() == null : this.getBrand().equals(other.getBrand()))
            && (this.getGuidePrice() == null ? other.getGuidePrice() == null : this.getGuidePrice().equals(other.getGuidePrice()))
            && (this.getProduceTime() == null ? other.getProduceTime() == null : this.getProduceTime().equals(other.getProduceTime()))
            && (this.getCarType() == null ? other.getCarType() == null : this.getCarType().equals(other.getCarType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCarNum() == null) ? 0 : getCarNum().hashCode());
        result = prime * result + ((getBrand() == null) ? 0 : getBrand().hashCode());
        result = prime * result + ((getGuidePrice() == null) ? 0 : getGuidePrice().hashCode());
        result = prime * result + ((getProduceTime() == null) ? 0 : getProduceTime().hashCode());
        result = prime * result + ((getCarType() == null) ? 0 : getCarType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", carNum=").append(carNum);
        sb.append(", brand=").append(brand);
        sb.append(", guidePrice=").append(guidePrice);
        sb.append(", produceTime=").append(produceTime);
        sb.append(", carType=").append(carType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}