package PROGRAM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
public class TransForm {
	private static  String source;
	private static String des;
	private static int amount;
	private JFrame frame;
	private JTextField txtSource;
	private JTextField txtDes;
	private JTextField txtAmount;
	private String name;
	//private String Dob;
	private static String trans;
	private static String date;
	
	public String getDate()
	{
		return date;
	}
	
	public String getName() throws SQLException
	{
		Connection conn = Connect.getConnect("project");
		Statement st = null;
		ResultSet rs = null;
		
		String sql = "select c_name from customer where c_tel = '"+getSource()+"'";
	
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			String n;
			if(rs.next())
			{
				return n = rs.getString("c_name");
			}
			else
			{
				return null;
			}
	}
	
	public String getSource()
	{
		return source;
	}
	public String getDes()
	{
		return des;
	}
	public int getAmount()
	{
		return amount;
	}
	public String getTrans()
	{
		
		return trans;
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransForm window = new TransForm();
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
	public TransForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 204, 204));
		frame.setBounds(100, 100, 688, 410);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TRANSACTION");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(251, 10, 205, 46);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Source's account:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(71, 60, 171, 37);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtSource = new JTextField();
		txtSource.setToolTipText("Telephone as Account ID");
		txtSource.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSource.setBounds(241, 62, 338, 33);
		frame.getContentPane().add(txtSource);
		txtSource.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Type of transaction:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(46, 105, 185, 37);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JComboBox cmbType = new JComboBox();
		cmbType.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmbType.setModel(new DefaultComboBoxModel(new String[] {"Transfer money ", "Deposit", "Withdraw"}));
		cmbType.setSelectedIndex(0);
		cmbType.setBounds(241, 105, 195, 37);
		frame.getContentPane().add(cmbType);
		
		JLabel lblNewLabel_1_2 = new JLabel("Destination's account:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(26, 156, 195, 37);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		txtDes = new JTextField();
		txtDes.setToolTipText("Blank it if you choose deposit/withdraw\r\n");
		txtDes.setBackground(Color.WHITE);
		txtDes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDes.setColumns(10);
		txtDes.setBounds(241, 160, 338, 33);
		frame.getContentPane().add(txtDes);
		
		JCheckBox ckb = new JCheckBox("Print Bill");
		ckb.setSelected(true);
		ckb.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ckb.setBounds(480, 106, 119, 43);
		frame.getContentPane().add(ckb);
		
		JButton btnperform = new JButton("Perform");
		btnperform.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Date d = Date.valueOf(LocalDate.now());
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					/*String d = null;
					d = dateFormat.format(dateD.getDate());
					date = d;*/
					date = d.toString();
					System.out.println(date);
					int type = cmbType.getSelectedIndex();
					Trans_detail t = new Trans_detail();
					if(txtSource.getText().equals("") || txtSource.getText().length()!=10 || txtAmount.getText().equals(""))
					{
						JOptionPane.showMessageDialog(btnperform, "Please type valid source's account!!!", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						Connection conn = Connect.getConnect("project");
						PreparedStatement st = null;
						ResultSet rs = null;
						String sql = "Insert into trans_detail(trans_type, sources, des, trans_date, amount) "
								+ "values (?, ?, ?, ?, ?)";
						st = conn.prepareStatement(sql);
						source = txtSource.getText();
						//date = d;
						des = txtDes.getText();
						System.out.println(des);
						amount = Integer.parseInt(txtAmount.getText());
						switch(type)
						{
						case 0:{
							Customer c = new Customer();
							Customer check = c.search(txtSource.getText());
							trans = "Transfer money";
							if(check.Balance > Integer.parseInt(txtAmount.getText()))
							{
								
								if(txtDes.getText().length()==10)
								{
									t.transfer(txtSource.getText(), txtDes.getText(), Integer.parseInt(txtAmount.getText()));
									JOptionPane.showMessageDialog(null, "Transfer money successfully");
									st.setString(1,  trans);
									st.setString(2,  txtSource.getText());
									st.setString(3, txtDes.getText());
									st.setDate(4, d);
									st.setInt(5, Integer.parseInt(txtAmount.getText()));
									st.execute();
									if(ckb.isSelected())
									{
										Bill.main(null);
									}
								}
								else
								{
									JOptionPane.showMessageDialog(null, "Invalid destination's account!", "Error", JOptionPane.ERROR_MESSAGE);
								}
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Balance is not enough!", "Error", JOptionPane.ERROR_MESSAGE);
							}
							break;
							
						}
						case 1:
						{
							trans = "Deposit";
							t.deposit(txtSource.getText(), Integer.parseInt(txtAmount.getText()));
							st.setString(1,  trans);
							st.setString(2,  txtSource.getText());
							st.setString(3, txtDes.getText());
							st.setDate(4, d);
							st.setInt(5, Integer.parseInt(txtAmount.getText()));
							st.execute();
							if(ckb.isSelected())
							if(ckb.isSelected())
							{
								Bill.main(null);
							}
							break;
						}
						case 2: 
						{
								trans = "Withdraw";
								Customer c = new Customer();
								Customer check = c.search(txtSource.getText());
								st.setString(1,  trans);
								st.setString(2,  txtSource.getText());
								st.setString(3, txtDes.getText());
								st.setDate(4, d);
								st.setInt(5, Integer.parseInt(txtAmount.getText()));
								st.execute();
								if(ckb.isSelected())
								if(check.Balance > Integer.parseInt(txtAmount.getText()))
								{
									t.withdraw(txtSource.getText(), Integer.parseInt(txtAmount.getText()));
									JOptionPane.showMessageDialog(null, "Successfully");
									if(ckb.isSelected())
									{
										Bill.main(null);
									}
								}
								else
								{
									JOptionPane.showMessageDialog(null, "Balance is not enough!", "Error", JOptionPane.ERROR_MESSAGE);
								}
								break;
						}						
						}
						
						
						
						
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Not Successful", "Error", JOptionPane.ERROR_MESSAGE);
					// TODO Auto-generated catch block
					e1.printStackTrace();
			
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				
				
			}
		});
		btnperform.setBackground(Color.GREEN);
		btnperform.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnperform.setBounds(439, 294, 119, 33);
		frame.getContentPane().add(btnperform);
		
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
			
			
			
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBackground(Color.RED);
		btnBack.setBounds(123, 294, 119, 33);
		frame.getContentPane().add(btnBack);
		
		JLabel label = new JLabel("Amount:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(145, 213, 76, 37);
		frame.getContentPane().add(label);
		
		txtAmount = new JTextField();
		txtAmount.setToolTipText("Type the amount of money");
		txtAmount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtAmount.setColumns(10);
		txtAmount.setBackground(Color.WHITE);
		txtAmount.setBounds(241, 215, 338, 33);
		frame.getContentPane().add(txtAmount);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSource.setText(null);
				txtDes.setText(null);
				txtAmount.setText(null);
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReset.setBackground(Color.YELLOW);
		btnReset.setBounds(276, 294, 119, 33);
		frame.getContentPane().add(btnReset);
	}
}
