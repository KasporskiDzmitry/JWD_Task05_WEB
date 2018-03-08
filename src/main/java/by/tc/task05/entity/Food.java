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

        return (int)(31*id +
                ((null == name) ? 0 : name.hashCode()) +
                ((null == price) ? 0 : price.hashCode()));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null) {return false;}
        if (getClass() != obj.getClass()) {return false;}

        Food food = (Food) obj;
        if (null == name) {
            return (name == food.name);
        } else {
            if (!name.equals(food.name)) {
                return false;
            }
        }
        if (null == price) {
            return (price == food.price);
        } else {
            if (!price.equals(food.price)) {
                return false;
            }
        }
        if (id != food.id) {return false;}
        return true;
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" + " name: " + name + ", id: " + id + ", price: " + price;
    }
}
