public class CPU extends Component{
 @Override
 public int getId() {
  return id;
 }

 int id;
 String name;

 public int getCoreNumber() {
  return coreNumber;
 }

 int coreNumber;
 float frequency;

 public String getSocketType() {
  return socketType;
 }

 public void setSocketType(String socketType) {
  this.socketType = socketType;
 }

 String socketType;
 int thread;

 public int getBenchmarks() {
  return benchmarks;
 }

 int benchmarks;

 public int getTDP() {
  return TDP;
 }

 int TDP;

 public CPU(String brand , int quantity,int price, String name , int coreNumber,float frequency,String socketType,int thread,int benchmarks,int TDP) {

  super(brand, quantity, price);
  this.name = name;
  this.coreNumber = coreNumber;
  this.frequency = frequency;
  this.socketType = socketType;
  this.thread = thread;
  this.benchmarks = benchmarks;
  this.TDP = TDP;

 }

 public CPU() {

 }
 public String info()
 {
  return (brand+" "+name+"\n");
 }

}
