import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class InventoryManagementSystem extends JFrame {

    private DefaultListModel<InventoryItem> itemListModel;
    private JList<InventoryItem> itemList;
    private JTextField nameField, qtyField, priceField;

    public InventoryManagementSystem() {
        setTitle("Inventory Management");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // UI Components
        itemListModel = new DefaultListModel<>();
        itemList = new JList<>(itemListModel);
        JScrollPane scrollPane = new JScrollPane(itemList);

        nameField = new JTextField(10);
        qtyField = new JTextField(5);
        priceField = new JTextField(7);

        JButton addBtn = new JButton("Add");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");

        // Panel for input fields
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Qty:"));
        inputPanel.add(qtyField);
        inputPanel.add(new JLabel("Price:"));
        inputPanel.add(priceField);
        inputPanel.add(addBtn);
        inputPanel.add(updateBtn);
        inputPanel.add(deleteBtn);

        // Add panels to frame
        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        // Button Actions
        addBtn.addActionListener(e -> addItem());
        updateBtn.addActionListener(e -> updateItem());
        deleteBtn.addActionListener(e -> deleteItem());
    }

    private void addItem() {
        try {
            String name = nameField.getText().trim();
            int qty = Integer.parseInt(qtyField.getText().trim());
            double price = Double.parseDouble(priceField.getText().trim());
            if(name.isEmpty()) throw new Exception("Name cannot be empty");
            itemListModel.addElement(new InventoryItem(name, qty, price));
            clearFields();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid input: " + ex.getMessage());
        }
    }

    private void updateItem() {
        int index = itemList.getSelectedIndex();
        if(index == -1) {
            JOptionPane.showMessageDialog(this, "Select an item to update");
            return;
        }
        try {
            String name = nameField.getText().trim();
            int qty = Integer.parseInt(qtyField.getText().trim());
            double price = Double.parseDouble(priceField.getText().trim());
            InventoryItem item = itemListModel.getElementAt(index);
            item.setName(name);
            item.setQuantity(qty);
            item.setPrice(price);
            itemList.repaint();
            clearFields();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid input: " + ex.getMessage());
        }
    }

    private void deleteItem() {
        int index = itemList.getSelectedIndex();
        if(index != -1) {
            itemListModel.remove(index);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Select an item to delete");
        }
    }

    private void clearFields() {
        nameField.setText("");
        qtyField.setText("");
        priceField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new InventoryManagementSystem().setVisible(true);
        });
    }
}
