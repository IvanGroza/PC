import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class demoJFrame extends JFrame {

    public void setM(JComboBox<String> m) {
        this.m = m;
    }

    public void setC(JComboBox<String> c) {
        this.c = c;
    }

    public void setG(JComboBox<String> g) {
        this.g = g;
    }

    public void setS(JComboBox<String> s) {
        this.s = s;
    }

    public void setP(JComboBox<String> p) {
        this.p = p;
    }

    public void setD(JComboBox<String> d) {
        this.d = d;

    }

    static JComboBox<String> m=new JComboBox<String>();
    static JComboBox<String> c=new JComboBox<String>();
    static JComboBox<String> g=new JComboBox<String>();
    static JComboBox<String> s=new JComboBox<String>();
    static JComboBox<String> p=new JComboBox<String>();
    static JComboBox<String> d=new JComboBox<String>();

    public static JComboBox<String> getS() {
        return s;
    }
    public static JComboBox<String> getP() {
        return p;
    }
    public static JComboBox<String> getM() {
        return m;
    }
    public static JComboBox<String> getC() {
        return c;
    }
    public static JComboBox<String> getG() {
        return g;
    }
    public static JComboBox<String> getD() {
        return d;
    }
    JFrame frame;



    static JButton buy1 = new JButton("Купить");
    static JButton buy2 = new JButton("Купить");
    public static JButton getBuy1() {
        return buy1;
    }

    public static JButton getBuy2() {
        return buy2;
    }


    ActionListener actionListener = new TestActionListener();
    ActionListener myActionListener = new TestActionListener();
    public static JTextArea getBalanced() {
        return balanced;
    }

    static JTextArea balanced = new JTextArea(40, 10);

    public static JTextArea getConfigurator() {
        return configurator;
    }

    static JTextArea configurator = new JTextArea(40, 10);
    public static JTextField getTextField() {
        return textField;
    }

    public static JTextField textField= new JTextField();

    demoJFrame() throws IOException {
    setTitle("A Sample JFrame Window");
    JButton button = new JButton("Сделать сборку");


        JLabel motherboard_text = new JLabel("Количество ядер процессора:");
        motherboard_text.setBounds(180,60,200,15);
        JLabel CPU_text = new JLabel("Процессор:");
        CPU_text.setBounds(180,150,200,15);
        JLabel GPU_text = new JLabel("Видеокарта:");
        GPU_text.setBounds(180,240,200,15);
        JLabel DRAM_text = new JLabel("Оперативная память:");
        DRAM_text.setBounds(180,330,200,15);
        JLabel Storage_text = new JLabel("Жесткий диск:");
        Storage_text.setBounds(180,430,200,15);
        JLabel PowerSupplies_text = new JLabel("Блок питания:");
        PowerSupplies_text.setBounds(180,510,200,15);
        JLabel Price_text = new JLabel("Ценовой диапазон на сборку:");
        Price_text.setBounds(180,720,300,15);
        add(motherboard_text);
        add(CPU_text);
        add(GPU_text);
        add(DRAM_text);
        add(Storage_text);
        add(PowerSupplies_text);
        add(Price_text);
        textField.setColumns(23);
        textField.setBounds(210,750,90,30);
        add(textField);
        button.setBounds(900,100,180,30);
        button.addActionListener(actionListener);
        buy1.addActionListener(e-> {
            try {
                TestActionListener.ev_button1_click();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        buy2.addActionListener(e-> {
            try {
                TestActionListener.ev_button2_click();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        buy1.setBounds(900,500,180,30);
        buy2.setBounds(1200,500,180,30);
        buy1.setVisible(false);
        buy2.setVisible(false);
        add(buy1);
        add(buy2);
        configurator.setText("            Готовая сборка по требованиям\n");
        configurator.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        // Параметры переноса слов
        configurator.setBounds(700,200,400,250);
        configurator.setLineWrap(true);
        configurator.setWrapStyleWord(true);
        add(configurator);
        balanced.setText("         Сбалансированная сборка по цене\n");
        balanced.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        // Параметры переноса слов
        balanced.setBounds(1200,200,400,250);
        balanced.setLineWrap(true);
        balanced.setWrapStyleWord(false);
        add(balanced);
        add(button);
    setSize(1920,1080);
    setLayout(null);
    setVisible(true);
        setM(demoJFrame.addinfoJFrame(frame,Main.getMotherboard(),1,getM()));
        setC(demoJFrame.addinfoJFrame(frame,Main.getCpu(),2,getC()));
        setG(demoJFrame.addinfoJFrame(frame,Main.getGpu(),3,getG()));
        setD(demoJFrame.addinfoJFrame(frame,Main.getDram(),4,getD()));
        setS(demoJFrame.addinfoJFrame(frame,Main.getStorage(),5,getS()));
        setP(demoJFrame.addinfoJFrame(frame,Main.getPowerSupplies(),6,getP()));

    }

        public static JComboBox<String> addinfoJFrame(JFrame frame, Component[] components,int a,JComboBox<String> cbFirst) {
        JPanel panel =new JPanel();
            DefaultComboBoxModel<String> cbModel;

            cbModel = new DefaultComboBoxModel<String>();
            System.out.println(1);
            System.out.println(components.getClass().getName());
            if(components.getClass().getName().equals("[LMotherboard;"))
            {
                cbModel.addElement((String)"2");
                cbModel.addElement((String)"4");
                cbModel.addElement((String)"6");
                cbModel.addElement((String)"8");
                cbModel.addElement((String)"10");
                cbModel.addElement((String)"12");
                cbModel.addElement((String)"16");
            }
            if(components.getClass().getName().equals("[LCPU;"))
            {
                cbModel.addElement((String)"intel");
                cbModel.addElement((String)"AMD");
            }
            if(components.getClass().getName().equals("[LGPU;"))
            {
                cbModel.addElement((String)"AFOX");
                cbModel.addElement((String)"ASRock");
                cbModel.addElement((String)"Palit");
                cbModel.addElement((String)"Gigabyte");
                cbModel.addElement((String)"Asus");
                cbModel.addElement((String)"MSI");
                cbModel.addElement((String)"INNO3D");
                cbModel.addElement((String)"Zotac");
            }
            if(components.getClass().getName().equals("[LStorage;"))
            {
                cbModel.addElement((String)"HDD");
                cbModel.addElement((String)"SSD");
            }
            if(components.getClass().getName().equals("[LDRAM;"))
            {
                cbModel.addElement((String)"8");
                cbModel.addElement((String)"16");
                cbModel.addElement((String)"32");
                cbModel.addElement((String)"64");
            }
            if(components.getClass().getName().equals("[LPowerSupplies;"))
            {
                cbModel.addElement((String)"Chieftec");
                cbModel.addElement((String)"Corsair");
                cbModel.addElement((String)"be quiet!");
            }

            cbFirst = new JComboBox<String>(cbModel);
            cbFirst.setBounds(120,(90*a),400,40);
            //frame.add(cbFirst);
            return cbFirst;
        }

    }


