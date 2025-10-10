package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Model {
private String name;
private String email;
private int accno;
private long phone;
private int balance;
private String Password;
private String npassword;
private Connection con;
private PreparedStatement ps;
private ResultSet rs;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public void setPassword(String Password) {
	this.Password =Password;
}
public String getPassword() {
	return Password;
}

public int getAccno() {
	return accno;
}
public void setAccno(int accno) {
	this.accno = accno;
}
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
public int getBalance() {
	return balance;
}
public void setBalance(int balance) {
	this.balance = balance;
}
public String getNpassword() {
	return npassword;
}
public void setNpassword(String npassword) {
	this.npassword = npassword;
}

public Model() {
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	con = DriverManager.getConnection(Credentials.url,Credentials.user,Credentials.pwd);
}catch (Exception e) {
	e.printStackTrace();
}	
}

public boolean userRegistration() {
	try {
		String sql="insert into BankApp(uname,uemail,accno,phone,balance,password) values (?,?,?,?,?,?)";
		ps= con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setInt(3,accno);
		ps.setLong(4,phone);
		ps.setInt(5, balance);
		ps.setString(6, Password);
		
		int x= ps.executeUpdate();
		if(x>0) {
			return true;
		}
		return false;
		
	}catch (Exception e) {
		e.printStackTrace();
		return false;
	}
}


public boolean userLogin() {
	try {
		String sql="select * from BankApp where uemail=? and password=?";
		ps= con.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, Password);
		
		rs = ps.executeQuery();
		if(rs.next()) {
			accno = rs.getInt("accno");
            name = rs.getString("uname");
            balance = rs.getInt("balance");
            phone = rs.getLong("phone");
			return true;
		}
		return false;
		
	}catch (Exception e) {
		e.printStackTrace();
		return false;
	}
}

public boolean fetchBalance() {
    try {
        String query = "SELECT balance FROM BankApp WHERE accno = ?";
        ps = con.prepareStatement(query);
        ps.setInt(1, accno);
        rs = ps.executeQuery();

        if (rs.next()==true) {
            balance = rs.getInt("balance"); 
            return true;
        }
        return false;

    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}

public boolean emailUpdate() {
    try {
        String sql = "UPDATE BankApp SET uemail = ? WHERE uname = ?";
        ps = con.prepareStatement(sql);
        ps.setString(1, email); 
        ps.setString(2, name);  
        
        int res = ps.executeUpdate();
        if (res > 0) {
            return true; 
        }
        return false;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}

public boolean deleteUser() {
 try {
		String sql ="delete from BankApp where uname=?";
		ps=con.prepareStatement(sql);
		ps.setString(1, name);
		int x=ps.executeUpdate();
		if(x>0) {
			return true;
		}
		return false;
 }catch (Exception e) {
	e.printStackTrace();
	return false;
}
	
}
public boolean changePassword() {
	try {
	String sql="update bankapp set password=? where accno=? and password=?";
	ps=con.prepareStatement(sql);
	ps.setString(1, npassword);
	ps.setInt(2, accno);
	ps.setString(3, Password);
	int x = ps.executeUpdate();
	if(x>0) {
		return true;
	}
	else {
		return false;
	}
	}catch (Exception e) {
		e.printStackTrace();
		return false;
	}
}

}
