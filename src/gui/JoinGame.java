package gui;

        import java.awt.Color;
        import java.awt.Font;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import javax.swing.*;

/**
 * Created by Jacky on 16/11/15.
 */
public class JoinGame extends JPanel {

    private JLabel lblJoin;
    private JLabel lblJoinMove;
    private JButton btnBack;
    private JButton btnJoinGame;
    private JTextField txtJoinMove;
    private JLabel lblJoinWUp;
    private JLabel lblJoinSDown;
    private JLabel lblJoinALeft;
    private JLabel lblJoinDRight;
    private JLabel lblJoinActions;
    private JLabel lblSelectGame;
    private JComboBox comboJoinBox;



    /**
     * Create the panel.
     */
    public JoinGame() {
        setForeground(Color.GRAY);
        setBackground(Color.LIGHT_GRAY);
        setBounds(100, 100, 668, 495);
        setLayout(null);

        lblJoin = new JLabel("JOIN GAME");
        lblJoin.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
        lblJoin.setBounds(254, 41, 167, 41);
        add(lblJoin);

        btnBack = new JButton("BACK TO MENU");
        btnBack.setForeground(Color.red);
        btnBack.setBounds(340, 427, 147, 41);
        btnBack.setActionCommand("BACK TO MENU");
        add(btnBack);

        btnJoinGame = new JButton("JOIN GAME");
        btnJoinGame.setForeground(Color.green);
        btnJoinGame.setBounds(181, 427, 147, 41);
        add(btnJoinGame);

        txtJoinMove = new JTextField();
        txtJoinMove.setColumns(10);
        txtJoinMove.setBounds(378, 325, 245, 81);
        add(txtJoinMove);

        lblJoinActions = new JLabel("Actions: ");
        lblJoinActions.setHorizontalAlignment(SwingConstants.CENTER);
        lblJoinActions.setBounds(154, 302, 94, 16);
        add(lblJoinActions);

        lblJoinWUp = new JLabel("\"W\": UP");
        lblJoinWUp.setHorizontalAlignment(SwingConstants.CENTER);
        lblJoinWUp.setBounds(164, 328, 61, 16);
        add(lblJoinWUp);

        lblJoinSDown = new JLabel("\"S\": DOWN");
        lblJoinSDown.setHorizontalAlignment(SwingConstants.CENTER);
        lblJoinSDown.setBounds(161, 385, 74, 16);
        add(lblJoinSDown);

        lblJoinALeft = new JLabel("\"A\": LEFT");
        lblJoinALeft.setHorizontalAlignment(SwingConstants.CENTER);
        lblJoinALeft.setBounds(77, 346, 74, 16);
        add(lblJoinALeft);

        lblJoinDRight = new JLabel("\"D\": RIGHT");
        lblJoinDRight.setHorizontalAlignment(SwingConstants.CENTER);
        lblJoinDRight.setBounds(254, 344, 74, 21);
        add(lblJoinDRight);

        lblJoinMove = new JLabel("Type Movements:");
        lblJoinMove.setBounds(441, 302, 117, 16);
        add(lblJoinMove);

        lblSelectGame = new JLabel("Join game by selecting a game!");
        lblSelectGame.setBounds(235, 123, 197, 16);
        add(lblSelectGame);

        comboJoinBox = new JComboBox();
        comboJoinBox.setBounds(211, 151, 246, 41);
        add(comboJoinBox);
    }


    public void actionPerformedBack(ActionListener back) {
        btnBack.addActionListener(back);
    }
}
