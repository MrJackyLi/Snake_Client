package gui;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import gui.OpponentTable;

/**
 * Created by Jacky on 16/11/15.
 */

public class CreateGame extends JPanel {
    private JLabel lblCreateGame;
    private JButton btnBack;
    private JButton btnCreateGame;
    private JTextField txtFGameName;
    private JTextField txtFMovements;
    private JLabel lblActionsA;
    private JLabel lblWUp;
    private JLabel lblsDown;
    private JLabel lblaLeft;
    private JLabel lbldRight;
    private JLabel lblGameName;
    private JLabel lblTypeMovements;
    private JTable table;
    private JLabel lblChooseOpponent;

    /**
     * Create the panel.
     */
    public CreateGame(){
        setForeground(Color.GRAY);
        setBackground(Color.LIGHT_GRAY);
        setBounds(100, 100, 668, 495);
        setLayout(null);

        lblCreateGame = new JLabel("CREATE GAME");
        lblCreateGame.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
        lblCreateGame.setBounds(240, 29, 186, 41);
        add(lblCreateGame);

        btnBack = new JButton("BACK TO MENU");
        btnBack.setForeground(Color.RED);
        btnBack.setBounds(406, 416, 147, 41);
        btnBack.setActionCommand("BACK TO MENU");
        add(btnBack);

        btnCreateGame = new JButton("CREATE GAME");
        btnCreateGame.setForeground(Color.GREEN);
        btnCreateGame.setActionCommand("CREATE GAME");
        btnCreateGame.setBounds(83, 416, 147, 41);
        add(btnCreateGame);

        txtFGameName = new JTextField();
        txtFGameName.setBounds(83, 137, 168, 41);
        add(txtFGameName);
        txtFGameName.setColumns(10);

        txtFMovements = new JTextField();
        txtFMovements.setColumns(10);
        txtFMovements.setBounds(131, 265, 218, 81);
        add(txtFMovements);

        lblGameName = new JLabel("Game Name:");
        lblGameName.setBounds(123, 109, 92, 16);
        add(lblGameName);

        lblTypeMovements = new JLabel("Type Movements:");
        lblTypeMovements.setBounds(192, 248, 117, 16);
        add(lblTypeMovements);

        lblActionsA = new JLabel("Actions: ");
        lblActionsA.setHorizontalAlignment(SwingConstants.CENTER);
        lblActionsA.setBounds(35, 248, 94, 16);
        add(lblActionsA);

        lblWUp = new JLabel("\"W\": UP");
        lblWUp.setHorizontalAlignment(SwingConstants.CENTER);
        lblWUp.setBounds(45, 271, 61, 16);
        add(lblWUp);

        lblsDown = new JLabel("\"S\": DOWN");
        lblsDown.setHorizontalAlignment(SwingConstants.CENTER);
        lblsDown.setBounds(45, 288, 74, 16);
        add(lblsDown);

        lblaLeft = new JLabel("\"A\": LEFT");
        lblaLeft.setHorizontalAlignment(SwingConstants.CENTER);
        lblaLeft.setBounds(45, 305, 74, 16);
        add(lblaLeft);

        lbldRight = new JLabel("\"D\": RIGHT");
        lbldRight.setHorizontalAlignment(SwingConstants.CENTER);
        lbldRight.setBounds(45, 325, 74, 21);
        add(lbldRight);

        table = new JTable(new OpponentTable());
        table.setBounds(368, 104, 251, 281);
        add(table);

        lblChooseOpponent = new JLabel("Choose opponent");
        lblChooseOpponent.setBounds(436, 82, 117, 16);
        add(lblChooseOpponent);
    }

    public void actionPerformedBack(ActionListener back) {
        btnBack.addActionListener(back);
    }
}
