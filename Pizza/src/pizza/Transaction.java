package pizza;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class Transaction extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox comboBox;

	public Transaction() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 672, 656);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 255), 2));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setUndecorated(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 250));
		panel.setPreferredSize(new Dimension(10, 50));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Transaction ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 10, 116, 30);
		panel.add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.setBounds(123, 10, 197, 30);
		panel.add(comboBox);
		
		JLabel date = new JLabel("Date: ");
		date.setFont(new Font("Tahoma", Font.PLAIN, 15));
		date.setBounds(399, 10, 239, 30);
		panel.add(date);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Flavor", "Size", "Qty", "Price", "Total"
				}
			));
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(135, 206, 250));
		panel_1.setPreferredSize(new Dimension(10, 150));
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(null);
		
		JLabel total_price_lbl = new JLabel("Total Price: ");
		total_price_lbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		total_price_lbl.setBounds(431, 22, 161, 25);
		panel_1.add(total_price_lbl);
		
		JLabel cash_lbl = new JLabel("Cash: ");
		cash_lbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		cash_lbl.setBounds(477, 57, 161, 25);
		panel_1.add(cash_lbl);
		
		JLabel change_lbl = new JLabel("Change: ");
		change_lbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		change_lbl.setBounds(459, 92, 161, 25);
		panel_1.add(change_lbl);
		try {
			getRecord();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				String query = "SELECT * FROM `order_tbl` WHERE ref_id = ?";
				
				PreparedStatement st;
				try {
					st = con.getConnection().prepareStatement(query);
					st.setString(1, (String)comboBox.getSelectedItem());
					ResultSet rs = st.executeQuery();
					model.getDataVector().removeAllElements();
					while(rs.next()) {
						
						String Flavor = rs.getString("flavor");
						String size = rs.getString("size");
						String qty = rs.getString("qty");
						String price = rs.getString("price");
						String total_price = rs.getString("total") ;
						
						Object data[] = {Flavor, size, qty, price,  total_price };							
						model.addRow(data);
					}
					
					model.fireTableDataChanged();
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				String query_1 = "SELECT * FROM `transaction_tbl` WHERE ref_id = ?";
				try {
					PreparedStatement st_1 = con.getConnection().prepareStatement(query_1);
					st_1.setString(1, (String)comboBox.getSelectedItem());
					ResultSet rs_1 = st_1.executeQuery();
					
					if(rs_1.next()) {
						change_lbl.setText("Change: " + rs_1.getString("cash_change"));
						date.setText("Date: " + rs_1.getString("date"));
						cash_lbl.setText("Cash: " + rs_1.getString("cash"));
						total_price_lbl.setText("Total Price: " + rs_1.getString("total_price"));
					}else {
						change_lbl.setText("Change: " );
						date.setText("Date: " );
						cash_lbl.setText("Cash: " );
						total_price_lbl.setText("Total Price: " );
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				

			}
		});
	}
	
	private DatabaseConnection con = new DatabaseConnection();
	
	private void getRecord() throws SQLException {
		
		String query = "SELECT * FROM `transaction_tbl`";
		
		PreparedStatement st = con.getConnection().prepareStatement(query);
		
		ResultSet rs = st.executeQuery();
		
		comboBox.addItem("");
		
		while(rs.next()) {
			comboBox.addItem(rs.getString("ref_id"));
		}
		
	}
	
}
