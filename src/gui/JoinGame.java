package gui;

        import java.awt.Color;
        import java.awt.Font;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import javax.swing.JButton;
        import javax.swing.JLabel;
        import javax.swing.JPanel;

/**
 * Created by Jacky on 16/11/15.
 */
public class JoinGame extends JPanel {

    private JLabel lblJoin;
    private JButton btnBack;
    private JButton btnJoinGame;
    /**
     * Create the panel.
     */
    public JoinGame() {
        setForeground(Color.GRAY);
        setBackground(Color.LIGHT_GRAY);
        setBounds(100, 100, 668, 395);
        setLayout(null);

        lblJoin = new JLabel("JOIN GAME");
        lblJoin.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
        lblJoin.setBounds(250, 16, 167, 41);
        add(lblJoin);

        btnBack = new JButton("BACK TO MENU");
        btnBack.setForeground(Color.red);
        btnBack.setBounds(339, 333, 147, 41);
        btnBack.setActionCommand("BACK TO MENU");
        add(btnBack);

        btnJoinGame = new JButton("JOIN GAME");
        btnJoinGame.setForeground(new Color(0, 128, 9));
        btnJoinGame.setBounds(180, 333, 147, 41);
        add(btnJoinGame);
    }


    public void actionPerformedBack(ActionListener back) {
        btnBack.addActionListener(back);
    }

}
