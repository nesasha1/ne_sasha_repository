package javacroc.matveeva.task5;

public abstract class DeviceGeneral {

    public String name;
    public int price;
    public String description;
    public double height;
    public double width;
    public double depth;
    public String color;
    public String status;
    public boolean IsRussianManufacturer;
    public String manufacturerCountry;
    public int guarantee;
    public String importGuarantee;



    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }

    public double getDepth() {
        return depth;
    }
    public void setDepth(double depth) {
        this.depth = depth;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getCharacteristics() {
        return """
                Имя : %s
                Цена : %d руб
                Описание : %s
                Высота : %.1f см
                Ширина : %.1f см
                Глубина : %.1f см
                Цвет : %s
                Статус : %s
                """.formatted
                (getName(),
                getPrice(),
                getDescription(),
                getHeight(),
                getWidth(),
                getDepth(),
                getColor(),
                getStatus());
    }

}
