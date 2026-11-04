using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UD5Tarea9
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //Aplicación que permita determinar la temperatura en grados Kelvin (K) y
            //Rankine(R) a partir de un valor en grados centígrados.
            //Hay que tener en cuenta los siguientes aspectos:
            //Debe introducir el valor en grados centígrados.
            //Mostrar los valores resultantes a dos decimales usando el método ToString (“0.00”).

            Console.WriteLine("Introduce la temperatura en grados centígrados: ");
            double centrigrados = Convert.ToDouble(Console.ReadLine());
            double kelvin = centrigrados + 273.15;
            double rankine = (centrigrados + 273.15) * 9 / 5;

            Console.WriteLine("La temperatura en Kelvin es: " + kelvin.ToString("0.00"));
            Console.WriteLine("La temperatura en Rankine es: " + rankine.ToString("0.00"));
        }
    }
}
