import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class GUI {

	public GUI() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int) screenSize.getHeight();

		int width = (int) screenSize.getWidth();
		JFrame frame;

		frame = new JFrame();

		JPanel NORTH_PANEL = new JPanel( new GridLayout(1,2));
		
		JLabel fullNamelabel = null ;
	
		

		JPanel SOUTH_PANEL = new JPanel();

		JPanel EAST_PANEL = new JPanel();

		JPanel WEST_PANEL = new JPanel();

		JPanel CENTER_PANEL = new JPanel();
		JPanel top = new JPanel();
		JPanel bottom = new JPanel();

		JSplitPane vertical = new JSplitPane(JSplitPane.VERTICAL_SPLIT, top, bottom);
		//Dimension CENTER_PANELsize = CENTER_PANEL.getSize();
		//vertical.setDividerLocation(0.5);

		//vertical.setSize(CENTER_PANELsize.height, CENTER_PANELsize.width);
		vertical.setBackground(Color.black);
		CENTER_PANEL.add(vertical, BorderLayout.CENTER);
		FactureObj newfacture = new FactureObj();


		JTextField firstName = new JTextField();
		JTextField lastName = new JTextField();

		Object[] message = {

				"first name:", firstName, "last name :", lastName,

		};
		int option = JOptionPane.showConfirmDialog(frame, message, "gimme ur name fool", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION) {
			String firstNameValue = firstName.getText();
			String lastNameValue = lastName.getText();
			fullNamelabel = new JLabel(firstNameValue +" " + lastNameValue);
			newfacture.name = firstNameValue +" " + lastNameValue;
			;

		}
		
		ProductsObj newproducts1 = new ProductsObj();
		ProductsObj newproducts2 = new ProductsObj();
		ProductsObj newproducts3 = new ProductsObj();
		JLabel enterprize = new JLabel("Entreprise National Des Pièces") ;
		JLabel zonename = new JLabel("15 Zone industrielle Rouiba\r\n" + "Algerie") ;
		JLabel datenow = new JLabel(newfacture.now) ;
		NORTH_PANEL.add(enterprize);
		NORTH_PANEL.add(zonename);
		NORTH_PANEL.add(datenow);
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
		String col[] = { "Ref", "Product", "Unit Price", "Quantity", "Product Total Price" };

		DefaultTableModel tableModel = new DefaultTableModel(col, 0);

		JTable table = new JTable(tableModel);

		String colfac[] = { "Total", "Montant" };

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

				newfacture.montant = newfacture.total * 106;

				Object[] objectLists = { newproducts1, newproducts2, newproducts3 };

				// Create an ArrayList object

				if (productChecker <= 2) {
					data.add((ProductsObj) objectLists[productChecker]);

					Object[] objs = { data.get(productChecker).ref, data.get(productChecker).productName,
							data.get(productChecker).prix, data.get(productChecker).quantity,
							data.get(productChecker).prix * data.get(productChecker).quantity };
					Object[] objsfac = { newfacture.total, newfacture.montant };
					tableModel.addRow(objs);

					if (productChecker > 0) {
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
		TableColumnModel columnModel = table.getColumnModel();
		TableColumnModel columnModelfac = tablefac.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(170);
		columnModel.getColumn(1).setPreferredWidth(170);
		columnModel.getColumn(2).setPreferredWidth(170);
		columnModelfac.getColumn(0).setPreferredWidth(150);
		columnModelfac.getColumn(1).setPreferredWidth(150);
	
		table.setRowHeight(150);
		tablefac.setRowHeight(150);
		top.add(new JScrollPane(table), BorderLayout.NORTH);
		bottom.add(new JScrollPane(tablefac), BorderLayout.SOUTH);
		NORTH_PANEL.add(fullNamelabel) ;
	
		frame.setVisible(true);
		
		// Our example data
		frame.addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent e) {
		        // call terminate
				writeDataLineByLine("/",newproducts1,newproducts2,newproducts3,newfacture);

		    }
		});

	
	}
	
	public static void writeDataLineByLine(String filePath , ProductsObj newproducts1 , ProductsObj newproducts2 , ProductsObj newproducts3 , FactureObj newfacture) 
	{ 
	    // first create file object for file placed at location 
	    // specified by filepath 
		 try (PrintWriter writer = new PrintWriter(new File("test.csv"))) {

		      StringBuilder sb1 = new StringBuilder();
		      StringBuilder sb2 = new StringBuilder();
		      StringBuilder sb3 = new StringBuilder();
		      sb1.append(newfacture.name);
		      sb1.append(newproducts1.productName);
		      sb1.append(newproducts1.prix);
		      sb1.append(newproducts1.quantity);
		      sb1.append(newproducts1.ref);

		      sb2.append(newfacture.name);
		      sb2.append(newproducts2.productName);
		      sb2.append(newproducts2.prix);
		      sb2.append(newproducts2.quantity);
		      sb2.append(newproducts2.ref);
		      
		      sb3.append(newfacture.name);
		      sb3.append(newproducts3.productName);
		      sb3.append(newproducts3.prix);
		      sb3.append(newproducts3.quantity);
		      sb3.append(newproducts3.ref);
		

		      writer.write(sb1.toString());
		      writer.write(sb2.toString());
		      writer.write(sb3.toString());

		      System.out.println("done!");

		    } catch (FileNotFoundException e) {
		      System.out.println(e.getMessage());
		    }
	} 
	
	

}
