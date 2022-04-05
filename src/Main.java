import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;


public class Main {





    /**
	 * @param args
	 */
    static Storage[] storage = new Storage[20];
	static CPU[] cpu = new CPU[40];
	static GPU[] gpu = new GPU[20];
    static PowerSupplies[] powerSupplies = new PowerSupplies[20];
    static DRAM[] dram = new DRAM[20];
	static Motherboard[] motherboard = new Motherboard[21];


    public static CPU[] getCpu() {
        return cpu;
    }

    public static GPU[] getGpu() {
        return gpu;
    }

	public static PowerSupplies[] getPowerSupplies() {
		return powerSupplies;
	}

	public static DRAM[] getDram() {
		return dram;
	}
	public static Storage[] getStorage() {
		return storage;
	}
    public static Motherboard[] getMotherboard() {
        return motherboard;
    }


	public static void main(String[] args) {
		try{
			Accessor ac=Accessor.getInstance();
			if(ac!=null)
				System.out.println("Connection successful");
			else
			{
				System.out.println("Connection failed");
				System.exit(0);
			}

			ac.propertyStatement();



			storage= ac.getStorage(storage);
			powerSupplies=ac.getPowerSupplies(powerSupplies);
			dram= ac.getDRAM(dram);
			cpu = ac.getCPU(cpu);
			gpu = ac.getGPU(gpu);
			motherboard=ac.getMotherboard(motherboard);
			for(int i=0;i<20;i++)
			{
				System.out.println(motherboard[i].info());
			}
			JFrame frame=new demoJFrame();


			frame.add(demoJFrame.getM());
			frame.add(demoJFrame.getC());
			frame.add(demoJFrame.getG());
			frame.add(demoJFrame.getD());
			frame.add(demoJFrame.getS());
			frame.add(demoJFrame.getP());
			frame.setVisible(true);


		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}

}
