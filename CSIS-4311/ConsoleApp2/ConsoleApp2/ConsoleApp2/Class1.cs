using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml;

namespace ConsoleApp2
{
    class Class1
    {
        public XmlDocument CreateDocument()
        {
            Connection con = new Connection();
            var books = con.GetBooks();

            XmlDocument doc = new XmlDocument();

            XmlDeclaration xmlDeclaration = doc.CreateXmlDeclaration("1.0", "UTF-8", null);
            XmlElement root = doc.DocumentElement;
            doc.InsertBefore(xmlDeclaration, root);

            XmlElement element1 = doc.CreateElement(string.Empty, "book", string.Empty);
            doc.AppendChild(element1);
            element1.SetAttribute("category", "academic");

            XmlElement element2 = doc.CreateElement(string.Empty, "author", string.Empty);
            element1.AppendChild(element2);

            XmlElement element3 = doc.CreateElement(string.Empty, "firstname", string.Empty);
            XmlText text1 = doc.CreateTextNode("Michael");
            element3.AppendChild(text1);
            element1.AppendChild(element3);

            XmlElement element4 = doc.CreateElement(string.Empty, "lastname", string.Empty);
            XmlText text2 = doc.CreateTextNode("Papazoglou");
            element4.AppendChild(text2);
            element2.AppendChild(element4);

        }
    }
}
