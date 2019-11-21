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
    public partial class ResultsForm : Form
    {
        public int crn;
        public string courseName;
        public string[,] scores;
        public int[,] scoresInt;
        public int[] finalScoreAverages;
        public string[] feedback;
        public string feedbackStr;
        List<Label> scoreLabels;
        public List<string>[] f;
        public int rows;

        public ResultsForm(int crn)
        {
            this.crn = crn;
            //finalScores = new int[10];
            finalScoreAverages = new int[10];
            InitializeComponent();
        }

        private void ResultsForm_Load(object sender, EventArgs e)
        {
            scoreLabels = new List<Label>(10)
            {
                label1,
                label2,
                label3,
                label4,
                label5,
                label6,
                label7,
                label8,
                label9,
                label10
            };
            FillForm();


        }

        private void FillForm()
        {
            int[] finalScore1 = new int[10];
            int[] finalScore2 = new int[10];
            int[] finalScore3 = new int[10];
            int[] finalScore4 = new int[10];
            int[] finalScore5 = new int[10];
            int[] finalScore6 = new int[10];
            int[] finalScore7 = new int[10];
            int[] finalScore8 = new int[10];
            int[] finalScore9 = new int[10];
            int[] finalScore10 = new int[10];
            string conString = @"Server=tcp:csis3750.database.windows.net,1433;Database=se_project;Uid=remote@csis3750;Pwd=1234qwer!@#$QWER;Encrypt=yes;TrustServerCertificate=no;Connection Timeout=30;";
            SqlConnection conn = new SqlConnection(conString);
            try
            {
                conn.Open();
                // SELECT eval_id FROM Evaluation WHERE course_crn = 1001;
                SqlDataAdapter da = new SqlDataAdapter("SELECT eval_id FROM Evaluation WHERE course_crn = " + crn + ";", conn);
                DataTable dt = new DataTable();
                DataTable dt2 = new DataTable();
                da.Fill(dt);
                string id = dt.Rows[0][0].ToString();
                int x = 0;
                Int32.TryParse(id, out x);
                int eval_id = x;

                SqlDataAdapter da2 = new SqlDataAdapter("SELECT Count(*) FROM Answer WHERE eval_id = " + eval_id + ";", conn);
                da2.Fill(dt2);
                string ct = dt2.Rows[0][0].ToString();
                Int32.TryParse(ct, out x);
                if (x >= 1)
                {
                    SqlDataAdapter da3 = new SqlDataAdapter("SELECT * FROM Answer WHERE eval_id = " + eval_id + ";", conn);
                    DataTable dt3 = new DataTable();
                    da3.Fill(dt3);
                    int count = dt3.Rows.Count;
                    rows = count;
                    int colCount = dt3.Columns.Count;
                    scores = new string[count,10];
                    scoresInt = new int[count, 10];
                    feedback = new string[count];
                    

                    for(int i = 0; i < count; i++)
                    {
                        feedback[i] = dt3.Rows[i][11].ToString();
                        for (int j = 0; j < 10; j++)
                        {
                            scores[i, j] = dt3.Rows[i][j+1].ToString();
                        }

                    }
                    for (int i = 0; i < count; i++)
                    {
                        for (int j = 0; j < 10; j++)
                        {
                            int n = 0;
                            Int32.TryParse(scores[i,j], out n);
                            scoresInt[i, j] = n;
                        }

                    }
                    

                    for (int i = 0; i < count; i++)
                    {
                        finalScore1[i] = scoresInt[i, 0];
                        finalScore2[i] = scoresInt[i, 1];
                        finalScore3[i] = scoresInt[i, 2];
                        finalScore4[i] = scoresInt[i, 3];
                        finalScore5[i] = scoresInt[i, 4];
                        finalScore6[i] = scoresInt[i, 5];
                        finalScore7[i] = scoresInt[i, 6];
                        finalScore8[i] = scoresInt[i, 7];
                        finalScore9[i] = scoresInt[i, 8];
                        finalScore10[i] = scoresInt[i, 9];
                    }

                    finalScoreAverages[0] = AverageScores(finalScore1);
                    finalScoreAverages[1] = AverageScores(finalScore2);
                    finalScoreAverages[2] = AverageScores(finalScore3);
                    finalScoreAverages[3] = AverageScores(finalScore4);
                    finalScoreAverages[4] = AverageScores(finalScore5);
                    finalScoreAverages[5] = AverageScores(finalScore6);
                    finalScoreAverages[6] = AverageScores(finalScore7);
                    finalScoreAverages[7] = AverageScores(finalScore8);
                    finalScoreAverages[8] = AverageScores(finalScore9);
                    finalScoreAverages[9] = AverageScores(finalScore10);
                    feedbackStr = CombineFeedBackStrings(feedback);
                    UpdateGUI();
                }
                else
                {
                    MessageBox.Show("Evaluation has not been answered yet.");
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

        private void UpdateGUI()
        {
            resultsCourseName.Text = courseName;
            ResultsCommentRichTextBox.Text = feedbackStr;
            FillScoreLabels();
        }

        private void FillScoreLabels()
        {
            for(int i = 0; i < 10; i++)
            {
                scoreLabels[i].Text = finalScoreAverages[i].ToString();
            }
        }

        private void ResultsHomeButton_Click(object sender, EventArgs e)
        {
            this.Dispose();
        }

        // averages array of ints
        private int AverageScores(int[] scores)
        {
            double sum = 0;
            double length = scores.Length;
            for (int i = 0; i < rows; i++)
                sum += scores[i];
            double average = sum / rows;
            return Convert.ToInt32(Math.Round(average, MidpointRounding.AwayFromZero));
        }


        // Concatenates string array into one string with seperator in between for results form
        private string CombineFeedBackStrings(string[] fb)
        {
            string str = "";
            string seperator = "\n----------\n";
            foreach (string s in fb)
            {
                str += s + seperator;
            }
            return str;
        }
    }
}
