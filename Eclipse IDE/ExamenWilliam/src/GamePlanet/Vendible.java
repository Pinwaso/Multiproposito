package GamePlanet;

import GamePlanet.Excepciones.DescuentonoValidoException;
import GamePlanet.Excepciones.PrecionoValidoException;

public interface Vendible {
	public double calcularPrecioFinal() throws DescuentonoValidoException, PrecionoValidoException;
}
