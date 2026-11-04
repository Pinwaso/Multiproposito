using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Tarea1
{
    public partial class Ejercicio3 : Form
    {
        public Ejercicio3()
        {
            InitializeComponent();
        }

        private void aniadir_Click(object sender, EventArgs e)
        {

        }

        private void Aniadirboton_Click(object sender, EventArgs e)
        {
            // No ejecutar lógica en tiempo de diseño
            if (System.ComponentModel.LicenseManager.UsageMode == System.ComponentModel.LicenseUsageMode.Designtime)
                return;

            // Añadir el texto de textBox1 a la lista Slida y limpiar el textbox
            var texto = this.textBox1.Text;
            if (!string.IsNullOrWhiteSpace(texto))
            {
                this.Slida.Items.Add(texto);
            }
            this.textBox1.Clear();
        }

        private void Terminar_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void Ejercicio3_Load(object sender, EventArgs e)
        {

        }

        private void Slida_SelectedIndexChanged(object sender, EventArgs e)
        {
            // No ejecutar lógica en tiempo de diseño
            if (System.ComponentModel.LicenseManager.UsageMode == System.ComponentModel.LicenseUsageMode.Designtime)
                return;

            // Mostrar el elemento seleccionado en textBox2
            if (this.Slida.SelectedItem != null)
            {
                this.textBox2.Text = this.Slida.SelectedItem.ToString();
            }
            else
            {
                this.textBox2.Clear();
            }
        }

        private void Eliminar_Click(object sender, EventArgs e)
        {
            // No ejecutar lógica en tiempo de diseño
            if (System.ComponentModel.LicenseManager.UsageMode == System.ComponentModel.LicenseUsageMode.Designtime)
                return;

            // Eliminar el elemento seleccionado de la lista y limpiar textBox2
            int idx = this.Slida.SelectedIndex;
            if (idx >= 0 && idx < this.Slida.Items.Count)
            {
                this.Slida.Items.RemoveAt(idx);
            }
            this.textBox2.Clear();
        }

        private void EliminarTodo_Click(object sender, EventArgs e)
        {
            // No ejecutar lógica en tiempo de diseño
            if (System.ComponentModel.LicenseManager.UsageMode == System.ComponentModel.LicenseUsageMode.Designtime)
                return;

            // Vaciar la lista y limpiar textBox2
            this.Slida.Items.Clear();
            this.textBox2.Clear();
        }

    }
}
