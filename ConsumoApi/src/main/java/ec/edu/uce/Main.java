package ec.edu.uce;

import ec.edu.uce.view.MarsPhotosPanel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Mars Photos");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new MarsPhotosPanel());
            frame.setSize(800, 600);
            frame.setVisible(true);
        });
    }
}
