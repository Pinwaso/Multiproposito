package Clase.Ejemplos;

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
	Mes(int dias,Estacion estacion,Boolean horario) { this.dias = dias;this.estacion=estacion;
	this.horario=horario;}
	
	Mes(int dias,Estacion estacion) { this.dias = dias;this.estacion=estacion;
	this.horario=false;}

	public int getDias() { return dias; }
	public Estacion getEstacion() { return estacion; }
	public boolean getHorario() { return horario; }
	public String getHorarioTexto() { 
		if (this.horario) { 
			return "horario verano" ;
		}else{
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