using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UD5Tarea1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("EJERCICIO 1");
            Console.WriteLine("¿Está lloviendo?");
            Console.WriteLine("Sí / No");
            String llueve = Console.ReadLine();
            if (llueve == "si")
            {
                //Comprobar si llueve. En el caso de que llueva, añadir la siguiente línea
                Console.WriteLine("¿Tienes paraguas?");
                Console.WriteLine("Sí/No");
                String paraguas = Console.ReadLine();
                //Comprobar si hay paraguas
                if (paraguas == "si")
                {
                    Console.WriteLine("Coge Paraguas");
                }
                else
                {
                    Console.WriteLine("Compra Paraguas");
                }
            }
            else
            {
                Console.WriteLine("Vamos a la playa");
            }
        }
    }
}
