using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml;
using System.Threading.Tasks;

namespace Assignment2
{
    class Program
    {
        static void Main(string[] args)
        {
            CourseXML courseXML = new CourseXML();
            // Create and Save Docs
            // this part is only for the purpose of creating the xml docs for outside the WebServiceClient
            // WebServiceClient methods create and use their own copies
            //get and save course xml
            XmlDocument doc1 = courseXML.GetCourseXML();
            doc1.Save("C:/Temp/Course.xml");
            // System.IO.File.WriteAllText(@"C:\Temp\TestCourse.txt", soapResult);
            // get and save courses xml
            XmlDocument doc2 = courseXML.GetCourseXML();
            doc1.Save("C:/Temp/Courses.xml");

            WebServiceClient client = new WebServiceClient();
            client.SendCourseXML();
            client.SendCoursesXML();
        }
    }
}
