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
    private JLabel backGround;
    private JButton btnBack;
    private JButton btnDeleteGame;
    private JComboBox comboDeleteBox;
    private JLabel lblChooseAGame;


    /**
     * Create the panel
     */

    public DeleteGame(){
        setForeground(Color.GRAY);
        setBackground(Color.LIGHT_GRAY);
        setBounds(100, 100, 668, 495);
        setLayout(null);

        lblChooseAGame = new JLabel("Choose a game to delete: ");
        lblChooseAGame.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        lblChooseAGame.setForeground(Color.CYAN);
        lblChooseAGame.setBounds(232, 150, 204, 26);
        add(lblChooseAGame);

        btnBack = new JButton("BACK TO MENU");
        btnBack.setForeground(Color.CYAN);
        btnBack.setBounds(406, 416, 174, 70);
        btnBack.setActionCommand("BACK TO MENU");
        add(btnBack);

        btnDeleteGame = new JButton("DELETE GAME");
        btnDeleteGame.setForeground(Color.CYAN);
        btnDeleteGame.setActionCommand("DELETE GAME");
        btnDeleteGame.setBounds(85, 416, 174, 70);
        add(btnDeleteGame);

        comboDeleteBox = new JComboBox();
        comboDeleteBox.setBounds(211, 215, 246, 41);
        add(comboDeleteBox);

        backGround = new JLabel("");
        backGround.setIcon(new ImageIcon(Login.class.getResource("snakedelete.jpg")));
        backGround.setBounds(0, 0, 668, 495);
        add(backGround);
    }

    public void actionPerformedBack(ActionListener back) {
        btnBack.addActionListener(back);
    }

    public void addActionDelete(ActionListener delete) {btnDeleteGame.addActionListener(delete);}


   public void setDeleteBox(ArrayList<Game> game){
        comboDeleteBox.removeAllItems();
        for (Game games : game) {
            comboDeleteBox.addItem(games.getName());
        }
    }

    public String getDeleteBox(){
        return (String) comboDeleteBox.getSelectedItem();
    }

    public void RemoveGame(){
        comboDeleteBox.removeItemAt(comboDeleteBox.getSelectedIndex());
    }

}
