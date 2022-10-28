package org.example.frontend;

import javax.swing.*;
import java.awt.*;

public class AlternateGamePanel extends JPanel {
    JButton button = new JButton("TEst");
    JButton button2 = new JButton("TEst2");
    JButton button3 = new JButton("TEst3");

    //Bajs

    public AlternateGamePanel() {
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(null);
        button.setBounds(0, 0, 200, 200);
        button2.setBounds(150, 0, 200, 200);
        button3.setBounds(300, 0, 200, 200);
        this.add(button);
        this.add(button2);
        this.add(button3);
        System.out.println(button.getX());
        System.out.println(button2.getX());
        System.out.println(button3.getX());

    }
}
