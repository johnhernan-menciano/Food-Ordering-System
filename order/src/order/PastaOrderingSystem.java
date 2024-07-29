package order;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class PastaOrderingSystem extends JFrame {
	
	private Image img_pancit1 = new ImageIcon(PastaOrderingSystem.class.getResource("Pancit/pancit1.jpg")).getImage().getScaledInstance(90, 60, Image.SCALE_REPLICATE);
	private Image img_pancit2 = new ImageIcon(PastaOrderingSystem.class.getResource("Pancit/pancit2.jpg")).getImage().getScaledInstance(90, 60, Image.SCALE_SMOOTH);
	private Image img_pancit3 = new ImageIcon(PastaOrderingSystem.class.getResource("Pancit/pancit4.jpg")).getImage().getScaledInstance(90, 60, Image.SCALE_SMOOTH);
	private Image img_pancit4 = new ImageIcon(PastaOrderingSystem.class.getResource("Pancit/pancit3.jpg")).getImage().getScaledInstance(90, 60, Image.SCALE_SMOOTH);
	
	
	
	private JPanel contentPane;
	private JComboBox cboFlavor;
	private JRadioButton rdoSmall;
	private JRadioButton rdoMedium;
	private JRadioButton rdoLarge;
	private JCheckBox chkShrimp;
	private JCheckBox chkVegetables;
	private JCheckBox chkSausage;
	private JCheckBox chkMeat;
	private JRadioButton rdoDineIn;
	private JRadioButton rdoTakeOut;
	private JRadioButton rdoDelivery;
	private JButton btnBillOut;
	private JButton btnOrderAgain;
	private JTextArea txaOrderDetails;
	private String[] flavor = {"Pancit Canton", "Pancit Bihon", "Pancit Malabon", "Pancit Palabok"};
	private JLabel lblSmallPrice;
	private JLabel lblMediumPrice;
	private JLabel lblLargePrice;
	private double addOnPrice = 0.00;
	private JLabel lblQuantity;
	private int qty = 1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PastaOrderingSystem frame = new PastaOrderingSystem();
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
	public PastaOrderingSystem() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				loadFlavors();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 520);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pancit:");
		lblNewLabel.setBounds(10, 11, 203, 14);
		contentPane.add(lblNewLabel);
		
		cboFlavor = new JComboBox();
		cboFlavor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showPrice();
			}
		});
		cboFlavor.setBackground(Color.WHITE);
		cboFlavor.setBounds(20, 36, 221, 22);
		contentPane.add(cboFlavor);
		
		JLabel sad = new JLabel("Bilao and Price:");
		sad.setBounds(10, 69, 203, 14);
		contentPane.add(sad);
		
		rdoSmall = new JRadioButton("Small");
		buttonGroup.add(rdoSmall);
		rdoSmall.setBackground(Color.ORANGE);
		rdoSmall.setBounds(20, 90, 109, 23);
		contentPane.add(rdoSmall);
		
		rdoMedium = new JRadioButton("Medium");
		buttonGroup.add(rdoMedium);
		rdoMedium.setBackground(Color.ORANGE);
		rdoMedium.setBounds(20, 116, 109, 23);
		contentPane.add(rdoMedium);
		
		rdoLarge = new JRadioButton("Large");
		buttonGroup.add(rdoLarge);
		rdoLarge.setBackground(Color.ORANGE);
		rdoLarge.setBounds(20, 140, 109, 23);
		contentPane.add(rdoLarge);
		
		JLabel lblAddOns = new JLabel("Add Ons:");
		lblAddOns.setBounds(10, 170, 203, 14);
		contentPane.add(lblAddOns);
		
		chkShrimp = new JCheckBox("Shrimp");
		chkShrimp.setBackground(Color.ORANGE);
		chkShrimp.setBounds(20, 191, 109, 23);
		contentPane.add(chkShrimp);
		
		chkVegetables = new JCheckBox("Vegetables");
		chkVegetables.setBackground(Color.ORANGE);
		chkVegetables.setBounds(20, 217, 109, 23);
		contentPane.add(chkVegetables);
		
		chkSausage = new JCheckBox("Sausage");
		chkSausage.setBackground(Color.ORANGE);
		chkSausage.setBounds(144, 217, 97, 23);
		contentPane.add(chkSausage);
		
		chkMeat = new JCheckBox("Meat");
		chkMeat.setBackground(Color.ORANGE);
		chkMeat.setBounds(144, 191, 97, 23);
		contentPane.add(chkMeat);
		
		JLabel lblChoose = new JLabel("Choose:");
		lblChoose.setBounds(10, 247, 203, 14);
		contentPane.add(lblChoose);
		
		rdoDineIn = new JRadioButton("Dine In");
		buttonGroup_1.add(rdoDineIn);
		rdoDineIn.setBackground(Color.ORANGE);
		rdoDineIn.setBounds(20, 268, 109, 23);
		contentPane.add(rdoDineIn);
		
		rdoTakeOut = new JRadioButton("Take Out");
		buttonGroup_1.add(rdoTakeOut);
		rdoTakeOut.setBackground(Color.ORANGE);
		rdoTakeOut.setBounds(20, 294, 109, 23);
		contentPane.add(rdoTakeOut);
		
		rdoDelivery = new JRadioButton("For Delivery");
		buttonGroup_1.add(rdoDelivery);
		rdoDelivery.setBackground(Color.ORANGE);
		rdoDelivery.setBounds(20, 320, 109, 23);
		contentPane.add(rdoDelivery);
		
		btnBillOut = new JButton("Bill Out");
		btnBillOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showOrderDetails();
			}
		});
		btnBillOut.setBackground(new Color(0, 128, 0));
		btnBillOut.setBounds(51, 414, 123, 23);
		contentPane.add(btnBillOut);
		
		JLabel sss = new JLabel("Quantity:");
		sss.setBounds(10, 350, 203, 14);
		contentPane.add(sss);
		
		JButton btnNewButton_1 = new JButton("-");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				qty--;
				lblQuantity.setText(String.valueOf(qty));
			}
		});
		btnNewButton_1.setBackground(new Color(255, 99, 71));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(31, 375, 53, 28);
		contentPane.add(btnNewButton_1);
		
		lblQuantity = new JLabel("1");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setBounds(86, 375, 53, 28);
		contentPane.add(lblQuantity);
		
		JButton button = new JButton("+");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				qty++;
				lblQuantity.setText(String.valueOf(qty));
			}
		});
		button.setBackground(new Color(65, 105, 225));
		button.setFont(new Font("Tahoma", Font.BOLD, 20));
		button.setBounds(138, 375, 53, 28);
		contentPane.add(button);
		
		btnOrderAgain = new JButton("Order Again");
		btnOrderAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				orderAgain();
			}
		});
		btnOrderAgain.setBackground(new Color(255, 105, 180));
		btnOrderAgain.setBounds(51, 448, 123, 23);
		contentPane.add(btnOrderAgain);
		
		JLabel lblPasta1 = new JLabel("");
		lblPasta1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasta1.setIcon(new ImageIcon(img_pancit1));
		lblPasta1.setBounds(251, 11, 97, 79);
		contentPane.add(lblPasta1);
		
		JLabel lblPasta2 = new JLabel("");
		lblPasta2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasta2.setIcon(new ImageIcon(img_pancit2));
		lblPasta2.setBounds(349, 11, 97, 79);
		contentPane.add(lblPasta2);
		
		JLabel lblPasta3 = new JLabel("");
		lblPasta3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasta3.setIcon(new ImageIcon(img_pancit3));
		lblPasta3.setBounds(541, 11, 97, 79);
		contentPane.add(lblPasta3);
		
		JLabel lblOrderDetails = new JLabel("Order Details:");
		lblOrderDetails.setBounds(260, 94, 203, 14);
		contentPane.add(lblOrderDetails);
		
		txaOrderDetails = new JTextArea();
		txaOrderDetails.setEditable(false);
		txaOrderDetails.setBounds(260, 116, 378, 356);
		contentPane.add(txaOrderDetails);
		
		lblSmallPrice = new JLabel("");
		lblSmallPrice.setBackground(Color.LIGHT_GRAY);
		lblSmallPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblSmallPrice.setBounds(155, 94, 72, 14);
		contentPane.add(lblSmallPrice);
		
		lblMediumPrice = new JLabel("");
		lblMediumPrice.setBackground(Color.LIGHT_GRAY);
		lblMediumPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblMediumPrice.setBounds(155, 120, 72, 14);
		contentPane.add(lblMediumPrice);
		
		lblLargePrice = new JLabel("");
		lblLargePrice.setBackground(Color.LIGHT_GRAY);
		lblLargePrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblLargePrice.setBounds(155, 144, 72, 14);
		contentPane.add(lblLargePrice);
		
		JLabel lblPasta4 = new JLabel("");
		lblPasta4.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasta4.setIcon(new ImageIcon(img_pancit4));
		lblPasta4.setBounds(446, 11, 97, 79);
		contentPane.add(lblPasta4);
	}
	private void loadFlavors() {
		for(String flavors : flavor) {
			cboFlavor.addItem(flavors);
		}
	}
	private void showPrice() {
		if(cboFlavor.getSelectedIndex() == 0)
		{
			lblSmallPrice.setText("100.00");
			lblMediumPrice.setText("150.00");
			lblLargePrice.setText("200.00");
		}
		else if(cboFlavor.getSelectedIndex() == 1)
		{
			lblSmallPrice.setText("80.00");
			lblMediumPrice.setText("130.00");
			lblLargePrice.setText("170.00");
		}
		else if(cboFlavor.getSelectedIndex() == 2)
		{
			lblSmallPrice.setText("120.00");
			lblMediumPrice.setText("160.00");
			lblLargePrice.setText("230.00");
		}
		else
		{
			lblSmallPrice.setText("90.00");
			lblMediumPrice.setText("145.00");
			lblLargePrice.setText("220.00");
		}
	
	}
	private String addOnPrice() {
		String addOns = "";
		
		if(chkShrimp.isSelected())
		{
			addOnPrice += 40.00;
			addOns = addOns + "\n\t" + chkShrimp.getText() + "\t\t" + "40.00";
		}
		if(chkVegetables.isSelected())
		{
			addOnPrice += 25.00;
			addOns = addOns + "\n\t" + chkVegetables.getText() + "\t\t" + "25.00";
		}
		if(chkSausage.isSelected())
		{
			addOnPrice += 50.00;
			addOns = addOns + "\n\t" + chkSausage.getText() + "\t\t" + "50.00";
		}
		if(chkMeat.isSelected())
		{
			addOnPrice += 60.00;
			addOns = addOns + "\n\t" + chkMeat.getText() + "\t\t" + "60.00";
		}				
		return addOns;
	}
	private String sizeOfPancit() {
		String size = "";
		if(rdoSmall.isSelected())
			size = rdoSmall.getText();
		else if(rdoMedium.isSelected())
			size = rdoMedium.getText();
		else
			size = rdoLarge.getText();
		
		return size;
	}
	private double priceOfPancit() {
		double pastaPrice = 0;
		if(rdoSmall.isSelected())
			pastaPrice = Double.parseDouble(lblSmallPrice.getText());
		else if(rdoMedium.isSelected())
			pastaPrice = Double.parseDouble(lblMediumPrice.getText());
		else
			pastaPrice = Double.parseDouble(lblLargePrice.getText());
		
		return pastaPrice;
	}
	private String serviceMethod() {
		String service = "";
		if(rdoDineIn.isSelected())
			service = "DINE IN";
		else if(rdoTakeOut.isSelected())
			service = "TAKE OUT";
		else
			service = "FOR DELIVERY" + "\t\t" + "50.00";
		
		return service;
	}
	private double serviceFee() {
		double serviceFee = 0;
		if(rdoDineIn.isSelected())
			serviceFee = 0.00;
		else if(rdoTakeOut.isSelected())
			serviceFee = 0.00;
		else
			serviceFee = 50.00;
		
		return serviceFee;
	}
	private double subtotal() {
		double subtotal = 0;
		
		subtotal = addOnPrice + priceOfPancit() + serviceFee();
		
		return subtotal;
	}
	private void orderAgain() {
		txaOrderDetails.setText(null);
	}
	private void showOrderDetails() {
		double totalPrice = 0;
		int quantity = Integer.parseInt(lblQuantity.getText());
		
		totalPrice = subtotal() * quantity;
		
		txaOrderDetails.setText("\nFLAVOR: \t" + cboFlavor.getSelectedItem() + "\n\nSIZE: \t" + sizeOfPancit() + "\n\nPRICE: \t\t\t"
								+ priceOfPancit() + "\n\nADD ONS: \t" + addOnPrice() + "\n\nSERVICE: \t" + serviceMethod()
								+ "\n\nQUANTITY: \t\t\t" + "x" + quantity
								+ "\n\n***************************************************************************************"
								+ "\n\nTOTAL PRICE: \t\t\t" + totalPrice);
	}
}
