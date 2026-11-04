using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UD5Tarea11
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //Realiza un bucle en un programa de consola que escriba los valores pares del 0 al 100.
            //Escríbelos seguidos separados por un guión
            //Escribe otro bucle en el mismo programa para que escriba n veces en líneas distintas una
            //cadena que pidas por teclado.
            for (int i = 0; i <= 100; i += 2)
            {
                Console.Write("-" + i);
            }
            Console.WriteLine("");
            Console.WriteLine("Dime una cadena:");
            string cadena = Console.ReadLine();
            Console.WriteLine("¿Cuántas veces quieres que se escriba?");
            int n = int.Parse(Console.ReadLine());
            for (int i = 0; i < n; i++)
            {
                Console.Write("-" + cadena);
            }
        }
    }
}
