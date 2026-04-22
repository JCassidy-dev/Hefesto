package com.josan.util;

import javax.swing.*;

public class Util {
    public static void showErrorAlert(String mensaje) {
        JOptionPane.showMessageDialog(null,mensaje,"Error",JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Muestra un cuadro de diálogo de advertencia/aviso al usuario.
     * @param mensaje Texto del mensaje de aviso a mostrar
     */
    public static void showWarningAlert(String mensaje) {
        JOptionPane.showMessageDialog(null,mensaje,"Aviso",JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Muestra un cuadro de diálogo de información al usuario.
     * @param mensaje Texto del mensaje informativo a mostrar
     */
    public static void showInfoAlert(String mensaje) {
        JOptionPane.showMessageDialog(null,mensaje,"Información", JOptionPane.INFORMATION_MESSAGE);
    }
}
