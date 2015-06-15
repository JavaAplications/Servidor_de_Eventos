package BBDD;

import java.sql.*;


public class Conexion {
	Connection con;
public Conexion() {
		
	}



public  Connection Conectar(){
	
	Connection con=null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con= DriverManager.getConnection("jdbc:mysql://localhost/bdradiobases","root","");	
		
	} catch (Exception e) {
		System.out.println("No se pudo conectar");
	}
	return con;
	
}
	


public void InsertarEventos(int IdRadio,int IdAlarma){
	
	con=Conectar();

		PreparedStatement pst;
		try {
			pst = con.prepareStatement("INSERT INTO eventos (IdRadios,IdAlarmas,Checked) VALUES (?,?,?)");
		
			pst.setInt(1,IdRadio);
			pst.setInt(2,IdAlarma);
			pst.setBoolean(3,false);
			
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	

}




public void InsertarKeepAlive(int IdRadio){
	
	con=Conectar();
	
		PreparedStatement pst;
		try {
			pst = con.prepareStatement("INSERT INTO keepalive (IdRadios) VALUES (?)");
		
			pst.setInt(1,IdRadio);
			
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}

public void InsertarRadiobases(String NomRadio,String TelRadio,String LatRadio,String LongRadio,
		String LocRadio,String ProvRadio,String ContacRadio){
	
	con=Conectar();
	
		PreparedStatement pst;
		try {
			pst = con.prepareStatement("INSERT INTO Radiobases (NomRadio,TelRadio,LatRadio,LongRadio,"
					+ "LocRadio, ProvRadio, ContacRadio) "
					+ "VALUES (?,?,?,?,?,?,?)");
		
			pst.setString(1,NomRadio);
			pst.setString(2,TelRadio);
			pst.setString(3,LatRadio);
			pst.setString(4,LongRadio);
			pst.setString(5,LocRadio);
			pst.setString(6,ProvRadio);
			pst.setString(7,ContacRadio);
			
			
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	

}

public String ConsultarNombre(int IdRadiobase)
{
	con=Conectar();
	Statement st;
	ResultSet rs=null;
	String NombreRadio = null;
	try {
		st=con.createStatement();
		rs=st.executeQuery("SELECT `NomRadio` FROM `radiobases` WHERE `IdRadios`='"+IdRadiobase+"'");
		while(rs.next()){
			NombreRadio=  rs.getString("NomRadio");
				
					
		}
			
	
	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 NombreRadio="Desconocido";
	}
	
	return NombreRadio;
}
	
public String ConsultarAlarma(int IdAlarma)
{
	con=Conectar();
	Statement st;
	ResultSet rs=null;
	String NomAlarmas = null;
	try {
		st=con.createStatement();
		rs=st.executeQuery("SELECT `NomAlarmas` FROM `alarmas` WHERE `IdAlarmas`='"+IdAlarma+"'");
		while(rs.next()){
			NomAlarmas=  rs.getString("NomAlarmas");
				
					
		}
			
	
	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			NomAlarmas="Desconocido";
	}
	
	return NomAlarmas;
}
	

}
