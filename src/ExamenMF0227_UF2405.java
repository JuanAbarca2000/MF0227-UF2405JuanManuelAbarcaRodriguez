import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ExamenMF0227_UF2405 {
    private JComboBox<String> boxColor; // Cuadro combinado para seleccionar el color
    private JRadioButton rbtnAmarillo;
    private JRadioButton rbtnBlanco;
    private JRadioButton rbtnRosa;
    private JButton btnPulsar; // Botón "Pulsa"
    private JTextField txtPulsar; // Cuadro de texto
    private JCheckBox checkBloqueado; // Casilla de verificación "Bloqueado"
    private JLabel lblColortxt;
    private JLabel lblFondoColor;
    private JPanel panelBotones;
    private JPanel panelVentana;
    private JTextField textField1;

    public ExamenMF0227_UF2405() {
        // Configurar el título de la ventana
        JFrame frame = new JFrame("EXAMEN MF0227 - UF2405");

        // Añadir un ActionListener a los botones de color de fondo (rbtnAmarillo, rbtnBlanco, rbtnRosa)
        rbtnAmarillo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtPulsar.setBackground(Color.YELLOW); // Cambiar a color amarillo
            }
        });

        rbtnBlanco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtPulsar.setBackground(Color.WHITE); // Cambiar a color blanco
            }
        });

        rbtnRosa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtPulsar.setBackground(Color.PINK); // Cambiar a color rosa
            }
        });

        // BotonGroup para los botones
        ButtonGroup grupoBotones = new ButtonGroup();
        grupoBotones.add(rbtnAmarillo);
        grupoBotones.add(rbtnBlanco);
        grupoBotones.add(rbtnRosa);

        // Seleccionar el botón de opción "Blanco" al inicio
        rbtnBlanco.setSelected(true);

        // Bloquear el cuadro de texto al inicio
        txtPulsar.setEditable(false);

        // Activar la casilla de verificación "Bloqueado" al inicio
        checkBloqueado.setSelected(true);

        // Asegurar que las etiquetas estén en negrita
        lblColortxt.setFont(lblColortxt.getFont().deriveFont(Font.BOLD));
        lblFondoColor.setFont(lblFondoColor.getFont().deriveFont(Font.BOLD));

        // Añadir un ActionListener al cuadro combinado
        btnPulsar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarColorTexto(); // Cambiar el color del texto
            }
        });

        // Añadir un ActionListener al botón "Pulsa"
        btnPulsar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar un cuadro de diálogo de entrada para preguntar el nombre
                String nombre = JOptionPane.showInputDialog(frame, "Introduce tu nombre:", "Nombre", JOptionPane.QUESTION_MESSAGE);

                // Si el usuario introduce un nombre, mostrarlo en el cuadro de texto
                if (nombre != null && !nombre.trim().isEmpty()) {
                    txtPulsar.setText(nombre); // Mostrar el nombre en el cuadro de texto
                } else {
                    txtPulsar.setText("No has introducido un nombre."); // Mensaje si no se introduce nada
                }
            }
        });

        // Añadir un ItemListener a la casilla de verificación "Bloqueado"
        checkBloqueado.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // Si la casilla está seleccionada, bloquear el cuadro de texto
                    txtPulsar.setEditable(false);
                } else {
                    // Si la casilla no está seleccionada, desbloquear el cuadro de texto
                    txtPulsar.setEditable(true);
                    txtPulsar.selectAll(); // Seleccionar todo el texto
                    txtPulsar.requestFocus(); // Dar foco al cuadro de texto
                }
            }
        });
        // Añadir un ItemListener al cuadro combinado para cambiar el color del texto automáticamente
        boxColor.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    cambiarColorTexto(); // Cambiar el color del texto
                }
            }
        });

        // Añadir el panel de la ventana al frame
        frame.setContentPane(panelVentana);

        // Configurar la operación de cierre
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Ajustar el tamaño de la ventana según su contenido
        frame.pack();

        // Centrar la ventana en la pantalla
        frame.setLocationRelativeTo(null);

        // Hacer visible la ventana
        frame.setVisible(true);
    }



    // Método para cambiar el color del texto según la selección del cuadro combinado
    private void cambiarColorTexto() {
        String colorSeleccionado = (String) boxColor.getSelectedItem(); // Obtener el color seleccionado

        switch (colorSeleccionado) {
            case "Negro":
                txtPulsar.setForeground(Color.BLACK); // Cambiar a color negro
                break;
            case "Rojo":
                txtPulsar.setForeground(Color.RED); // Cambiar a color rojo
                break;
            case "Verde":
                txtPulsar.setForeground(Color.GREEN); // Cambiar a color verde
                break;
            case "Azul":
                txtPulsar.setForeground(Color.BLUE); // Cambiar a color azul
                break;
            default:
                txtPulsar.setForeground(Color.BLACK); // Por defecto, color negro
                break;
        }
    }

    public static void main(String[] args) {
        // Crear y mostrar la ventana
        new ExamenMF0227_UF2405();
    }
}