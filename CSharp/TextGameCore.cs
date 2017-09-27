using System;
using System.IO;
using System.Xml;

namespace TextGameEngine
{
    class TextGameCore
    {
        public static void Greeting()
        {
            Console.WriteLine("123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
            for (int i = 0; i <= 4; i++)
            {
                Console.WriteLine(">");
            }
            Console.Write(">                                                        Hello.");
            for (int i = 0; i <= 23; i++)
            {
                Console.Write("\r\n> ");
            }
            System.Threading.Thread.Sleep(4000);
            for (int i = 0; i < 10; i++)
            {
                Console.Write("\r\n> ");
                System.Threading.Thread.Sleep(150);
            }
            Console.Write(" Welcome to the text game.");
            System.Threading.Thread.Sleep(3000);
            for (int i = 0; i < 35; i++)
            {
                Console.Write("\r\n> ");
                System.Threading.Thread.Sleep(150);
            }
        }

        public static string GetFileName()
        {
            Console.Write("Please enter the name of the game file, or EXIT to quit \r\n>\r\n> ");
            string response = Console.ReadLine();
            return response;
        }

        public static void ValidateFileName(string n)
        {
            if (n.ToUpper() == "EXIT")
            {
                Console.Write(">\r\n> Exiting...\r\n> ");
                System.Threading.Thread.Sleep(1000);
                Environment.Exit(exitCode: 0);
            }
        }

        public static XmlReader ReadXMLFromUser(XmlReader r, string g)
        {
            while (r == null)
            {
                try
                {
                    r = XmlReader.Create(g + ".xml");
                }
                catch (FileNotFoundException e)
                {
                    Console.Write(">\r\n> " + e.Message + "\r\n>\r\n> ");
                    // Get new input if it's wrong
                    g = GetFileName();
                    ValidateFileName(g);
                }
            }
            return r;
        }

        public static void Main()
        {
            XmlReader reader = null;
            // Display greeting animation
            Greeting();

            // Get the name of the file from the user
            string GameFileName = GetFileName();

            ValidateFileName(GameFileName);

            // Try to read the xml file
            reader = ReadXMLFromUser(reader, GameFileName);

            // File is found, parsing
            Console.WriteLine("> File found! PARSING...");
            /*
             * TODO: Figure out Schema for XML
             *          Each screen is a story node
             *          Nodes have ID number and links to next nodes
             *          Nodes have story elements
             *          User picks a choice that leads them to the next linked node
             *       Parse through XML
             *       Verify schema as we parse
             *       Create story node objects
             *          Fill story nodes with data from XML
             *          Somehow have links to next node
             *       Progress with the story
             *          Get user input
             *          Traverse through the story
             */

            // Pause at the end of the program
            Console.Write("> \r\n> Press ENTER to exit \r\n> ");
            Console.ReadLine();
            Environment.Exit(exitCode: 0);
        }
    }
}
