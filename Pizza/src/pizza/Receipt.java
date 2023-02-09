package pizza;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.border.LineBorder;
// inheritance
public class Receipt extends JFrame {

	private JPanel contentPane;
	
	private JTable table_1;

	public Receipt(String cash, String totalprice, JTable table) {
		setBackground(new Color(240, 240, 240));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 575, 728);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 222, 179));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 255), 3));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setUndecorated(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(222, 184, 135));
		panel.setPreferredSize(new Dimension(10, 50));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RECEIPT OF SALE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 10, 531, 30);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(222, 184, 135));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 186, 531, 304);
		panel_1.add(scrollPane);
		
		this.table_1 = new JTable();
		
		table_1.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Flavor", "Size", "Qty", "Price", "Total"
				}
			));
		DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		
		for(int x = 0; x < table.getRowCount(); x++) {
			
			String Flavor = String.valueOf(table.getValueAt(x, 0));
			String size = String.valueOf(table.getValueAt(x, 1));
			String qty = String.valueOf(table.getValueAt(x, 2));
			String price = String.valueOf(table.getValueAt(x, 3));
			String total = String.valueOf(table.getValueAt(x, 4));
			Object data[] = {Flavor, size, qty, price,  total };
			model.addRow(data);
		}
		
		this.table_1.setShowGrid(false);
		scrollPane.setViewportView(this.table_1);
		
		JLabel lblNewLabel_1 = new JLabel("Total Price: " + totalprice);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(380, 366, 161, 25);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cash: " + cash);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(390, 517, 161, 25);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Change: " + (Integer.valueOf(cash) - Integer.valueOf(totalprice)));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(390, 552, 161, 25);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Referrence #: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 151, 169, 25);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("PIZZA ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel_3.setBounds(10, 0, 531, 30);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Koronadal City South Cotabato");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(10, 23, 531, 30);
		panel_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Carlo,Jasper,Xavier\r\n");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_1.setBounds(10, 52, 531, 30);
		panel_1.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("09548567575676");
		lblNewLabel_3_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_1_1.setBounds(10, 80, 531, 30);
		panel_1.add(lblNewLabel_3_1_1_1);
	}
}
