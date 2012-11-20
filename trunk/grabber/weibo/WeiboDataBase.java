package grabber.weibo;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class WeiboDataBase
{
	private Connection connect = null;
	Statement stmt = null;
	int count=0;
	public WeiboDataBase() 
	{
		this.register();
		this.conDB();
		try 
		{
			stmt = this.connect.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 /**
	  * 加载mysql驱动
	  */
	 public void register()
	 {
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
			 System.out.println("com.mysql.jdbc.Driver");
			 }
			 catch (Exception e) {
				 System.out.print("Error loading Mysql Driver!");
				 e.printStackTrace();
			 }
	 }
	 
	 /**
	  *  连接数据库
	  * @return 连接对象
	  */
	 public void conDB()
	 {
		 try {
			  this.connect = DriverManager.getConnection(
			 "jdbc:mysql://127.0.0.1:3306/weibo", "chengy", "1989817");
			  //连接URL为 jdbc:mysql//服务器地址/数据库名
			  //后面的2个参数分别是登陆用户名和密码
			 System.out.println("Success connect sql server!");
		 } 
		 catch (Exception e) 
		 {
			 System.out.print("get data error!");
			 e.printStackTrace();
		 }
	 }
	 public boolean query(String id,String table)
	 {
		 String sql="select * from "+table+" where id= "+id+";";
		 ResultSet rs;
		 try
		 {
			 stmt.clearBatch();
			 rs=stmt.executeQuery(sql);
			 return rs.next();
		 }catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
		 return true;
	 }
	 public synchronized void insert(WeiboInfo wb)
	 {
		 if(query(wb.getId(),"weiboinfo"))
			 return;
	/*	 String sql="insert into weiboinfo values ("+"\'"+wb.id+"\',"+"\'"+wb.screenName+"\',"
				 +"\'"+wb.province+"\',"+"\'"+wb.city+"\',"+"\'"+wb.location+"\',"
				 +"\'"+wb.description+"\',"+"\'"+wb.url+"\',"+"\'"+wb.profileImageUrl+"\',"
				 +"\'"+wb.userDomain+"\',"+"\'"+wb.gender+"\',"+"\'"+wb.followersCount+"\',"
				 +"\'"+wb.friendsCount+"\',"+"\'"+wb.statusesCount+"\',"+"\'"+wb.favouritesCount+"\',"
				 +"\'"+wb.createdAt+"\',"+"\'"+wb.verified+"\');";
	*/
		 String sql=null;
		 System.out.println(sql);
		 try
		 {
			 stmt.clearBatch();
			 stmt.execute(sql);
		 }catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
	 }
	 public static void main(String[] agrs)
	 {
		 new WeiboDataBase();
	 }
}