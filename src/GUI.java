import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class GUI {

	public GUI() {


		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int) screenSize.getHeight();
		int width = (int) screenSize.getWidth();
		JFrame frame;

		frame = new JFrame();

		JPanel NORTH_PANEL = new JPanel(new GridLayout(1, 2));

		JLabel fullNamelabel = null;

		JPanel SOUTH_PANEL = new JPanel(new FlowLayout(FlowLayout.CENTER));  

		JPanel EAST_PANEL = new JPanel();

		JPanel WEST_PANEL = new JPanel();

		JPanel CENTER_PANEL = new JPanel();
		JPanel top = new JPanel();
		JPanel bottom = new JPanel();
		top.setBackground(Color.red);
		top.setSize(200, 200);
		bottom.setSize(200, 200);
		JSplitPane vertical = new JSplitPane(JSplitPane.VERTICAL_SPLIT, top, bottom);
		
		vertical.setDividerSize(10);
		vertical.setResizeWeight(0.5);
		// Dimension CENTER_PANELsize = CENTER_PANEL.getSize();
		// vertical.setDividerLocation(0.5);

		top.setBackground(Color.decode("#222831"));
		bottom.setBackground(Color.decode("#222831"));
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
			fullNamelabel = new JLabel("FullName : " + firstNameValue + " " + lastNameValue);
			newfacture.name = firstNameValue + " " + lastNameValue;
			;

		}

		fullNamelabel.setForeground(Color.WHITE);
		ProductsObj newproducts1 = new ProductsObj();
		ProductsObj newproducts2 = new ProductsObj();
		ProductsObj newproducts3 = new ProductsObj();
		JLabel enterprize = new JLabel("Entreprise National Des Pièces");
		JLabel zonename = new JLabel("15 Zone industrielle Rouiba\r\n" + "Algerie");
		JLabel datenow = new JLabel("Date: "+newfacture.now);
		zonename.setForeground(Color.WHITE);
		enterprize.setForeground(Color.WHITE);
		datenow.setForeground(Color.WHITE);
		zonename.setHorizontalAlignment(JLabel.CENTER);
		enterprize.setHorizontalAlignment(JLabel.CENTER);
		datenow.setHorizontalAlignment(JLabel.CENTER);
		NORTH_PANEL.add(enterprize, BorderLayout.CENTER);
		NORTH_PANEL.add(zonename, BorderLayout.CENTER);
		NORTH_PANEL.add(datenow, BorderLayout.CENTER);

		frame.add(NORTH_PANEL, BorderLayout.NORTH);
		frame.add(SOUTH_PANEL, BorderLayout.SOUTH);
		frame.add(EAST_PANEL, BorderLayout.EAST);
		frame.add(WEST_PANEL, BorderLayout.WEST);
		frame.add(CENTER_PANEL, BorderLayout.CENTER);
		NORTH_PANEL.setBackground(Color.decode("#222831"));
		SOUTH_PANEL.setBackground(Color.decode("#222831"));
		;
		EAST_PANEL.setBackground(Color.decode("#393e46"));
		;
		WEST_PANEL.setBackground(Color.decode("#393e46"));
		;
		CENTER_PANEL.setBackground(Color.decode("#393e46"));
		;
		NORTH_PANEL.setPreferredSize(new Dimension(width, 100));
		SOUTH_PANEL.setPreferredSize(new Dimension(width, 100));
		EAST_PANEL.setPreferredSize(new Dimension(100, height));
		WEST_PANEL.setPreferredSize(new Dimension(100, height));
		frame.setSize(width, height);

		String products[] = { "delaa3", "ma3adnouus", "9onbolat cheb bello" };
		  SpinnerModel newSpinnerModel =  
		             new SpinnerNumberModel(1, //initial value  
		                1, //minimum value  
		                10000000, //maximum value  
		                1); 
		JComboBox Products = new JComboBox(products);
		JSpinner Quantity = new JSpinner(newSpinnerModel);

		JButton addProduct = new JButton("Add Product");
		SOUTH_PANEL.add(Products,FlowLayout.LEFT);
		SOUTH_PANEL.add(Quantity,FlowLayout.CENTER);
		SOUTH_PANEL.add(addProduct,FlowLayout.RIGHT);
		ArrayList<ProductsObj> data = new ArrayList<ProductsObj>();
		JButton printbtn = new JButton();

		
		// table
		String col[] = { "Ref", "Product", "Unit Price", "Quantity", "Product Total Price" };

		DefaultTableModel tableModel = new DefaultTableModel(col, 0);

		JTable table = new JTable(tableModel);

		String colfac[] = { "Total", "Montant" };

		DefaultTableModel tableModelfac = new DefaultTableModel(colfac, 0);

		JTable tablefac = new JTable(tableModelfac);
		table.getTableHeader().setBackground(Color.decode("#393e46"));
		tablefac.getTableHeader().setBackground(Color.decode("#393e46"));
		table.setBackground(Color.decode("#393e46"));
		tablefac.setBackground(Color.decode("#393e46"));
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

		table.setForeground(Color.WHITE);
		tablefac.setForeground(Color.WHITE);
		table.getTableHeader().setForeground(Color.WHITE);
		tablefac.getTableHeader().setForeground(Color.WHITE);
		table.setRowHeight(250);
		tablefac.setRowHeight(250);

		top.add(new JScrollPane(table), BorderLayout.NORTH);
		bottom.add(new JScrollPane(tablefac), BorderLayout.SOUTH);
		NORTH_PANEL.add(fullNamelabel, BorderLayout.CENTER);
		fullNamelabel.setHorizontalAlignment(JLabel.CENTER);
		JLabel facid = new JLabel("Id :" + String.valueOf(count("output.txt")));
		facid.setForeground(Color.WHITE);
		NORTH_PANEL.add(facid, BorderLayout.CENTER);
		facid.setHorizontalAlignment(JLabel.CENTER);
		frame.setVisible(true);

		frame.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				// call terminate

				// Our example data
				String[] headercsv = { "id", "client name", "product 1", "product 2 price", "product 2 quantity",
						"product 2", "product 2 price", "product 2 quantity", "product 2", "product 2 price",
						"product 2 quantity", "total", };
				try {
					newfacture.id_number = count("output.txt");
					System.out.print("id  " + FileStorage.getLastId("output"));
					String[] list = { String.valueOf(newfacture.id_number), newfacture.name, newproducts1.productName,
							String.valueOf(newproducts1.prix), String.valueOf(newproducts1.quantity),
							newproducts2.productName, String.valueOf(newproducts2.prix),
							String.valueOf(newproducts2.quantity), newproducts3.productName,
							String.valueOf(newproducts2.prix), String.valueOf(newproducts2.quantity),
							String.valueOf(newfacture.total),

					};
					FileStorage.addRecord("output", list);

				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					print(table);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

	}

	public static int count(String fileName) {

		Path path = Paths.get(fileName);

		long lines = 0;
		try {

			// much slower, this task better with sequence access
			// lines = Files.lines(path).parallel().count();

			lines = Files.lines(path).count();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return (int) lines;

	}
	


		  public void print(JTable table) throws Exception {
		 
		  

		    table.print();
		  }
		

}
