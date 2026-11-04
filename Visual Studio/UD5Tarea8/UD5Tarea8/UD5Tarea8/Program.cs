using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UD5Tarea8
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //Aplicación de consola que permita determinar el promedio de cuatro notas
            //de un alumno teniendo cada una de ellas un peso diferente.
            //Hay que tener en cuenta los siguientes aspectos:
            //Debe introducir el nombre del alumno y sus cuatro notas.
            //Los pesos de las notas son 10%, 20%, 30% y 40%, según el orden de introducción.
            //El promedio de notas se obtiene del valor porcentual de cada nota según el peso.
            //Mostrar los resultados en un formato numérico de dos decimales

            Console.WriteLine("Ingrese el nombre del alumno:");
            string nombreAlumno = Console.ReadLine();
            Console.WriteLine("Ingrese la primera nota (peso 10%):");
            double nota1 = double.Parse(Console.ReadLine());
            Console.WriteLine("Ingrese la segunda nota (peso 20%):");
            double nota2 = double.Parse(Console.ReadLine());
            Console.WriteLine("Ingrese la tercera nota (peso 30%):");
            double nota3 = double.Parse(Console.ReadLine());
            Console.WriteLine("Ingrese la cuarta nota (peso 40%):");
            double nota4 = double.Parse(Console.ReadLine());

            double promedio = (nota1 * 0.1) + (nota2 * 0.2) + (nota3 * 0.3) + (nota4 * 0.4);

            Console.WriteLine($"El promedio de {nombreAlumno} es: {promedio:F2}");
        }
    }
}
