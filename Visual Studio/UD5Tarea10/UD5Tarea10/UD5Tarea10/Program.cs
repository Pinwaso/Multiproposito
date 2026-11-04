using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

namespace UD5Tarea10
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //Una empresa de venta de automóviles nuevos necesita una aplicación que
            //permita determinar el precio de venta de un coche determinado, sabiendo que la empresa
            //tiene como política ganar el 25 % sobre el valor del coche.
            //Hay que tener en cuenta los siguientes aspectos:
            //Debe introducir el coste real del coche.
            //Determinar el precio de venta para obtener una ganancia del 25% sobre el coste real
            //del coche.
            //Mostrar los valores resultantes en formato moneda euro.

            Console.WriteLine("Introduce el coste real del coche: ");
            int costeReal = Convert.ToInt32(Console.ReadLine());
            double precioVenta = costeReal * 1.25;
            double ganancia = precioVenta - costeReal;
            Console.WriteLine("El precio de venta del coche es: {0:C}", precioVenta);
            Console.WriteLine("La ganancia es: {0:C}", ganancia);
            Console.ReadKey();
        }
    }
}
