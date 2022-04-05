public class Motherboard extends Component{
 public Motherboard() {

 }

 @Override
 public int getId() {
  return id;
 }

 int id;



 int price;

 public String getSocketType() {
  return socketType;
 }

 String socketType;
 int memorySlots;
 String memoryStandard;

 public String getChipset() {
  return chipset;
 }

 String chipset;

 public Motherboard(String brand , int quantity,int price,String socketType,int memorySlots,String memoryStandard,String chipset) {

  super(brand, quantity, price);
  this.socketType = socketType;
  this.memorySlots = memorySlots;
  this.memoryStandard = memoryStandard;
  this.chipset = chipset;

 }
 public String info()
 {
  return (brand+" "+chipset+"\n");
 }
}
