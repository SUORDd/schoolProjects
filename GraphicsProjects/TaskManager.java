import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class TaskManager extends JFrame {
    private JTextField campoTituloTarea; 
    private JTextArea campoDescripcionTarea;
    private JComboBox<String> comboPrioridad;
    private JSlider deslizadorProgreso;
    private JTable tablaTareas;
    private DefaultTableModel modeloTabla;
    private JLabel etiquetaProgreso;
    private JLabel mensajeNoTareas;

    public TaskManager() {
        ImageIcon icon = new ImageIcon("like.jpg");
        setIconImage(icon.getImage());
        setTitle("Gestor de Tareas");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel panelEntrada = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints(); 
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        panelEntrada.add(new JLabel("Título de la Tarea: "), gbc);
        campoTituloTarea = new JTextField(30);
        gbc.gridx = 1; gbc.gridwidth = 3;
        panelEntrada.add(campoTituloTarea, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panelEntrada.add(new JLabel("Descripción: "), gbc);
        campoDescripcionTarea = new JTextArea(3, 30);
        JScrollPane scrollDescripcion = new JScrollPane(campoDescripcionTarea);
        gbc.gridx = 1; gbc.gridwidth = 3;
        panelEntrada.add(scrollDescripcion, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panelEntrada.add(new JLabel("Prioridad: "), gbc);
        comboPrioridad = new JComboBox<>(new String[]{"Baja", "Media", "Alta"});
        gbc.gridx = 1; gbc.gridwidth = 1;
        panelEntrada.add(comboPrioridad, gbc);

        gbc.gridx = 2; gbc.gridy = 2;
        panelEntrada.add(new JLabel("Progreso: "), gbc);
        deslizadorProgreso = new JSlider(0, 100, 0);
        deslizadorProgreso.setMajorTickSpacing(10);
        deslizadorProgreso.setPaintTicks(true);
        deslizadorProgreso.setPaintLabels(true);
        gbc.gridx = 3; gbc.gridwidth = 1;
        panelEntrada.add(deslizadorProgreso, gbc);

        etiquetaProgreso = new JLabel("0%");
        gbc.gridx = 4; gbc.gridwidth = 1;
        panelEntrada.add(etiquetaProgreso, gbc);

        deslizadorProgreso.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int valor = deslizadorProgreso.getValue();
                etiquetaProgreso.setText(valor + "%");
            }
        });

        add(panelEntrada, BorderLayout.NORTH);

        modeloTabla = new DefaultTableModel(new Object[]{"No.", "Título", "Descripción", "Prioridad", "Progreso", "Editar"}, 0);
        tablaTareas = new JTable(modeloTabla) {
            public boolean isCellEditable(int row, int column) {
                return column == 5; // Solo la columna "Editar" es editable
            }
        };

        // Configuración de las columnas
        TableColumnModel columnModel = tablaTareas.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(40);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(300);
        columnModel.getColumn(3).setPreferredWidth(80);
        columnModel.getColumn(4).setPreferredWidth(80);
        columnModel.getColumn(5).setPreferredWidth(80);

        // Asignar el renderizador de colores a la columna de Prioridad
        tablaTareas.getColumnModel().getColumn(3).setCellRenderer(new ColorPrioridad());

        tablaTareas.getColumn("Editar").setCellRenderer(new ButtonRenderer());
        tablaTareas.getColumn("Editar").setCellEditor(new ButtonEditor(new JCheckBox()));

        JPanel panelTabla = new JPanel(new BorderLayout());
        panelTabla.add(new JScrollPane(tablaTareas), BorderLayout.CENTER);

        mensajeNoTareas = new JLabel("Aún no hay tareas", SwingConstants.CENTER);
        mensajeNoTareas.setForeground(Color.GRAY);
        panelTabla.add(mensajeNoTareas, BorderLayout.NORTH);
        add(panelTabla, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        JButton botonAgregar = new JButton("Agregar Tarea");
        botonAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarTarea();
            }
        });
        panelBotones.add(botonAgregar);

        JButton botonBorrar = new JButton("Borrar");
        botonBorrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                borrarTarea();
            }
        });
        panelBotones.add(botonBorrar);
        
        JPanel panelCerrar = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton botonCerrar = new JButton("Cerrar");
        botonCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panelCerrar.add(botonCerrar);

        JPanel panelInferior = new JPanel(new BorderLayout());
        panelInferior.add(panelBotones, BorderLayout.WEST);
        panelInferior.add(panelCerrar, BorderLayout.EAST);
        add(panelInferior, BorderLayout.SOUTH);
        
        setVisible(true);
    }

    private void actualizarNumerosDeTareas() {
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            modeloTabla.setValueAt(i + 1, i, 0);
        }
    }

    private void agregarTarea() {
        String titulo = campoTituloTarea.getText();
        String descripcion = campoDescripcionTarea.getText();
        String prioridad = (String) comboPrioridad.getSelectedItem();
        int progreso = deslizadorProgreso.getValue();

        if (!titulo.isEmpty() && !descripcion.isEmpty()) {
            modeloTabla.addRow(new Object[]{null, titulo, descripcion, prioridad, progreso + "%", "..."}); 
            limpiarCampos();
            mensajeNoTareas.setVisible(false);
            actualizarNumerosDeTareas();
        } else {
            JOptionPane.showMessageDialog(this, "Título y descripción no pueden estar vacíos.");
        }
    }

    private void borrarTarea() {
        int filaSeleccionada = tablaTareas.getSelectedRow();
        if (filaSeleccionada != -1) {
            modeloTabla.removeRow(filaSeleccionada);
            if (modeloTabla.getRowCount() == 0) {
                mensajeNoTareas.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una tarea para borrar.");
        }
    }

    private void limpiarCampos() {
        campoTituloTarea.setText("");
        campoDescripcionTarea.setText("");
        deslizadorProgreso.setValue(0);
    }

    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText("...");
            setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {
        private JButton boton;
        private boolean isPushed;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            boton = new JButton("...");
            boton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (isPushed) {
                        int filaSeleccionada = tablaTareas.getSelectedRow();
                        if (filaSeleccionada != -1) {
                            editarTarea(filaSeleccionada);
                        }
                    }
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            isPushed = true;
            return boton;
        }

        public Object getCellEditorValue() {
            isPushed = false;
            return "...";
        }

        private void editarTarea(int filaSeleccionada) {
            String titulo = (String) modeloTabla.getValueAt(filaSeleccionada, 1);
            String descripcion = (String) modeloTabla.getValueAt(filaSeleccionada, 2);
            String prioridad = (String) modeloTabla.getValueAt(filaSeleccionada, 3);
            String progresoStr = (String) modeloTabla.getValueAt(filaSeleccionada, 4);
            int progreso = Integer.parseInt(progresoStr.replace("%", "").trim());

            campoTituloTarea.setText(titulo);
            campoDescripcionTarea.setText(descripcion);
            comboPrioridad.setSelectedItem(prioridad);
            deslizadorProgreso.setValue(progreso);

            modeloTabla.removeRow(filaSeleccionada);
        }
    }

    //Acabado de colores
    class ColorPrioridad extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            String prioridad = (String) value;
            if (prioridad.equals("Baja")) {
                cell.setBackground(Color.GREEN);
            } else if (prioridad.equals("Media")) {
                cell.setBackground(Color.YELLOW);
            } else if (prioridad.equals("Alta")) {
                cell.setBackground(Color.RED);
            }
            if (isSelected) {
                cell.setBackground(table.getSelectionBackground());
            } else {
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    public static void main(String[] args) {
        new TaskManager();
    }
}
