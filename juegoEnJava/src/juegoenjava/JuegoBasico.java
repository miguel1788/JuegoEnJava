/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package juegoenjava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JuegoBasico extends JPanel implements ActionListener, KeyListener {
    private int x = 200, y = 150;  // Posición inicial
    private final int DIAMETRO = 30;
    private int velX = 0, velY = 0;

    public JuegoBasico() {
        Timer timer = new Timer(10, this);
        timer.start();

        setFocusable(true);
        addKeyListener(this); // Escuchar las teclas
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

        // Mantener dentro de la ventana
        if (x < 0) x = 0;
        if (x > getWidth() - DIAMETRO) x = getWidth() - DIAMETRO;
        if (y < 0) y = 0;
        if (y > getHeight() - DIAMETRO) y = getHeight() - DIAMETRO;

        repaint();
    }

    // Métodos de KeyListener
    @Override
    public void keyPressed(KeyEvent e) {
        int tecla = e.getKeyCode();
        if (tecla == KeyEvent.VK_LEFT)  velX = -2;
        if (tecla == KeyEvent.VK_RIGHT) velX =  2;
        if (tecla == KeyEvent.VK_UP)    velY = -2;
        if (tecla == KeyEvent.VK_DOWN)  velY =  2;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int tecla = e.getKeyCode();
        // Cuando se suelta la tecla, se detiene el movimiento
        if (tecla == KeyEvent.VK_LEFT || tecla == KeyEvent.VK_RIGHT) velX = 0;
        if (tecla == KeyEvent.VK_UP   || tecla == KeyEvent.VK_DOWN)  velY = 0;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Juego en Java");
        JuegoBasico juego = new JuegoBasico();
        frame.add(juego);
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
