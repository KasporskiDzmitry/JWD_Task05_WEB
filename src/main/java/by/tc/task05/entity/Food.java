package by.tc.task05.entity;

/**
 * Created by Дима on 04.03.2018.
 */
public class Food {
    private int id;
    private String name;
    private String price;

    public Food() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" + " name: " + name + ", id: " + id + ", price: " + price;
    }
}
