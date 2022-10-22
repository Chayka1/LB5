using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Inheritance_and_polimorphism_3
{
    class Program
    {
        static void Main()
        {
            DokumentWorker worker = new DokumentWorker();
            Console.WriteLine("Произошла активация базового функционала программы.");
            Console.WriteLine("\n");
            Console.WriteLine("Для доступа к версиям про или эксперт - необходимы ключи доступа:");
            Console.WriteLine("введите ключ доступа от версии про или эксперт. \nКод должен содержать четыре цифры от 0 до 9. \n");
            string product_key = Console.ReadLine();
            int key = Convert.ToInt32(product_key);

            switch(key)
            {
                case 1234:
                    DokumentWorker pro = new ProDocumentWorker();
                    Console.WriteLine("Поздравляем с успешным приобретением Про версии");
                    break;
                case 4321:
                    ProDocumentWorker expert = new ExpertDocumentWorker();
                    Console.WriteLine("Поздравляем с успешным приобретиние Эксперт версии");
                    break;
            }
            Console.ReadKey();
        }
    }
}