package coffemachine;

public class Drinks {
    private int id;
    private String name;
    private String decs;
    private int price;

    public Drinks(int id, String name, String decs, int price) {
        this.id = id;
        this.name = name;
        this.decs = decs;
        this.price = price;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDecs() {
        return decs;
    }

    public void setDecs(String decs) {
        this.decs = decs;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
