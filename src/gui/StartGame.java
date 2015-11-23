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
public class StartGame extends JPanel {

    private JLabel lblStart;
    private JButton btnBack;
    private JButton btnStartGame;
    /**
     * Create the panel.
     */
    public StartGame() {
        setForeground(Color.GRAY);
        setBackground(Color.LIGHT_GRAY);
        setBounds(100, 100, 668, 395);
        setLayout(null);

        lblStart = new JLabel("START GAME");
        lblStart.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
        lblStart.setBounds(250, 16, 167, 41);
        add(lblStart);

        btnBack = new JButton("BACK TO MENU");
        btnBack.setForeground(Color.red);
        btnBack.setBounds(339, 333, 147, 41);
        btnBack.setActionCommand("BACK TO MENU");
        add(btnBack);

        btnStartGame = new JButton("START GAME");
        btnStartGame.setForeground(new Color(0, 128, 9));
        btnStartGame.setBounds(180, 333, 147, 41);
        add(btnStartGame);
    }


    public void actionPerformedBack(ActionListener back) {
        btnBack.addActionListener(back);
    }

}
