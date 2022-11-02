package org.example.frontend;

import org.example.backend.ShufflePieces;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GamePanel extends JPanel {

    public GamePanel() {
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(null);
        createJButtons();
    }

    // Daniel Förklarar
    public void createJButtons(){
        int x = 0;
        int y = 0;
        int width = 200;
        int height = 200;

        // Behöver inte hårdkoda varje knapp så valde en mer dynamisk lösning
        // Listan "shufflas" mha Collections.shuffle()
        List<Integer> shuffledList = new ShufflePieces().getShuffledNumberList();

        for (int i = 0; i < 16; i++) {
            // Varje knapp tillskrivs en slumpad siffra från shuffledList
            JButton currentButton = new JButton(String.valueOf(shuffledList.get(i)));
            currentButton.setFocusable(false); // Tar bort den fula rutan som annars hade omringat siffran.
            currentButton.setFont(new Font("Sans-serif", Font.BOLD, 22));
            currentButton.setBackground(Color.decode("#C7F2A4"));
            // Om siffran är 0 blir knappen "blankButton". Finns under huven men går inte att interagera med.
            if(currentButton.getText().equals("0")) {
                currentButton.setBackground(Color.WHITE);
                currentButton.setText("");
                currentButton.setEnabled(false);
            }

            // Daniel förklarar - använd Excalidraw i syfte att förklara valet att räkna på bounds.
            // Säkerställer att
            currentButton.setBounds(x, y, width, height);
            x += 200;
            if (x == 800) {
                y += 200;
                x = 0;
            }

            // varje knapp får en skräddarsydd ActionListener kopplad på sig och en boolean satt till false (hasWonGame)
            currentButton.addActionListener(new ButtonActionListener(currentButton, false));
            this.add(currentButton);

        }
    }



}
