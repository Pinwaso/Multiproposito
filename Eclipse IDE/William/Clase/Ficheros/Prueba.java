package Clase.Ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Prueba {

	public void desencriptar (String ficheroOrigen,String ficheroDestino,int paso) {
		this.encriptar(ficheroOrigen,ficheroDestino,(-paso));
	}
	
    public void encriptar (String ficheroOrigen,String ficheroDestino,int paso) {
    	try {
			BufferedReader br=new BufferedReader(new FileReader(ficheroOrigen));			
		    BufferedWriter bw=new BufferedWriter(new FileWriter(ficheroDestino));
		    int caracter=0;
		    while ( (caracter=br.read())!=-1) {
				caracter+=paso;
				if (caracter <0) caracter +=256;
				else caracter=caracter % 256;
				bw.write(caracter);	
		    }
		    bw.flush();
		    bw.close();	
		    br.close();
	  } catch (FileNotFoundException e) {		
			e.printStackTrace();
	  } catch (IOException e) {			
			e.printStackTrace();
	 }
		
    }
	
    public static String pasarLetraAMayuscula(String dato) {
    	int encontrada=-1;
    	for (int indice=0;indice<dato.length();indice++) {    		
    		String caracter=dato.substring(indice,indice+1);
    		
    		//if (caracter.matches("[a-zA-Z]")){
    	    if (caracter.matches("\\p{L}+")){    		
    			encontrada=indice;
    			break;
    		}
    	}
    	String dato1=dato;
    	if (encontrada==0) {
    		dato1=dato.substring(encontrada).toUpperCase()+dato.substring(1);
    	}else if (encontrada > 0) {
    		dato1=dato.substring(0,encontrada)+dato.substring(encontrada).toUpperCase()+dato.substring(1);
    	}
    	System.out.print(dato+"  - ");    	System.out.println(dato1);
    	return dato1;
    	
    }
    
    
    public static void main(String[] args) {    	
    	pasarLetraAMayuscula("\nñ");    	
    	pasarLetraAMayuscula("32143214");
    	pasarLetraAMayuscula("\t\na143214");
	
	
	
		
		Prueba p=new Prueba();
	p.encriptar("E:\\ProyectosJavaAlvaro\\Tema0\\alvaro.txt", "E:\\ProyectosJavaAlvaro\\Tema0\\alvaro1.txt", 1);
	p.desencriptar("E:\\ProyectosJavaAlvaro\\Tema0\\alvaro1.txt", "E:\\ProyectosJavaAlvaro\\Tema0\\alvaro2.txt", 1);
	}
	
	public void ejercicioAnterior() {
		try {
			String palabra="casa";
			String arhivoLeer="E:\\ProyectosJavaAlvaro\\Tema0\\alvaro.txt";
			int indice=arhivoLeer.lastIndexOf(".");
			String archivoEscribir=arhivoLeer.substring(0,indice)+"_2"+arhivoLeer.substring(indice);
			BufferedReader br=new BufferedReader(new FileReader(arhivoLeer));
			Scanner le= new Scanner(br);
		    BufferedWriter bw=new BufferedWriter(new FileWriter(archivoEscribir));
		    while (le.hasNextLine()) {
				bw.write((le.nextLine()).replace(palabra,""));
				bw.write("\n");
		    }
		    bw.flush();
		    bw.close();
		    le.close();
	  } catch (FileNotFoundException e) {		
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
	}

}
