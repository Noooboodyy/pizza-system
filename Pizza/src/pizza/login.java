package pizza;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	
	private DatabaseConnection con = new DatabaseConnection();
	private JButton btnRegister;
	private JLabel lblx;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	//login
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 985, 680);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 255));
		contentPane.setForeground(new Color(0, 0, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(283, 40, 412, 550);
		contentPane.add(panel);
		
		passwordField = new JPasswordField();
		
		btnNewButton = new JButton("Login");
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBackground(SystemColor.inactiveCaptionBorder);
		
		lblNewLabel = new JLabel("Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 28));
		
		lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Arial", Font.BOLD, 18));
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.BOLD, 18));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		btnRegister = new JButton("Register");
		btnRegister.setForeground(Color.BLUE);
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRegister.setBackground(SystemColor.inactiveCaptionBorder);
		btnRegister.addActionListener(new ActionListener() {
			//register
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(textField.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Enter your username!");
				}else if(String.valueOf(passwordField.getPassword()).isBlank()) {
					JOptionPane.showMessageDialog(null, "Enter your password!");
				}else {
					try {
						InsertTransaction(textField.getText(), String.valueOf(passwordField.getPassword()));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
			}
			
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(55)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(58)
					.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(58)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(58)
					.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(55)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(50)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(44)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnRegister, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)))
		);
		panel.setLayout(gl_panel);
		
		lblx = new JLabel("X");
		lblx.addMouseListener(new MouseAdapter() {
			// close function
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to close this application","Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					login.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblx.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblx.setForeground(Color.WHITE);
			}
		});
		lblx.setHorizontalAlignment(SwingConstants.CENTER);
		lblx.setFont(new Font("Swis721 BT", Font.BOLD, 20));
		lblx.setForeground(new Color(255, 255, 255));
		lblx.setBounds(955, 10, 20, 20);
		contentPane.add(lblx);
		
		btnNewButton.addActionListener(new ActionListener() {
			//login
			public void actionPerformed(ActionEvent e) {
				
				if(textField.getText().isBlank()) {
					JOptionPane.showMessageDialog(null, "Enter your username!");
				}else if(String.valueOf(passwordField.getPassword()).isBlank()) {
					JOptionPane.showMessageDialog(null, "Enter your password!");
				}else {
					ResultSet rs = con.getAccount(textField.getText());
					String getPassword = String.valueOf(passwordField.getPassword());
					try {
						if(rs.next()) {
							if(rs.getString("Password").equals(getPassword)) {
								new PizzaFrame().setVisible(true);
								dispose();
							}else {
								JOptionPane.showMessageDialog(null, "Incorrect Password");
							}
						}else {
							JOptionPane.showMessageDialog(null, "Username is not register");
						}
					} catch (HeadlessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				

			}
		});
	}
	
private void InsertTransaction	(String userName, String password) throws SQLException {
		
		String query = "INSERT INTO `login`(`Username`, `Password`) VALUES (?,?)";
		
		PreparedStatement st = con.getConnection().prepareStatement(query);
		st.setString(1, userName);
		st.setString(2, password);
		
		st.execute();	
		JOptionPane.showMessageDialog(null, "Account Created!");
		
	}
}
