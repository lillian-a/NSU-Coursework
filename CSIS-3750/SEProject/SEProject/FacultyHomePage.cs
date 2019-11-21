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
    public partial class FacultyHomePage : Form
    {
        private CreateCourseForm createCourseForm;
        private FacultyEvaluationForm facultyEvaluationForm;
        private ResultsForm resultsForm;

        protected int facultyId;

        public FacultyHomePage(int facultyId)
        {
            this.facultyId = facultyId;
            InitializeComponent();
        }

        private void FacultyHomePage_Load(object sender, EventArgs e)
        {
            FillEvalComboBox();
            FillReportComboBox();
        }

        private void FacultyHomePage_Activated(object sender, EventArgs e)
        {
            FillEvalComboBox();
            FillReportComboBox();
        }

        private void CreateCourseButton_Click(object sender, EventArgs e)
        {
            createCourseForm = new CreateCourseForm(facultyId);
            createCourseForm.Show();
        }

        private void CreateEvalButton_Click(object sender, EventArgs e)
        {
            string selectedCourse = CreateEvalComboBox.SelectedValue.ToString();
            int x = 0;
            Int32.TryParse(selectedCourse, out x);
            facultyEvaluationForm = new FacultyEvaluationForm(x);
            facultyEvaluationForm.Show();
            
        }
        private void GenerateReportButton_Click(object sender, EventArgs e)
        {
            string selectedCourse = GenerateReportComboBox.SelectedValue.ToString();
            int x = 0;
            Int32.TryParse(selectedCourse, out x);
            resultsForm = new ResultsForm(x);
            resultsForm.Show();
        }

        

        protected void FillEvalComboBox()
        {
            string conString = @"Server=tcp:csis3750.database.windows.net,1433;Database=se_project;Uid=remote@csis3750;Pwd=1234qwer!@#$QWER;Encrypt=yes;TrustServerCertificate=no;Connection Timeout=30;";
            SqlConnection conn = new SqlConnection(conString);
            try
            {
                conn.Open();
                SqlDataAdapter da = new SqlDataAdapter("SELECT (dept + ' ' + CONVERT(VARCHAR(4),course_num)) AS NAME, crn FROM Course WHERE prof_id = " + facultyId + " AND isEvalCreated = 0;", conn);
                DataSet ds = new DataSet();
                da.Fill(ds);
                CreateEvalComboBox.DisplayMember = "name";
                CreateEvalComboBox.ValueMember = "crn";
                CreateEvalComboBox.DataSource = ds.Tables[0];
                
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
        }

        protected void FillReportComboBox()
        {
            string conString = @"Server=tcp:csis3750.database.windows.net,1433;Database=se_project;Uid=remote@csis3750;Pwd=1234qwer!@#$QWER;Encrypt=yes;TrustServerCertificate=no;Connection Timeout=30;";
            SqlConnection conn = new SqlConnection(conString);
            try
            {
                conn.Open();
                SqlDataAdapter da = new SqlDataAdapter("SELECT (dept + ' ' + CONVERT(VARCHAR(4),course_num)) AS NAME, crn FROM Course WHERE prof_id = " + facultyId + " AND isEvalCreated = 1;", conn);
                DataSet ds = new DataSet();
                da.Fill(ds);
                GenerateReportComboBox.DisplayMember = "name";
                GenerateReportComboBox.ValueMember = "crn";
                GenerateReportComboBox.DataSource = ds.Tables[0];

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
        }

        

        private void LogOutLinkLabel_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            this.Dispose();
        }
    }
}
