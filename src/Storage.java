public class Storage extends Component {
    @Override
    public int getId() {
        return id;
    }

    int id;

    public String getTypeMemory() {
        return typeMemory;
    }

    String typeMemory;
    int capacity;
    int RPM;
    Storage(String brand , int quantity,int price, String typeMemory , int capacity,int RPM)
    {

        super(brand,quantity,price);
        this.typeMemory=typeMemory;
        this.capacity=capacity;
        this.RPM=RPM;
    }
    Storage() {}
    public String info()
    {
        return  (brand+" "+typeMemory+" "+capacity+"GB"+"\n");
    }

}
