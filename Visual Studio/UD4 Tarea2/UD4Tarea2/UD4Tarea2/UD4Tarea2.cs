using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UD4Tarea2
{
    class Program
    {
        static void Main(string[] args)
        {
            int operacion, a = 0, b = 0, resultado = 0;
            bool salir = false;
            while (!salir) {
                Console.WriteLine("Elige el tipo de operación que quieres hacer: ");
                Console.WriteLine(" 1 - Numerica / 2 - Logicas / 3 - Cadenas / 0 - Salir");
                operacion = Convert.ToInt32(Console.ReadLine());

                switch (operacion)
                {
                    case 1:
                        Console.WriteLine("1 - Numérica");
                        bool salir2 = false;
                        Console.WriteLine("Elige la operación que quieres hacer: ");
                        Console.WriteLine(" 1 - Suma / 2 - Resta / 3 - Multiplicación / 4 - División / 0 - Salir");
                        int operacion2 = Convert.ToInt32(Console.ReadLine());
                        switch (operacion2)
                        {
                            case 1:
                                Console.WriteLine("Introduce el primer número: ");
                                a = Convert.ToInt32(Console.ReadLine());
                                Console.WriteLine("Introduce el segundo número: ");
                                b = Convert.ToInt32(Console.ReadLine());
                                resultado = a + b;
                                Console.WriteLine("El resultado de la suma es: " + resultado);
                                break;
                            case 2:
                                Console.WriteLine("Introduce el primer número: ");
                                a = Convert.ToInt32(Console.ReadLine());
                                Console.WriteLine("Introduce el segundo número: ");
                                b = Convert.ToInt32(Console.ReadLine());
                                resultado = a - b;
                                Console.WriteLine("El resultado de la resta es: " + resultado);
                                break;
                            case 3:
                                Console.WriteLine("Introduce el primer número: ");
                                a = Convert.ToInt32(Console.ReadLine());
                                Console.WriteLine("Introduce el segundo número: ");
                                b = Convert.ToInt32(Console.ReadLine());
                                resultado = a * b;
                                Console.WriteLine("El resultado de la multiplicación es: " + resultado);
                                break;
                            case 4:
                                Console.WriteLine("Introduce el primer número: ");
                                a = Convert.ToInt32(Console.ReadLine());
                                Console.WriteLine("Introduce el segundo número: ");
                                b = Convert.ToInt32(Console.ReadLine());
                                if (b != 0)
                                {
                                    resultado = a / b;
                                    Console.WriteLine("El resultado de la división es: " + resultado);
                                }
                                else
                                {
                                    Console.WriteLine("No se puede dividir entre cero");
                                }
                                break;
                            case 0:
                                Console.WriteLine("Saliendo del programa...");
                                salir2 = true;
                                break;
                        }
                        break; // <-- Añadido este break
                    case 2:
                        Console.WriteLine("1 - Lógicas");
                        int c = 0;
                        int d = 0;
                        int resultado2 = 0;
                        
                        break; // <-- Añadido este break
                    case 3:
                        Console.WriteLine("1 - Cadenas");
                        string n = "Hola";
                        string m = "Buenos días";
                        break; // <-- Añadido este break
                    case 0:
                        Console.WriteLine("Saliendo del programa...");
                        salir = true;
                        break;
                    default:
                        Console.WriteLine("Opción no válida");
                        break;
                }
            }
        }
    }
}
