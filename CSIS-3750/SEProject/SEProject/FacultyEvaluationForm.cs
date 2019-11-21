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
    public partial class FacultyEvaluationForm : Form
    {
        public int crn;
        List<TextBox> questionTextBoxes;

        public FacultyEvaluationForm(int crn)
        {
            this.crn = crn;
            InitializeComponent();
        }

        private void FacultyEvaluationForm_Load(object sender, EventArgs e)
        {
            questionTextBoxes = new List<TextBox>(10)
            {
                textBox1,
                textBox2,
                textBox3,
                textBox4,
                textBox5,
                textBox6,
                textBox7,
                textBox8,
                textBox9,
                textBox10
            };
            CreateEvalCourseNameLabel.Text = crn.ToString();
        }

        private void CreateEvalCancelButton_Click(object sender, EventArgs e)
        {
            this.Dispose();
        }

        private void CreateEvalHelpButton_Click(object sender, EventArgs e)
        {
            const string msg = "To Create an Evaluation:\n" +
                "1. Fill text boxes with questions.\n" +
                "2. Click the Submit Button\n" +
                "Click the CANCEL Button to go back to the main screen.";
            const string caption = "Help";
            ShowMessage(msg, caption);
        }

        private void CreateEvalSubmitButton_Click(object sender, EventArgs e)
        {
            string[] qs = GetQuestions();

            string conString = @"Server=tcp:csis3750.database.windows.net,1433;Database=se_project;Uid=remote@csis3750;Pwd=1234qwer!@#$QWER;Encrypt=yes;TrustServerCertificate=no;Connection Timeout=30;";
            SqlConnection conn = new SqlConnection(conString);
            try
            {
                conn.Open();
                string query = "INSERT INTO Evaluation (q1,q2,q3,q4,q5,q6,q7,q8,q9,q10, course_crn) VALUES (";
                for(int i = 0; i < 10; i++)
                {
                    query += "'" + qs[i] + "',";
                }
                query += crn + ");";
                SqlCommand cmd = new SqlCommand(query, conn);
                cmd.ExecuteNonQuery();
                

                string query2 = "UPDATE Course SET isEvalCreated = 1 WHERE crn = " + crn + ";";
                SqlCommand cmd2 = new SqlCommand(query2, conn);
                cmd2.ExecuteNonQuery();

                MessageBox.Show("Evaluation Created");
                
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
            this.Close();
        }

        public string[] GetQuestions()
        {
            string[] qs = new string[10];
            for(int i = 0; i < 10; i++)
            {
                qs[i] = questionTextBoxes[i].Text;
            }
            return qs;
        }

        private void ShowMessage(string message, string caption,
                                MessageBoxButtons btns = MessageBoxButtons.OK,
                                MessageBoxIcon icon = MessageBoxIcon.Information)
        {
            DialogResult result;
            result = MessageBox.Show(message, caption, btns, icon);
        }

        

        
    }
}
