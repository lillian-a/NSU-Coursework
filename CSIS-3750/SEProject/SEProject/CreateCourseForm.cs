using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace SEProject
{
    public partial class CreateCourseForm : Form
    {
        public int facultyId;

        public CreateCourseForm(int facultyId)
        {
            InitializeComponent();
            this.facultyId = facultyId;
            FacultyIDTextBox.Text = facultyId.ToString();
        }

        private void CancelButton_Click(object sender, EventArgs e)
        {
            this.Dispose();
        }

        private void HelpButton_Click(object sender, EventArgs e)
        {
            MessageBox.Show("HELP Message...");
        }

        private void SubmitButton_Click(object sender, EventArgs e)
        {
            string dept = DepartmentNameTextBox.Text;
            //string courseID = CourseIDTextBox.Text;
            string courseID = CourseIDMaskedTextBox.Text;
            string term = TermTextBox.Text;
            
            string conString = @"Server=tcp:csis3750.database.windows.net,1433;Database=se_project;Uid=remote@csis3750;Pwd=1234qwer!@#$QWER;Encrypt=yes;TrustServerCertificate=no;Connection Timeout=30;";
            SqlConnection conn = new SqlConnection(conString);
            try
            {
                conn.Open();
                string query = "INSERT INTO Course (dept,course_num,term,isEvalCreated,prof_id) VALUES ('"+ dept + "',"+ courseID + ",'"+ term + "',0,"+ facultyId + ");";
                SqlCommand cmd = new SqlCommand(query, conn);
                cmd.ExecuteNonQuery();
                MessageBox.Show("Course Created");
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                conn.Close();
                conn.Dispose();
            }

            if (!CheckIfCreateAnotherCourse())
                this.Dispose();
            else
            {
                DepartmentNameTextBox.Text = String.Empty;
                CourseIDMaskedTextBox.Text = String.Empty;
                TermTextBox.Text = String.Empty;
            }
        }
        private bool CheckIfCreateAnotherCourse()
        {
            string message = "Do you want to create another course?";
            string caption = "Info";
            MessageBoxButtons buttons = MessageBoxButtons.YesNo;
            DialogResult result;
            result = MessageBox.Show(message, caption, buttons);
            if (result == DialogResult.No)
                return false;
            else
                return true;
        }
    }
}
