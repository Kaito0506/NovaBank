package PROGRAM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Tran_search {

	private JFrame frame;
	private JTextField txtAccount;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tran_search window = new Tran_search();
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
	public Tran_search() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 204, 204));
		frame.setBounds(100, 100, 687, 541);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TRANSACTION SEARCH");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(178, 21, 345, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Account:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(36, 81, 90, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtAccount = new JTextField();
		txtAccount.setToolTipText("Type your phone number as account to search transaction\r\n");
		txtAccount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtAccount.setBounds(141, 77, 430, 34);
		frame.getContentPane().add(txtAccount);
		txtAccount.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(Color.GREEN);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				Connection conn = Connect.getConnect("project");
				PreparedStatement st = null;
				ResultSet rs = null;
				String sql = "select*from trans_detail where sources=?";
				try {
					if(txtAccount.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null,  "Plese type account to search!", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						DefaultTableModel model = (DefaultTableModel)table.getModel();
						st = conn.prepareStatement(sql);
						st.setString(1, txtAccount.getText());
						rs= st.executeQuery();
						
							while(rs.next())
							{
								model.addRow(new Object [] {rs.getString(1), rs.getString(2),
										rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6)});
							}
					}
				
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSearch.setBounds(459, 138, 112, 31);
		frame.getContentPane().add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 191, 653, 282);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.setBackground(Color.WHITE);
		table.setCellSelectionEnabled(true);
		table.setEnabled(false);
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "Type", "Source", "Destination", "Date", "Amount"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(34);
		table.getColumnModel().getColumn(1).setPreferredWidth(108);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel());
				table.setModel(new DefaultTableModel(
						new Object[][] {
							
						},
						new String[] {
							"STT", "Type", "Source", "Destination", "Date", "Amount"
						}
					));
				txtAccount.setText(null);
				table.getColumnModel().getColumn(0).setPreferredWidth(34);
				table.getColumnModel().getColumn(1).setPreferredWidth(108);
				table.setFont(new Font("Tahoma", Font.PLAIN, 15));
			}
		});
		btnReset.setBackground(Color.YELLOW);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReset.setBounds(303, 138, 102, 31);
		frame.getContentPane().add(btnReset);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int aw = JOptionPane.showConfirmDialog(btnBack, "Do you want to return menu!", "Quit", JOptionPane.YES_NO_OPTION);
				if(aw == JOptionPane.YES_OPTION)
				{
					frame.dispose();
				}
				
				
			}
		});
		btnBack.setBackground(Color.RED);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBounds(141, 138, 102, 31);
		frame.getContentPane().add(btnBack);
	}
}
