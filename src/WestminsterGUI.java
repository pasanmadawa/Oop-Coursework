import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class WestminsterGUI extends JFrame {

    private JComboBox<String> productTypeComboBox;
    private JTable productTable;
    //private JTable cartTable;
    private DefaultTableModel tableModel;

    Product selectedProduct;
    private JTextArea productDetailsTextArea;
    private JButton addToCartButton;
    private JButton viewCartButton;
    private DefaultListModel<String> cartListModel;
    ArrayList<Product> productList ;
    ArrayList<Product> updatedList = new ArrayList<>();
    ArrayList<Product> filteredList = new ArrayList<>();
    ArrayList<Product> shoppingList = new ArrayList<>();
    CartGUI cartUI;

    public WestminsterGUI(ArrayList<Product> productList) {
        this.productList = productList;

        // Create components
        productTypeComboBox = new JComboBox<>(new String[]{"All", "Electronics", "Clothes"});
        tableModel = new DefaultTableModel();
        updatedList = productList;
        productTable = new JTable(tableModel);

        productDetailsTextArea = new JTextArea(12, 20);
        addToCartButton = new JButton("Add to Cart");
        viewCartButton = new JButton("View Cart");
        cartListModel = new DefaultListModel<>();

        // Set up the table
        tableModel.addColumn("Product ID");
        tableModel.addColumn("Product Name");
        tableModel.addColumn("Category");
        tableModel.addColumn("Price($)");
        tableModel.addColumn("Info");

        // Set up the layout
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Select Product Type: "));
        topPanel.add(productTypeComboBox);
        topPanel.add(viewCartButton);

        JPanel centerPanel = new JPanel();
        centerPanel.add(new JScrollPane(productTable));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(new JScrollPane(productDetailsTextArea), BorderLayout.CENTER);
        bottomPanel.add(addToCartButton, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Event handling
        productTypeComboBox.addActionListener(e -> {

            String selectedType = (String) productTypeComboBox.getSelectedItem();
            productDetailsTextArea.setText("No product is selected");
            updatedList = new ArrayList<>();
            if ("All".equals(selectedType)) {
                updatedList = productList;
            }
            else if("Electronics".equals(selectedType)){
                for (Product product:productList){
                    if (product instanceof Electronics){
                        updatedList.add(product);
                    }
                }
            }
            else if ("Clothes".equals(selectedType)){
                for (Product product:productList){
                    if (product instanceof Clothing){
                        updatedList.add(product);
                    }
                }
            }
            updateTableData();
        });

        productTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!productTable.getSelectionModel().isSelectionEmpty()){
                    selectedProduct = updatedList.get(productTable.getSelectionModel().getMinSelectionIndex());
                    productDetailsTextArea.setText(selectedProduct.getInfo());

                }
            }

        });

        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (selectedProduct.getNum_of_items() > 0) {
                        if (shoppingList.size() == 0) {
                            selectedProduct.setUserQuantity(1);
                            shoppingList.add(selectedProduct);
                        } else {
                            boolean productNotFound = true;
                            for (Product product : shoppingList) {
                                if (selectedProduct == product) {
                                    product.setUserQuantity(product.getUserQuantity() + 1);
                                    productNotFound = false;
                                    break;
                                    //Quantity is increased
                                }
                            }
                            if (productNotFound) {
                                selectedProduct.setUserQuantity(1);
                                shoppingList.add(selectedProduct);
                            }
                        }

                        selectedProduct.setNum_of_items(selectedProduct.getNum_of_items() - 1);
                    } else {
                        JOptionPane.showMessageDialog(centerPanel, selectedProduct.getProduct_ID() + " Stock is over !!! ");
                    }
                    System.out.println(shoppingList);
                    cartUI.updateTableData(shoppingList);
                } catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(centerPanel,"Cart is not opened yet.");
                }
            }
        });


        viewCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewCart();
            }
        });

        updateTableData();
    }

    private void viewCart() {
        cartUI = new CartGUI();
        cartUI.setTitle("Shopping Cart");
        cartUI.setVisible(true);
        cartUI.setSize(500, 600);
        cartUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void updateTableData(){
        System.out.println("update"+updatedList);
        tableModel.setRowCount(0);
        for (Product product: updatedList){
            tableModel.addRow(new Object[]{product.getProduct_ID(),product.getProduct_name(),product.getClass(),product.getPrice(),product.toString()});
        }

    }

    private void showProductDetails() {
        int selectedRow = productTable.getSelectedRow();
        System.out.println(selectedRow);
    }

    private void addToCart() {
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow != -1) {
            String productName = (String) productTable.getValueAt(selectedRow, 0);
            cartListModel.addElement(productName);
        }
    }

//    private void rowColor(){
//
//    }


}
