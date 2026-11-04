namespace UD6Calculadora
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
            this.textparametro1 = new System.Windows.Forms.TextBox();
            this.textparametro2 = new System.Windows.Forms.TextBox();
            this.JLigual = new System.Windows.Forms.Label();
            this.textresltado = new System.Windows.Forms.TextBox();
            this.combooperacion = new System.Windows.Forms.ComboBox();
            this.btncalcular = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // textparametro1
            // 
            this.textparametro1.Location = new System.Drawing.Point(12, 12);
            this.textparametro1.Name = "textparametro1";
            this.textparametro1.Size = new System.Drawing.Size(100, 20);
            this.textparametro1.TabIndex = 0;
            // 
            // textparametro2
            // 
            this.textparametro2.Location = new System.Drawing.Point(167, 11);
            this.textparametro2.Name = "textparametro2";
            this.textparametro2.Size = new System.Drawing.Size(100, 20);
            this.textparametro2.TabIndex = 1;
            // 
            // JLigual
            // 
            this.JLigual.AutoSize = true;
            this.JLigual.Location = new System.Drawing.Point(273, 15);
            this.JLigual.Name = "JLigual";
            this.JLigual.Size = new System.Drawing.Size(13, 13);
            this.JLigual.TabIndex = 2;
            this.JLigual.Text = "=";
            // 
            // textresltado
            // 
            this.textresltado.Location = new System.Drawing.Point(292, 11);
            this.textresltado.Name = "textresltado";
            this.textresltado.Size = new System.Drawing.Size(100, 20);
            this.textresltado.TabIndex = 3;
            // 
            // combooperacion
            // 
            this.combooperacion.FormattingEnabled = true;
            this.combooperacion.Items.AddRange(new object[] {
            "+",
            "-",
            "/",
            "*"});
            this.combooperacion.Location = new System.Drawing.Point(118, 11);
            this.combooperacion.Name = "combooperacion";
            this.combooperacion.Size = new System.Drawing.Size(43, 21);
            this.combooperacion.TabIndex = 4;
            // 
            // btncalcular
            // 
            this.btncalcular.Location = new System.Drawing.Point(167, 37);
            this.btncalcular.Name = "btncalcular";
            this.btncalcular.Size = new System.Drawing.Size(75, 23);
            this.btncalcular.TabIndex = 5;
            this.btncalcular.Text = "Calcular";
            this.btncalcular.UseVisualStyleBackColor = true;
            this.btncalcular.Click += new System.EventHandler(this.btncalcular_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(408, 73);
            this.Controls.Add(this.btncalcular);
            this.Controls.Add(this.combooperacion);
            this.Controls.Add(this.textresltado);
            this.Controls.Add(this.JLigual);
            this.Controls.Add(this.textparametro2);
            this.Controls.Add(this.textparametro1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox textparametro1;
        private System.Windows.Forms.TextBox textparametro2;
        private System.Windows.Forms.Label JLigual;
        private System.Windows.Forms.TextBox textresltado;
        private System.Windows.Forms.ComboBox combooperacion;
        private System.Windows.Forms.Button btncalcular;
    }
}

