namespace Tarea1
{
    partial class Ejercicio3
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
            this.Grupo = new System.Windows.Forms.GroupBox();
            this.Slida = new System.Windows.Forms.ListBox();
            this.EliminarTodo = new System.Windows.Forms.Button();
            this.Eliminar = new System.Windows.Forms.Button();
            this.textBox2 = new System.Windows.Forms.TextBox();
            this.seleccioando = new System.Windows.Forms.Label();
            this.Aniadirboton = new System.Windows.Forms.Button();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.aniadir = new System.Windows.Forms.Label();
            this.Terminar = new System.Windows.Forms.Button();
            this.Grupo.SuspendLayout();
            this.SuspendLayout();
            // 
            // Grupo
            // 
            this.Grupo.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.Grupo.Controls.Add(this.Slida);
            this.Grupo.Controls.Add(this.EliminarTodo);
            this.Grupo.Controls.Add(this.Eliminar);
            this.Grupo.Controls.Add(this.textBox2);
            this.Grupo.Controls.Add(this.seleccioando);
            this.Grupo.Controls.Add(this.Aniadirboton);
            this.Grupo.Controls.Add(this.textBox1);
            this.Grupo.Controls.Add(this.aniadir);
            this.Grupo.Location = new System.Drawing.Point(12, 12);
            this.Grupo.Name = "Grupo";
            this.Grupo.Size = new System.Drawing.Size(334, 242);
            this.Grupo.TabIndex = 0;
            this.Grupo.TabStop = false;
            this.Grupo.Text = "Grupo";
            // 
            // Slida
            // 
            this.Slida.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.Slida.FormattingEnabled = true;
            this.Slida.Location = new System.Drawing.Point(6, 16);
            this.Slida.Name = "Slida";
            this.Slida.Size = new System.Drawing.Size(190, 212);
            this.Slida.TabIndex = 7;
            this.Slida.SelectedIndexChanged += new System.EventHandler(this.Slida_SelectedIndexChanged);
            // 
            // EliminarTodo
            // 
            this.EliminarTodo.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.EliminarTodo.Location = new System.Drawing.Point(205, 181);
            this.EliminarTodo.Name = "EliminarTodo";
            this.EliminarTodo.Size = new System.Drawing.Size(123, 23);
            this.EliminarTodo.TabIndex = 6;
            this.EliminarTodo.Text = "Eliminar todos";
            this.EliminarTodo.UseVisualStyleBackColor = true;
            this.EliminarTodo.Click += new System.EventHandler(this.EliminarTodo_Click);
            // 
            // Eliminar
            // 
            this.Eliminar.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.Eliminar.Location = new System.Drawing.Point(205, 152);
            this.Eliminar.Name = "Eliminar";
            this.Eliminar.Size = new System.Drawing.Size(123, 23);
            this.Eliminar.TabIndex = 5;
            this.Eliminar.Text = "Eliminar seleccionado";
            this.Eliminar.UseVisualStyleBackColor = true;
            this.Eliminar.Click += new System.EventHandler(this.Eliminar_Click);
            // 
            // textBox2
            // 
            this.textBox2.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.textBox2.Location = new System.Drawing.Point(205, 100);
            this.textBox2.Name = "textBox2";
            this.textBox2.Size = new System.Drawing.Size(123, 20);
            this.textBox2.TabIndex = 4;
            // 
            // seleccioando
            // 
            this.seleccioando.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.seleccioando.AutoSize = true;
            this.seleccioando.Location = new System.Drawing.Point(202, 84);
            this.seleccioando.Name = "seleccioando";
            this.seleccioando.Size = new System.Drawing.Size(102, 13);
            this.seleccioando.TabIndex = 3;
            this.seleccioando.Text = "Seleccionado ahora";
            // 
            // Aniadirboton
            // 
            this.Aniadirboton.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.Aniadirboton.Location = new System.Drawing.Point(205, 58);
            this.Aniadirboton.Name = "Aniadirboton";
            this.Aniadirboton.Size = new System.Drawing.Size(123, 23);
            this.Aniadirboton.TabIndex = 2;
            this.Aniadirboton.Text = "Añadir";
            this.Aniadirboton.UseVisualStyleBackColor = true;
            this.Aniadirboton.Click += new System.EventHandler(this.Aniadirboton_Click);
            // 
            // textBox1
            // 
            this.textBox1.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.textBox1.Location = new System.Drawing.Point(205, 32);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(123, 20);
            this.textBox1.TabIndex = 1;
            // 
            // aniadir
            // 
            this.aniadir.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.aniadir.AutoSize = true;
            this.aniadir.Location = new System.Drawing.Point(202, 16);
            this.aniadir.Name = "aniadir";
            this.aniadir.Size = new System.Drawing.Size(37, 13);
            this.aniadir.TabIndex = 0;
            this.aniadir.Text = "Añadir";
            this.aniadir.Click += new System.EventHandler(this.aniadir_Click);
            // 
            // Terminar
            // 
            this.Terminar.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.Terminar.Location = new System.Drawing.Point(217, 260);
            this.Terminar.Name = "Terminar";
            this.Terminar.Size = new System.Drawing.Size(129, 23);
            this.Terminar.TabIndex = 1;
            this.Terminar.Text = "Terminar programa";
            this.Terminar.UseVisualStyleBackColor = true;
            this.Terminar.Click += new System.EventHandler(this.Terminar_Click);
            // 
            // Ejercicio3
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(358, 335);
            this.Controls.Add(this.Terminar);
            this.Controls.Add(this.Grupo);
            this.Name = "Ejercicio3";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Ejercicio3_Load);
            this.Grupo.ResumeLayout(false);
            this.Grupo.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.GroupBox Grupo;
        private System.Windows.Forms.Button EliminarTodo;
        private System.Windows.Forms.Button Eliminar;
        private System.Windows.Forms.TextBox textBox2;
        private System.Windows.Forms.Label seleccioando;
        private System.Windows.Forms.Button Aniadirboton;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.Label aniadir;
        private System.Windows.Forms.ListBox Slida;
        private System.Windows.Forms.Button Terminar;
    }
}