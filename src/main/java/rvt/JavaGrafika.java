package rvt;

import javax.swing.JFrame;

public class JavaGrafika {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Grafika");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(new GrafikasPanelis());

        frame.setVisible(true);
    }
}
