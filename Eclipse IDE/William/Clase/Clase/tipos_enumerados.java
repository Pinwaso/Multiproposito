package Clase.Clase;

import java.util.Arrays;

public class tipos_enumerados {

	public enum Estacion {
		PRIMAVERA, 
		VERANO, 
		OTONO, 
		INVIERNO;
	}

	public enum Mes {
		ENERO(31,Estacion.INVIERNO,false),
		FEBRERO(28,Estacion.INVIERNO,false),
		MARZO(31,Estacion.INVIERNO,false),
		ABRIL(30,Estacion.PRIMAVERA,true),
		MAYO(31,Estacion.PRIMAVERA,true),
		JUNIO(30,Estacion.PRIMAVERA,true),
		JULIO(31,Estacion.VERANO,true),
		AGOSTO(31,Estacion.VERANO,true),
		SEPTIEMBRE(30,Estacion.VERANO,true),
		OCTUBRE(31,Estacion.OTONO,true),
		NOVIEMBRE(30,Estacion.OTONO,false),
		DICIEMBRE(31,Estacion.OTONO);
		
		private final int dias;
		private final Estacion estacion;
		private final Boolean horario;
		
		Mes (int dias,Estacion estacion,Boolean horario) { 
			this.dias = dias;
			this.estacion=estacion;
			this.horario=horario;
		}
		
		Mes (int dias,Estacion estacion) { 
			this.dias = dias;
			this.estacion=estacion;
			this.horario=false;
		}

		public int getDias() { 
			return dias; 
		}
		
		public Estacion getEstacion() { 
			return estacion; 
		}
		
		public boolean getHorario() { 
			return horario; 
		}
		
		public String getHorarioTexto() { 
			if (this.horario) { 
				return "horario verano" ;
			} else {
				return "horario invierno"; 
			}
		}
		
		public Mes localizarMes(String mesABuscar) {
			   Mes encontrado=null;
			   for (Mes lMes : Mes.values()) {
				   if (mesABuscar.toUpperCase().equals(lMes.toString().toUpperCase())) {		   
					   encontrado=lMes;
					   break;
				   }
			   }
			   return encontrado;
		}
	}

	public static void main(String[] args) {
		Mes mes=Mes.AGOSTO;
		System.out.println("el mes  "+mes+"tiene "+ mes.getDias()+"dias y esta en la estación :"
		   +mes.getEstacion()+mes.getHorario()+mes.getHorarioTexto());
		
		   mes = Mes.valueOf("ENERO");
		   System.out.println("el mes  "+mes+"tiene "+ mes.getDias()+"dias y esta en la estación :"
				   +mes.getEstacion()+mes.getHorario()+mes.getHorarioTexto());
		
		   String forMes="Enero";
		   boolean encontrado=false;
		   for (Mes lMes : Mes.values()) {

			   if (forMes.toUpperCase().equals(lMes.toString().toUpperCase())) {		   
				   encontrado=true;
			   }
		   }
		   
		   System.out.println("hola "+encontrado);
	 
		   System.out.println("el mes  "+mes+"tiene "+ mes.getDias()+"dias y esta en la estación :"
				   +mes.getEstacion()+mes.getHorario()+mes.getHorarioTexto());
	}
}