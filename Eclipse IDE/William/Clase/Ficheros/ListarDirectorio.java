package Clase.Ficheros;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ListarDirectorio {

	public ListarDirectorio() {
		// TODO Auto-generated constructor stub
	}
	public void dentar(int dentado) {
		for (int i=0;i<dentado;i++) {
			System.out.print("  ");
		}
	}
	
    public void listarDirectorio(File directorio, int dentado) {
    	try {
	    	this.dentar(dentado);		
			System.out.println("*"+directorio.getCanonicalPath());			
			dentado++;
	    	String[] archivos = directorio.list();	    	
	    	ArrayList<String> listaArchivos=new ArrayList<String>();
			if (archivos != null) {
				for (String a : archivos) {
					this.dentar(dentado);				
					File subfichero=new File(directorio.getCanonicalPath()+"\\"+a);
					if (subfichero.isDirectory()) {
						this.listarDirectorio(subfichero, dentado);
					}else {
						listaArchivos.add(a);						
					}
				}
				for (String dato : listaArchivos) {
					this.dentar(dentado);	
					System.out.println(dato);
				}
			}else {
				System.out.println("No hay archivos en la carpeta");
			}
    	} catch (IOException e) {			
			e.printStackTrace();
		}
    }
	
	public void principal(String directorio) {
		int dentado=1;
		File directorio2 = new File(directorio);
		if (directorio2.isDirectory()) {
			this.listarDirectorio(directorio2, dentado);
		}else {
			System.out.println(directorio);
		}
		
	}
	
	public static void main (String[] args) {
		ListarDirectorio l=new ListarDirectorio();
		l.principal("c:/imagenes/pepe/");
	}
	
}
