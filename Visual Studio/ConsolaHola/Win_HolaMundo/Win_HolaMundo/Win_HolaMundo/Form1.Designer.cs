namespace Win_HolaMundo
{
    partial class Form1
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.Botoncerrar = new System.Windows.Forms.Button();
            this.listnombres = new System.Windows.Forms.ListBox();
            this.Botonaniadir = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(32, 40);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(44, 13);
            this.label1.TabIndex = 1;
            this.label1.Text = "Nombre";
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // textBox1
            // 
            this.textBox1.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.textBox1.Location = new System.Drawing.Point(82, 37);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(100, 20);
            this.textBox1.TabIndex = 2;
            this.textBox1.KeyDown += new System.Windows.Forms.KeyEventHandler(this.textBox1_KeyDown);
            // 
            // Botoncerrar
            // 
            this.Botoncerrar.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.Botoncerrar.Location = new System.Drawing.Point(107, 193);
            this.Botoncerrar.Name = "Botoncerrar";
            this.Botoncerrar.Size = new System.Drawing.Size(75, 23);
            this.Botoncerrar.TabIndex = 3;
            this.Botoncerrar.Text = "Cerrar";
            this.Botoncerrar.UseVisualStyleBackColor = true;
            this.Botoncerrar.Click += new System.EventHandler(this.Botoncerrar_Click);
            // 
            // listnombres
            // 
            this.listnombres.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.listnombres.FormattingEnabled = true;
            this.listnombres.Location = new System.Drawing.Point(35, 92);
            this.listnombres.Name = "listnombres";
            this.listnombres.Size = new System.Drawing.Size(147, 95);
            this.listnombres.TabIndex = 4;
            this.listnombres.SelectedIndexChanged += new System.EventHandler(this.listBox1_SelectedIndexChanged);
            this.listnombres.KeyDown += new System.Windows.Forms.KeyEventHandler(this.listnombres_KeyDown);
            // 
            // Botonaniadir
            // 
            this.Botonaniadir.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.Botonaniadir.Location = new System.Drawing.Point(107, 63);
            this.Botonaniadir.Name = "Botonaniadir";
            this.Botonaniadir.Size = new System.Drawing.Size(75, 23);
            this.Botonaniadir.TabIndex = 5;
            this.Botonaniadir.Text = "Añadir";
            this.Botonaniadir.UseVisualStyleBackColor = true;
            this.Botonaniadir.Click += new System.EventHandler(this.Botonaniadir_Click);
            // 
            // Form1
            // 
            this.AcceptButton = this.Botonaniadir;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoScroll = true;
            this.ClientSize = new System.Drawing.Size(215, 306);
            this.Controls.Add(this.Botonaniadir);
            this.Controls.Add(this.listnombres);
            this.Controls.Add(this.Botoncerrar);
            this.Controls.Add(this.textBox1);
            this.Controls.Add(this.label1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.Button Botoncerrar;
        private System.Windows.Forms.ListBox listnombres;
        private System.Windows.Forms.Button Botonaniadir;
    }
}

