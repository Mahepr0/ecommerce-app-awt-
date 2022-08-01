package desktopPack;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class grocery extends JFrame
{
	JFrame f5;
	JTextField total;
	String data;
	int tot;
	JTextField  tf4;
	JPasswordField  tf6;
	//String total1;
	int [] itemcost = new int[20];
	grocery() throws IOException
	{
		JFrame f = new JFrame("Welcome Page");
		f.setBackground(Color.yellow);
		
		Label l1 = new Label("Welcome to Fresh2Day");
		l1.setBackground(Color.orange);
		l1.setBounds(75,40,140,30);
		
		JButton b1 = new JButton("New User");
		b1.setBounds(30,100,220,50);
		b1.setBackground(Color.yellow);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame f2 = new JFrame("Register Page");
				
				Label l2 = new Label("First Name:");
				l2.setBounds(30,40,70,30);
				JTextField  tf1 = new JTextField();
				tf1.setBounds(150,40,100,20);
				
				Label l3 = new Label("Last Name:");
				l3.setBounds(30,80,70,30);
				JTextField  tf2 = new JTextField();
				tf2.setBounds(150,80,100,20);
				
				Label l4 = new Label("User Name:");
				l4.setBounds(30,120,70,30);
				JTextField  tf3 = new JTextField();
				tf3.setBounds(150,120,100,20);
				
				Label l5 = new Label("Email ID:");
				l5.setBounds(30,160,70,30);
				tf4 = new JTextField();
				tf4.setBounds(150,160,100,20);
				
				Label l6 = new Label("Phone Number:");
				l6.setBounds(30,200,100,30);
				JTextField  tf5 = new JTextField();
				tf5.setBounds(150,200,100,20);
				
				Label l7 = new Label("Password:");
				l7.setBounds(30,240,70,30);
				tf6 = new JPasswordField();
				tf6.setBounds(150,240,100,20);
				
				Label l8 = new Label("Confirm Password:");
				l8.setBounds(30,280,120,30);
				JPasswordField  tf7 = new JPasswordField();
				tf7.setBounds(150,280,100,20);
				
				JButton b3 = new JButton("Submit");
				b3.setBounds(50,320,80,30);
				b3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						String uname = tf3.getText();
						String email = tf4.getText();
						String phone = tf5.getText();
						String pass = tf6.getText();
						
						try
						{
							String drivername = "com.mysql.jdbc.Drive";
							String url = "jdbc:mysql://localhost:3306/java10";
							String username = "root";
							String password = "welcome123";
							Connection con = DriverManager.getConnection(url,username,password);
							
							PreparedStatement ps = con.prepareStatement("insert into mini values(?,?,?,?)");
							ps.setString(1, uname);
							ps.setString(2, email);
							ps.setString(3, phone);
							ps.setString(4, pass);
							
							ps.executeUpdate();
							
							JOptionPane.showMessageDialog(b3, "Sign In Successful");
							f2.dispose();
						}
						catch (SQLException e1)
						{
							e1.printStackTrace();
						}
//						Label sus = new Label("Sign In Successful");
//						sus.setBounds(70,10,120,20);
//						sus.setBackground(Color.green);
//						f2.add(sus);
					}
				});
				
				JButton b4 = new JButton("Cancel");
				b4.setBounds(150,320,80,30);
				b4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						f2.dispose();
					}
				});
				
				f2.add(l2);
				f2.add(tf1);
				f2.add(l3);
				f2.add(tf2);
				f2.add(l4);
				f2.add(tf3);
				f2.add(l5);
				f2.add(tf4);
				f2.add(l6);
				f2.add(tf5);
				f2.add(l7);
				f2.add(tf6);
				f2.add(l8);
				f2.add(tf7);
				f2.add(b3);
				f2.add(b4);
				f2.setSize(300,400);
				f2.setLayout(null);
				f2.setVisible(true);
			}
			
		});
		
		JButton b2 = new JButton("Existing User");
		b2.setBounds(30,180,220,50);
		b2.setBackground(Color.yellow);
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame f3 = new JFrame("Login Page");
				
				Label l9 = new Label("Fresh2Day Login Page");
				l9.setBounds(70,50,150,30);
				l9.setBackground(Color.orange);
				
				Label l10 = new Label("Email ID:");
				l10.setBounds(30,100,150,30);
				JTextField  tf8 = new JTextField();
				tf8.setBounds(30,130,200,20);
				
				Label l11 = new Label("Confirm Password:");
				l11.setBounds(30,160,150,30);
				JPasswordField  tf9 = new JPasswordField();
				tf9.setBounds(30,190,200,20);
				
				Checkbox c1 = new Checkbox("Remember me",false);
				c1.setBounds(30,210,100,30);
				
				JButton b5 = new JButton("Login");
				b5.setBounds(30,250,80,30);
				b5.setBackground(Color.yellow);
				b5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						try
						{
							String drivername = "com.mysql.jdbc.Drive";
							String url = "jdbc:mysql://localhost:3306/java10";
							String username = "root";
							String password = "welcome123";
							Connection con = DriverManager.getConnection(url,username,password);
							
							Statement st = con.createStatement();
							
							String sql = "select email,password from mini where email='"+tf8.getText().toString()+"' and password = '"+tf9.getText().toString()+"'"; 
							
							ResultSet rs = st.executeQuery(sql);
							
							if(rs.next())
							{
								JOptionPane.showMessageDialog(null, "Log In Successful");
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Incorrect Email or Password");
								
							}
							
						}
						catch (SQLException e1)
						{
							e1.printStackTrace();
						}
						
						JFrame f4 = new JFrame("Home Page");
						
						Label l12 = new Label("Welcome, user");
						l12.setBounds(20,20,100,30);
						
						JButton b7 = new JButton("Home");
						b7.setBounds(750,20,80,30);
						JButton b8 = new JButton("Category");
						b8.setBounds(850,20,80,30);
						JButton b9 = new JButton("Career");
						b9.setBounds(950,20,80,30);
						JButton b10 = new JButton("Contact");
						b10.setBounds(1050,20,80,30);
						JButton b11 = new JButton("About Us");
						b11.setBounds(1150,20,80,30);

						JLabel apples = new JLabel();
						ImageIcon img = new ImageIcon("C:/Users/msmah/OneDrive/Desktop/JAVA/apples.jpg");
						apples.setIcon(img);
						apples.setBounds(100,100,150,200);
						JButton b14=new JButton("Apples 1kg= rs.100");
						b14.setBounds(100,300,150,30);
						b14.addActionListener(new  ActionListener () {
							public void actionPerformed(ActionEvent e) {
								f5.show();
							}
						});
						
						JLabel grapes = new JLabel();
						ImageIcon img2 = new ImageIcon("C:/Users/msmah/OneDrive/Desktop/JAVA/grapes.jpg");
						grapes.setIcon(img2);
						grapes.setBounds(300,100,150,200);
						JButton b15=new JButton("Grapes 1kg= rs.80");
						b15.setBounds(300,300,150,30);
						b15.addActionListener(new  ActionListener () {
							public void actionPerformed(ActionEvent e) {
								f5.show();
							}
						});
						
						JLabel bananas = new JLabel();
						ImageIcon img3 = new ImageIcon("C:/Users/msmah/OneDrive/Desktop/JAVA/bananas.jpg");
						bananas.setIcon(img3);
						bananas.setBounds(500,100,150,200);
						JButton b16=new JButton("Bananas 1pc= rs.10");
						b16.setBounds(500,300,150,30);
						b16.addActionListener(new  ActionListener () {
							public void actionPerformed(ActionEvent e) {
								f5.show();
							}
						});
						
						JLabel watermelon = new JLabel();
						ImageIcon img4 = new ImageIcon("C:/Users/msmah/OneDrive/Desktop/JAVA/watermelon.jpg");
						watermelon.setBounds(700,100,150,200);
						watermelon.setIcon(img4);
						JButton b17=new JButton("Watermelon= rs.25");
						b17.setBounds(700,300,150,30);
						b17.addActionListener(new  ActionListener () {
							public void actionPerformed(ActionEvent e) {
								f5.show();
							}
						});
						
						JLabel orange = new JLabel();
						ImageIcon img5 = new ImageIcon("C:/Users/msmah/OneDrive/Desktop/JAVA/orange.jpg");
						orange.setBounds(900,100,150,200);
						orange.setIcon(img5);
						JButton b18=new JButton("Orange 1kg= rs. 75");
						b18.setBounds(900,300,150,30);
						b18.addActionListener(new  ActionListener () {
							public void actionPerformed(ActionEvent e) {
								f5.show();
							}
						});
						
						JLabel lime = new JLabel();
						ImageIcon img6 = new ImageIcon("C:/Users/msmah/OneDrive/Desktop/JAVA/lime.jpg");
						lime.setBounds(1100,100,150,200);
						lime.setIcon(img6);
						JButton b19=new JButton("Lime 1kg= rs.60");
						b19.setBounds(1100,300,150,30);
						b19.addActionListener(new  ActionListener () {
							public void actionPerformed(ActionEvent e) {
								f5.show();
							}
						});
						
						JLabel cucumber = new JLabel();
						ImageIcon img7 = new ImageIcon("C:/Users/msmah/OneDrive/Desktop/JAVA/cucumber.jpg");
						cucumber.setBounds(100,350,150,200);
						cucumber.setIcon(img7);
						JButton b20=new JButton("Cucumber= rs.50");
						b20.setBounds(100,550,150,30);
						b20.addActionListener(new  ActionListener () {
							public void actionPerformed(ActionEvent e) {
								f5.show();
							}
						});
						
						JLabel cabbage = new JLabel();
						ImageIcon img8 = new ImageIcon("C:/Users/msmah/OneDrive/Desktop/JAVA/cabbage.jpg");
						cabbage.setBounds(300,350,150,200);
						cabbage.setIcon(img8);
						JButton b21=new JButton("Cabbage= rs.25");
						b21.setBounds(300,550,150,30);
						b21.addActionListener(new  ActionListener () {
							public void actionPerformed(ActionEvent e) {
								f5.show();
							}
						});
						
						JLabel onion = new JLabel();
						ImageIcon img9 = new ImageIcon("C:/Users/msmah/OneDrive/Desktop/JAVA/onion.jpg");
						onion.setBounds(500,350,150,200);
						onion.setIcon(img9);
						JButton b22=new JButton("Onion 1kg= rs.35");
						b22.setBounds(500,550,150,30);
						b22.addActionListener(new  ActionListener () {
							public void actionPerformed(ActionEvent e) {
								f5.show();
							}
						});
						
						JLabel tomato = new JLabel();
						ImageIcon img10 = new ImageIcon("C:/Users/msmah/OneDrive/Desktop/JAVA/tomato.jpg");
						tomato.setBounds(700,350,150,200);
						tomato.setIcon(img10);
						JButton b23=new JButton("Tomato 1kg= rs.45");
						b23.setBounds(700,550,150,30);
						b23.addActionListener(new  ActionListener () {
							public void actionPerformed(ActionEvent e) {
								f5.show();
							}
						});
						
						JLabel carrot = new JLabel();
						ImageIcon img11 = new ImageIcon("C:/Users/msmah/OneDrive/Desktop/JAVA/carrot.jpg");
						carrot.setBounds(900,350,150,200);
						carrot.setIcon(img11);
						JButton b24=new JButton("Carrot 1kg= rs.40");
						b24.setBounds(900,550,150,30);
						b24.addActionListener(new  ActionListener () {
							public void actionPerformed(ActionEvent e) {
								f5.show();
							}
						});
						
						JLabel garlic = new JLabel();
						ImageIcon img12 = new ImageIcon("C:/Users/msmah/OneDrive/Desktop/JAVA/garlic.jpg");
						garlic.setBounds(1100,350,150,200);
						garlic.setIcon(img12);
						JButton b25=new JButton("Garlic 1kg= rs.20");
						b25.setBounds(1100,550,150,30);
						
						JButton b12 = new JButton("Save for later");
						b12.setBounds(1050,600,120,30);
						b12.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								Label msg = new Label();
								msg.setBounds(600,600,200,30);
								msg.setBackground(Color.orange);
								msg.setText("Items have been added to your cart");
								f4.add(msg);
								}
							});
						JButton b13 = new JButton("Open Cart");
						b13.setBounds(1200,600,100,30);
						b13.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								f5 = new JFrame("Payment Page");
								
								Label ap = new Label("Apples: ");
								ap.setBounds(30,30,60,30);
								JTextField ap1 = new JTextField();
								ap1.setBounds(120,30,100,30);
								
								Label gr = new Label("Grapes: ");
								gr.setBounds(30,60,60,30);
								JTextField gr1 = new JTextField();
								gr1.setBounds(120,60,100,30);
								
								Label ba = new Label("Bananas: ");
								ba.setBounds(30,90,60,30);
								JTextField ba1 = new JTextField();
								ba1.setBounds(120,90,100,30);
								
								Label wa = new Label("Watermelon: ");
								wa.setBounds(30,120,75,30);
								JTextField wa1 = new JTextField();
								wa1.setBounds(120,120,100,30);
								
								Label or = new Label("Oranges: ");
								or.setBounds(30,150,60,30);
								JTextField or1 = new JTextField();
								or1.setBounds(120,150,100,30);
								
								Label li = new Label("Lime: ");
								li.setBounds(30,180,60,30);
								JTextField li1 = new JTextField();
								li1.setBounds(120,180,100,30);
								
								Label cu = new Label("Cucumber: ");
								cu.setBounds(30,210,60,30);
								JTextField cu1 = new JTextField();
								cu1.setBounds(120,210,100,30);
								
								Label ca = new Label("Cabbage: ");
								ca.setBounds(30,240,60,30);
								JTextField ca1 = new JTextField();
								ca1.setBounds(120,240,100,30);
								
								Label on = new Label("Onions: ");
								on.setBounds(30,270,60,30);
								JTextField on1 = new JTextField();
								on1.setBounds(120,270,100,30);
								
								Label to = new Label("Tomatoes: ");
								to.setBounds(30,300,60,30);
								JTextField to1 = new JTextField();
								to1.setBounds(120,300,100,30);
								
								Label car = new Label("Carrot: ");
								car.setBounds(30,330,60,30);
								JTextField car1 = new JTextField();
								car1.setBounds(120,330,100,30);
								
								Label ga = new Label("Garlic: ");
								ga.setBounds(30,360,60,30);
								JTextField ga1 = new JTextField();
								ga1.setBounds(120,360,100,30);
								
								ap1.setText("0");
								gr1.setText("0");
								ba1.setText("0");
								wa1.setText("0");
								or1.setText("0");
								li1.setText("0");
								cu1.setText("0");
								ca1.setText("0");
								on1.setText("0");
								to1.setText("0");
								car1.setText("0");
								ga1.setText("0");
								
								JButton btnTotal = new JButton("Total");
								btnTotal.setBounds(30,460,230,30);
								JTextField total = new JTextField();
								total.setBounds(30,420,230,30);
								btnTotal.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										
										itemcost[0] = Integer.parseInt(ap1.getText())*100;
										itemcost[1] = Integer.parseInt(gr1.getText())*80;
										itemcost[2] = Integer.parseInt(ba1.getText())*10;
										itemcost[3] = Integer.parseInt(wa1.getText())*25;
										itemcost[4] = Integer.parseInt(or1.getText())*75;
										itemcost[5] = Integer.parseInt(li1.getText())*60;
										itemcost[6] = Integer.parseInt(cu1.getText())*50;
										itemcost[7] = Integer.parseInt(ca1.getText())*25;
										itemcost[8] = Integer.parseInt(on1.getText())*35;
										itemcost[9] = Integer.parseInt(to1.getText())*45;
										itemcost[10] = Integer.parseInt(car1.getText())*40;
										itemcost[11] = Integer.parseInt(ga1.getText())*20;
										tot = itemcost[0]+itemcost[1]+itemcost[2]+itemcost[3]+itemcost[4]+itemcost[5]+itemcost[6]+itemcost[7]+itemcost[8]+itemcost[9]+itemcost[10]+itemcost[11];
										
										//String tot = itemcost.toString();
										//total1 = itemcost[12];
										data = String.valueOf(tot);
										total.setText(data);
									}
								});
								
								
								
								JButton pay = new JButton("Pay");
								pay.setBounds(30,500,230,30);
								pay.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										if (tot==0)
										{
											JOptionPane.showMessageDialog(pay, "Please enter some items");
//											Label proc = new Label("Please enter some items");
//											proc.setBounds(30,600,150,30);
//											f5.add(proc);
										}
										else
										{
											JOptionPane.showMessageDialog(pay, "Payment Processing...");
//											Label proc = new Label("Payment Processing...");
//											proc.setBounds(30,630,150,30);
//											f5.add(proc);
										}
									}
								});
								JButton can = new JButton("Cancel");
								can.setBounds(30,540,230,30);
								can.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										f5.dispose();
									}
								});
								
								f5.add(btnTotal);
								f5.add(total);
								f5.add(ap);
								f5.add(ap1);
								f5.add(gr);
								f5.add(gr1);
								f5.add(ba);
								f5.add(ba1);
								f5.add(wa);
								f5.add(wa1);
								f5.add(or);
								f5.add(or1);
								f5.add(li);
								f5.add(li1);
								f5.add(cu);
								f5.add(cu1);
								f5.add(ca);
								f5.add(ca1);
								f5.add(on);
								f5.add(on1);
								f5.add(to);
								f5.add(to1);
								f5.add(car);
								f5.add(car1);
								f5.add(ga);
								f5.add(ga1);
								f5.add(pay);
								f5.add(can);
								f5.setSize(300,650);
								f5.setLayout(null);
								f5.setVisible(true);
							}
						});
						
						f4.add(apples);
						f4.add(grapes);
						f4.add(bananas);
						f4.add(watermelon);
						f4.add(orange);
						f4.add(lime);
						f4.add(cucumber);
						f4.add(cabbage);
						f4.add(onion);
						f4.add(tomato);
						f4.add(carrot);
						f4.add(garlic);
						f4.add(l12);
						f4.add(b7);
						f4.add(b8);
						f4.add(b9);
						f4.add(b10);
						f4.add(b11);
						f4.add(b12);
						f4.add(b13);
						f4.add(b14);
						f4.add(b15);
						f4.add(b16);
						f4.add(b17);
						f4.add(b18);
						f4.add(b19);
						f4.add(b20);
						f4.add(b21);
						f4.add(b22);
						f4.add(b23);
						f4.add(b24);
						f4.add(b25);
						//f4.add(sp1);
						f4.setSize(1360,720);
						f4.setLayout(null);
						f4.setVisible(true);
					}
				});
				
				JButton b6 = new JButton("Cancel");
				b6.setBounds(120,250,100,30);
				b6.setBackground(Color.yellow);
				b6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						f3.dispose();
					}
				});
				
				f3.add(l9);
				f3.add(l10);
				f3.add(tf8);
				f3.add(l11);
				f3.add(tf9);
				f3.add(c1);
				f3.add(b5);
				f3.add(b6);
				f3.setSize(300,380);
				f3.setLayout(null);
				f3.setVisible(true);
			}
		});
		
		f.add(l1);
		f.add(b1);
		f.add(b2);
		f.setSize(300,300);
		f.setLayout(null);
		f.setVisible(true);
	}
	
}
public class mini_project {

	public static void main(String[] args) throws IOException {
		new grocery();

	}

}
