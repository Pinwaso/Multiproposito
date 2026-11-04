using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsolaHola
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Dame tu nombre:");
            string nombre = Console.ReadLine();
            Console.WriteLine("Cuantos años tienes?");
            string edad = Console.ReadLine();
            Console.WriteLine("Hola me llamo: {0} y tengo {1} años.", nombre, edad);
        }
    }
}