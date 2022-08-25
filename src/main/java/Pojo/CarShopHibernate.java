package Pojo;

import jakarta.persistence.*;

@Entity
@Table(name = "carShopHibernate", schema = "car_shop_hibernate")
public class CarShopHibernate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "serialNumber")
    private int serialNumber;
    @Column(name = "brand")
    private String brand;
    @Column(name = "color")
    private String color;
    @Column(name = "equipment")
    private String equipment;
    @Column(name = "price")
    private int price;
    @Column(name = "getInfo")
    private int getInfo;
    @Column(name = "isDelete")
    private Boolean isDelete;

    public CarShopHibernate() {
    }

    public CarShopHibernate(int id) {
        this.id = id;
    }

    public CarShopHibernate(int serialNumber, String brand, String color, String equipment, int price) {
        this.serialNumber = serialNumber;
        this.brand = brand;
        this.color = color;
        this.equipment = equipment;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getGetInfo() {
        return getInfo;
    }

    public void setGetInfo(int getInfo) {
        this.getInfo = getInfo;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    @Override
    public String toString() {
        return "Car Shop Hibernate [id = " + id
                + ", serialNumber = " + serialNumber
                + ", brand = " + brand
                + ", color = " + color
                + ", equipment = " + equipment
                + ", price = " + price
                + ", getInfo = " + getInfo
                + ", isDelete = " + isDelete
                + "]";
    }
}
