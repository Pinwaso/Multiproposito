using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace UD6Calculadora
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        //boton para calcular
        private void btncalcular_Click(object sender, EventArgs e)
        {
            if (textparametro1.Text == "" || textparametro2.Text == "" || combooperacion.Text == "")
            {
                MessageBox.Show("Debe introducir un número en cada campo");
            }
            else
            {
                double num1 = Convert.ToDouble(textparametro1.Text);
                double num2 = Convert.ToDouble(textparametro2.Text);
                double resultado = 0;
                String operacion = combooperacion.SelectedItem.ToString();
                switch (operacion)
                {
                    case "+":
                        resultado = num1 + num2;
                        textresltado.Text = resultado.ToString();
                        break;
                    case "-":
                        resultado = num1 - num2;
                        textresltado.Text = resultado.ToString();
                        break;
                    case "*":
                        resultado = num1 * num2;
                        textresltado.Text = resultado.ToString();
                        break;
                    case "/":
                        if (num2 != 0)
                        {
                            resultado = num1 / num2;
                            textresltado.Text = resultado.ToString();
                        }
                        else
                        {
                            MessageBox.Show("No se puede dividir entre cero");
                            return;
                        }
                        break;
                }
            }
        }
    }
}
