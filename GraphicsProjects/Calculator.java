import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {
    
    // Elementos de la calculadora
    JTextField text = new JTextField();
    boolean nuevaOperacion = true;
    String operador = "";
    double operandoIzquierdo = 0; //Por ejemplo: 5 + 8 (guarda el 5)

    private Color colorTextoOriginal = Color.decode("#5382a1");

    // Constructor de la calculadora
    Calculator() {
        
        setSize(300, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Calculadora");

        //Icono
        ImageIcon icon=new ImageIcon("Proyectos_equipo/R.png");
        setIconImage(icon.getImage());

        // Layout muy flexible:
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints(); //Este objeto define las configuraciones individuales
        gbc.fill = GridBagConstraints.BOTH; //Función para repartir en toda la cuadricula adecuadamente
        gbc.weightx = 1;
        gbc.weighty = 1; //Expansión del componente
        gbc.insets = new Insets(4, 4, 4, 4); //Margenes alrededor del componente

        // Crear y configurar el JTextField
        text.setFont(new Font("Noto Sans", Font.PLAIN, 20));
        text.setHorizontalAlignment(JTextField.RIGHT);
        text.setForeground(colorTextoOriginal); // Establecer el color original del texto
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 0; //Localización
        gbc.gridy = 0;
        add(text, gbc); //Agregación al Panel

        // Crear botones y asignarles eventos
        JButton botonCE = new JButton("CE");
        botonCE.addActionListener(e -> {
            text.setText("0");
            text.setForeground(colorTextoOriginal); //restablecer el color al original
            nuevaOperacion = true;
            operador = "";
        });

        
        //Eventos
        JButton botonDivision = new JButton("÷");
        botonDivision.addActionListener(e -> operar("÷"));

        JButton botonMultiplicacion = new JButton("×");
        botonMultiplicacion.addActionListener(e -> operar("x"));

        JButton botonResta = new JButton("-");
        botonResta.addActionListener(e -> operar("-"));

        JButton botonSuma = new JButton("+");
        botonSuma.addActionListener(e -> operar("+"));

        JButton boton7 = new JButton("7");
        boton7.addActionListener(e -> agregarNumero("7"));

        JButton boton8 = new JButton("8");
        boton8.addActionListener(e -> agregarNumero("8"));

        JButton boton9 = new JButton("9");
        boton9.addActionListener(e -> agregarNumero("9"));

        JButton boton4 = new JButton("4");
        boton4.addActionListener(e -> agregarNumero("4"));

        JButton boton5 = new JButton("5");
        boton5.addActionListener(e -> agregarNumero("5"));

        JButton boton6 = new JButton("6");
        boton6.addActionListener(e -> agregarNumero("6"));

        JButton boton1 = new JButton("1");
        boton1.addActionListener(e -> agregarNumero("1"));

        JButton boton2 = new JButton("2");
        boton2.addActionListener(e -> agregarNumero("2"));

        JButton boton3 = new JButton("3");
        boton3.addActionListener(e -> agregarNumero("3"));

        JButton boton0 = new JButton("0");
        boton0.addActionListener(e -> agregarNumero("0"));

        JButton botonPunto = new JButton(".");
        botonPunto.addActionListener(e -> text.setText(text.getText() + botonPunto.getText()));

        JButton botonIgual = new JButton("=");
        botonIgual.addActionListener(e -> realizarOperacion());

        JButton botonEliminar = new JButton("↩");
        botonEliminar.addActionListener(e -> {
            String textoActual = text.getText(); //Obtenemos el texto actual(Numero)
            if (textoActual.length() > 1) { //Si tiene más de un caracter procedemos a borrar de derecha a izquierda
                text.setText(textoActual.substring(0, textoActual.length() - 1)); 
            } else {
                text.setText("0"); 
            }
        });

        text.setText("0");

        // Aplicar estilo a los botones
        aplicarEstilo(botonCE);
        aplicarEstilo(botonDivision);
        aplicarEstilo(botonMultiplicacion);
        aplicarEstilo(botonResta);
        aplicarEstilo(botonSuma);
        aplicarEstilo(boton7);
        aplicarEstilo(boton8);
        aplicarEstilo(boton9);
        aplicarEstilo(boton4);
        aplicarEstilo(boton5);
        aplicarEstilo(boton6);
        aplicarEstilo(boton1);
        aplicarEstilo(boton2);
        aplicarEstilo(boton3);
        aplicarEstilo(boton0);
        aplicarEstilo(botonPunto);
        aplicarEstilo(botonIgual);
        aplicarEstilo(botonEliminar);

        // Ubicar los botones en la ventana
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        add(botonCE, gbc);

        gbc.gridx = 1;
        add(botonDivision, gbc);

        gbc.gridwidth = 2;
        gbc.gridx = 2;
        add(botonEliminar, gbc);  //Boton Eliminar

        gbc.gridwidth = 1;
        gbc.gridy = 2;
        gbc.gridx = 0;
        add(boton7, gbc);

        gbc.gridx = 1;
        add(boton8, gbc);

        gbc.gridx = 2;
        add(boton9, gbc);

        gbc.gridx = 3;
        add(botonSuma, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        add(boton4, gbc);

        gbc.gridx = 1;
        add(boton5, gbc);

        gbc.gridx = 2;
        add(boton6, gbc);

        gbc.gridx = 3;
        add(botonResta, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        add(boton1, gbc);

        gbc.gridx = 1;
        add(boton2, gbc);

        gbc.gridx = 2;
        add(boton3, gbc);

        gbc.gridx = 3;
        add(botonMultiplicacion, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        add(boton0, gbc);

        gbc.gridx = 1;
        add(botonPunto, gbc);

        gbc.gridwidth = 2;  //Boton "="
        gbc.gridx = 2;
        add(botonIgual, gbc);
        gbc.gridwidth = 1;

        setVisible(true);
    }
    

    // Método para aplicar estilo a los botones
    private void aplicarEstilo(JButton boton) {
        boton.setFont(new Font("Noto Sans", Font.PLAIN, 22));
        Color fondo = Color.decode("#5382a1");
        Color texto = Color.decode("#FFFFFF");
        boton.setBackground(fondo);
        boton.setForeground(texto);
    }


    
    // Método para manejar operadores
    private void operar(String operadorActual) {
        
        if (!nuevaOperacion) { //Si no se está realizando una operacion, llamamos al metodo realizarOperacion()
            realizarOperacion();
        }
        operador = operadorActual;  
        operandoIzquierdo = Double.parseDouble(text.getText()); //Parseamos el simbolo y lo guardamos 
        text.setText("0");
        nuevaOperacion = true;  //Cuando se ha obtenido el primer operando, se procede al método realizarOperacion()
    }

    // Método para manejar los números
    private void agregarNumero(String valor) {
        // Si es una nueva operación o el texto actual es "0", reemplaza el texto con el nuevo valor
        if (nuevaOperacion || text.getText().equals("0")) {
            text.setText(valor);
            nuevaOperacion = false;
        } else {
            // Si el texto no es "0", simplemente añade el valor al texto existente
            text.setText(text.getText() + valor);
        }
    }
    

    // Método para realizar las operaciones básicas
    private void realizarOperacion() {
        try {
            String textoActual = text.getText(); //Obtenemos el número actual del JTextField (5 + 3)  |3|
            if (!textoActual.isEmpty() && !operador.isEmpty()) {  //Que haya un operador y un numero por lo menos ingresado
                double operandoDerecho = Double.parseDouble(textoActual); //Convertimos el numero actual a Double |3.0|
                double resultado = operandoIzquierdo; //Guardamos el numero izquierdo por el resultado (5 + 3)  |5.0|

                switch (operador) { //De acuerdo al operando, se determinará su operación
                    case "+":
                        resultado += operandoDerecho;
                        break;
                    case "-":
                        resultado -= operandoDerecho;
                        break;
                    case "x":
                        resultado *= operandoDerecho;
                        break;
                    case "÷":
                        if (operandoDerecho != 0) { //En caso de la división entre cero, tirar Error
                            resultado /= operandoDerecho;
                        } else {
                            text.setText("Error");
                            text.setForeground(Color.red);
                            nuevaOperacion = true;
                            operador = "";
                            return;
                        }
                        break;
                }

                text.setText(String.valueOf(resultado)); //Finalmente convertimos a String el resultado
                text.setForeground(colorTextoOriginal);
                nuevaOperacion = true; //Operación finalizada
                operador = "";  
            }
        } catch (NumberFormatException e) {
            text.setText("Error");
            text.setForeground(Color.red);
        }
    }

    // Método principal para ejecutar la calculadora
    public static void main(String[] args) {
        new Calculator();
    }
}