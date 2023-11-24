package PROGRAM;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;

public class Menu {

	JFrame frame;
	private JButton btnTrans;
	private JButton btnCustomer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 510, 512);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ImageIcon Bank = new ImageIcon(this.getClass().getResource("/Bank-Manager.png"));
		Image BankImage = Bank.getImage();
		Image modifiedBankImage = BankImage.getScaledInstance(500, 370, java.awt.Image.SCALE_DEFAULT);
		Bank = new ImageIcon(modifiedBankImage);
		
		btnTrans = new JButton("Transaction");
		btnTrans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransForm f = new TransForm();
				f.main(null);
				
			}
		});
		btnTrans.setBackground(new Color(0, 255, 0));
		btnTrans.setForeground(Color.BLACK);
		btnTrans.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnTrans.setBounds(130, 85, 248, 51);
		frame.getContentPane().add(btnTrans);
		
		btnCustomer = new JButton("Customer");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertForm i = new InsertForm();
				i.main(null);
				
				
			}
		});
		btnCustomer.setForeground(Color.BLACK);
		btnCustomer.setBackground(Color.GREEN);
		btnCustomer.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCustomer.setBounds(130, 170, 248, 51);
		frame.getContentPane().add(btnCustomer);
		
		JLabel lblNewLabel_1 = new JLabel("NOVABANK SYSTEM");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(97, 11, 316, 51);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnSaving = new JButton("Transaction search");
		btnSaving.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tran_search.main(null);
			}
		});
		btnSaving.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSaving.setBackground(Color.GREEN);
		btnSaving.setBounds(130, 256, 248, 51);
		frame.getContentPane().add(btnSaving);
		
		JButton btnLoan = new JButton("Loan");
		btnLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DebtForm d = new DebtForm();
				d.main(null);
				
				
			}
		});
		btnLoan.setBackground(Color.GREEN);
		btnLoan.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLoan.setBounds(130, 341, 248, 51);
		frame.getContentPane().add(btnLoan);
		
		JButton btnLogout = new JButton("Log out");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int aw = JOptionPane.showConfirmDialog(frame, "Do you want to log out", "Log out", JOptionPane.YES_NO_OPTION);
				if(aw == JOptionPane.YES_OPTION)
				{
					frame.dispose();
					Login l = new Login();					
					l.main(null);
					frame.dispose();
					frame.dispose();
				}
			}
		});
		btnLogout.setForeground(Color.DARK_GRAY);
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogout.setBackground(Color.GREEN);
		btnLogout.setBounds(392, 426, 92, 23);
		frame.getContentPane().add(btnLogout);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setIcon(Bank);
		lblNewLabel.setBounds(0, 119, 494, 361);
		frame.getContentPane().add(lblNewLabel);
		
		
	}
}
