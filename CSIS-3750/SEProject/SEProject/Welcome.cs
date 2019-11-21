using System;
using System.Windows.Forms;
using StudetEval;

namespace SEProject
{
    public partial class Welcome : Form
    {
        FacultyLoginForm facultyForm;
        // StudentLoginForm studentForm
        Form1 studentForm;

        public Welcome()
        {
            InitializeComponent();
        }

        private void FacultyLoginButton_Click(object sender, EventArgs e)
        {
            facultyForm = new FacultyLoginForm();
            facultyForm.Show();
        }

        private void StudentLoginButton_Click(object sender, EventArgs e)
        {
            studentForm = new Form1();
            studentForm.Show();
        }
    }
}
