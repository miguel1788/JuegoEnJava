/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package juegoenjava;


    
    import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JuegoBasico extends JPanel implements ActionListener {
    private int x = 0, y = 0;       // Posición de la bola
    private int velX = 2, velY = 2; // Velocidad de movimiento
    private final int DIAMETRO = 30;

    public JuegoBasico() {
        Timer timer = new Timer(10, this); // Actualiza cada 10 ms
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(x, y, DIAMETRO, DIAMETRO);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x += velX;
        y += velY;

        // Rebote en los bordes
        if (x < 0 || x > getWidth() - DIAMETRO) velX = -velX;
        if (y < 0 || y > getHeight() - DIAMETRO) velY = -velY;

        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Juego en Java");
        JuegoBasico juego = new JuegoBasico();
        frame.add(juego);
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

