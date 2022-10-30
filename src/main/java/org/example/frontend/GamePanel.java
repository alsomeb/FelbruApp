package org.example.frontend;

import org.example.backend.ShufflePieces;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GamePanel extends JPanel {

    //TODO: Eventuellt obsolet. Om jag inte kan skapa upp listan winCondition härifrån till ButtonActionListener så ska
    // den tas bort helt från GamePanel. "setName" måste vara kvar!!!
//    public List<String> getWinCondition() {
//        return winCondition;
//    }
    //TODO: Eventuellt obsolet.
//    public List<String> winCondition = new ArrayList<>();

    public GamePanel() {
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(null);
        createJButtons();
    }

    public void createJButtons(){
        int x = 0;
        int y = 0;
        int width = 200;
        int height = 200;
        List<Integer> shuffledList = new ShufflePieces().getShuffledNumberList();

        for (int i = 0; i < 16; i++) {
            JButton currentButton = new JButton(String.valueOf(shuffledList.get(i)));
            currentButton.setFocusable(false);
            currentButton.setFont(new Font("Sans-serif", Font.BOLD, 22));
            currentButton.setBackground(Color.decode("#C7F2A4"));
            currentButton.setName(String.valueOf(shuffledList.get(i)));

            if(currentButton.getText().equals("0")) {
                currentButton.setBackground(Color.WHITE);
                currentButton.setText("");
                currentButton.setName("empty");
                currentButton.setEnabled(false);
            }
            currentButton.setBounds(x, y, width, height);
            x += 200;
            if (x == 800) {
                y += 200;
                x = 0;
            }

            currentButton.addActionListener(new ButtonActionListener(currentButton));
            this.add(currentButton);

        }
    }

    // TODO: Eventuellt obsolet.
//    public void createWinCondition(JButton currentButton){
//        winCondition.add(currentButton.getName());
//    }



}
