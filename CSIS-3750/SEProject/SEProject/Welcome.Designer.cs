namespace SEProject
{
    partial class Welcome
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
            this.FacultyLoginButton = new System.Windows.Forms.Button();
            this.StudentLoginButton = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // TitleLabel
            // 
            this.TitleLabel.AutoSize = true;
            this.TitleLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.TitleLabel.Location = new System.Drawing.Point(194, 31);
            this.TitleLabel.Name = "TitleLabel";
            this.TitleLabel.Size = new System.Drawing.Size(392, 69);
            this.TitleLabel.TabIndex = 0;
            this.TitleLabel.Text = "Project Name";
            // 
            // FacultyLoginButton
            // 
            this.FacultyLoginButton.Location = new System.Drawing.Point(252, 170);
            this.FacultyLoginButton.Name = "FacultyLoginButton";
            this.FacultyLoginButton.Size = new System.Drawing.Size(276, 68);
            this.FacultyLoginButton.TabIndex = 1;
            this.FacultyLoginButton.Text = "Faculty Login";
            this.FacultyLoginButton.UseVisualStyleBackColor = true;
            this.FacultyLoginButton.Click += new System.EventHandler(this.FacultyLoginButton_Click);
            // 
            // StudentLoginButton
            // 
            this.StudentLoginButton.Location = new System.Drawing.Point(252, 296);
            this.StudentLoginButton.Name = "StudentLoginButton";
            this.StudentLoginButton.Size = new System.Drawing.Size(276, 74);
            this.StudentLoginButton.TabIndex = 2;
            this.StudentLoginButton.Text = "Student Login";
            this.StudentLoginButton.UseVisualStyleBackColor = true;
            this.StudentLoginButton.Click += new System.EventHandler(this.StudentLoginButton_Click);
            // 
            // Welcome
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(16F, 31F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.StudentLoginButton);
            this.Controls.Add(this.FacultyLoginButton);
            this.Controls.Add(this.TitleLabel);
            this.Name = "Welcome";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label TitleLabel;
        private System.Windows.Forms.Button FacultyLoginButton;
        private System.Windows.Forms.Button StudentLoginButton;
    }
}

