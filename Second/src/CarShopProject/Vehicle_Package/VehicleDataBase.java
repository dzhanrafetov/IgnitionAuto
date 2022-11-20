package CarShopProject.Vehicle_Package;

public class VehicleDataBase {
    private int id = -1;
    private String description;

    public VehicleDataBase() {
    }

        public VehicleDataBase(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}

