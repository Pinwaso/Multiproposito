using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UD5Tarea2
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("EJERCICIO 2");
            Console.WriteLine("Selecciona un mes");
            Console.WriteLine("1 - Enero / 2 - Febrero / 3 - Marzo / 4 - Abril / "
             + "5 - Mayo / 6 - Junio / 7 - Julio / 8 - Agosto / 9 - Septiembre /"
             + " 10 - Octubre / 11 - Noviembre / 12 - Diciembre");
            // Permite capturar lo que se escribe por teclado
            String mes = Console.ReadLine();
            switch (mes)
            {
                case "2":
                    Console.WriteLine("28 dias");
                    break;
                case "4":
                case "6":
                case "9":
                case "11":
                    Console.WriteLine("30 dias");
                    break; 
                default:
                    Console.WriteLine("31 dias");
                    break;
            }
        }
    }
}