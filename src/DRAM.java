public class DRAM extends Component{
    @Override
    public int getId() {
        return id;
    }

    int id;
    String memoryType;

    public int getMemorySize() {
        return memorySize;
    }

    int memorySize;
    int frequency;

    public DRAM(String brand , int quantity,int price, String memoryType , int memorySize,int frequency){

        super(brand,quantity,price);
        this.memoryType=memoryType;
        this.memorySize=memorySize;
        this.frequency=frequency;
    }

    public DRAM() {

    }
    public String info()
    {
        return (brand+" "+memorySize+"gb "+frequency+"Mhz"+"\n");

    }
}
