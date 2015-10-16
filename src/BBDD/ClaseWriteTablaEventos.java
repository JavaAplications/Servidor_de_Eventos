package BBDD;




public class ClaseWriteTablaEventos{

	Conexion con;
	int Radiobase,Alarma;
	String linkVideo;
	public ClaseWriteTablaEventos(int Radiobase,int Alarma,String linkVideo) {
		
		this.Alarma=Alarma;
		this.Radiobase=Radiobase;
		this.linkVideo=linkVideo;
	
	}



	public void run(){
		
	    con=new Conexion();
		//  con.Conectar();
		  con.InsertarEventos(Radiobase, Alarma,linkVideo);
		
		
		
	}
	
	
}