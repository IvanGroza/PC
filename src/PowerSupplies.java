public class PowerSupplies extends Component{
    @Override
    public int getId() {
        return id;
    }

    int id;

    public int getTDP() {
        return TDP;
    }

    int TDP;
    public PowerSupplies(String brand , int quantity,int price, int TDP){

        super(brand,quantity,price);
        this.TDP=TDP;
    }

    public PowerSupplies() {

    }
    public String info()
    {
        return (brand+" "+TDP+"W"+"\n");
    }
}
