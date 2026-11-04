using System;
using System.Collections.Generic;
using System.Diagnostics.SymbolStore;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

namespace UD5Tarea4
{
    internal class Program
    {
        static void Main(string[] args)
        {
            String salirBucle = "salir";
            while (!salirBucle.Equals("salir"))
            {
                Console.WriteLine("¿Quieres salir del bucle?");
                String salir = Console.ReadLine();
                if (salir.Equals("salir"))
                {
                    salirBucle = "salir";
                }
            }
        }
    }
}
