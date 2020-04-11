package hib.hw.fromLesson14;

import java.util.Set;

public class Item {

    private int id;
    private int total;
    private Set<Cart> carts;

    public Item() {
    }

    public Item(int total) {
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Set<Cart> getCarts() {
        return carts;
    }

    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }

}
