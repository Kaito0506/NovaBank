package PROGRAM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDayChooser;
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;

public class InsertForm {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtCccd;
	private JTextField txtAdd;
	private JTextField txtTel;
	private JTextField IntBal;
	private JPasswordField txtPass;
	private JDateChooser dateDob;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertForm window = new InsertForm();
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
	public InsertForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 204, 204));
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.setBounds(100, 100, 705, 506);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INSERT FORM");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(207, 0, 243, 51);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(42, 55, 73, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtName = new JTextField();
		txtName.setToolTipText("Customer's name");
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtName.setBounds(141, 49, 389, 38);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("CCCD:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(42, 99, 73, 25);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		txtCccd = new JTextField();
		txtCccd.setToolTipText("Type ID");
		txtCccd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCccd.setColumns(10);
		txtCccd.setBounds(141, 93, 389, 37);
		frame.getContentPane().add(txtCccd);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Date of birth(YYYY-MM-DD):");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(42, 150, 270, 25);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Address:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_2.setBounds(42, 195, 91, 25);
		frame.getContentPane().add(lblNewLabel_1_1_2);
		
		txtAdd = new JTextField();
		txtAdd.setToolTipText("Customer's address");
		txtAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtAdd.setColumns(10);
		txtAdd.setBounds(141, 185, 389, 37);
		frame.getContentPane().add(txtAdd);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tel:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(42, 242, 73, 25);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		txtTel = new JTextField();
		txtTel.setToolTipText("Type telephone number");
		txtTel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTel.setColumns(10);
		txtTel.setBounds(141, 236, 389, 38);
		frame.getContentPane().add(txtTel);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Password:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2_1.setBounds(42, 283, 91, 25);
		frame.getContentPane().add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Balance:");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2_1_1.setBounds(42, 335, 91, 25);
		frame.getContentPane().add(lblNewLabel_1_2_1_1);
		
		IntBal = new JTextField();
		IntBal.setToolTipText("Balance is number of money in account (<3000000000)");
		IntBal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		IntBal.setColumns(10);
		IntBal.setBounds(141, 335, 389, 38);
		frame.getContentPane().add(IntBal);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText(null);
				txtCccd.setText(null);
				dateDob.setDate(null);
				txtAdd.setText(null);
				txtTel.setText(null);
				txtPass.setText(null);
				IntBal.setText(null);
			}
		});
		btnReset.setBackground(Color.ORANGE);
		btnReset.setForeground(Color.BLACK);
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReset.setBounds(367, 408, 83, 36);
		frame.getContentPane().add(btnReset);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setToolTipText("Type all information ");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String dob = null;
				if(txtName.getText().equals("") | txtCccd.getText().equals("")  |dateDob.getDate()==null |txtAdd.getText().equals("") | txtTel.getText().equals("") | txtPass.getText().equals("") | IntBal.getText().equals(""))
						JOptionPane.showMessageDialog(btnInsert, "Please type all information!", "Error", JOptionPane.ERROR_MESSAGE);
				else {
					
					dob = dateFormat.format(dateDob.getDate());
					Customer c = new Customer(txtName.getText(), txtCccd.getText(),
							dob, txtAdd.getText(),
							txtTel.getText(), txtPass.getText(), Integer.parseInt(IntBal.getText()));
					try {
						c.insert();
						JOptionPane.showMessageDialog(btnInsert, "Insert successfully!","Success", JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e1) {
						//System.out.println("Error: "+ e);
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(btnInsert, "Not successful!", "Wanrning", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			
		});
		btnInsert.setBackground(Color.GREEN);
		btnInsert.setForeground(Color.BLACK);
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnInsert.setBounds(562, 30, 101, 36);
		frame.getContentPane().add(btnInsert);
		
		JButton btnQuit = new JButton("Back");
		btnQuit.setSelectedIcon(null);
		btnQuit.setIcon(null);
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int aw = JOptionPane.showConfirmDialog(btnQuit, "Do you want to return menu!", "Quit", JOptionPane.YES_NO_OPTION);
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
		btnQuit.setForeground(Color.BLACK);
		btnQuit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnQuit.setBackground(Color.RED);
		btnQuit.setBounds(207, 408, 91, 36);
		frame.getContentPane().add(btnQuit);
		
		txtPass = new JPasswordField();
		txtPass.setToolTipText("Password is 6 digits");
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPass.setBounds(141, 287, 389, 38);
		frame.getContentPane().add(txtPass);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Customer m = new Customer();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String dob = null;
				dob = dateFormat.format(dateDob.getDate());
				try {
					if(txtTel.getText().equals(""))
					{
						JOptionPane.showMessageDialog(btnInsert, "Please type telephone number to update information!", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						Customer c = new Customer(txtName.getText(), txtCccd.getText(),
								dob, txtAdd.getText(),
								txtTel.getText(), txtPass.getText(), Integer.parseInt(IntBal.getText()));
						
						m.update(c.C_Name, c.C_CCCD, c.C_Dob, c.C_Address, c.C_Tel, c.C_Pass, c.Balance);
						JOptionPane.showMessageDialog(btnInsert, "Update successfully!","Success", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(btnInsert, "Can not update!", "Wanrning", JOptionPane.ERROR_MESSAGE);
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdate.setBackground(Color.GREEN);
		btnUpdate.setBounds(562, 88, 101, 36);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer m = new Customer();
				try {
					if(txtTel.getText().equals(""))
					{
						JOptionPane.showMessageDialog(btnInsert, "Please type telephone number to delete account!", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						m.delete(txtTel.getText());
						JOptionPane.showMessageDialog(btnInsert, "Delete successfully!","Success", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(btnInsert, "Can not delete!", "Wanrning", JOptionPane.ERROR_MESSAGE);
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDelete.setBackground(Color.GREEN);
		btnDelete.setBounds(562, 149, 101, 36);
		frame.getContentPane().add(btnDelete);
		
		JButton btnsearch = new JButton("Search");
		btnsearch.setToolTipText("Type telephone number to search\r\n");
		btnsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtTel.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please type telephone number to search!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else 
				{
					Customer c = new Customer();
					try {
							Customer c2 = c.search(txtTel.getText());
							if(c2!=null)
							{
								
								txtName.setText(c2.C_Name);
								txtCccd.setText(c2.C_CCCD);
								txtTel.setText(c2.C_Tel);
								dateDob.setDate(Date.valueOf(c2.C_Dob));
								
								Date da = Date.valueOf(c2.C_Dob);
								System.out.println(da);
								System.out.println(c2.C_Dob);
								
								txtPass.setText(c2.C_Pass);
								txtAdd.setText(c2.C_Address);
								IntBal.setText(String.valueOf(c2.Balance));	
								
							}
							else 
							{
								JOptionPane.showMessageDialog(btnsearch, "Can not find", "Warning", JOptionPane.WARNING_MESSAGE);
							}
							
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						System.out.println("Error: " +e1);
						e1.printStackTrace();
					}
					
				}
				
				
			}
		});
		btnsearch.setForeground(Color.BLACK);
		btnsearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnsearch.setBackground(Color.GREEN);
		btnsearch.setBounds(562, 206, 101, 36);
		frame.getContentPane().add(btnsearch);
		
		dateDob = new JDateChooser();
		dateDob.setBounds(322, 140, 208, 35);
		frame.getContentPane().add(dateDob);
	}
}
