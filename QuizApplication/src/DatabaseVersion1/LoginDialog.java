package DatabaseVersion1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginDialog extends JDialog {
    
	private static final long serialVersionUID = 1L;
	private JTextField nameField;
    private JTextField emailField;
    private JButton startButton;
    private JButton cancelButton;
    
    private int userId = -1; 
    private boolean cancelled = false;
    
    public LoginDialog(JFrame parent) {
        super(parent, "Enter Your Details", true); 
        
        setSize(400, 250);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout(10, 10));
        
        createComponents();
        
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                handleCancel();
            }
        });
    }
    
    private void createComponents() {
        // Title Panel
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Welcome to Quiz Game!");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(0, 102, 204));
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);
        
        // Form Panel
        JPanel formPanel = new JPanel(new GridLayout(2, 2, 10, 15));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        nameField = new JTextField(20);
        nameField.setFont(new Font("Arial", Font.PLAIN, 14));
        
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        emailField = new JTextField(20);
        emailField.setFont(new Font("Arial", Font.PLAIN, 14));
        
        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(emailLabel);
        formPanel.add(emailField);
        
        add(formPanel, BorderLayout.CENTER);
        
        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        startButton = new JButton("Start Quiz");
        startButton.setFont(new Font("Arial", Font.BOLD, 14));
        startButton.setBackground(new Color(34, 139, 34));
        startButton.setForeground(Color.WHITE);
        startButton.setFocusPainted(false);
        startButton.addActionListener(e -> handleStart());
        
        cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Arial", Font.BOLD, 14));
        cancelButton.setBackground(new Color(220, 20, 60));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFocusPainted(false);
        cancelButton.addActionListener(e -> handleCancel());
        
        buttonPanel.add(startButton);
        buttonPanel.add(cancelButton);
        
        add(buttonPanel, BorderLayout.SOUTH);
        
        
        nameField.addActionListener(e -> emailField.requestFocus());
        emailField.addActionListener(e -> handleStart());
    }
    
    private void handleStart() {
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Please enter your name!", 
                "Validation Error", 
                JOptionPane.WARNING_MESSAGE);
            nameField.requestFocus();
            return;
        }
        
        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Please enter your email!", 
                "Validation Error", 
                JOptionPane.WARNING_MESSAGE);
            emailField.requestFocus();
            return;
        }
        
        
        if (!isValidEmail(email)) {
            JOptionPane.showMessageDialog(this, 
                "Please enter a valid email address!", 
                "Validation Error", 
                JOptionPane.WARNING_MESSAGE);
            emailField.requestFocus();
            return;
        }
        
       
        userId = UserDAO.saveUser(name, email);
        
        if (userId > 0) {
            JOptionPane.showMessageDialog(this, 
                "Welcome " + name + "!\nLet's start the quiz!", 
                "Success", 
                JOptionPane.INFORMATION_MESSAGE);
            dispose();  
        } else {
            JOptionPane.showMessageDialog(this, 
                "Error saving user details.\nPlease check database connection.", 
                "Database Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void handleCancel() {
        int confirm = JOptionPane.showConfirmDialog(this,
            "Are you sure you want to exit?",
            "Confirm Exit",
            JOptionPane.YES_NO_OPTION);
            
        if (confirm == JOptionPane.YES_OPTION) {
            cancelled = true;
            dispose();
        }
    }
    
    private boolean isValidEmail(String email) {
       
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }
    
    public int getUserId() {
        return userId;
    }
    
    public boolean isCancelled() {
        return cancelled;
    }
    
    public static int showLoginDialog(JFrame parent) {
        LoginDialog dialog = new LoginDialog(parent);
        dialog.setVisible(true);
        
        if (dialog.isCancelled()) {
            return -1;
        }
        
        return dialog.getUserId();
    }
}