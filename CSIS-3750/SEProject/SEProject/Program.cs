using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace SEProject
{
    static class Program
    {
        /// <summary>
        /// The main entry point for the application.
        /// </summary>
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);


            Application.Run(new Welcome());
            // Application.Run(new FacultyLoginForm());

            //Application.Run(new FacultyHomePage(2));

            //Application.Run(new FacultyEvaluationForm("Testing 123"));


            //int[] scores = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
            //string feedback = "Blah\nBlah\nBlah\nBlah\nBlah\n";
            //Application.Run(new ResultsForm("Testing",scores,feedback));
        }
    }
}
