public class GPU extends Component{
 @Override
 public int getId() {
  return id;
 }

 int id;
 String name;
 String memoryType;
 int memorySize;

 public int getBenchmarks() {
  return benchmarks;
 }

 int benchmarks;

 public int getTDP() {
  return TDP;
 }

 int TDP;

 public GPU(String brand , int quantity,int price, String name , String memoryType,int memorySize, int benchmarks,int TDP) {

  super(brand, quantity, price);
  this.name = name;
  this.memoryType = memoryType;
  this.memorySize = memorySize;
  this.benchmarks = benchmarks;
  this.TDP = TDP;

 }

 public GPU() {

 }
 public String info()
 {

  return (brand+" "+name+" "+ memorySize+"GB"+"\n");
 }
}
