import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;


public class TestActionListener implements ActionListener {
    static Computer[] computers=new Computer[2];



    public static void ev_button1_click() throws SQLException {
        Accessor.UpdateInfoStore(computers[0]);
    }
    public static void ev_button2_click() throws SQLException {
        Accessor.UpdateInfoStore(computers[1]);
    }
    public void actionPerformed(ActionEvent e) {
        int price = Integer.valueOf(demoJFrame.getTextField().getText());
        if(price>0)
        {
            computers[0]=new Computer();
            computers[1]=new Computer();
            computers[0]=getBalancedComputer(computers[0],price);
            computers[1]=getConfigurateComputer(computers[1],price);
            demoJFrame.getBuy1().setVisible(true);
            demoJFrame.getBuy2().setVisible(true);
        }
        else
            System.out.println("no");
    }
    public boolean getConfigComputer(Computer computer)
    {
        boolean a=TRUE;
        if(computer.getCpu() == null)
        {
            a=FALSE;
        }
        if(computer.getGpu() == null)
        {
            a=FALSE;
        }
        if(computer.getMotherboard() == null)
        {
            a=FALSE;
        }
        if(computer.getStorage() == null)
        {
            a=FALSE;
        }
        if(computer.getDram() == null)
        {
            a=FALSE;
        }
        if(computer.getPowerSupplies() == null)
        {
            a=FALSE;
        }
        return a;
    }
    public Computer getBalancedComputer(Computer computer , int price)
    {
        int c=1;
        int g=1;
        int m=1;
        int d=1;
        int s=1;
        int p=1;
        for(int i=0;i<100000;i++)
        {
            for(int j=0;j<Main.getGpu().length;j++)
            {
                if (((price/2)-(5*i))<Main.getGpu()[j].getPrice()&&Main.getGpu()[j].getPrice()<((price/2)+(5*i))&&Main.getGpu()[j].getQuantity()>0)
                {
                    computer.setGpu(Main.getGpu()[j]);
                    i=100000;
                    j=1000;
                    g=0;
                }
            }
        }
        for(int i=1;i<1000;i++)
        {
            for(int j=0;j<Main.getCpu().length;j++)
            {
                if ((Main.getCpu()[j].getBenchmarks()-(5*i))<(computer.getGpu().getBenchmarks()*1.5)&&(computer.getGpu().getBenchmarks()*1.5)<(Main.getCpu()[j].getBenchmarks()+(5*i))&&Main.getCpu()[j].getQuantity()>0)
                {
                    computer.setCpu(Main.getCpu()[j]);
                    i=1000;
                    j=1000;
                    c=0;
                }
            }
        }

        int a = 0;
        if(computer.getCpu().getBenchmarks()<5000)
        {
            a=8;
        }
        if(computer.getCpu().getBenchmarks()>5000&&computer.getCpu().getBenchmarks()<13000)
        {
            a=16;
        }
        if(computer.getCpu().getBenchmarks()>13000)
        {
            a=32;
        }
        for(int j=0;j<Main.getDram().length;j++)
        {
            if(Main.getDram()[j].getMemorySize()==a&&Main.getDram()[j].getQuantity()>0)
            {
                computer.setDram(Main.getDram()[j]);
                j=1000;
                d=0;
            }
        }
        for(int i=0;i<100000;i++)
        {
            for(int j=0;j<Main.getStorage().length;j++)
            {
                if (((price/15)-(5*i))<Main.getStorage()[j].getPrice()&&Main.getStorage()[j].getPrice()<((price/15)+(5*i))&&Main.getStorage()[j].getQuantity()>0)
                {
                    computer.setStorage(Main.getStorage()[j]);
                    i=100000;
                    j=1000;
                    s=0;
                }
            }
        }
        char chipset;
        if (computer.getDram().getMemorySize()==8)
        {
            if(computer.getCpu().getBrand().equals("intel"))
            {
                chipset = 'H';
            }
            else
                chipset = 'A';
        }
        else if (computer.getDram().getMemorySize()==16)
        {
            if(computer.getCpu().getBrand().equals("intel"))
            {
                chipset = 'H';
            }
            else
                chipset = 'B';
        }
        else
        {
            if(computer.getCpu().getBrand().equals("intel"))
            {
                chipset = 'Z';
            }
            else
                chipset = 'X';
        }

            //char c = str.charAt(0);
        for(int j=0;j<Main.getMotherboard().length;j++)
        {

            if ( computer.getCpu().getSocketType().equals(Main.getMotherboard()[j].getSocketType())&&chipset==Main.getMotherboard()[j].getChipset().charAt(0)&&Main.getMotherboard()[j].getQuantity()>0)
            {
                computer.setMotherboard(Main.getMotherboard()[j]);
                j=Main.getMotherboard().length;
                m=0;
            }
        }


        for(int i=0;i<1000;i++) {
            for (int j = 0; j < Main.getPowerSupplies().length; j++) {

                if (Main.getPowerSupplies()[j].getTDP() == (1.5*(computer.getGpu().getTDP() + computer.getCpu().getTDP()) +i)&&Main.getPowerSupplies()[j].getQuantity()>0) {
                    computer.setPowerSupplies(Main.getPowerSupplies()[j]);
                    j = 1000;
                    i=1000;
                    p=0;
                }

            }
        }
        demoJFrame.getBalanced().setText("Сбалансированная сборка по цене\n");
        if (c==1)
            demoJFrame.getBalanced().append("Процессора нет в наличии\n");
        if (g==1)
            demoJFrame.getBalanced().append("Видеокарты нет в наличии\n");
        if (m==1)
            demoJFrame.getBalanced().append("Материнской платы нет в наличии\n");
        if (d==1)
            demoJFrame.getBalanced().append("Оперативной памяти нет в наличии\n");
        if (s==1)
            demoJFrame.getBalanced().append("Жесткого диска нет в наличии\n");
        if (p==1)
            demoJFrame.getBalanced().append("Блока питания нет в наличии\n");
        if (c==0&&g==0&&m==0&&d==0&&s==0&&p==0)
            demoJFrame.getBalanced().setText("         Сбалансированная сборка по цене\n"+computer.toString());






        return computer;
    }
    public Computer getConfigurateComputer(Computer computer2 , int price)
    {
        int c=1;
        int g=1;
        int m=1;
        int d=1;
        int s=1;
        int p=1;
        for(int i=0;i<100000;i++)
        {
            for(int j=0;j<Main.getGpu().length;j++)
            {
                if (((price/2)-(5*i))<Main.getGpu()[j].getPrice()&&Main.getGpu()[j].getPrice()<((price/2)+(5*i))&&demoJFrame.getG().getSelectedItem().equals(Main.getGpu()[j].getBrand())&&Main.getGpu()[j].getQuantity()>0)
                {
                    computer2.setGpu(Main.getGpu()[j]);
                    i=100000;
                    j=1000;
                    g=0;
                }
            }
        }
        for(int i=1;i<1000;i++)
        {
            for(int j=0;j<Main.getCpu().length;j++)
            {
                if ((Main.getCpu()[j].getBenchmarks()-(5*i))<(computers[1].getGpu().getBenchmarks()*1.5)&&(computers[1].getGpu().getBenchmarks()*1.5)<(Main.getCpu()[j].getBenchmarks()+(5*i))&&demoJFrame.getC().getSelectedItem().equals(Main.getCpu()[j].getBrand())&&demoJFrame.getM().getSelectedItem().equals(String.valueOf(Main.getCpu()[j].getCoreNumber()))&&Main.getCpu()[j].getQuantity()>0)
                {
                    computer2.setCpu(Main.getCpu()[j]);
                    i=1000;
                    j=1000;
                    c=0;
                }
            }
        }

        int a = 0;
        if(computer2.getCpu().getBenchmarks()<5000)
        {
            a=8;
        }
        if(computer2.getCpu().getBenchmarks()>5000&&computer2.getCpu().getBenchmarks()<13000)
        {
            a=16;
        }
        if(computer2.getCpu().getBenchmarks()>13000)
        {
            a=32;
        }
        for(int j=0;j<Main.getDram().length;j++)
        {
            if(demoJFrame.getD().getSelectedItem().equals(String.valueOf(Main.getDram()[j].getMemorySize()))&&Main.getDram()[j].getQuantity()>0)
            {
                computer2.setDram(Main.getDram()[j]);
                j=1000;
                d=0;
            }
        }
        for(int i=0;i<100000;i++)
        {
            for(int j=0;j<Main.getStorage().length;j++)
            {
                if (((price/15)-(5*i))<Main.getStorage()[j].getPrice()&&Main.getStorage()[j].getPrice()<((price/15)+(5*i))&&demoJFrame.getS().getSelectedItem().equals(Main.getStorage()[j].getTypeMemory())&&Main.getStorage()[j].getQuantity()>0)
                {
                    computer2.setStorage(Main.getStorage()[j]);
                    i=100000;
                    j=1000;
                    s=0;
                }
            }
        }
        char chipset;
        if (computer2.getDram().getMemorySize()==8)
        {
            if(computer2.getCpu().getBrand().equals("intel"))
            {
                chipset = 'H';
            }
            else
                chipset = 'A';
        }
        else if (computer2.getDram().getMemorySize()==16)
        {
            if(computer2.getCpu().getBrand().equals("intel"))
            {
                chipset = 'H';
            }
            else
                chipset = 'B';
        }
        else
        {
            if(computer2.getCpu().getBrand().equals("intel"))
            {
                chipset = 'Z';
            }
            else
                chipset = 'X';
        }

        //char c = str.charAt(0);
        for(int j=0;j<Main.getMotherboard().length;j++)
        {
            System.out.println(computer2.getCpu().getSocketType());
            System.out.println(Main.getMotherboard()[j].getSocketType());
            if ( computer2.getCpu().getSocketType().equals(Main.getMotherboard()[j].getSocketType())&&chipset==Main.getMotherboard()[j].getChipset().charAt(0)&&Main.getMotherboard()[j].getQuantity()>0)
            {
                computer2.setMotherboard(Main.getMotherboard()[j]);
                j=Main.getMotherboard().length;
                m=0;
            }
        }


        for(int i=0;i<1000;i++) {
            for (int j = 0; j < Main.getPowerSupplies().length; j++) {

                if (Main.getPowerSupplies()[j].getTDP() == (1.5*(computer2.getGpu().getTDP() + computer2.getCpu().getTDP()) +i)&&demoJFrame.getP().getSelectedItem().equals(Main.getPowerSupplies()[j].getBrand())&&Main.getPowerSupplies()[j].getQuantity()>0) {
                    computer2.setPowerSupplies(Main.getPowerSupplies()[j]);
                    j = 1000;
                    i=1000;
                    p=0;
                }

            }
        }
        demoJFrame.getConfigurator().setText("Сбалансированная сборка по цене\n");
        if (c==1)
            demoJFrame.getConfigurator().append("Процессора нет в наличии\n");
        if (g==1)
            demoJFrame.getConfigurator().append("Видеокарты нет в наличии\n");
        if (m==1)
            demoJFrame.getConfigurator().append("Материнской платы нет в наличии\n");
        if (d==1)
            demoJFrame.getConfigurator().append("Оперативной памяти нет в наличии\n");
        if (s==1)
            demoJFrame.getConfigurator().append("Жесткого диска нет в наличии\n");
        if (p==1)
            demoJFrame.getConfigurator().append("Блока питания нет в наличии\n");
        if (c==0&&g==0&&m==0&&d==0&&s==0&&p==0)
            demoJFrame.getConfigurator().setText("          Cборка по параметрам\n"+computer2.toString());
        return computer2;
    }
}
