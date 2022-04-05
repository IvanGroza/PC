import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
;


public class Accessor {

	private static Accessor singletonAccessor=null;
	private static Connection con=null;
	static Statement stat=null ;

	// скрытый конструктор принимает драйвер и адрес БД
	// выбрасывает исключение Exception
	private Accessor() throws Exception {
	

		String server = "DESKTOP-NULGKQ3\\SQLEXPRESS:1433";

		String urlDatabase ="PC-Configurator";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		// формирование строки подключения
		
		//String connectionString = "jdbc:sqlserver://localhost;databaseName="+urlDatabase+";integratedSecurity=true;";
		//String connectionString = "jdbc:sqlserver://"+server+";databaseName="+urlDatabase+";integratedSecurity=false;";
		String connectionString = "jdbc:sqlserver://"+server+";databaseName="+urlDatabase+";integratedSecurity=true;";
		

		// подключение к БД
		con = DriverManager.getConnection(connectionString);
		stat = con.createStatement();
	
	}

	// открытый метод получения единственного экземпляра аксесора
	// выбрасывает исключение Exception
	public static Accessor getInstance()
			throws Exception {
		if (singletonAccessor == null)
			singletonAccessor = new Accessor();
		return singletonAccessor;
	}
	
	//закрывает соединение с БД
	public static void closeConnection()
			throws SQLException {
		if (con!= null)
			con.close();
		}
	
	void propertyStatement()throws SQLException 
	{
		//проверка, реализует ли драйвер JDBC тот или иной тип выборки
		//TYPE_FORWARD_ONLY - курсор выборки перемещается только вперед
		//TYPE_SCROLL_INSENSITIVE - курсор перемещается в обеих направлениях, выборка не изменяется
		//TYPE_SCROLL_SENSITIVE - курсор перемещается в обеих направлениях, выборка изменяется при изменении строк в БД
		
		boolean ro=con.getMetaData().supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY);
		System.out.println("TYPE_FORWARD_ONLY - "+ro);
		
		ro=con.getMetaData().supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE);
		System.out.println("TYPE_SCROLL_INSENSITIVE - "+ro);
			
		ro=con.getMetaData().supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE);
		System.out.println("TYPE_SCROLL_SENSITIVE - "+ro);
		
		//проверка, поддерживает ли драйвер JDBC тот или иной режим изменения выборки
		//CONCUR_READ_ONLY - выборку нельзя изменять
		//CONCUR_UPDATABLE - выборку можно изменять
		ro=con.getMetaData().supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		System.out.println("CONCUR_READ_ONLY - "+ro);
		
		ro=con.getMetaData().supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		System.out.println("CONCUR_UPDATABLE - "+ro);
		
					
	}

	
/*********************************** комфортность номеров ******************************************/
	
	
	
//Перечень названий комфортности номеров
	public Storage[] getStorage(Storage[] storage) throws SQLException {
			ResultSet rs = stat.executeQuery("SELECT * FROM Storage");
			int i=0;
			while (rs.next()) {
				storage[i]=new Storage();
				storage[i].id = rs.getInt("id_storage");
				storage[i].typeMemory = rs.getString("type_memory");
				storage[i].capacity = rs.getInt("capacity");
				storage[i].RPM = rs.getInt("RPM");
				//storage[i]=addInfoStorage(id,storage[i]);
				i++;
			}
			rs.close();
		 storage= (Storage[]) addInfoStore(storage);
			return storage;
		}
	public PowerSupplies[] getPowerSupplies(PowerSupplies[] powerSupplies) throws SQLException {
		// инициализация оператора работы с запросами

		ResultSet rs = stat.executeQuery("SELECT * FROM PowerSupplies");

		int i=0;
		while (rs.next()) {
			powerSupplies[i]=new PowerSupplies();
			powerSupplies[i].id = rs.getInt("id_PowerSupplies");
			powerSupplies[i].TDP = rs.getInt("TDP");
			i++;
		}
		rs.close();
		powerSupplies= (PowerSupplies[]) addInfoStore(powerSupplies);


		return powerSupplies;
	}
	public DRAM[] getDRAM(DRAM[] dram) throws SQLException {
		ResultSet rs = stat.executeQuery("SELECT * FROM DRAM");

		int i=0;
		while (rs.next()) {
			dram[i]=new DRAM();
			dram[i].id = rs.getInt("id_DRAM");
			dram[i].memoryType = rs.getString("DRAM_type");
			dram[i].memorySize = rs.getInt("memory_size");
			dram[i].frequency = rs.getInt("frequency");
			i++;
		}
		rs.close();
		dram= (DRAM[]) addInfoStore(dram);


		return dram;
	}
	public CPU[] getCPU(CPU[] cpu) throws SQLException {
		ResultSet rs = stat.executeQuery("SELECT * FROM CPU");

		int i=0;
		while (rs.next()) {
			cpu[i]=new CPU();
			cpu[i].id = rs.getInt("id_CPU");
			cpu[i].coreNumber = rs.getInt("core_number");
			cpu[i].frequency = rs.getFloat("frequency");
			cpu[i].socketType = rs.getString("socket_type");
			cpu[i].name = rs.getString("name");
			cpu[i].thread = rs.getInt("thread");
			cpu[i].benchmarks = rs.getInt("Benchmarks");
			cpu[i].TDP = rs.getInt("TDP");
			i++;
		}
		rs.close();
		cpu= (CPU[]) addInfoStore(cpu);


		return cpu;
	}
	public GPU[] getGPU(GPU[] gpu) throws SQLException {
		ResultSet rs = stat.executeQuery("SELECT * FROM GPU");
		int i=0;
		while (rs.next()) {
			gpu[i]=new GPU();
			gpu[i].id = rs.getInt("id_GPU");
			gpu[i].memoryType = rs.getString("memory_type");
			gpu[i].memorySize = rs.getInt("memory_size");
			gpu[i].TDP = rs.getInt("TDP");
			gpu[i].benchmarks = rs.getInt("Benchmarks");
			gpu[i].name = rs.getString("name");
			i++;
		}
		rs.close();
		gpu= (GPU[]) addInfoStore(gpu);
		return gpu;
	}
	public Motherboard[] getMotherboard(Motherboard[] motherboard) throws SQLException {



		// инициализация оператора работы с запросами

		ResultSet rs = stat.executeQuery("SELECT * FROM Motherboard");

		int i=0;
		while (rs.next()) {
			motherboard[i]=new Motherboard();
			motherboard[i].id = rs.getInt("id_motherboard");
			motherboard[i].socketType = rs.getString("socket_type");
			motherboard[i].memorySlots = rs.getInt("memory_slots");
			motherboard[i].memoryStandard = rs.getString("memory_standard");
			motherboard[i].chipset = rs.getString("chipset");
			//storage[i]=addInfoStorage(id,storage[i]);

			i++;
		}
		rs.close();
		motherboard= (Motherboard[]) addInfoStore(motherboard);


		return motherboard;
	}
	public Component[] addInfoStore(Component[] component) throws SQLException {
		for (int i = 0; i < component.length; i++) {
			ResultSet rs  = stat.executeQuery("SELECT * FROM Store WHERE id_product='" + component[i].getId() + "';");
			//"SELECT * FROM HumanResources.Department WHERE Name = 'Accounting';";
			int a = rs.getRow();
			while(rs.next()) {
				component[i].quantity = rs.getInt("quantity");
				component[i].price = rs.getInt("price");
				component[i].brand = rs.getString("brand");
			}
			rs.close();
		}
		return component;
	}
	public static void UpdateInfoStore(Computer computer) throws SQLException {
		stat.executeUpdate("UPDATE Store SET quantity='"+(computer.getCpu().getQuantity()-1)+"' where id_product='"+ computer.getCpu().getId()+"';");
		stat.executeUpdate("UPDATE Store SET quantity='"+(computer.getGpu().getQuantity()-1)+"' where id_product='"+ computer.getGpu().getId()+"';");
		stat.executeUpdate("UPDATE Store SET quantity='"+(computer.getDram().getQuantity()-1)+"' where id_product='"+ computer.getDram().getId()+"';");
		stat.executeUpdate("UPDATE Store SET quantity='"+(computer.getMotherboard().getQuantity()-1)+"' where id_product='"+ computer.getMotherboard().getId()+"';");
		stat.executeUpdate("UPDATE Store SET quantity='"+(computer.getStorage().getQuantity()-1)+"' where id_product='"+ computer.getStorage().getId()+"';");
		stat.executeUpdate("UPDATE Store SET quantity='"+(computer.getPowerSupplies().getQuantity()-1)+"' where id_product='"+ computer.getPowerSupplies().getId()+"';");
		closeConnection();
	}
/*********************************** Добавление нового клиента ******************************************/

	//Добавление нового клиента БД. возращает успешно ли прошло добавление в БД
	public boolean saveClient(String fio, String pasport) throws SQLException {
		
			
			int id=0;
			//проверка, не существует ли клиента с таким именем
			ResultSet rs = stat.executeQuery("SELECT fio FROM Client WHERE fio='"+fio+"'");
			if (rs.next())
				return false;//клиент с таким именем в БД уже есть, поэтому не добавлятся
			//получаем последний номер ID	
			rs = stat.executeQuery("SELECT max(id_client) FROM Client" );
			if (rs.next())
				id=rs.getInt(1);
			//добавление нового клиента в базу данных. 	метод executeUpdate возращает количество обработанных строк
			int  n = stat.executeUpdate("INSERT INTO Client (fio, passport) VALUES ( '"+fio+"','"+pasport+"')");
			if(n>0)
				return true;
			return false;
			}
			
	
	protected void finalize()
	{
		try{
			con.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			}
		
		
	}
	
	
}