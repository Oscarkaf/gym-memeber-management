package GymCoursework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

public class GymGUI extends JFrame {
    private java.util.ArrayList members;

    private JTextField idField, nameField, locationField, phoneField, emailField,
    referralSourceField, paymentField, removalReasonField, trainerNameField,
    regularPriceField, premiumChargeField, discountAmountField, memberIdField;
    private JComboBox dobYearComboBox, dobMonthComboBox, dobDayComboBox,
    msYearComboBox, msMonthComboBox, msDayComboBox, planComboBox;
    private JRadioButton maleButton, femaleButton;
    private JButton clearButton;
    private JButton addRegularButton, addPremiumButton, activateButton, deactivateButton,
    markAttendanceButton, revertRegularButton, revertPremiumButton, displayButton,
    payDueButton, discountAmountButton,SaveFileButton,ReadFileButton;

    public GymGUI() {
        members = new java.util.ArrayList();

        setTitle("Gym Member Management System");
        setSize(1000, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel formPanel = createFormPanel();
        JPanel actionPanel = createActionPanel();
        JPanel operationPanel = createOperationPanel();

        JPanel centerPanel = new JPanel(new BorderLayout(10, 10));
        centerPanel.add(formPanel, BorderLayout.NORTH);
        centerPanel.add(actionPanel, BorderLayout.CENTER);

        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(operationPanel, BorderLayout.SOUTH);

        add(mainPanel);

        addActionListeners();

        setVisible(true);
    }

    private JPanel createFormPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Member Details"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(8, 8, 8, 8);

        idField = new JTextField(15);
        nameField = new JTextField(15);
        locationField = new JTextField(15);
        phoneField = new JTextField(15);
        emailField = new JTextField(15);
        referralSourceField = new JTextField(15);
        paymentField = new JTextField(15);
        removalReasonField = new JTextField(15);
        trainerNameField = new JTextField(15);

        regularPriceField = new JTextField("6500.0", 10);
        premiumChargeField = new JTextField("50000.0", 10);
        discountAmountField = new JTextField("0.0", 10);
        regularPriceField.setEditable(false);
        premiumChargeField.setEditable(false);
        discountAmountField.setEditable(false);

        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        String[] years = {"1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000", "2001", "2002", "2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025"};
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] days = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", 
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};

        dobYearComboBox = new JComboBox(years);
        dobMonthComboBox = new JComboBox(months);
        dobDayComboBox = new JComboBox(days);
        msYearComboBox = new JComboBox(years);
        msMonthComboBox = new JComboBox(months);
        msDayComboBox = new JComboBox(days);

        String[] plans = {"Basic", "Standard", "Deluxe"};
        planComboBox = new JComboBox(plans);

        int row = 0;

        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1;
        panel.add(idField, gbc);
        gbc.gridx = 2;
        panel.add(new JLabel("Name:"), gbc);
        gbc.gridx = 3;
        panel.add(nameField, gbc);

        row++;
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Location:"), gbc);
        gbc.gridx = 1;
        panel.add(locationField, gbc);
        gbc.gridx = 2;
        panel.add(new JLabel("Phone:"), gbc);
        gbc.gridx = 3;
        panel.add(phoneField, gbc);

        row++;
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        panel.add(emailField, gbc);
        gbc.gridx = 2;
        panel.add(new JLabel("Gender:"), gbc);
        gbc.gridx = 3;
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        panel.add(genderPanel, gbc);

        row++;
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("DOB (Y-M-D):"), gbc);
        gbc.gridx = 1;
        JPanel dobPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dobPanel.add(dobYearComboBox);
        dobPanel.add(new JLabel("-"));
        dobPanel.add(dobMonthComboBox);
        dobPanel.add(new JLabel("-"));
        dobPanel.add(dobDayComboBox);
        panel.add(dobPanel, gbc);
        gbc.gridx = 2;
        panel.add(new JLabel("Referral Source:"), gbc);
        gbc.gridx = 3;
        panel.add(referralSourceField, gbc);

        row++;
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Membership Start Date (Y-M-D):"), gbc);
        gbc.gridx = 1;
        JPanel msPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        msPanel.add(msYearComboBox);
        msPanel.add(new JLabel("-"));
        msPanel.add(msMonthComboBox);
        msPanel.add(new JLabel("-"));
        msPanel.add(msDayComboBox);
        panel.add(msPanel, gbc);
        gbc.gridx = 2;
        panel.add(new JLabel("Trainer Name:"), gbc);
        gbc.gridx = 3;
        panel.add(trainerNameField, gbc);

        row++;
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Payment Amount:"), gbc);
        gbc.gridx = 1;
        panel.add(paymentField, gbc);
        gbc.gridx = 2;
        panel.add(new JLabel("Removal Reason:"), gbc);
        gbc.gridx = 3;
        panel.add(removalReasonField, gbc);

        row++;
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Plan:"), gbc);
        gbc.gridx = 1;
        panel.add(planComboBox, gbc);
        gbc.gridx = 2;
        panel.add(new JLabel("Regular Plan Price:"), gbc);
        gbc.gridx = 3;
        panel.add(regularPriceField, gbc);

        row++;
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Premium Charge:"), gbc);
        gbc.gridx = 1;
        panel.add(premiumChargeField, gbc);
        gbc.gridx = 2;
        panel.add(new JLabel("Discount Amount:"), gbc);
        gbc.gridx = 3;
        panel.add(discountAmountField, gbc);

        return panel;
    }

    private JPanel createActionPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 4, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Actions"));
        panel.setPreferredSize(new Dimension(900, 150));

        addRegularButton = createStyledButton("Add Regular Member");
        addPremiumButton = createStyledButton("Add Premium Member");
        activateButton = createStyledButton("Activate Membership");
        deactivateButton = createStyledButton("Deactivate Membership");
        markAttendanceButton = createStyledButton("Mark Attendance");
        revertRegularButton = createStyledButton("Revert Regular Member");
        revertPremiumButton = createStyledButton("Revert Premium Member");
        clearButton = createStyledButton("Clear Fields");
        displayButton = createStyledButton("Display Members");
        payDueButton = createStyledButton("Pay Due");
        discountAmountButton = createStyledButton("Discount Amount");
        SaveFileButton = new JButton("Save file");
        SaveFileButton.setFont(new Font("Arial", Font.BOLD, 12));
        ReadFileButton =  new JButton("Read File");
        ReadFileButton.setFont(new Font("Arial", Font.BOLD, 12));

        panel.add(addRegularButton);
        panel.add(addPremiumButton);
        panel.add(activateButton);
        panel.add(deactivateButton);
        panel.add(markAttendanceButton);
        panel.add(revertRegularButton);
        panel.add(revertPremiumButton);
        panel.add(clearButton);
        panel.add(displayButton);
        panel.add(payDueButton);
        panel.add(discountAmountButton);
        panel.add(SaveFileButton);
        panel.add(ReadFileButton);
        panel.add(new JLabel(""));

        return panel;
    }

    private JPanel createOperationPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Member Operations"));

        memberIdField = new JTextField(15);
        JLabel memberIdLabel = new JLabel("Enter Member ID:");

        panel.add(memberIdLabel);
        panel.add(memberIdField);

        return panel;
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(180, 30));
        button.setFont(new Font("Arial", Font.BOLD, 12));
        return button;
    }

    private void addActionListeners() {
            addRegularButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    addRegularMember();
                }
            });
            addPremiumButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    addPremiumMember();
                }
            });
            activateButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    changeMembershipStatus(true);
                }
            });
            deactivateButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    changeMembershipStatus(false);
                }
            });
            markAttendanceButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    markAttendance();
                }
            });
            revertRegularButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    revertMember("Regular");
                }
            });
            revertPremiumButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    revertMember("Premium");
                }
            });
            clearButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    clearFields();
                }
            });
            displayButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    displayMembers();
                }
            });
            payDueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    payDue();
                }
            });
            discountAmountButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    applyDiscount();
                }
            });
            SaveFileButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                     SaveFile();
                }
            });
            
            ReadFileButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        // Read the file content
                        FileReader reader = new FileReader("Member.txt");
                        int ch;
                        String fileContent = "";

                        while ((ch = reader.read()) != -1) {
                            fileContent += (char) ch;
                        }
                        reader.close();

                        // Create a new JPanel
                        JPanel panel = new JPanel();
                        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

                        // Create a label or text area to show file content
                        JTextArea fileText = new JTextArea(15, 40);
                        fileText.setText(fileContent);
                        fileText.setEditable(false);

                        JScrollPane scrollPane = new JScrollPane(fileText);
                        panel.add(scrollPane);

                        // Show the panel in a dialog (or add to frame if you prefer)
                        JOptionPane.showMessageDialog(null, panel, "Member.txt Contents", JOptionPane.PLAIN_MESSAGE);

                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error reading file: " + ex.getMessage());
                    }
                }
            });
            
    }

        private void SaveFile() {
        if (members.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No member data to save.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            FileWriter writer = new FileWriter("Member.txt");
            for (Object obj : members) {
                GymMember member = (GymMember) obj;
                writer.write("Member ID: " + member.getId() + "\n");
                writer.write("Name: " + member.getName() + "\n");
                writer.write("Location: " + member.getLocation() + "\n");
                writer.write("Phone: " + member.getPhone() + "\n");
                writer.write("Email: " + member.getEmail() + "\n");
                writer.write("Gender: " + member.getGender() + "\n");
                writer.write("DOB: " + member.getDOB() + "\n");
                writer.write("Membership Start Date: " + member.getMembershipStartDate() + "\n");
                writer.write("Active Status: " + member.isActiveStatus() + "\n");
                writer.write("Attendance: " + member.getAttendance() + "\n");
                writer.write("Loyalty Points: " + member.getLoyaltyPoints() + "\n");
                if (member instanceof RegularMember) {
                    RegularMember rm = (RegularMember) member;
                    writer.write("Member Type: Regular\n");
                    writer.write("Referral Source: " + rm.getReferralSource() + "\n");
                    writer.write("Plan: " + rm.getPlan() + "\n");
                    writer.write("Price: " + rm.getPrice() + "\n");
                    writer.write("Attendance Limit: " + rm.getAttendanceLimit() + "\n");
                    writer.write("Eligible for Upgrade: " + rm.isEligibleForUpgrade() + "\n");
                    if (!rm.getRemovalReason().isEmpty()) {
                        writer.write("Removal Reason: " + rm.getRemovalReason() + "\n");
                    }
                } else if (member instanceof PremiumMember) {
                    PremiumMember pm = (PremiumMember) member;
                    writer.write("Member Type: Premium\n");
                    writer.write("Personal Trainer: " + pm.getPersonalTrainer() + "\n");
                    writer.write("Premium Charge: " + pm.getPremiumCharge() + "\n");
                    writer.write("Paid Amount: " + pm.getPaidAmount() + "\n");
                    writer.write("Discount Amount: " + pm.getDiscountAmount() + "\n");
                    writer.write("Full Payment Done: " + pm.isFullPayment() + "\n");
                }
                writer.write("\n");
            }
            writer.close();
            JOptionPane.showMessageDialog(this, "Member data saved successfully to Member.txt!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    private void addRegularMember() {
        try {
            if (!trainerNameField.getText().isEmpty()) {
                showMessage("This feature is only for premium members.");
                return;
            }
            if (idField.getText().isEmpty() || nameField.getText().isEmpty() || 
            locationField.getText().isEmpty() || phoneField.getText().isEmpty() || 
            emailField.getText().isEmpty() || referralSourceField.getText().isEmpty() ||
            (!maleButton.isSelected() && !femaleButton.isSelected())) {
                showMessage("Please fill all required fields.");
                return;
            }
            int id = Integer.parseInt(idField.getText());
            if (isDuplicateId(id)) {
                showMessage("Member ID already exists!");
                return;
            }
            String name = nameField.getText();
            String location = locationField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            String gender = maleButton.isSelected() ? "Male" : "Female";
            String dob = dobYearComboBox.getSelectedItem() + "-" + dobMonthComboBox.getSelectedItem() + "-" + dobDayComboBox.getSelectedItem();
            String startDate = msYearComboBox.getSelectedItem() + "-" + msMonthComboBox.getSelectedItem() + "-" + msDayComboBox.getSelectedItem();
            String referral = referralSourceField.getText();

            members.add(new RegularMember(id, name, location, phone, email, gender, dob, startDate, referral));
            showMessage("Regular Member Added Successfully");
            clearFields();
        } catch (NumberFormatException e) {
            showMessage("Please enter valid numerical values for ID.");
        }
    }

    private void addPremiumMember() {
        try {
            if (idField.getText().isEmpty() || nameField.getText().isEmpty() || 
            locationField.getText().isEmpty() || phoneField.getText().isEmpty() || 
            emailField.getText().isEmpty() || 
            (!maleButton.isSelected() && !femaleButton.isSelected())) {
                showMessage("Please fill all required fields.");
                return;
            }
            int id = Integer.parseInt(idField.getText());
            if (isDuplicateId(id)) {
                showMessage("Member ID already exists!");
                return;
            }
            String name = nameField.getText();
            String location = locationField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            String gender = maleButton.isSelected() ? "Male" : "Female";
            String dob = dobYearComboBox.getSelectedItem() + "-" + dobMonthComboBox.getSelectedItem() + "-" + dobDayComboBox.getSelectedItem();
            String startDate = msYearComboBox.getSelectedItem() + "-" + msMonthComboBox.getSelectedItem() + "-" + msDayComboBox.getSelectedItem();
            String trainer = trainerNameField.getText();

            members.add(new PremiumMember(id, name, location, phone, email, gender, dob, startDate, trainer));
            showMessage("Premium Member Added Successfully");
            clearFields();
        } catch (NumberFormatException e) {
            showMessage("Please enter valid numerical values for ID.");
        }
    }

    private void changeMembershipStatus(boolean activate) {
        try {
            int id = Integer.parseInt(memberIdField.getText());
            for (int i = 0; i < members.size(); i++) {
                GymMember m = (GymMember) members.get(i);
                if (m.getId() == id) {
                    if (activate && m.isActiveStatus()) {
                        showMessage("Membership is already active.");
                        return;
                    } else if (!activate && !m.isActiveStatus()) {
                        showMessage("Membership is already inactive.");
                        return;
                    }
                    if (activate) {
                        m.activateMembership();
                    } else {
                        m.deactivateMembership();
                    }
                    showMessage("Membership status updated.");
                    return;
                }
            }
            showMessage("Member ID not found.");
        } catch (NumberFormatException e) {
            showMessage("Please enter a valid numeric Member ID.");
        }
    }

    private void markAttendance() {
        try {
            int id = Integer.parseInt(memberIdField.getText());
            for (int i = 0; i < members.size(); i++) {
                GymMember m = (GymMember) members.get(i);
                if (m.getId() == id) {
                    if (m.isActiveStatus()) {
                        m.markAttendance();
                        showMessage("Attendance has been marked.");
                    } else {
                        showMessage("Membership not active. Attendance not marked.");
                    }
                    return;
                }
            }
            showMessage("Member ID not found. Please enter a valid member ID.");
        } catch (NumberFormatException e) {
            showMessage("Please enter a valid numeric Member ID.");
        }
    }

    private void revertMember(String type) {
        try {
            int id = Integer.parseInt(memberIdField.getText());
            for (int i = 0; i < members.size(); i++) {
                GymMember m = (GymMember) members.get(i);
                if (m.getId() == id) {
                    if (type.equals("Regular") && m instanceof RegularMember) {
                        ((RegularMember) m).revertRegularMember(removalReasonField.getText());
                        showMessage("Regular Member reverted.");
                        return;
                    } else if (type.equals("Premium") && m instanceof PremiumMember) {
                        ((PremiumMember) m).revertPremiumMember();
                        showMessage("Premium Member reverted.");
                        return;
                    }
                }
            }
            showMessage("Member ID not found or incorrect type.");
        } catch (NumberFormatException e) {
            showMessage("Please enter a valid numeric Member ID.");
        }
    }

    private void payDue() {
        try {
            int id = Integer.parseInt(memberIdField.getText());
            for (int i = 0; i < members.size(); i++) {
                GymMember m = (GymMember) members.get(i);
                if (m.getId() == id) {
                    if (!(m instanceof PremiumMember)) {
                        showMessage("Member is not a premium member.");
                        return;
                    }
                    PremiumMember pm = (PremiumMember) m;
                    String paymentInput = paymentField.getText();
                    String result;
                    if (paymentInput.isEmpty()) {
                        result = pm.payDueAmount(-1.0);
                    } else {
                        double payment = Double.parseDouble(paymentInput);
                        result = pm.payDueAmount(payment);
                    }
                    showMessage(result);
                    paymentField.setText("");
                    return;
                }
            }
            showMessage("Member ID not found.");
        } catch (NumberFormatException e) {
            showMessage("Please enter a valid numeric Member ID or payment amount.");
        }
    }

    private void applyDiscount() {
        try {
            int id = Integer.parseInt(memberIdField.getText());
            for (int i = 0; i < members.size(); i++) {
                GymMember m = (GymMember) members.get(i);
                if (m.getId() == id) {
                    if (!(m instanceof PremiumMember)) {
                        showMessage("Member is not a premium member.");
                        return;
                    }
                    PremiumMember pm = (PremiumMember) m;
                    pm.calculateDiscount();
                    String result = String.valueOf(pm.getDiscountAmount());
                    showMessage(result);
                    return;
                }
            }
            showMessage("Member ID not found.");
        } catch (NumberFormatException e) {
            showMessage("Please enter a valid numeric Member ID.");
        }
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        locationField.setText("");
        phoneField.setText("");
        emailField.setText("");
        referralSourceField.setText("");
        trainerNameField.setText("");
        paymentField.setText("");
        removalReasonField.setText("");
        memberIdField.setText("");
        maleButton.setSelected(false);
        femaleButton.setSelected(false);
    }

    private void displayMembers() {
        if (members.isEmpty()) {
            showMessage("No members to display.");
            return;
        }
        String result = "";
        for (int i = 0; i < members.size(); i++) {
            GymMember m = (GymMember) members.get(i);
            result += "Member Type: " + (m instanceof RegularMember ? "Regular" : "Premium") + "\n";
            result += "ID: " + m.getId() + "\n";
            result += "Name: " + m.getName() + "\n";
            result += "Location: " + m.getLocation() + "\n";
            result += "Phone: " + m.getPhone() + "\n";
            result += "Email: " + m.getEmail() + "\n";
            result += "Gender: " + m.getGender() + "\n";
            result += "Date of Birth: " + m.getDOB() + "\n";
            result += "Membership Start Date: " + m.getMembershipStartDate() + "\n";
            result += "Attendance: " + m.getAttendance() + "\n";
            result += "Loyalty Points: " + m.getLoyaltyPoints() + "\n";
            result += "Membership Status: " + (m.isActiveStatus() ? "Active" : "Inactive") + "\n";
            if (m instanceof RegularMember) {
                RegularMember rm = (RegularMember) m;
                result += "Referral Source: " + rm.getReferralSource() + "\n";
                result += "Plan: " + rm.getPlan() + "\n";
                result += "Price: " + rm.getPrice() + "\n";
                result += "Attendance Limit: " + rm.getAttendanceLimit() + "\n";
                result += "Eligible for Upgrade: " + (rm.isEligibleForUpgrade() ? "Yes" : "No") + "\n";
                if (!rm.getRemovalReason().isEmpty()) {
                    result += "Removal Reason: " + rm.getRemovalReason() + "\n";
                }
            } else if (m instanceof PremiumMember) {
                PremiumMember pm = (PremiumMember) m;
                result += "Personal Trainer: " + pm.getPersonalTrainer() + "\n";
                result += "Premium Charge: " + pm.getPremiumCharge() + "\n";
                result += "Paid Amount: " + pm.getPaidAmount() + "\n";
                result += "Discount Amount: " + pm.getDiscountAmount() + "\n";
                result += "Full Payment Done: " + (pm.isFullPayment() ? "Yes" : "No") + "\n";
            }
            result += "-------------------------\n";
        }
        JTextArea area = new JTextArea(result);
        area.setEditable(false);
        area.setCaretPosition(0);
        JScrollPane scroll = new JScrollPane(area);
        scroll.setPreferredSize(new Dimension(600, 400));
        JOptionPane.showMessageDialog(this, scroll, "All Gym Members", JOptionPane.INFORMATION_MESSAGE);
    }

    private boolean isDuplicateId(int id) {
        for (int i = 0; i < members.size(); i++) {
            GymMember m = (GymMember) members.get(i);
            if (m.getId() == id) {
                return true;
            }
        }
        return false;
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new GymGUI();
    }
}