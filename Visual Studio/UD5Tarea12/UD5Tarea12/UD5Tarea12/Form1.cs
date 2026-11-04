using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace UD5Tarea12
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }
        //boton para añadir un elemento a la lista
        private void BTNAniadir_Click(object sender, EventArgs e)
        {
            Lista.Items.Add(TBElemento.Text);
            TBElemento.Clear();
        }

        private void BTNTerminar_Click(object sender, EventArgs e)
        {
            this.Close();
        }
        //boton para buscar un elemento en la lista
        private void BTNBuscar_Click(object sender, EventArgs e)
        {
            if (TBBusca.Text != "")
            {
                //variables para guardar la palabra y el indice del elemento encontrado
                String palabra = "";
                int indice = -1;
                //bucle para recorrer la lista y buscar el elemento
                for (int i = 0; i < Lista.Items.Count; i++)
                {
                    //comparar el elemento de la lista con el texto del textbox ignorando mayusculas y minusculas
                    if (Lista.Items[i].ToString().Equals(TBBusca.Text, StringComparison.OrdinalIgnoreCase))
                    {
                        palabra = Lista.Items[i].ToString();
                        indice = i;
                        break;
                    }
                }
                //si se encuentra el elemento, se muestra un mensaje con la posicion del elemento en la lista
                if (palabra.Equals(TBBusca.Text, StringComparison.OrdinalIgnoreCase))
                {
                    //seleccionar el elemento encontrado en la lista
                    Lista.SelectedIndex = indice;
                    //mostrar mensaje con la posicion del elemento encontrado
                    MessageBox.Show("Elemento encontrado en la lista en la posicion " + (indice + 1));
                }
                else
                {
                    MessageBox.Show("Elemento no encontrado en la lista");
                }
            }
        }
    }
}
