package Clases;

import java.util.regex.Pattern;

import BBDD.ClaseWriteTablaEventos;

public class ClaseReadBuffer {
	
	
	 private static final Pattern SPACE = Pattern.compile(" ");
	 int Radiobase,Alarma;
	 String StringAlarma,linkVideo;

	 String mensaje=null;
	
	public ClaseReadBuffer(String mensaje){
		
		
		this.mensaje=mensaje;
		
		
	}
	
	
	public void run(){
		
			
		String[] arr = SPACE.split(mensaje); // str is the string to be split
		System.out.println("lonigut arr: "+arr.length);
		Radiobase=Integer.parseInt(arr[1]);
		Alarma=Integer.parseInt(arr[2]);
		
		if(arr.length<4){
			linkVideo="sin video";
		}else{
		linkVideo=arr[3];}
		// cuando la alarma es '1' es una keep alive.
		// caso contrario es una alarma de algun tipo.

		System.out.println("mensajeevento: "+mensaje);
		
		
	if (Alarma!=1){	
		System.out.println("Alarma de RADIOBASE: " +Radiobase);
		 ClaseWriteTablaEventos EscribirEvento =new ClaseWriteTablaEventos(Radiobase,Alarma,linkVideo);
		EscribirEvento.run();
		
	}

}
}