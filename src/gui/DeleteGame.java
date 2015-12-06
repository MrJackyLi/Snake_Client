package gui;

import sdk.Game;
import sdk.Score;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Created by Jacky on 16/11/15.
 */
public class DeleteGame extends JPanel {

    private JLabel lblDeleteGame;
    private JButton btnBack;
    private JButton btnDeleteGame;
   private JComboBox comboDeleteBox;


    /**
     * Create the panel
     */

    public DeleteGame(){
        setForeground(Color.GRAY);
        setBackground(Color.LIGHT_GRAY);
        setBounds(100, 100, 668, 395);
        setLayout(null);

        lblDeleteGame = new JLabel("DELETE GAME");
        lblDeleteGame.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
        lblDeleteGame.setBounds(243, 55, 182, 41);
        add(lblDeleteGame);

        btnBack = new JButton("BACK TO MENU");
        btnBack.setForeground(Color.RED);
        btnBack.setBounds(406, 416, 147, 41);
        btnBack.setActionCommand("BACK TO MENU");
        add(btnBack);

        btnDeleteGame = new JButton("DELETE GAME");
        btnDeleteGame.setForeground(Color.GREEN);
        btnDeleteGame.setActionCommand("DELETE GAME");
        btnDeleteGame.setBounds(83, 416, 147, 41);
        add(btnDeleteGame);

     comboDeleteBox = new JComboBox();
        comboDeleteBox.setBounds(211, 215, 246, 41);
        add(comboDeleteBox);
    }

    public JButton getBtnDeleteGame() {
        return btnDeleteGame;
    }


    public void actionPerformedBack(ActionListener back) {
        btnBack.addActionListener(back);
    }

    public void addActionDelete(ActionListener delete) {btnDeleteGame.addActionListener(delete);}


   public void setDeleteBox(ArrayList<Game> game){
        comboDeleteBox.removeAllItems();
        for (Game games : game) {
            comboDeleteBox.addItem(games.getGameId());

        }
    }


    public String getDeleteBox(){
        return (String) comboDeleteBox.getSelectedItem();
    }

    public void RemoveGame(){
        comboDeleteBox.removeItemAt(comboDeleteBox.getSelectedIndex());
    }

}
