namespace SEProject
{
    partial class FacultyHomePage
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.TitleLabel = new System.Windows.Forms.Label();
            this.LogOutLinkLabel = new System.Windows.Forms.LinkLabel();
            this.CreateCourseButton = new System.Windows.Forms.Button();
            this.CreateEvalButton = new System.Windows.Forms.Button();
            this.GenerateReportButton = new System.Windows.Forms.Button();
            this.CreateEvalComboBox = new System.Windows.Forms.ComboBox();
            this.GenerateReportComboBox = new System.Windows.Forms.ComboBox();
            this.SuspendLayout();
            // 
            // TitleLabel
            // 
            this.TitleLabel.AutoSize = true;
            this.TitleLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TitleLabel.Location = new System.Drawing.Point(475, 66);
            this.TitleLabel.Name = "TitleLabel";
            this.TitleLabel.Size = new System.Drawing.Size(489, 61);
            this.TitleLabel.TabIndex = 0;
            this.TitleLabel.Text = "Faculty Home Page";
            // 
            // LogOutLinkLabel
            // 
            this.LogOutLinkLabel.AutoSize = true;
            this.LogOutLinkLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.LogOutLinkLabel.Location = new System.Drawing.Point(1376, 48);
            this.LogOutLinkLabel.Name = "LogOutLinkLabel";
            this.LogOutLinkLabel.Size = new System.Drawing.Size(162, 46);
            this.LogOutLinkLabel.TabIndex = 1;
            this.LogOutLinkLabel.TabStop = true;
            this.LogOutLinkLabel.Text = "Log Out";
            this.LogOutLinkLabel.LinkClicked += new System.Windows.Forms.LinkLabelLinkClickedEventHandler(this.LogOutLinkLabel_LinkClicked);
            // 
            // CreateCourseButton
            // 
            this.CreateCourseButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.CreateCourseButton.Location = new System.Drawing.Point(772, 323);
            this.CreateCourseButton.Name = "CreateCourseButton";
            this.CreateCourseButton.Size = new System.Drawing.Size(386, 73);
            this.CreateCourseButton.TabIndex = 2;
            this.CreateCourseButton.Text = "Create Course";
            this.CreateCourseButton.UseVisualStyleBackColor = true;
            this.CreateCourseButton.Click += new System.EventHandler(this.CreateCourseButton_Click);
            // 
            // CreateEvalButton
            // 
            this.CreateEvalButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.CreateEvalButton.Location = new System.Drawing.Point(772, 478);
            this.CreateEvalButton.Name = "CreateEvalButton";
            this.CreateEvalButton.Size = new System.Drawing.Size(386, 75);
            this.CreateEvalButton.TabIndex = 3;
            this.CreateEvalButton.Text = "Create Evaluation";
            this.CreateEvalButton.UseVisualStyleBackColor = true;
            this.CreateEvalButton.Click += new System.EventHandler(this.CreateEvalButton_Click);
            // 
            // GenerateReportButton
            // 
            this.GenerateReportButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.GenerateReportButton.Location = new System.Drawing.Point(772, 639);
            this.GenerateReportButton.Name = "GenerateReportButton";
            this.GenerateReportButton.Size = new System.Drawing.Size(386, 79);
            this.GenerateReportButton.TabIndex = 4;
            this.GenerateReportButton.Text = "Generate Report";
            this.GenerateReportButton.UseVisualStyleBackColor = true;
            this.GenerateReportButton.Click += new System.EventHandler(this.GenerateReportButton_Click);
            // 
            // CreateEvalComboBox
            // 
            this.CreateEvalComboBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.CreateEvalComboBox.FormattingEnabled = true;
            this.CreateEvalComboBox.Location = new System.Drawing.Point(214, 489);
            this.CreateEvalComboBox.Name = "CreateEvalComboBox";
            this.CreateEvalComboBox.Size = new System.Drawing.Size(463, 54);
            this.CreateEvalComboBox.TabIndex = 5;
            // 
            // GenerateReportComboBox
            // 
            this.GenerateReportComboBox.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.GenerateReportComboBox.FormattingEnabled = true;
            this.GenerateReportComboBox.Location = new System.Drawing.Point(214, 652);
            this.GenerateReportComboBox.Name = "GenerateReportComboBox";
            this.GenerateReportComboBox.Size = new System.Drawing.Size(463, 54);
            this.GenerateReportComboBox.TabIndex = 6;
            // 
            // FacultyHomePage
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(16F, 31F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1583, 1095);
            this.Controls.Add(this.GenerateReportComboBox);
            this.Controls.Add(this.CreateEvalComboBox);
            this.Controls.Add(this.GenerateReportButton);
            this.Controls.Add(this.CreateEvalButton);
            this.Controls.Add(this.CreateCourseButton);
            this.Controls.Add(this.LogOutLinkLabel);
            this.Controls.Add(this.TitleLabel);
            this.Name = "FacultyHomePage";
            this.Text = "FacultyHomePage";
            this.Load += new System.EventHandler(this.FacultyHomePage_Load);
            this.ResumeLayout(false);
            this.PerformLayout();
            this.Activated += new System.EventHandler(this.FacultyHomePage_Activated);
        }

        #endregion

        private System.Windows.Forms.Label TitleLabel;
        private System.Windows.Forms.LinkLabel LogOutLinkLabel;
        private System.Windows.Forms.Button CreateCourseButton;
        private System.Windows.Forms.Button CreateEvalButton;
        private System.Windows.Forms.Button GenerateReportButton;
        private System.Windows.Forms.ComboBox CreateEvalComboBox;
        private System.Windows.Forms.ComboBox GenerateReportComboBox;
    }
}