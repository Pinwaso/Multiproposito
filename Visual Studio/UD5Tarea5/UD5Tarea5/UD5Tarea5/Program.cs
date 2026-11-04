using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UD5Tarea5
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int numeroAleatorio = new Random().Next(1, 101);
            bool adivinado = false;
            while (!adivinado)
            {
                Console.Write("Adivina el número (entre 1 y 100): ");
                int intento = Convert.ToInt32(Console.ReadLine());
                if (intento < numeroAleatorio)
                {
                    Console.WriteLine("Demasiado bajo. Intenta de nuevo.");
                }
                else if (intento > numeroAleatorio)
                {
                    Console.WriteLine("Demasiado alto. Intenta de nuevo.");
                }
                else
                {
                    Console.WriteLine("¡Felicidades! Adivinaste el número.");
                    adivinado = true;
                }
            }
        }
    }
}
