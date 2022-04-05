public class Computer {
    static Motherboard motherboard;
    static CPU cpu;
    static GPU gpu;
    static DRAM dram;
    static Storage storage;
    static PowerSupplies powerSupplies;

    @Override
    public String toString() {
        return
                " Процессор: " + Computer.getCpu().info() +
                " Мат.плата: " + getMotherboard().info() +
                " Видеокарта: "  + Computer.getGpu().info() +
                " ОЗУ: " + getDram().info() +
                " Жесткий диск: " + getStorage().info() +
                " Блок питания: " + getPowerSupplies().info()+
                " Цена: "+  getComputerPrice();
    }

    public static Motherboard getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
    }

    public static CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public int getComputerPrice()
    {
        int price=Computer.getCpu().getPrice()+Computer.getStorage().getPrice()+Computer.getGpu().getPrice()+Computer.getMotherboard().getPrice()+Computer.getDram().getPrice()+Computer.getPowerSupplies().getPrice();
        return price;
    }

    public static GPU getGpu() {
        return gpu;
    }

    public void setGpu(GPU gpu) {
        this.gpu = gpu;
    }



    public static DRAM getDram() {
        return dram;
    }

    public void setDram(DRAM dram) {
        this.dram = dram;
    }



    public static Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }



    public static PowerSupplies getPowerSupplies() {
        return powerSupplies;
    }

    public void setPowerSupplies(PowerSupplies powerSupplies) {
        this.powerSupplies = powerSupplies;
    }






}
