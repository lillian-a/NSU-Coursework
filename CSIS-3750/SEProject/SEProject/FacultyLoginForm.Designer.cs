namespace SEProject
{
    partial class FacultyLoginForm
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
            this.UsernameLabel = new System.Windows.Forms.Label();
            this.PasswordLabel = new System.Windows.Forms.Label();
            this.FacultyLoginCancelButton = new System.Windows.Forms.Button();
            this.SubmitButton = new System.Windows.Forms.Button();
            this.FacultyUserTextBox = new System.Windows.Forms.TextBox();
            this.FacultyPassTextBox = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // TitleLabel
            // 
            this.TitleLabel.AutoSize = true;
            this.TitleLabel.Location = new System.Drawing.Point(406, 103);
            this.TitleLabel.Name = "TitleLabel";
            this.TitleLabel.Size = new System.Drawing.Size(185, 32);
            this.TitleLabel.TabIndex = 0;
            this.TitleLabel.Text = "Faculty Login";
            // 
            // UsernameLabel
            // 
            this.UsernameLabel.AutoSize = true;
            this.UsernameLabel.Location = new System.Drawing.Point(191, 229);
            this.UsernameLabel.Name = "UsernameLabel";
            this.UsernameLabel.Size = new System.Drawing.Size(153, 32);
            this.UsernameLabel.TabIndex = 1;
            this.UsernameLabel.Text = "Username:";
            // 
            // PasswordLabel
            // 
            this.PasswordLabel.AutoSize = true;
            this.PasswordLabel.Location = new System.Drawing.Point(197, 334);
            this.PasswordLabel.Name = "PasswordLabel";
            this.PasswordLabel.Size = new System.Drawing.Size(147, 32);
            this.PasswordLabel.TabIndex = 2;
            this.PasswordLabel.Text = "Password:";
            // 
            // FacultyLoginCancelButton
            // 
            this.FacultyLoginCancelButton.Location = new System.Drawing.Point(237, 609);
            this.FacultyLoginCancelButton.Name = "FacultyLoginCancelButton";
            this.FacultyLoginCancelButton.Size = new System.Drawing.Size(159, 66);
            this.FacultyLoginCancelButton.TabIndex = 3;
            this.FacultyLoginCancelButton.Text = "Cancel";
            this.FacultyLoginCancelButton.UseVisualStyleBackColor = true;
            this.FacultyLoginCancelButton.Click += new System.EventHandler(this.CancelButton_Click);
            // 
            // SubmitButton
            // 
            this.SubmitButton.Location = new System.Drawing.Point(703, 609);
            this.SubmitButton.Name = "SubmitButton";
            this.SubmitButton.Size = new System.Drawing.Size(154, 66);
            this.SubmitButton.TabIndex = 4;
            this.SubmitButton.Text = "Submit";
            this.SubmitButton.UseVisualStyleBackColor = true;
            this.SubmitButton.Click += new System.EventHandler(this.SubmitButton_Click);
            // 
            // FacultyUserTextBox
            // 
            this.FacultyUserTextBox.Location = new System.Drawing.Point(566, 222);
            this.FacultyUserTextBox.MaxLength = 20;
            this.FacultyUserTextBox.Name = "FacultyUserTextBox";
            this.FacultyUserTextBox.Size = new System.Drawing.Size(306, 38);
            this.FacultyUserTextBox.TabIndex = 5;
            // 
            // FacultyPassTextBox
            // 
            this.FacultyPassTextBox.Location = new System.Drawing.Point(566, 334);
            this.FacultyPassTextBox.MaxLength = 20;
            this.FacultyPassTextBox.Name = "FacultyPassTextBox";
            this.FacultyPassTextBox.PasswordChar = '*';
            this.FacultyPassTextBox.Size = new System.Drawing.Size(306, 38);
            this.FacultyPassTextBox.TabIndex = 6;
            // 
            // FacultyLoginForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(16F, 31F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1143, 814);
            this.Controls.Add(this.FacultyPassTextBox);
            this.Controls.Add(this.FacultyUserTextBox);
            this.Controls.Add(this.SubmitButton);
            this.Controls.Add(this.FacultyLoginCancelButton);
            this.Controls.Add(this.PasswordLabel);
            this.Controls.Add(this.UsernameLabel);
            this.Controls.Add(this.TitleLabel);
            this.Name = "FacultyLoginForm";
            this.Text = "FacultyLoginForm";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label TitleLabel;
        private System.Windows.Forms.Label UsernameLabel;
        private System.Windows.Forms.Label PasswordLabel;
        private System.Windows.Forms.Button FacultyLoginCancelButton;
        private System.Windows.Forms.Button SubmitButton;
        private System.Windows.Forms.TextBox FacultyUserTextBox;
        private System.Windows.Forms.TextBox FacultyPassTextBox;
    }
}