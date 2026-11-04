using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UD5Tarea3
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("EJERCICIO 3");
            int num1 = 5;
            int num2 = 3;
            int resultado = 0;
            // Aquí el bucle
            for (int i = 0; i < num2; i++)
            {
                resultado += num1;
            }
            Console.WriteLine("El resultado " + resultado);
        }
    }
}
