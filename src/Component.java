import java.sql.ResultSet;
import java.sql.SQLException;

public class Component
{
    public int getId() {
        return id;
    }

    public int id;

    public String getBrand() {
        return brand;
    }

    String brand;

    public int getQuantity() {
        return quantity;
    }

    int quantity;

    public int getPrice() {
        return price;
    }

    int price;
    public Component(String brand , int quantity,int price){

        this.brand=brand;
        this.quantity=quantity;
        this.price=price;
    }
    public Component() {

    }

    public String info() {
        return ("1");
    }
}
