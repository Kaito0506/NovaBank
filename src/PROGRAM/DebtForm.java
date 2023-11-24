package PROGRAM;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.time.*;
public class DebtForm {

	private JFrame frame;
	private JTextField txtAccount;
	private JTextField txtName;
	private JTextField txtAmount;
	private JTextField txtInterest;
	private JTextField txtTotal;
	static JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DebtForm window = new DebtForm();
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
	public DebtForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 204, 204));
		frame.setBounds(100, 100, 629, 573);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ImageIcon Bank = new ImageIcon(this.getClass().getResource("/Bank-Manager.png"));
		Image BankImage = Bank.getImage();
		Image modifiedBankImage = BankImage.getScaledInstance(500, 400, java.awt.Image.SCALE_SMOOTH);
		Bank = new ImageIcon(modifiedBankImage);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUser = new JLabel("");
		lblUser.setBounds(246, 0, 130, 108);
		frame.getContentPane().add(lblUser);
		ImageIcon User = new ImageIcon(this.getClass().getResource("/User.png"));
		Image UserImage = User.getImage();
		Image modifiedUserImage = UserImage.getScaledInstance(130, 130, java.awt.Image.SCALE_DEFAULT);
		User = new ImageIcon(modifiedUserImage);
		
		lblUser.setIcon(User);
		
		JLabel lblNewLabel_1 = new JLabel("Account:");
		lblNewLabel_1.setBounds(43, 128, 89, 22);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblBank = new JLabel("New label");
		lblBank.setBounds(0, 864, 496, -328);
		lblBank.setIcon(Bank);
		frame.getContentPane().add(lblBank);
		
		txtAccount = new JTextField();
		txtAccount.setBounds(142, 128, 263, 30);
		txtAccount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtAccount.setToolTipText("Type customer's account (telephone)");
		frame.getContentPane().add(txtAccount);
		txtAccount.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(471, 123, 117, 33);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtAccount.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please type account number to search!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					Debt d = new Debt();
					Customer c = new Customer();
					try {
							Debt d2 = d.search(txtAccount.getText());
							Customer c2 = c.search(txtAccount.getText());
							if(d2!=null && c2!=null)
							{						
								txtAccount.setText(d2.Tel);
								txtName.setText(c2.C_Name);
								txtAmount.setText(String.valueOf(d2.Debt_Amount));
								//txtInterest.setText(String.valueOf(d2.Debt_Interest));
								dateChooser.setDate(d2.Debt_date);
							}
							else {
								JOptionPane.showMessageDialog(null, "Can not find", "Warning", JOptionPane.WARNING_MESSAGE);
							}
								
						
					} catch (SQLException e1) {
						
						// TODO Auto-generated catch block
						System.out.println("Error: " +e1);
						e1.printStackTrace();
					}
				}
			}
		});
		btnSearch.setBackground(Color.GREEN);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 18));
		frame.getContentPane().add(btnSearch);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name:");
		lblNewLabel_1_1.setBounds(43, 191, 89, 22);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		frame.getContentPane().add(lblNewLabel_1_1);
		
		txtName = new JTextField();
		txtName.setBounds(142, 186, 263, 30);
		txtName.setToolTipText("Type customer's name");
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtName.setColumns(10);
		frame.getContentPane().add(txtName);
		
		JLabel lblNewLabel_1_2 = new JLabel("Amount:");
		lblNewLabel_1_2.setBounds(43, 244, 89, 22);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		frame.getContentPane().add(lblNewLabel_1_2);
		
		txtAmount = new JTextField();
		txtAmount.setBounds(142, 239, 263, 30);
		txtAmount.setToolTipText("Type amount of debt");
		txtAmount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtAmount.setColumns(10);
		frame.getContentPane().add(txtAmount);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Debt_Date:");
		lblNewLabel_1_2_1.setBounds(25, 298, 107, 22);
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		frame.getContentPane().add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Interest:");
		lblNewLabel_1_2_1_1.setBounds(25, 345, 107, 22);
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		frame.getContentPane().add(lblNewLabel_1_2_1_1);
		
		txtInterest = new JTextField();
		txtInterest.setBounds(142, 345, 263, 30);
		txtInterest.setToolTipText("");
		txtInterest.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtInterest.setColumns(10);
		frame.getContentPane().add(txtInterest);
		
		dateChooser = new JDateChooser();
		dateChooser.setForeground(new Color(0, 0, 0));
		dateChooser.setToolTipText("Date of debt");
		dateChooser.setBounds(142, 290, 263, 30);
		frame.getContentPane().add(dateChooser);
		
		JButton btnPay = new JButton("Pay");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn = Connect.getConnect("project");
				 PreparedStatement st = null;
				 PreparedStatement st2 =  null;
				 ResultSet rs = null;
				 String sql= "delete from debt where debt_id = ?";
				 String s_pay = "insert into trans_detail(trans_type, sources, trans_date, amount) values ('Pay debt', ?, ?, ?)";
				 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				 try {
					 st = conn.prepareStatement(sql);
					 st.setString(1,  txtAccount.getText());
					 st.execute();
					 
					 st2 = conn.prepareStatement(s_pay);
					 st2.setString(1, txtAccount.getText());
					 st2.setString(2, dateFormat.format(dateChooser.getDate()));
					 st2.setInt(3, Integer.parseInt(txtTotal.getText()));
					 st2.execute();
					 
						JOptionPane.showMessageDialog(null, "Pay successfully!","Success", JOptionPane.INFORMATION_MESSAGE);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Can not pay!", "Wanrning", JOptionPane.ERROR_MESSAGE);

				}
				
				
				
			}
		});
		btnPay.setBounds(449, 468, 89, 30);
		btnPay.setBackground(Color.GREEN);
		btnPay.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().add(btnPay);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Total:");
		lblNewLabel_1_2_1_1_1.setBounds(60, 406, 89, 22);
		lblNewLabel_1_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		frame.getContentPane().add(lblNewLabel_1_2_1_1_1);
		
		txtTotal = new JTextField();
		txtTotal.setBounds(142, 401, 263, 30);
		txtTotal.setToolTipText("");
		txtTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTotal.setColumns(10);
		frame.getContentPane().add(txtTotal);
		
		JButton btnTotal = new JButton("Total");
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalDate d = LocalDate.now();
				Date PayDate = Date.valueOf(d);
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String debtDate = null;
				debtDate = dateFormat.format(dateChooser.getDate());
				Date dd = Date.valueOf(debtDate);
				Debt de = new Debt();
				double i = Integer.parseInt(txtAmount.getText()) * de.date_cal(PayDate, dd)*0.005 ;
				System.out.println(de.date_cal(PayDate, dd));
				txtInterest.setText(String.valueOf((int)i));
				double total = i + Integer.parseInt(txtAmount.getText());
				System.out.println((int)total);
				txtTotal.setText(String.valueOf((int)total));
				
			}
		});
		btnTotal.setBounds(471, 312, 117, 30);
		btnTotal.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnTotal.setBackground(Color.GREEN);
		frame.getContentPane().add(btnTotal);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int aw = JOptionPane.showConfirmDialog(btnBack, "Do you want to return menu!", "Quit", JOptionPane.YES_NO_OPTION);
				if(aw == JOptionPane.YES_OPTION)
				{
					//
					//Menu m = new Menu();
					//m.main(null);
					frame.dispose();
					//System.exit(aw);
				}
			}
		});
		btnBack.setBounds(89, 468, 89, 30);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBackground(Color.RED);
		frame.getContentPane().add(btnBack);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText(null);
				txtAccount.setText(null);
				txtAmount.setText(null);
				txtTotal.setText(null);
				dateChooser.setDate(null);
				txtInterest.setText(null);	
			}
		});
		btnReset.setBounds(265, 468, 89, 33);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnReset.setBackground(Color.ORANGE);
		frame.getContentPane().add(btnReset);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtAccount.getText().equals("") | txtAmount.getText().equals(""))
						JOptionPane.showMessageDialog(btnInsert, "Please type account and amount to insert!", "Error", JOptionPane.ERROR_MESSAGE);
				else {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String debtDate = null;
					debtDate = dateFormat.format(dateChooser.getDate());
					
					Debt d = new Debt(txtAccount.getText(), Integer.parseInt(txtAmount.getText()), debtDate);
					
				
					try {
						d.insert();
						JOptionPane.showMessageDialog(btnInsert, "Insert successfully!","Success", JOptionPane.INFORMATION_MESSAGE);

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(btnInsert, "Not successful, this account is on database!", "Wanrning", JOptionPane.ERROR_MESSAGE);

					}
				}
			}
		});
		btnInsert.setToolTipText("Type account, date and amount");
		btnInsert.setBounds(471, 186, 117, 33);
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnInsert.setBackground(Color.GREEN);
		frame.getContentPane().add(btnInsert);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String d = null;
				d = dateFormat.format(dateChooser.getDate());
				Connection conn = Connect.getConnect("project");
				
				PreparedStatement st2 = null;
				 ResultSet rs = null;
				 try {
						String sql2 = "update Debt set "
								+ "debt_id = ?, debt_amount = ?, debt_date = ?, debt_interest = ? "
								+ "where debt_id = ?";
						st2 = conn.prepareStatement(sql2);
						st2.setString(1, txtAccount.getText());
						st2.setInt(2, Integer.parseInt(txtAmount.getText()));
						d = dateFormat.format(dateChooser.getDate());
						st2.setString(3, d);
						st2.setInt(4, Integer.parseInt(txtInterest.getText()));
						st2.setString(5, txtAccount.getText());
						int count = st2.executeUpdate();
						JOptionPane.showMessageDialog(null, "Update successfully","Success", JOptionPane.INFORMATION_MESSAGE);
						conn.close();
						 
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnUpdate.setBackground(Color.GREEN);
		btnUpdate.setBounds(471, 252, 117, 30);
		frame.getContentPane().add(btnUpdate);
	}
}
