package pizza;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.LinkedList;
import javax.swing.JSpinner;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
//inhiratance
public class PizzaFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;


	
	private String Flavor = "" ;
	private String size = "";
	private int price ;
	private int totalPrice = 0;
	private int selecteRow; 
	//constructor
	public PizzaFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1364, 736);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pizza Ordering System");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 0, 1262, 86);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Hawaian Pizza");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\user\\Downloads\\hawaian.jpg"));
		btnNewButton_2.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBounds(10, 174, 177, 122);
		
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("BBQ Chicken Pizza");
		btnNewButton_2_1.setIcon(new ImageIcon("C:\\Users\\user\\Downloads\\bbq pizza.jpg"));
		btnNewButton_2_1.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2_1.setBounds(10, 330, 171, 122);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("Bufallu chicken Pizza");
		btnNewButton_2_1_1.setIcon(new ImageIcon("C:\\Users\\user\\Downloads\\bufalo.jpg"));
		btnNewButton_2_1_1.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2_1_1.setBounds(10, 486, 171, 131);
		contentPane.add(btnNewButton_2_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Menu");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 124, 136, 43);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Size");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(203, 124, 136, 43);
		contentPane.add(lblNewLabel_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("SansSerif", Font.PLAIN, 14));
		scrollPane.setBounds(542, 108, 798, 570);
		contentPane.add(scrollPane);
		
		table = new JTable();

		table.setFont(new Font("SansSerif", Font.PLAIN, 14));
		JTableHeader head = table.getTableHeader();
		head.setFont(new Font("SansSerif", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Flavor", "Size", "Qty", "Price", "Total"
			}
		));
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		table.getColumnModel().getColumn(0).setPreferredWidth(175);
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				selecteRow = table.getSelectedRow();
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		table.setDragEnabled(false);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1_2 = new JLabel("Total Price");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(226, 345, 136, 28);
		contentPane.add(lblNewLabel_1_2);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(226, 383, 286, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(226, 555, 286, 28);
		contentPane.add(textField_2);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if(!((c >= '0')&& (c <= '9') || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_BACK_SPACE))) {
					e.consume();
					
				}
			}
			
			public void keyReleased(KeyEvent e) {
				int total_price = Integer.valueOf(textField_1.getText());
				int cash = Integer.valueOf(textField.getText());
				int change = total_price - cash;
				textField_2.setText(String.valueOf(change)) ;
			}
		});
		textField_1.setColumns(10);
		textField_1.setBounds(226, 459, 286, 28);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Cash");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBounds(226, 431, 136, 28);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Change");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1.setBounds(226, 501, 136, 28);
		contentPane.add(lblNewLabel_1_2_1_1);
		
		JButton btnPrintReceipt = new JButton("Pay Now");
		btnPrintReceipt.addActionListener(new ActionListener() {
			
			//for pay bttn 
			public void actionPerformed(ActionEvent e) {
				
				if(textField_1.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Enter cash");
				}else {

					int cash = Integer.valueOf(textField_1.getText());
					int total_price = Integer.valueOf(textField.getText());
					
					if(cash <= total_price) {
						JOptionPane.showMessageDialog(null, "Enter a valid cash");
					}else {
						new Receipt(textField_1.getText(), textField.getText(), table).setVisible(true);
						try {
							
							String ref_num =  RandNum();
							InsertData(ref_num, table);
							InsertTransaction(ref_num,  String.valueOf(total_price),  String.valueOf(cash), String.valueOf((cash - total_price)));
							model.getDataVector().removeAllElements();
							model.fireTableDataChanged();
						} catch (SQLException e1) {

							e1.printStackTrace();
						}
						
					}
				}
			
			}
		});
		btnPrintReceipt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPrintReceipt.setBounds(376, 593, 136, 28);
		contentPane.add(btnPrintReceipt);
		// for flavor menus
		btnNewButton_2_1_1.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				Flavor = btnNewButton_2_1_1.getText();
				btnNewButton_2_1_1.setBorder(new LineBorder(Color.BLUE, 2, true));
				btnNewButton_2.setBorder(null);
				btnNewButton_2_1.setBorder(null);
			}
		});
		
		btnNewButton_2.addActionListener(new ActionListener() {
					
			public void actionPerformed(ActionEvent e) {
				Flavor = btnNewButton_2.getText();
				btnNewButton_2.setBorder(new LineBorder(Color.BLUE, 2, true));
				btnNewButton_2_1_1.setBorder(null);
				btnNewButton_2_1.setBorder(null);
			}
		});
		
		btnNewButton_2_1.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				Flavor = btnNewButton_2_1.getText();
				btnNewButton_2_1.setBorder(new LineBorder(Color.BLUE, 2, true));
				btnNewButton_2.setBorder(null);
				btnNewButton_2_1_1.setBorder(null);
			}
		});
		
		JRadioButton Large = new JRadioButton("Large");
		Large.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Large.setBounds(206, 174, 133, 28);
		contentPane.add(Large);
		
		JRadioButton Medium = new JRadioButton("Medium");
		Medium.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Medium.setBounds(206, 204, 133, 28);
		contentPane.add(Medium);
		
		JRadioButton Small = new JRadioButton("Small");
		Small.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Small.setBounds(206, 234, 133, 28);
		contentPane.add(Small);
		
		Large.addItemListener(new ChooseSize(Large,Medium, Small));
		Medium.addItemListener(new ChooseSize(Medium,Small, Large));
		Small.addItemListener(new ChooseSize(Small,Large, Medium));
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(351, 179, 136, 28);
		contentPane.add(spinner);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Quantity");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(351, 124, 136, 43);
		contentPane.add(lblNewLabel_1_1_1);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(376, 268, 136, 28);
		
		contentPane.add(btnNewButton);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRemove.setBounds(226, 268, 136, 28);
		btnRemove.addActionListener(new ActionListener() {
			//remove bttn
			@Override
			public void actionPerformed(ActionEvent e) {
				
				totalPrice = totalPrice - (int)model.getValueAt(selecteRow, 4);
				textField.setText(String.valueOf(totalPrice));
				model.removeRow(selecteRow);
			}
			
		});
		contentPane.add(btnRemove);
		
		JButton btnTransaction = new JButton("Transaction");
		btnTransaction.addActionListener(new ActionListener() {
			// trasaction bttn 
			public void actionPerformed(ActionEvent e) {
				new Transaction().setVisible(true);;
			}
		});
		btnTransaction.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTransaction.setBounds(226, 593, 136, 28);
		contentPane.add(btnTransaction);
		
		JLabel lblNewLabel_2 = new JLabel("Hawaiian pizza");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(31, 292, 136, 28);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("BBQ pizza");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(51, 448, 136, 28);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Chicken pizza");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_1.setBounds(45, 612, 136, 28);
		contentPane.add(lblNewLabel_2_1_1);
		
		btnNewButton.addActionListener(new ActionListener() {
			//add bttn
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int qty = (int) spinner.getValue();
				
				if(Flavor.isBlank()) {
					
					JOptionPane.showMessageDialog(null,"Please Select a flavor!");
					
				}else if(size.isBlank()){
					JOptionPane.showMessageDialog(null,"Please Select a pizza size!");
				}else if(qty == 0) {
					JOptionPane.showMessageDialog(null,"Please select quantity");
				}else{
					totalPrice = (qty * price) + totalPrice;
					
					textField.setText(String.valueOf(totalPrice));
					Object data[] = {Flavor, size, qty, price,  (qty * price) };		
					
					model.addRow(data);
				}

				
			}
			
		});
		
	}
	
	private DatabaseConnection con = new DatabaseConnection();
	
	private void InsertData(String ref_num, JTable table) throws SQLException {
		
		String query = "INSERT INTO `order_tbl`(`ref_id`, `flavor`, `size`, `qty`, `price`, `total`) VALUES (?,?,?,?,?,?)";
		
		PreparedStatement st = con.getConnection().prepareStatement(query);
		
		for(int x = 0; x < table.getRowCount(); x++) {
			st.setString(1, ref_num);
			st.setString(2, String.valueOf(table.getValueAt(x, 0)));
			st.setString(3, String.valueOf(table.getValueAt(x, 1)));
			st.setString(4, String.valueOf(table.getValueAt(x, 2)));
			st.setString(5, String.valueOf(table.getValueAt(x, 3)));
			st.setString(6, String.valueOf(table.getValueAt(x, 4)));		
			st.execute();
		}
		
	}
	
	private void InsertTransaction	(String ref_num, String total_price, String cash, String change) throws SQLException {
		
		String query = "INSERT INTO `transaction_tbl`(`ref_id`, `date`, `total_price`, `cash`, `cash_change`) VALUES(?,?,?,?,?) ";
		
		PreparedStatement st = con.getConnection().prepareStatement(query);
		
	    LocalDateTime currentLocalDateTime = LocalDateTime.now();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = currentLocalDateTime.format(dateTimeFormatter);
		
			st.setString(1, ref_num);
			st.setString(2, String.valueOf(formattedDateTime));
			st.setString(3, total_price);
			st.setString(4, cash);
			st.setString(5, change);
			
			st.execute();		
		
	}
	
	//interafce
	// and constructors overloding
	private String RandNum() {
		
		int random_int = (int)Math.floor(Math.random() * (99999 - 10000 + 1) + 10000);
		
		return String.valueOf(random_int);
	}
	
	// and this keyword 
	class ChooseSize implements ItemListener{


		private JRadioButton getSize;
		private JRadioButton uncheck;
		private JRadioButton uncheck_1;
		
		
		public ChooseSize(JRadioButton getSize, JRadioButton uncheck, JRadioButton uncheck_1 ) {

			this.getSize = getSize;
			this.uncheck = uncheck;
			this.uncheck_1 =uncheck_1;
		}
		
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			
			int state = e.getStateChange();
			
			if(state == ItemEvent.SELECTED) {
				size = getSize.getText();
				price = getPrice(size);
				
				uncheck.setSelected(false);
				uncheck_1.setSelected(false);
			}
			
		}
		// encapsulaion
		
		private int getPrice(String getSize) {
			int Price = 0;
			
			switch(getSize) {
			case "Large":
				Price = 400;
				break;
			case "Medium":
				Price = 300;
				break;
			case "Small":
				Price = 200;
				break;
			}
			return Price;
		}
	
}
}	