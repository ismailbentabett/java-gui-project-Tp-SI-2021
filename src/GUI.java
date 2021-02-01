import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GUI {

	public GUI() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int) screenSize.getHeight();

		int width = (int) screenSize.getWidth();
		JFrame frame;

		frame = new JFrame();

		JPanel NORTH_PANEL = new JPanel();

		JPanel SOUTH_PANEL = new JPanel();

		JPanel EAST_PANEL = new JPanel();

		JPanel WEST_PANEL = new JPanel();

		JPanel CENTER_PANEL = new JPanel();

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
		frame.add(NORTH_PANEL, BorderLayout.NORTH);
		frame.add(SOUTH_PANEL, BorderLayout.SOUTH);
		frame.add(EAST_PANEL, BorderLayout.EAST);
		frame.add(WEST_PANEL, BorderLayout.WEST);
		frame.add(CENTER_PANEL, BorderLayout.CENTER);
		NORTH_PANEL.setBackground(Color.red);
		SOUTH_PANEL.setBackground(Color.blue);
		;
		EAST_PANEL.setBackground(Color.green);
		;
		WEST_PANEL.setBackground(Color.yellow);
		;
		CENTER_PANEL.setBackground(Color.black);
		;
		NORTH_PANEL.setPreferredSize(new Dimension(width, 100));
		SOUTH_PANEL.setPreferredSize(new Dimension(width, 100));
		EAST_PANEL.setPreferredSize(new Dimension(100, height));
		WEST_PANEL.setPreferredSize(new Dimension(100, height));
		frame.setSize(width, height);

		String products[] = { "delaa3", "ma3adnouus", "9onbolat cheb bello" };

		JComboBox Products = new JComboBox(products);
		JSpinner Quantity = new JSpinner();

		JButton addProduct = new JButton("Add Product");
		SOUTH_PANEL.add(Products);
		SOUTH_PANEL.add(Quantity);
		SOUTH_PANEL.add(addProduct);
		ArrayList<ProductsObj> data = new ArrayList<ProductsObj>();

		// table
		String col[] = { "Pos", "Team", "P", "W", "L" };

		DefaultTableModel tableModel = new DefaultTableModel(col, 0);

		JTable table = new JTable(tableModel);
		
		String colfac[] = { "Pos", "Team", "P", "W", "L" };

		DefaultTableModel tableModelfac = new DefaultTableModel(colfac, 0);

		JTable tablefac = new JTable(tableModelfac);
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
					newproducts1.prix = 106;

				} else if (productChecker == 1) {
					newproducts2.ref = productChecker;

					newproducts2.productName = productNameValue;
					newproducts2.quantity = productQuantityValue;
					newproducts2.prix = 106;

				} else if (productChecker == 2) {
					newproducts3.ref = productChecker;

					newproducts3.productName = productNameValue;
					newproducts3.quantity = productQuantityValue;
					newproducts3.prix = 106;

				} else if (productChecker > 2) {
					System.out.println("fuck off the bill is full");
				}

				newfacture.total = newproducts1.prix * newproducts1.quantity + newproducts2.prix * newproducts2.quantity
						+ newproducts3.prix * newproducts3.quantity;
				System.out.println(newfacture.total);

				newfacture.montant = newfacture.total*106;
				
				Object[] objectLists = { newproducts1, newproducts2, newproducts3 };

				// Create an ArrayList object

				if (productChecker <= 2) {
					data.add((ProductsObj) objectLists[productChecker]);

					Object[] objs = { data.get(productChecker).ref, data.get(productChecker).productName,
							data.get(productChecker).prix, data.get(productChecker).quantity,
							data.get(productChecker).prix * data.get(productChecker).quantity };
					Object[] objsfac = { newfacture.total,newfacture.montant};
					tableModel.addRow(objs);



				
					if(productChecker>0) {
						tableModelfac.removeRow(0);

					}
					tableModelfac.addRow(objsfac);

					tablefac.revalidate();
					
				
				}

				if (productChecker >= 0 && productChecker <= 3) {

					CENTER_PANEL.revalidate();

					CENTER_PANEL.repaint();

				}

				productChecker++;

			}

		});
		

		CENTER_PANEL.add(table);
		CENTER_PANEL.add(tablefac);

		frame.setVisible(true);

	}

}
