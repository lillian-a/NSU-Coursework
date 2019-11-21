namespace SEProject
{
    partial class CreateCourseForm
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
            this.FacultyIDLabel = new System.Windows.Forms.Label();
            this.DepartmentNameLabel = new System.Windows.Forms.Label();
            this.CourseIDLabel = new System.Windows.Forms.Label();
            this.TermLabel = new System.Windows.Forms.Label();
            this.CreateCourseCancelButton = new System.Windows.Forms.Button();
            this.CreateCourseHelpButton = new System.Windows.Forms.Button();
            this.CreateCourseSubmitButton = new System.Windows.Forms.Button();
            this.FacultyIDTextBox = new System.Windows.Forms.TextBox();
            this.DepartmentNameTextBox = new System.Windows.Forms.TextBox();
            this.TermTextBox = new System.Windows.Forms.TextBox();
            this.CourseIDMaskedTextBox = new System.Windows.Forms.MaskedTextBox();
            this.SuspendLayout();
            // 
            // TitleLabel
            // 
            this.TitleLabel.AutoSize = true;
            this.TitleLabel.Location = new System.Drawing.Point(306, 49);
            this.TitleLabel.Name = "TitleLabel";
            this.TitleLabel.Size = new System.Drawing.Size(198, 32);
            this.TitleLabel.TabIndex = 0;
            this.TitleLabel.Text = "Create Course";
            // 
            // FacultyIDLabel
            // 
            this.FacultyIDLabel.AutoSize = true;
            this.FacultyIDLabel.Location = new System.Drawing.Point(95, 166);
            this.FacultyIDLabel.Name = "FacultyIDLabel";
            this.FacultyIDLabel.Size = new System.Drawing.Size(149, 32);
            this.FacultyIDLabel.TabIndex = 1;
            this.FacultyIDLabel.Text = "Faculty ID:";
            // 
            // DepartmentNameLabel
            // 
            this.DepartmentNameLabel.AutoSize = true;
            this.DepartmentNameLabel.Location = new System.Drawing.Point(101, 241);
            this.DepartmentNameLabel.Name = "DepartmentNameLabel";
            this.DepartmentNameLabel.Size = new System.Drawing.Size(253, 32);
            this.DepartmentNameLabel.TabIndex = 2;
            this.DepartmentNameLabel.Text = "Department Name:";
            // 
            // CourseIDLabel
            // 
            this.CourseIDLabel.AutoSize = true;
            this.CourseIDLabel.Location = new System.Drawing.Point(101, 301);
            this.CourseIDLabel.Name = "CourseIDLabel";
            this.CourseIDLabel.Size = new System.Drawing.Size(148, 32);
            this.CourseIDLabel.TabIndex = 3;
            this.CourseIDLabel.Text = "Course ID:";
            // 
            // TermLabel
            // 
            this.TermLabel.AutoSize = true;
            this.TermLabel.Location = new System.Drawing.Point(101, 367);
            this.TermLabel.Name = "TermLabel";
            this.TermLabel.Size = new System.Drawing.Size(88, 32);
            this.TermLabel.TabIndex = 4;
            this.TermLabel.Text = "Term:";
            // 
            // CreateCourseCancelButton
            // 
            this.CreateCourseCancelButton.Location = new System.Drawing.Point(112, 588);
            this.CreateCourseCancelButton.Name = "CreateCourseCancelButton";
            this.CreateCourseCancelButton.Size = new System.Drawing.Size(183, 67);
            this.CreateCourseCancelButton.TabIndex = 5;
            this.CreateCourseCancelButton.Text = "Cancel";
            this.CreateCourseCancelButton.UseVisualStyleBackColor = true;
            this.CreateCourseCancelButton.Click += new System.EventHandler(this.CancelButton_Click);
            // 
            // CreateCourseHelpButton
            // 
            this.CreateCourseHelpButton.Location = new System.Drawing.Point(356, 588);
            this.CreateCourseHelpButton.Name = "CreateCourseHelpButton";
            this.CreateCourseHelpButton.Size = new System.Drawing.Size(184, 67);
            this.CreateCourseHelpButton.TabIndex = 6;
            this.CreateCourseHelpButton.Text = "Help";
            this.CreateCourseHelpButton.UseVisualStyleBackColor = true;
            this.CreateCourseHelpButton.Click += new System.EventHandler(this.HelpButton_Click);
            // 
            // CreateCourseSubmitButton
            // 
            this.CreateCourseSubmitButton.Location = new System.Drawing.Point(596, 588);
            this.CreateCourseSubmitButton.Name = "CreateCourseSubmitButton";
            this.CreateCourseSubmitButton.Size = new System.Drawing.Size(185, 67);
            this.CreateCourseSubmitButton.TabIndex = 7;
            this.CreateCourseSubmitButton.Text = "Submit";
            this.CreateCourseSubmitButton.UseVisualStyleBackColor = true;
            this.CreateCourseSubmitButton.Click += new System.EventHandler(this.SubmitButton_Click);
            // 
            // FacultyIDTextBox
            // 
            this.FacultyIDTextBox.Location = new System.Drawing.Point(356, 159);
            this.FacultyIDTextBox.Name = "FacultyIDTextBox";
            this.FacultyIDTextBox.ReadOnly = true;
            this.FacultyIDTextBox.Size = new System.Drawing.Size(357, 38);
            this.FacultyIDTextBox.TabIndex = 8;
            // 
            // DepartmentNameTextBox
            // 
            this.DepartmentNameTextBox.CharacterCasing = System.Windows.Forms.CharacterCasing.Upper;
            this.DepartmentNameTextBox.Location = new System.Drawing.Point(356, 241);
            this.DepartmentNameTextBox.MaxLength = 4;
            this.DepartmentNameTextBox.Name = "DepartmentNameTextBox";
            this.DepartmentNameTextBox.Size = new System.Drawing.Size(357, 38);
            this.DepartmentNameTextBox.TabIndex = 9;
            // 
            // TermTextBox
            // 
            this.TermTextBox.Location = new System.Drawing.Point(356, 391);
            this.TermTextBox.MaxLength = 11;
            this.TermTextBox.Name = "TermTextBox";
            this.TermTextBox.Size = new System.Drawing.Size(357, 38);
            this.TermTextBox.TabIndex = 11;
            // 
            // CourseIDMaskedTextBox
            // 
            this.CourseIDMaskedTextBox.Location = new System.Drawing.Point(356, 312);
            this.CourseIDMaskedTextBox.Mask = "0000";
            this.CourseIDMaskedTextBox.Name = "CourseIDMaskedTextBox";
            this.CourseIDMaskedTextBox.Size = new System.Drawing.Size(357, 38);
            this.CourseIDMaskedTextBox.TabIndex = 10;
            // 
            // CreateCourseForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(16F, 31F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(932, 685);
            this.Controls.Add(this.CourseIDMaskedTextBox);
            this.Controls.Add(this.TermTextBox);
            this.Controls.Add(this.DepartmentNameTextBox);
            this.Controls.Add(this.FacultyIDTextBox);
            this.Controls.Add(this.CreateCourseSubmitButton);
            this.Controls.Add(this.CreateCourseHelpButton);
            this.Controls.Add(this.CreateCourseCancelButton);
            this.Controls.Add(this.TermLabel);
            this.Controls.Add(this.CourseIDLabel);
            this.Controls.Add(this.DepartmentNameLabel);
            this.Controls.Add(this.FacultyIDLabel);
            this.Controls.Add(this.TitleLabel);
            this.Name = "CreateCourseForm";
            this.Text = "CreateCourseForm";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label TitleLabel;
        private System.Windows.Forms.Label FacultyIDLabel;
        private System.Windows.Forms.Label DepartmentNameLabel;
        private System.Windows.Forms.Label CourseIDLabel;
        private System.Windows.Forms.Label TermLabel;
        private System.Windows.Forms.Button CreateCourseCancelButton;
        private System.Windows.Forms.Button CreateCourseHelpButton;
        private System.Windows.Forms.Button CreateCourseSubmitButton;
        private System.Windows.Forms.TextBox FacultyIDTextBox;
        private System.Windows.Forms.TextBox DepartmentNameTextBox;
        private System.Windows.Forms.TextBox TermTextBox;
        private System.Windows.Forms.MaskedTextBox CourseIDMaskedTextBox;
    }
}