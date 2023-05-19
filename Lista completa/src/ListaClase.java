import java.util.ArrayList;
import java.util.List;

public class ListaClase extends javax.swing.JFrame {

    private List<String> lista; // Lista para almacenar los textos ingresados

    public ListaClase() {
        initComponents();
        lista = new ArrayList<>(); // Inicialización de la lista en el constructor
    }

    private void initComponents() {
        // Inicialización de los componentes de la interfaz de usuario

        txtNombre = new javax.swing.JTextField(); // Cuadro de texto para ingresar el nombre
        etqNombre = new javax.swing.JLabel(); // Etiqueta "Nombre"
        btnAgregar = new javax.swing.JButton(); // Botón "Agregar"
        btnQuitar = new javax.swing.JButton(); // Botón "Quitar"
        panPanel = new javax.swing.JPanel(); // Panel para mostrar la lista
        etqLista = new javax.swing.JLabel(); // Etiqueta para mostrar la lista
        etqTitulo = new javax.swing.JLabel(); // Etiqueta "Lista de clase"

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        etqNombre.setText("Nombre");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnQuitar.setText("Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        etqLista.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        etqTitulo.setText("Lista de clase");

        javax.swing.GroupLayout panPanelLayout = new javax.swing.GroupLayout(panPanel);
        panPanel.setLayout(panPanelLayout);
        panPanelLayout.setHorizontalGroup(
            panPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etqLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etqTitulo)
                .addContainerGap(149, Short.MAX_VALUE))
        );
        panPanelLayout.setVerticalGroup(
            panPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(etqTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(etqLista, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etqNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuitar)))
                .addGap(18, 18, 18)
                .addComponent(panPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etqNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnQuitar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {
        // Acción al hacer clic en el botón "Agregar"
        String texto = txtNombre.getText();

        if (!texto.isEmpty() && !lista.contains(texto)) {
            lista.add(texto); // Agrega el texto a la lista si no está vacío ni duplicado
            actualizarEtiquetaLista(); // Actualiza la etiqueta que muestra la lista
        }

        txtNombre.setText(""); // Limpia el cuadro de texto después de agregar el texto a la lista
    }

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {
        // Acción al hacer clic en el botón "Quitar"
        if (!lista.isEmpty()) {
            lista.remove(lista.size() - 1); // Elimina el último texto ingresado de la lista
            actualizarEtiquetaLista(); // Actualiza la etiqueta que muestra la lista
        }

        txtNombre.setText(""); // Limpia el cuadro de texto después de quitar el texto de la lista
    }

    private void actualizarEtiquetaLista() {
        // Actualiza la etiqueta que muestra la lista en formato vertical
        StringBuilder sb = new StringBuilder();

        for (String elemento : lista) {
            sb.append(elemento).append("<br>");
        }

        etqLista.setText("<html>" + sb.toString() + "</html>");
    }

    public static void main(String args[]) {
        // Ejecuta la aplicación
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaClase().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JLabel etqLista;
    private javax.swing.JLabel etqNombre;
    private javax.swing.JLabel etqTitulo;
    private javax.swing.JPanel panPanel;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration
}
