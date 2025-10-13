package pOne;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Model {
String email;
String password;
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public Model(){
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection(Credentials.url,Credentials.user,Credentials.pwd);
	}catch (Exception e) {
	e.printStackTrace();
	}
}
private Connection con ;
private PreparedStatement ps;
private ResultSet res;
public boolean login() {
	try {
		String sql="select * from bankapp where uemail=? and password=?";
		ps=con.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, password);
		res=ps.executeQuery();
		while(res.next()==true) {
			return true;
		}
		return false;
	}catch (Exception e) {
		e.printStackTrace();
		return false;
	}
}
}
