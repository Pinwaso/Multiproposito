namespace UD5Tarea12
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
            this.Lista = new System.Windows.Forms.ListBox();
            this.JLElemento = new System.Windows.Forms.Label();
            this.BTNAniadir = new System.Windows.Forms.Button();
            this.TBElemento = new System.Windows.Forms.TextBox();
            this.JLBusca = new System.Windows.Forms.Label();
            this.TBBusca = new System.Windows.Forms.TextBox();
            this.BTNBuscar = new System.Windows.Forms.Button();
            this.BTNTerminar = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // Lista
            // 
            this.Lista.FormattingEnabled = true;
            this.Lista.Location = new System.Drawing.Point(24, 30);
            this.Lista.Name = "Lista";
            this.Lista.Size = new System.Drawing.Size(238, 290);
            this.Lista.TabIndex = 0;
            // 
            // JLElemento
            // 
            this.JLElemento.AutoSize = true;
            this.JLElemento.Location = new System.Drawing.Point(277, 30);
            this.JLElemento.Name = "JLElemento";
            this.JLElemento.Size = new System.Drawing.Size(54, 13);
            this.JLElemento.TabIndex = 1;
            this.JLElemento.Text = "Elemento:";
            // 
            // BTNAniadir
            // 
            this.BTNAniadir.Location = new System.Drawing.Point(280, 72);
            this.BTNAniadir.Name = "BTNAniadir";
            this.BTNAniadir.Size = new System.Drawing.Size(75, 23);
            this.BTNAniadir.TabIndex = 2;
            this.BTNAniadir.Text = "Añadir";
            this.BTNAniadir.UseVisualStyleBackColor = true;
            this.BTNAniadir.Click += new System.EventHandler(this.BTNAniadir_Click);
            // 
            // TBElemento
            // 
            this.TBElemento.Location = new System.Drawing.Point(280, 46);
            this.TBElemento.Name = "TBElemento";
            this.TBElemento.Size = new System.Drawing.Size(100, 20);
            this.TBElemento.TabIndex = 3;
            // 
            // JLBusca
            // 
            this.JLBusca.AutoSize = true;
            this.JLBusca.Location = new System.Drawing.Point(277, 119);
            this.JLBusca.Name = "JLBusca";
            this.JLBusca.Size = new System.Drawing.Size(40, 13);
            this.JLBusca.TabIndex = 4;
            this.JLBusca.Text = "Busca:";
            // 
            // TBBusca
            // 
            this.TBBusca.Location = new System.Drawing.Point(280, 135);
            this.TBBusca.Name = "TBBusca";
            this.TBBusca.Size = new System.Drawing.Size(100, 20);
            this.TBBusca.TabIndex = 5;
            this.TBBusca.TextChanged += new System.EventHandler(this.textBox1_TextChanged);
            // 
            // BTNBuscar
            // 
            this.BTNBuscar.Location = new System.Drawing.Point(280, 161);
            this.BTNBuscar.Name = "BTNBuscar";
            this.BTNBuscar.Size = new System.Drawing.Size(75, 23);
            this.BTNBuscar.TabIndex = 6;
            this.BTNBuscar.Text = "Buscar";
            this.BTNBuscar.UseVisualStyleBackColor = true;
            this.BTNBuscar.Click += new System.EventHandler(this.BTNBuscar_Click);
            // 
            // BTNTerminar
            // 
            this.BTNTerminar.Location = new System.Drawing.Point(280, 297);
            this.BTNTerminar.Name = "BTNTerminar";
            this.BTNTerminar.Size = new System.Drawing.Size(75, 23);
            this.BTNTerminar.TabIndex = 7;
            this.BTNTerminar.Text = "Terminar";
            this.BTNTerminar.UseVisualStyleBackColor = true;
            this.BTNTerminar.Click += new System.EventHandler(this.BTNTerminar_Click);
            // 
            // Form1
            // 
            this.AcceptButton = this.BTNAniadir;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(452, 360);
            this.Controls.Add(this.BTNTerminar);
            this.Controls.Add(this.BTNBuscar);
            this.Controls.Add(this.TBBusca);
            this.Controls.Add(this.JLBusca);
            this.Controls.Add(this.TBElemento);
            this.Controls.Add(this.BTNAniadir);
            this.Controls.Add(this.JLElemento);
            this.Controls.Add(this.Lista);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ListBox Lista;
        private System.Windows.Forms.Label JLElemento;
        private System.Windows.Forms.Button BTNAniadir;
        private System.Windows.Forms.TextBox TBElemento;
        private System.Windows.Forms.Label JLBusca;
        private System.Windows.Forms.TextBox TBBusca;
        private System.Windows.Forms.Button BTNBuscar;
        private System.Windows.Forms.Button BTNTerminar;
    }
}

