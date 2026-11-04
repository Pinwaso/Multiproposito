using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UD4Tarea1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Introduce un número:");
            int numero = int.Parse(Console.ReadLine());
            if (numero < 0)
            {
                Console.WriteLine("El número introducido es negativo: " + numero );
            }
            else
            {
                Console.WriteLine("El número introducido es positivo: " + numero);
            }
        }
    }
}
