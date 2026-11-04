using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UD5Tarea6
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(" Dame un número correspondiente al mes");
            int mes = int.Parse(Console.ReadLine());
            switch (mes)
            {
                case 1:
                    Console.WriteLine("Has introducido el mes Enero");
                    break;
                case 2:
                    Console.WriteLine("Has introducido el mes Febrero");
                    break;
                case 3:
                    Console.WriteLine("Has introducido el mes Marzo");
                    break;
                case 4:
                    Console.WriteLine("Has introducido el mes Abril");
                    break;
                case 5:
                    Console.WriteLine("Has introducido el mes Mayo");
                    break;
                case 6:
                    Console.WriteLine("Has introducido el mes Junio");
                    break;
                case 7:
                    Console.WriteLine("Has introducido el mes Julio");
                    break;
                case 8:
                    Console.WriteLine("Has introducido el mes Agosto");
                    break;
                case 9:
                    Console.WriteLine("Has introducido el mes Septiembre");
                    break;
                case 10:
                    Console.WriteLine("Has introducido el mes Octubre");
                    break;
                case 11:
                    Console.WriteLine("Has introducido el mes Noviembre");
                    break;
                case 12:
                    Console.WriteLine("Has introducido el mes Diciembre");
                    break;
                default:
                    Console.WriteLine("Número de mes no válido.");
                    break;
            }
        }
    }
}
