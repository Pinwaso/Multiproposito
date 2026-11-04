using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

/*
 en los botones de añadir y eliminar, se puede usar el evento KeyDown para detectar 
la tecla "Delete" y eliminar el elemento seleccionado en la lista.
 */

/*
 en el formulario se pueede usar autoscroll para que aparezca una barra de 
desplazamiento cuando la lista de nombres sea más grande que el área visible del ListBox.
 */

/*
 en el label con keydown se puede usar el evento KeyDown para detectar 
la tecla "Enter" y añadir el texto del TextBox a la lista de nombres.
 */

namespace Win_HolaMundo
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            // Registrar el manejador para el evento Load del formulario
            this.Load += new EventHandler(this.Form1_Load);
        }

        private void Form1_Load(Object sender, EventArgs e)
        {
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void Botoncerrar_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            // Evitar NullReferenceException cuando no hay elemento seleccionado
            if (listnombres.SelectedItem != null)
            {
                MessageBox.Show("seleccionado: " + listnombres.SelectedItem.ToString());
            }
        }

        private void Botonaniadir_Click(object sender, EventArgs e)
        {
            listnombres.Items.Add(textBox1.Text);
            textBox1.Clear();
        }

        private void listnombres_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Delete)
            {
                if (listnombres.SelectedIndex != -1)
                {
                    listnombres.Items.RemoveAt(listnombres.SelectedIndex);
                }
            }
        }
    }
}
