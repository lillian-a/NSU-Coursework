using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Serialization;
using System.Xml;

namespace Assignment2
{
    class CourseXML
    {
        public XmlDocument GetCourseXML()
        {
            XmlDocument doc = new XmlDocument();
            XmlDeclaration xmlDeclaration = doc.CreateXmlDeclaration("1.0", "UTF-8", null);
            XmlElement root = doc.DocumentElement;
            doc.InsertBefore(xmlDeclaration, root);
            // ROOT
            XmlNode course = doc.CreateElement("course");
            XmlNode title = doc.CreateElement("title");
            XmlText titleText = doc.CreateTextNode("Web Services and Systems");
            title.AppendChild(titleText);
            XmlNode program = doc.CreateElement("program");
            XmlText programText = doc.CreateTextNode("CSIS");
            program.AppendChild(programText);
            XmlNode number = doc.CreateElement("number");
            XmlText courseNumber = doc.CreateTextNode("4311");
            number.AppendChild(courseNumber);
            XmlNode term = doc.CreateElement("term");
            XmlNode crn = doc.CreateElement("crn");
            XmlText crnText = doc.CreateTextNode("32903");
            crn.AppendChild(crnText);
            XmlNode code = doc.CreateElement("code");
            XmlText codeText = doc.CreateTextNode("EV1");
            code.AppendChild(codeText);
            XmlNode name = doc.CreateElement("name");
            XmlText nameText = doc.CreateTextNode("Winter");
            name.AppendChild(nameText);
            XmlNode year = doc.CreateElement("year");
            XmlText yearText = doc.CreateTextNode("2018");
            year.AppendChild(yearText);
            term.AppendChild(crn);
            term.AppendChild(code);
            term.AppendChild(name);
            term.AppendChild(year);
            XmlNode schedule = doc.CreateElement("schedule");
            XmlNode dates = doc.CreateElement("dates");
            XmlNode startdate = doc.CreateElement("startdate");
            XmlText startdateText = doc.CreateTextNode("Jan 10");
            startdate.AppendChild(startdateText);
            XmlNode enddate = doc.CreateElement("enddate");
            XmlText enddateText = doc.CreateTextNode("May 2");
            enddate.AppendChild(enddateText);
            dates.AppendChild(startdate);
            dates.AppendChild(enddate);
            XmlNode day = doc.CreateElement("day");
            XmlText dayText = doc.CreateTextNode("Wednesday");
            day.AppendChild(dayText);
            XmlNode time = doc.CreateElement("time");
            XmlNode starttime = doc.CreateElement("starttime");
            XmlText starttimeText = doc.CreateTextNode("6:00 pm");
            starttime.AppendChild(starttimeText);
            XmlNode endtime = doc.CreateElement("endtime");
            XmlText endtimeText = doc.CreateTextNode("8:00 pm");
            endtime.AppendChild(endtimeText);
            time.AppendChild(starttime);
            time.AppendChild(endtime);
            schedule.AppendChild(dates);
            schedule.AppendChild(day);
            schedule.AppendChild(time);
            // LOCATION
            XmlNode location = doc.CreateElement("location");
            XmlNode building = doc.CreateElement("building");
            XmlText buildingText = doc.CreateTextNode("Carl DeSantis");
            building.AppendChild(buildingText);
            XmlNode room = doc.CreateElement("room");
            XmlText roomText = doc.CreateTextNode("4023");
            room.AppendChild(roomText);
            location.AppendChild(building);
            location.AppendChild(room);
            // INSTRUCTOR
            XmlNode instructor = doc.CreateElement("instructor");
            XmlNode firstname = doc.CreateElement("firstname");
            XmlText firstnameText = doc.CreateTextNode("Salam");
            firstname.AppendChild(firstnameText);
            XmlNode lastname = doc.CreateElement("lastname");
            XmlText lastnameText = doc.CreateTextNode("Farhat");
            lastname.AppendChild(lastnameText);
            XmlNode email = doc.CreateElement("email");
            XmlText emailText = doc.CreateTextNode("farhat@nova.edu");
            email.AppendChild(emailText);
            XmlNode notes = doc.CreateElement("notes");
            XmlText notesText = doc.CreateTextNode("Insert notes here");
            notes.AppendChild(notesText);
            //append subnodes to instructor
            instructor.AppendChild(firstname);
            instructor.AppendChild(lastname);
            instructor.AppendChild(email);
            instructor.AppendChild(notes);
            //materials has subnodes
            XmlNode materials = doc.CreateElement("materials");
            //books has subnodes
            XmlNode books = doc.CreateElement("books");
            //book has subnodes
            XmlNode book = doc.CreateElement("book");
            XmlNode type = doc.CreateElement("type");
            XmlText typeText = doc.CreateTextNode("Hardback");
            type.AppendChild(typeText);
            XmlNode booktitle = doc.CreateElement("booktitle");
            XmlText booktitleText = doc.CreateTextNode("WEBSERVICES & SOA : PRINCIPLES & TECHNOLOGY");
            booktitle.AppendChild(booktitleText);
            //Authors has subnodes
            XmlNode authors = doc.CreateElement("authors");
            //Author has subnodes
            XmlNode author = doc.CreateElement("author");
            XmlNode authorfirstname = doc.CreateElement("authorfirstname");
            XmlText authorfirstnameText = doc.CreateTextNode("Michael");
            authorfirstname.AppendChild(authorfirstnameText);
            XmlNode authorlastname = doc.CreateElement("authorlastname");
            XmlText authorlastnameText = doc.CreateTextNode("Papazoglou");
            authorlastname.AppendChild(authorlastnameText);
            //append subnodes to author
            author.AppendChild(authorfirstname);
            author.AppendChild(authorlastname);
            //append subnode to authors
            authors.AppendChild(author);
            XmlNode publisher = doc.CreateElement("publisher");
            XmlText publisherText = doc.CreateTextNode("Pearson UK");
            publisher.AppendChild(publisherText);
            XmlNode publishyear = doc.CreateElement("publishyear");
            XmlText publishyearText = doc.CreateTextNode("2012");
            publishyear.AppendChild(publishyearText);
            XmlNode edition = doc.CreateElement("edition");
            XmlText editionText = doc.CreateTextNode("2nd");
            edition.AppendChild(editionText);
            XmlNode isbn10 = doc.CreateElement("isbn10");
            XmlText isbn10Text = doc.CreateTextNode("0273732161");
            isbn10.AppendChild(isbn10Text);
            XmlNode isbn13 = doc.CreateElement("isbn13");
            XmlText isbn13Text = doc.CreateTextNode("978-0273732167");
            isbn13.AppendChild(isbn13Text);
            XmlNode booksnotes = doc.CreateElement("booksnotes");
            XmlText booksnotesText = doc.CreateTextNode("You probably won't need this book.");
            booksnotes.AppendChild(booksnotesText);
            //append subnode to book
            book.AppendChild(authors);
            book.AppendChild(publisher);
            book.AppendChild(publishyear);
            book.AppendChild(edition);
            book.AppendChild(isbn10);
            book.AppendChild(isbn13);
            book.AppendChild(booksnotes);
            //append subnodes to books
            books.AppendChild(book);
            //append subnodes to materials
            materials.AppendChild(books);
            //append subnodes to course
            course.AppendChild(title);
            course.AppendChild(program);
            course.AppendChild(number);
            course.AppendChild(term);
            course.AppendChild(schedule);
            course.AppendChild(location);
            course.AppendChild(instructor);
            course.AppendChild(materials);
            //append subnode to root
            doc.AppendChild(course);
            return doc;
            
        }

        public XmlDocument GetCoursesXML()
        {
            XmlDocument doc = new XmlDocument();
            XmlDeclaration xmlDeclaration = doc.CreateXmlDeclaration("1.0", "UTF-8", null);
            XmlElement root = doc.DocumentElement;
            doc.InsertBefore(xmlDeclaration, root);
            // ROOT
            XmlNode courses = doc.CreateElement("courses");
            XmlNode course = doc.CreateElement("course");
            XmlNode title = doc.CreateElement("title");
            XmlText titleText = doc.CreateTextNode("Web Services and Systems");
            title.AppendChild(titleText);
            XmlNode program = doc.CreateElement("program");
            XmlText programText = doc.CreateTextNode("CSIS");
            program.AppendChild(programText);
            XmlNode number = doc.CreateElement("number");
            XmlText courseNumber = doc.CreateTextNode("4311");
            number.AppendChild(courseNumber);
            XmlNode term = doc.CreateElement("term");
            XmlNode crn = doc.CreateElement("crn");
            XmlText crnText = doc.CreateTextNode("32903");
            crn.AppendChild(crnText);
            XmlNode code = doc.CreateElement("code");
            XmlText codeText = doc.CreateTextNode("EV1");
            code.AppendChild(codeText);
            XmlNode name = doc.CreateElement("name");
            XmlText nameText = doc.CreateTextNode("Winter");
            name.AppendChild(nameText);
            XmlNode year = doc.CreateElement("year");
            XmlText yearText = doc.CreateTextNode("2018");
            year.AppendChild(yearText);
            term.AppendChild(crn);
            term.AppendChild(code);
            term.AppendChild(name);
            term.AppendChild(year);
            XmlNode schedule = doc.CreateElement("schedule");
            XmlNode dates = doc.CreateElement("dates");
            XmlNode startdate = doc.CreateElement("startdate");
            XmlText startdateText = doc.CreateTextNode("Jan 10");
            startdate.AppendChild(startdateText);
            XmlNode enddate = doc.CreateElement("enddate");
            XmlText enddateText = doc.CreateTextNode("May 2");
            enddate.AppendChild(enddateText);
            dates.AppendChild(startdate);
            dates.AppendChild(enddate);
            XmlNode day = doc.CreateElement("day");
            XmlText dayText = doc.CreateTextNode("Wednesday");
            day.AppendChild(dayText);
            XmlNode time = doc.CreateElement("time");
            XmlNode starttime = doc.CreateElement("starttime");
            XmlText starttimeText = doc.CreateTextNode("6:00 pm");
            starttime.AppendChild(starttimeText);
            XmlNode endtime = doc.CreateElement("endtime");
            XmlText endtimeText = doc.CreateTextNode("8:00 pm");
            endtime.AppendChild(endtimeText);
            time.AppendChild(starttime);
            time.AppendChild(endtime);
            schedule.AppendChild(dates);
            schedule.AppendChild(day);
            schedule.AppendChild(time);
            // LOCATION
            XmlNode location = doc.CreateElement("location");
            XmlNode building = doc.CreateElement("building");
            XmlText buildingText = doc.CreateTextNode("Carl DeSantis");
            building.AppendChild(buildingText);
            XmlNode room = doc.CreateElement("room");
            XmlText roomText = doc.CreateTextNode("4023");
            room.AppendChild(roomText);
            location.AppendChild(building);
            location.AppendChild(room);
            // INSTRUCTOR
            XmlNode instructor = doc.CreateElement("instructor");
            XmlNode firstname = doc.CreateElement("firstname");
            XmlText firstnameText = doc.CreateTextNode("Salam");
            firstname.AppendChild(firstnameText);
            XmlNode lastname = doc.CreateElement("lastname");
            XmlText lastnameText = doc.CreateTextNode("Farhat");
            lastname.AppendChild(lastnameText);
            XmlNode email = doc.CreateElement("email");
            XmlText emailText = doc.CreateTextNode("farhat@nova.edu");
            email.AppendChild(emailText);
            XmlNode notes = doc.CreateElement("notes");
            XmlText notesText = doc.CreateTextNode("Insert notes here");
            notes.AppendChild(notesText);
            //append subnodes to instructor
            instructor.AppendChild(firstname);
            instructor.AppendChild(lastname);
            instructor.AppendChild(email);
            instructor.AppendChild(notes);
            //materials has subnodes
            XmlNode materials = doc.CreateElement("materials");
            //books has subnodes
            XmlNode books = doc.CreateElement("books");
            //book has subnodes
            XmlNode book = doc.CreateElement("book");
            XmlNode type = doc.CreateElement("type");
            XmlText typeText = doc.CreateTextNode("Hardback");
            type.AppendChild(typeText);
            XmlNode booktitle = doc.CreateElement("booktitle");
            XmlText booktitleText = doc.CreateTextNode("WEBSERVICES & SOA : PRINCIPLES & TECHNOLOGY");
            booktitle.AppendChild(booktitleText);
            //Authors has subnodes
            XmlNode authors = doc.CreateElement("authors");
            //Author has subnodes
            XmlNode author = doc.CreateElement("author");
            XmlNode authorfirstname = doc.CreateElement("authorfirstname");
            XmlText authorfirstnameText = doc.CreateTextNode("Michael");
            authorfirstname.AppendChild(authorfirstnameText);
            XmlNode authorlastname = doc.CreateElement("authorlastname");
            XmlText authorlastnameText = doc.CreateTextNode("Papazoglou");
            authorlastname.AppendChild(authorlastnameText);
            //append subnodes to author
            author.AppendChild(authorfirstname);
            author.AppendChild(authorlastname);
            //append subnode to authors
            authors.AppendChild(author);
            XmlNode publisher = doc.CreateElement("publisher");
            XmlText publisherText = doc.CreateTextNode("Pearson UK");
            publisher.AppendChild(publisherText);
            XmlNode publishyear = doc.CreateElement("publishyear");
            XmlText publishyearText = doc.CreateTextNode("2012");
            publishyear.AppendChild(publishyearText);
            XmlNode edition = doc.CreateElement("edition");
            XmlText editionText = doc.CreateTextNode("2nd");
            edition.AppendChild(editionText);
            XmlNode isbn10 = doc.CreateElement("isbn10");
            XmlText isbn10Text = doc.CreateTextNode("0273732161");
            isbn10.AppendChild(isbn10Text);
            XmlNode isbn13 = doc.CreateElement("isbn13");
            XmlText isbn13Text = doc.CreateTextNode("978-0273732167");
            isbn13.AppendChild(isbn13Text);
            XmlNode booksnotes = doc.CreateElement("booksnotes");
            XmlText booksnotesText = doc.CreateTextNode("You probably won't need this book.");
            booksnotes.AppendChild(booksnotesText);
            //append subnode to book
            book.AppendChild(authors);
            book.AppendChild(publisher);
            book.AppendChild(publishyear);
            book.AppendChild(edition);
            book.AppendChild(isbn10);
            book.AppendChild(isbn13);
            book.AppendChild(booksnotes);
            //append subnodes to books
            books.AppendChild(book);
            //append subnodes to materials
            materials.AppendChild(books);
            //append subnodes to course
            course.AppendChild(title);
            course.AppendChild(program);
            course.AppendChild(number);
            course.AppendChild(term);
            course.AppendChild(schedule);
            course.AppendChild(location);
            course.AppendChild(instructor);
            course.AppendChild(materials);
            courses.AppendChild(course);
            doc.AppendChild(courses);
            return doc;
        }
        


    }
}
