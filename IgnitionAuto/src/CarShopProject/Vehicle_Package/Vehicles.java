package CarShopProject.Vehicle_Package;


public class Vehicles {
    private int id;
    private String type;
    private String brand;
    private String model;
    private String color;
    private int horsepower;
    private int price;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public  String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

      Vehicles vehicles = (Vehicles) o;

        if (id != vehicles.id) return false;
        if (horsepower != vehicles.horsepower) return false;
        if (price != vehicles.price) return false;
        if (type != null ? !type.equals(vehicles.type) : vehicles.type != null) return false;
        if (brand != null ? !brand.equals(vehicles.brand) : vehicles.brand != null) return false;
        if (model != null ? !model.equals(vehicles.model) : vehicles.model != null) return false;
        if (color != null ? !color.equals(vehicles.color) : vehicles.color != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + horsepower;
        result = 31 * result + price;
        return result;
    }
}
