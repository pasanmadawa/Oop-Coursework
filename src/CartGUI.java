import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.lang.System.exit;

public class CartGUI extends JFrame {

    private JTable cartTable;
    private DefaultTableModel cartModel= new DefaultTableModel();
    private JTextArea discountTextArea;
    private JButton purchaseButton = new JButton("Confirm purchase");
    private ArrayList<Product> shoppingList = new ArrayList<Product>();


    public CartGUI() {

        cartTable = new JTable(cartModel);
        discountTextArea = new JTextArea(12,10);
        discountTextArea.setText("Your Bill");

        cartModel.addColumn("Product");
        cartModel.addColumn("Quantity");
        cartModel.addColumn("Price");

        JPanel topPanel = new JPanel();
        topPanel.add(new JScrollPane(cartTable));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(new JScrollPane(discountTextArea),BorderLayout.CENTER);
        bottomPanel.add(purchaseButton,BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);

        add(bottomPanel, BorderLayout.SOUTH);

        purchaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WestminsterShoppingManager.saveInfo();
                exit(0);
            }
        });

    }

    public void updateTableData(ArrayList<Product> shoppingList){
        this.shoppingList = shoppingList;
        cartModel.setRowCount(0);
        for (Product product:shoppingList){
            cartModel.addRow(new Object[]{product.getProduct_ID(),product.getUserQuantity(),product.getPrice()*product.getUserQuantity()});

        }
        updateBill();
    }

    public void updateBill(){

        double total = 0.0;
        int electronicsCount = 0;
        int clothingCount = 0;
        boolean sameCategoryOccurs = false;
        double memberDiscount = 0.0;
        double categoryDiscount = 0.0;
        double grantTotal = 0.0;

        for (int i=0;i<shoppingList.size();i++) {
            String value = cartTable.getModel().getValueAt(i, 2).toString();
            total += Double.parseDouble(value.substring(0, value.length() - 2));
            if (shoppingList.get(i) instanceof Electronics){
                electronicsCount++;
            }else if (shoppingList.get(i) instanceof Clothing){
                clothingCount++;
            }
        }
        if (electronicsCount>2 || clothingCount>2){
            //sameCategoryOccurs = true;

            categoryDiscount = Math.ceil((total*0.2)*100)/100 ;


        }

        grantTotal = Math.ceil((total-categoryDiscount-memberDiscount)*100)/100;





        discountTextArea.setText(" Total                                                   - "+total+" $"+"\n Purchasing three from same category - "+(categoryDiscount)+" $"+"\n Final Total                                           - "+grantTotal+" $");
    }
}

//+"\n First Purchase Discount(10%)              - "+(memberDiscount)+" $"