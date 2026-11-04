using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace UD2_Tarea1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void btnMostrar_Click(object sender, EventArgs e)
        {
            String nombre = "";
            int edad = 0;


            Console.WriteLine("hola, me llamo {0} y tengo {1} años", nombre, edad);
        }

        private void textbox_TextChanged(object sender, EventArgs e)
        {

        }

        private void btnaniador_Click(object sender, EventArgs e)
        {
            listBox1.Items.Clear();
        }

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            textbox.Text = listBox1.SelectedItem.ToString();
        }

        private void listBox1_KeyDown(object sender, KeyEventArgs e)
        {
           if (e.KeyCode == Keys.Delete)
            {
                if (listBox1.SelectedIndex != -1)
                {
                    for (int i = 0; i < listBox1.Items.Count; i++)
                    {
                       listBox1.Items.Remove(listBox1.SelectedItems[i]);
                    }
                }
            }
        }
    }
}
