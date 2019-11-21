using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml;

namespace ConsoleApp2
{
    public class XmlGenerator
    {
        public void generateXmlDoc()
        {
            XmlDocument doc = new XmlDocument();

            XmlDeclaration xmlDeclaration = doc.CreateXmlDeclaration("1.0", "UTF-8", null);
            XmlElement root = doc.DocumentElement;
            doc.InsertBefore(xmlDeclaration, root);


            XmlElement book = doc.CreateElement("", "book","");

            XmlElement publisher = doc.CreateElement("", "publisher", "");
            XmlText publisherText = doc.CreateTextNode("Pearsons");
            publisher.AppendChild(publisherText);

            XmlElement year = doc.CreateElement("", "year", "");
            XmlText yearText = doc.CreateTextNode("1999");
            year.AppendChild(yearText);

            XmlElement title = doc.CreateElement("", "title", "");
            XmlText titleText = doc.CreateTextNode("This is the book title");
            title.AppendChild(titleText);

            XmlElement author = doc.CreateElement("", "author", "");

            XmlElement firstname = doc.CreateElement("", "firstname", "");
            XmlText firstnameText = doc.CreateTextNode("First");
            firstname.AppendChild(firstnameText);

            XmlElement lastname = doc.CreateElement("", "lastname", "");
            XmlText lastnameText = doc.CreateTextNode("Last");
            lastname.AppendChild(lastnameText);

            author.AppendChild(firstname);
            author.AppendChild(lastname);

            book.AppendChild(title);
            book.AppendChild(author);
            book.AppendChild(year);
            book.AppendChild(publisher);

            doc.AppendChild(book);

            doc.Save("C:\\temp\\lab.xml");

        }
    }
}
