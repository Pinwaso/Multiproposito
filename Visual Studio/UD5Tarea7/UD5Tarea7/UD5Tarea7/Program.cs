using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UD5Tarea7
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //Aplicación de consola que permita determinar el sueldo básico, descuento
            //y neto que debe percibir un empleado de acuerdo a las horas de trabajo y a un coste por hora.
            //Hay que tener en cuenta los siguientes aspectos:
            //Debe introducir el nombre del empleado, horas trabajadas y coste por hora.
            //El sueldo básico se obtiene del producto entre las horas trabajadas y el coste por hora.
            //El descuento se obtiene aplicando el 12 % al sueldo básico.
            //El neto se obtiene de la diferencia entre el sueldo básico y el descuento.
            //Mostrar los resultados con el formato de moneda en euros.
            Console.WriteLine("Introduce el nombre del empleado: ");
            String empleado = Console.ReadLine();
            Console.WriteLine("Introduce las horas trabajadas: ");
            double horas = Convert.ToDouble(Console.ReadLine());
            Console.WriteLine("Introduce el coste por hora: ");
            double costePorHora = Convert.ToDouble(Console.ReadLine());
            
            double sueldoBasico = horas * costePorHora;
            double descuento = sueldoBasico * 0.12;
            double neto = sueldoBasico - descuento;

            Console.WriteLine("Empleado: {0}", empleado);
            Console.WriteLine("Sueldo básico: {0:C}", sueldoBasico);
            Console.WriteLine("Descuento: {0:C}", descuento);
            Console.WriteLine("Neto: {0:C}", neto);
        }
    }
}
