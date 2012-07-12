package com.valmansoft.desktop.dns;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author anna
 */
public class Windows {
    public static final void centerOnScreen(Window window) {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(
                (d.width - window.getSize().width)/2,
                (d.height - window.getSize().height)/2);
    }
    public static final void windowsLookAndFeel(Window window) {
        try {
          UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
          SwingUtilities.updateComponentTreeUI(window);
        } catch (Exception e) {
        }
    }

}
