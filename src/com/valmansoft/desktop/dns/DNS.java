package com.valmansoft.desktop.dns;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import javax.swing.JPanel;

/**
 * DNS.java
 *
 * Created on Sep 13, 2010, 9:03:13 PM
 * 
 * @author Valery Manahkimov
 */
public class DNS extends javax.swing.JFrame implements DNSModelListener {

    final int _HSIZE_ = 100;
    final int _VSIZE_ = 30;
    Image image;
    JPanel imagePane;
    MediaTracker tracker;  // one will do

    /** Creates new form DNS */
    public DNS() {
        initComponents();
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        Windows.windowsLookAndFeel(this);
        Windows.centerOnScreen(this);
        ActionListener showAction = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String input = txtHostIPAddress.getText();
                try {
                    InetAddress ia = (input.length() > 0)
                            ? InetAddress.getByName(input)
                            : InetAddress.getLocalHost();
                    txtIP.setBackground(Color.GREEN);
                    if (rdoHost.isSelected()) {
                        txtIP.setText("IP Address :\t" + ia.getHostName());
                    } else {
                        txtIP.setText("IP Address :\t" + ia.getHostAddress());
                    }

                } catch (UnknownHostException ex) {
                    txtIP.setBackground(Color.RED);
                    txtIP.setText("Uknown Host :" + ex.getMessage());
                }

            }
        };
        btnShow.addActionListener(showAction);

        tracker = new MediaTracker(pnlLogo);
        imagePane = new JPanel() {

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                if (image != null) {
//                    int w = getWidth();
//                    int h = getHeight();
//                    int imageWidth  = image.getWidth(this);
//                    int imageHeight = image.getHeight(this);
                    int x = 0;//(w - imageWidth)/2;
                    int y = 0;//(h - imageHeight)/2;
                    g.drawImage(image, x, y, this);
                }
            }
        };
        imagePane.setPreferredSize(new Dimension(_HSIZE_, _VSIZE_));
        pnlLogo.setLayout(new BorderLayout());
        pnlLogo.add(imagePane);
        loadImageAction();

        KeyAdapter keyAdp = new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();
                if (code == KeyEvent.VK_ENTER || code == KeyEvent.VK_SPACE) {
                    btnShow.doClick();
                }
            }
        };

        txtHostIPAddress.addKeyListener(keyAdp);
        btnShow.addKeyListener(keyAdp);
        rdoHost.addKeyListener(keyAdp);
        rdoIP.addKeyListener(keyAdp);
        addKeyListener(keyAdp);
    }

    private void loadImageAction() {
        URL url = getClass().getResource("logo.jpg");
        Image orig = Toolkit.getDefaultToolkit().getImage(url);
        loadImage(orig);
        image = scale(orig);
        loadImage(image);
        repaint();
    }

    private Image scale(Image orig) {
        double w = _HSIZE_;
        double h = _VSIZE_;
        int imageWidth = orig.getWidth(this);
        int imageHeight = orig.getHeight(this);
        double xScale = (w / imageWidth);
        double yScale = (h / imageHeight);
        double scale = Math.min(xScale, yScale);     // scale to fit
        //Math.max(xScale, yScale);   // scale to fill
        int width = (int) (scale * imageWidth);
        int height = (int) (scale * imageHeight);
        return orig.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

    private void loadImage(Image image) {
        tracker.addImage(image, 0);
        try {
            tracker.waitForID(0);
        } catch (InterruptedException ev) {
            ev.printStackTrace();
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpDomain = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txtHostIPAddress = new javax.swing.JTextField();
        btnShow = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtIP = new javax.swing.JTextPane();
        rdoHost = new javax.swing.JRadioButton();
        rdoIP = new javax.swing.JRadioButton();
        pnlLogo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DNS Convertor");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12));
        jLabel1.setText("Host or IP address");

        txtHostIPAddress.setFont(new java.awt.Font("DialogInput", 1, 12));

        btnShow.setText("Show");

        txtIP.setFont(new java.awt.Font("Dialog", 1, 12));
        jScrollPane1.setViewportView(txtIP);

        grpDomain.add(rdoHost);
        rdoHost.setText("Host Name");

        grpDomain.add(rdoIP);
        rdoIP.setText("IP Address");

        pnlLogo.setToolTipText("VMIT");

        javax.swing.GroupLayout pnlLogoLayout = new javax.swing.GroupLayout(pnlLogo);
        pnlLogo.setLayout(pnlLogoLayout);
        pnlLogoLayout.setHorizontalGroup(
            pnlLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 146, Short.MAX_VALUE)
        );
        pnlLogoLayout.setVerticalGroup(
            pnlLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                            .addComponent(txtHostIPAddress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnShow)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdoHost)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdoIP))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)))
                    .addComponent(pnlLogo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHostIPAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShow)
                    .addComponent(rdoHost)
                    .addComponent(rdoIP))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlLogo.setPreferredSize(new Dimension(_HSIZE_, _VSIZE_));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_ENTER || code == KeyEvent.VK_SPACE) {
            btnShow.doClick();
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new DNS().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnShow;
    private javax.swing.ButtonGroup grpDomain;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlLogo;
    private javax.swing.JRadioButton rdoHost;
    private javax.swing.JRadioButton rdoIP;
    private javax.swing.JTextField txtHostIPAddress;
    private javax.swing.JTextPane txtIP;
    // End of variables declaration//GEN-END:variables

    public void ipChanged(DNSModelEvent event) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
