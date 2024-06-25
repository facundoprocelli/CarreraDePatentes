package org.example.GUI;

    import javax.swing.*;
import java.awt.*;

    public class ErrorPopUp extends JDialog {
        private JLabel messageLabel;

        public ErrorPopUp(Frame parent, String message) {
            super(parent, "Error", true);
            setUndecorated(true);
            setLayout(new BorderLayout());

            // Panel principal con color de fondo personalizado
            JPanel panel = new JPanel();
            panel.setBackground(new Color(0, 36, 194));
            panel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
            panel.setLayout(new BorderLayout());

            // Label para el mensaje de error
            messageLabel = new JLabel(message, JLabel.CENTER);
            messageLabel.setForeground(Color.WHITE);
            messageLabel.setFont(new Font("Yu Gothic", Font.BOLD, 14));

            // Botón de cierre
            JButton closeButton = new JButton("Cerrar");
            closeButton.setForeground(Color.BLACK);
            closeButton.setBackground(new Color(252,252,252));
            closeButton.setFocusPainted(false);
            //closeButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
            closeButton.addActionListener(e -> dispose());

            // Agregar componentes al panel
            panel.add(messageLabel, BorderLayout.CENTER);
            panel.add(closeButton, BorderLayout.SOUTH);

            // Agregar el panel al JDialog
            add(panel);

            setSize(300, 150);
            setLocationRelativeTo(parent);
        }

        // Método estático para mostrar el diálogo de error
        public static void showErrorDialog(Frame parent, String message) {
            ErrorPopUp dialog = new ErrorPopUp(parent, message);
            dialog.setVisible(true);
        }
    }

