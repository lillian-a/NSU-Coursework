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
    public partial class FacultyLoginForm : Form
    {
        FacultyHomePage facultyHome;
        public FacultyLoginForm()
        {
            InitializeComponent();
        }

        private void CancelButton_Click(object sender, EventArgs e)
        {
            this.Dispose();
        }

        private void SubmitButton_Click(object sender, EventArgs e)
        {
            string userName = FacultyUserTextBox.Text;
            string password = FacultyPassTextBox.Text;

            string conString = @"Server=tcp:csis3750.database.windows.net,1433;Database=se_project;Uid=remote@csis3750;Pwd=1234qwer!@#$QWER;Encrypt=yes;TrustServerCertificate=no;Connection Timeout=30;";
            SqlConnection conn = new SqlConnection(conString);
            
            try
            {
                conn.Open();
                SqlDataAdapter da = new SqlDataAdapter("SELECT COUNT(*) FROM Faculty WHERE username = '" + userName + "' AND password = '" + password + "';", conn);
                DataTable dt = new DataTable();
                da.Fill(dt);
                if (dt.Rows[0][0].ToString() == "1")
                {
                    da.UpdateCommand = new SqlCommand("SELECT id FROM Faculty WHERE username = '" + userName + "' AND password = '" + password + "';", conn);
                    dt.Clear();
                    da.Fill(dt);
                    string id = dt.Rows[0][0].ToString();
                    int x = 0;
                    Int32.TryParse(id, out x);
                    facultyHome = new FacultyHomePage(x);
                    facultyHome.Show();

                } else
                {
                    MessageBox.Show("Bad Username or Password.\nPlease Try Again.");
                    FacultyUserTextBox.Clear();
                    FacultyPassTextBox.Clear();
                }
                
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
    }
}
