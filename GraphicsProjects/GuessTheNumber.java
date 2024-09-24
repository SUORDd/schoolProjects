import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuessTheNumber extends JFrame{
    public static void main(String[] args) {
        new GuessTheNumber();
    }
    
    final int numeroAdivinar = (int) (Math.random() * 100) + 1; // Número aleatorio entre 1 y 100
    int intentos = 0;
    int maxIntentos = 10;
    
    private GuessTheNumber() {
        //Estructura de ventana
        setTitle("Adivina el número");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(250, 150);
        setLocationRelativeTo(null);

            //Estructura del panel
            JPanel panel = new JPanel(); 
            JLabel label = new JLabel("Ingresa un número entre el 1 y el 100", JLabel.CENTER);
            label.setFont(new Font ("Open Sans",Font.BOLD,13 ));
            JTextField textfield = new JTextField(5);
            JButton button = new JButton("Adivinar");
            JLabel resultado = new JLabel(" ", JLabel.CENTER); // Etiqueta para mostrar mensajes de resultado
            
            //Alt+Enter para ingresar otro numero
            button.setMnemonic(KeyEvent.VK_ENTER);
            panel.add(label);
            panel.add(textfield);
            panel.add(button);
            panel.add(resultado); // Añadir la etiqueta de resultado al panel
            resultado.setForeground(Color.BLUE);

            add(panel, BorderLayout.CENTER);

            //botón "Adivinar"
            button.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    String input = textfield.getText();
                    try {
                        int numeroIngresado = Integer.parseInt(input);

                        if (numeroIngresado < 1 || numeroIngresado > 100) {
                            resultado.setText("Número fuera de rango. Intenta de nuevo.");
                            resultado.setForeground(Color.RED);
                        } else {
                            intentos++;
                            if (numeroIngresado == numeroAdivinar) {
                                resultado.setText(" ¡Felicidades! Adivinaste el número ");
                                resultado.setForeground(Color.GREEN);
                                button.setEnabled(false); // Deshabilita el botón si se adivina el número
                            } else if (intentos >= maxIntentos) {
                                resultado.setText(" Se acabaron los intentos. El número era: " + numeroAdivinar);
                                resultado.setForeground(Color.red);
                                button.setEnabled(false); // Deshabilita el botón si se acaban los intentos (10)
                            } else if (numeroIngresado < numeroAdivinar) {
                                resultado.setText("El número es mayor. Intentos restantes: " + (maxIntentos - intentos));
                            } else {
                                resultado.setText("El número es menor. Intentos restantes: " + (maxIntentos - intentos));
                            }
                        }

                        // Limpiar el campo de texto
                        textfield.setText("");
                        
                        //agregar que se coloque el cursor 
                        textfield.requestFocusInWindow();

                    } catch (NumberFormatException ex) {
                        resultado.setText("Por favor, ingresa un número válido.");
                        resultado.setForeground(Color.RED);
                        // Limpiar el campo de texto
                        textfield.setText("");
                    }
                }
            });

            setVisible(true);
        }

        
}