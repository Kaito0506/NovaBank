package PROGRAM;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;
;public class Login {

	private JFrame frame;
	private final JLabel lblNovaBank = new JLabel("NovaBank");
	private JTextField cccd;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 204));
		frame.setBounds(100, 100, 664, 258);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		lblNovaBank.setBackground(new Color(255, 255, 0));
		lblNovaBank.setForeground(Color.BLACK);
		lblNovaBank.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNovaBank.setBounds(228, 11, 171, 36);
		frame.getContentPane().add(lblNovaBank);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String src = e.getActionCommand();
				System.out.println(src);
				String user = cccd.getText();
				String pw = password.getText();
				if(user.equals("") || pw.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please type your account!", "Error", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					try {
						Connection conn = Connect.getConnect("novabank");
						Statement st = null;
						ResultSet rs = null;
						st = conn.createStatement();
						String sql = "select * from employment where e_cccd = '"+ user + "' and e_tel = '" + pw+"'"; 
						rs = st.executeQuery(sql);
						if(rs.next())
						{
							frame.dispose();
							Menu m = new Menu();
							m.main(null);
							//JOptionPane.showMessageDialog(null,"Login successfully!", "Error", JOptionPane.WARNING_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Invalid user or password!", "Error", JOptionPane.WARNING_MESSAGE);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
				
				
				

				
			}
		});
		btnLogin.setBounds(215, 154, 128, 44);
		frame.getContentPane().add(btnLogin);
		
		JLabel UserCCCD = new JLabel(" User (CCCD):");
		UserCCCD.setFont(new Font("Tahoma", Font.ITALIC, 18));
		UserCCCD.setBounds(154, 58, 142, 36);
		frame.getContentPane().add(UserCCCD);
		
		cccd = new JTextField();
		cccd.setToolTipText("Type your CCCD");
		cccd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cccd.setBounds(335, 58, 241, 28);
		frame.getContentPane().add(cccd);
		cccd.setColumns(10);
		
		JLabel Password = new JLabel("Password:");
		Password.setFont(new Font("Tahoma", Font.ITALIC, 18));
		Password.setBounds(164, 101, 128, 28);
		frame.getContentPane().add(Password);
		
		password = new JPasswordField();
		password.setToolTipText("Password is telephone number");
		password.setFont(new Font("Tahoma", Font.PLAIN, 18));
		password.setBounds(335, 101, 241, 28);
		frame.getContentPane().add(password);
		
		JLabel lblBankIcon = new JLabel("");
		ImageIcon Bank = new ImageIcon(this.getClass().getResource("/Bank.png"));
		
		Image BankImage = Bank.getImage();
		Image modifiedBankImage = BankImage.getScaledInstance(150, 150, java.awt.Image.SCALE_DEFAULT);
		Bank = new ImageIcon(modifiedBankImage);
		lblBankIcon.setIcon(Bank);
		lblBankIcon.setBounds(10, 26, 150, 147);
		frame.getContentPane().add(lblBankIcon);
	}
}
