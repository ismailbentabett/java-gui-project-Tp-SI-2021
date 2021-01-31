import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI {

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int height = (int) screenSize.getHeight();

	int width = (int) screenSize.getWidth();

	public GUI() {
		JFrame frame = new JFrame();// creating instance of JFrame

		JTextField firstName = new JTextField();
		JTextField lastName = new JTextField();

		Object[] message = {

				"first name:", firstName, "last name :", lastName,

		};
		int option = JOptionPane.showConfirmDialog(frame, message, "gimme ur name fool", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION) {
			String firstNameValue = firstName.getText();
			String lastNameValue = lastName.getText();

		}

		ProductsObj newproducts1 = new ProductsObj();
		ProductsObj newproducts2 = new ProductsObj();
		ProductsObj newproducts3 = new ProductsObj();
		FactureObj newfacture = new FactureObj();

		JPanel outputPanel = new JPanel();
		JPanel inputPanel = new JPanel();
		inputPanel.setBounds(0, (height / 2), width, (height / 2));

		inputPanel.setBackground(Color.red);
		outputPanel.setBounds(0, 0, width, (height / 2));
		inputPanel.setBackground(Color.blue);

		outputPanel.setBackground(Color.red);
		frame.add(outputPanel);
		frame.add(inputPanel);
		frame.setSize(width, height);// 400 width and 500 height
		frame.setLayout(null);// using no layout managers
		String products[] = { "delaa3", "ma3adnouus", "9onbolat cheb bello" };

		JComboBox Products = new JComboBox(products);
		JSpinner Quantity = new JSpinner();

		JButton addProduct = new JButton("Add Product");
		inputPanel.add(Products);
		inputPanel.add(Quantity);
		inputPanel.add(addProduct);

		JButton nami = new JButton("namiii");

		addProduct.addActionListener(new ActionListener() {
			int productChecker = 0;

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String productNameValue = (String) Products.getSelectedItem();
				int productQuantityValue = (int) Quantity.getValue();

				if (productChecker == 0) {
					newproducts1.ref = productChecker;
					newproducts1.productName = productNameValue;
					newproducts1.quantity = productQuantityValue;
					newproducts1.prix = 106 * productQuantityValue;

				} else if (productChecker == 1) {
					newproducts2.ref = productChecker;

					newproducts2.productName = productNameValue;
					newproducts2.quantity = productQuantityValue;
					newproducts2.prix = 106 * productQuantityValue;

				} else if (productChecker == 2) {
					newproducts3.ref = productChecker;

					newproducts3.productName = productNameValue;
					newproducts3.quantity = productQuantityValue;
					newproducts3.prix = 106 * productQuantityValue;

				} else if (productChecker > 2) {
					System.out.println("fuck off the bill is full");
				}
				productChecker++;
				newfacture.total = newproducts1.prix * newproducts1.quantity + newproducts2.prix * newproducts2.quantity
						+ newproducts3.prix * newproducts3.quantity;

				
			}

		});
		
		String  pd1_name = String.valueOf(newproducts1.productName);
		String  pd1_ref = String.valueOf(newproducts1.ref);
		String  pd1_quantity = String.valueOf(newproducts1.quantity);
		String  pd1_prix =String.valueOf(newproducts1.prix) ;
		String  pd2_name =String.valueOf(newproducts2.productName) ;
		String  pd2_ref = String.valueOf(newproducts2.ref);
		String  pd2_quantity = String.valueOf(newproducts2.quantity);
		String  pd2_prix = String.valueOf(newproducts2.prix);
		String  pd3_name = String.valueOf(newproducts3.productName);
		String  pd3_ref = String.valueOf(newproducts3.ref);
		String  pd3_quantity = String.valueOf(newproducts3.quantity);
		String  pd3_prix = String.valueOf(newproducts3.prix);
		String  total = String.valueOf(newfacture.total);


		String []  header = {pd1_ref,pd1_ref,pd1_ref,pd1_ref};
		
		String [][] data = {
				{pd1_ref,pd1_ref,pd1_ref,pd1_ref},
				{pd1_ref,pd1_ref,pd1_ref,pd1_ref},
				{pd1_ref,pd1_ref,pd1_ref,pd1_ref}
		}; 
	JTable table = new JTable(data,header);
	
	outputPanel.add(table);
	JButton btn = new JButton();
	btn.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			outputPanel.repaint();
		}
		
	});
	outputPanel.add(btn);
		frame.setVisible(true);// making the frame visible

	}

}
