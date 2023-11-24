package PROGRAM;

import java.awt.EventQueue;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class Bill {

	private JFrame frame;
	private final JLabel lblBank = new JLabel("");
	private JTextField textSource;
	private JTextField textOwner;
	private JTextField textTransaction;
	private JTextField textDate;
	private JTextField textDestination;
	private TransForm t = new TransForm();
	private JTextField txtAmount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bill window = new Bill();
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
	public Bill() {
		try {
			initialize();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 617);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ImageIcon Bank = new ImageIcon(this.getClass().getResource("/Bank-Manager.png"));	
		Image BankImage = Bank.getImage();
		Image modifiedBankImage = BankImage.getScaledInstance(440, 200, java.awt.Image.SCALE_DEFAULT);
		Bank = new ImageIcon(modifiedBankImage);
		
		JLabel lblBankName = new JLabel("NovaBank");
		lblBankName.setFont(new Font("Tahoma", Font.BOLD, 56));
		lblBankName.setBounds(10, 40, 297, 67);
		frame.getContentPane().add(lblBankName);
		ImageIcon BankIcon = new ImageIcon(this.getClass().getResource("/Bank.png"));	
		Image BankIconImage= BankIcon.getImage();
		Image modifiedBankIcon = BankIconImage.getScaledInstance(120, 120, java.awt.Image.SCALE_DEFAULT);
		BankIcon = new ImageIcon(modifiedBankIcon);
		
		JLabel lblNewLabel = new JLabel("Source:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(50, 163, 80, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblOwner = new JLabel("Owner:");
		lblOwner.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblOwner.setBounds(50, 205, 80, 32);
		frame.getContentPane().add(lblOwner);
		
		JLabel lblTransactionType = new JLabel("Transaction:");
		lblTransactionType.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTransactionType.setBounds(10, 247, 112, 32);
		frame.getContentPane().add(lblTransactionType);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDate.setBounds(66, 285, 59, 32);
		frame.getContentPane().add(lblDate);
		
		JLabel lblDestinationsId = new JLabel("Destination:");
		lblDestinationsId.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDestinationsId.setBounds(10, 327, 120, 32);
		frame.getContentPane().add(lblDestinationsId);
		
		JLabel lblOwner_1 = new JLabel("--------------------------------------------");
		lblOwner_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblOwner_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblOwner_1.setBounds(20, 117, 375, 32);
		frame.getContentPane().add(lblOwner_1);
		
		JLabel lblBankIcon = new JLabel("");
		lblBankIcon.setIcon(BankIcon);
		
		lblBankIcon.setBounds(306, 27, 120, 95);
		frame.getContentPane().add(lblBankIcon);
		
		textSource = new JTextField();
		textSource.setText(t.getSource());
		textSource.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textSource.setBounds(142, 163, 233, 29);
		frame.getContentPane().add(textSource);
		textSource.setColumns(10);
		
		textOwner = new JTextField();
		textOwner.setText(t.getName());
		textOwner.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textOwner.setColumns(10);
		textOwner.setBounds(142, 205, 233, 29);
		frame.getContentPane().add(textOwner);
		
		textTransaction = new JTextField();
		textTransaction.setText(t.getTrans());
		System.out.println(t.getTrans());
		textTransaction.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textTransaction.setColumns(10);
		textTransaction.setBounds(142, 247, 233, 29);
		frame.getContentPane().add(textTransaction);
		
		textDate = new JTextField();
		textDate.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textDate.setText(t.getDate());
		textDate.setColumns(10);
		textDate.setBounds(142, 289, 233, 29);
		frame.getContentPane().add(textDate);
		
		textDestination = new JTextField();
		textDestination.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textDestination.setText(t.getDes());
		textDestination.setColumns(10);
		textDestination.setBounds(142, 331, 233, 29);
		frame.getContentPane().add(textDestination);
		lblBank.setBounds(0, 422, 436, 158);
		frame.getContentPane().add(lblBank);
		lblBank.setIcon(Bank);
		
		JLabel lblDestinationsId_1 = new JLabel("Destination:");
		lblDestinationsId_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDestinationsId_1.setBounds(55, 431, 120, 32);
		frame.getContentPane().add(lblDestinationsId_1);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAmount.setBounds(38, 369, 102, 38);
		frame.getContentPane().add(lblAmount);
		
		txtAmount = new JTextField();
		txtAmount.setText(String.valueOf(t.getAmount()));
		txtAmount.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtAmount.setColumns(10);
		txtAmount.setBounds(142, 378, 233, 29);
		frame.getContentPane().add(txtAmount);
	}
}
