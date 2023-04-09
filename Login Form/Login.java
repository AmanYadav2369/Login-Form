import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Login extends JFrame
{
Container c;
JLabel head, username, password, ans;
JTextField txtusername, txtpassword;
JButton btnlogin;

Login(){
c=getContentPane();
c.setLayout(null);
c.setBackground(Color.CYAN);

head=new JLabel("Login Form");
head.setBounds(95,0,300,45);
head.setFont(new Font("Arial", Font.BOLD, 35));
head.setForeground(Color.BLUE);
c.add(head);

username=new JLabel("Username :");
username.setBounds(40,80,200,30);
username.setFont(new Font("Arial", Font.BOLD, 25));
username.setForeground(Color.BLUE);
c.add(username);

txtusername=new JTextField(20);
txtusername.setBounds(180,80,180,30);
txtusername.setFont(new Font("Arial", Font.PLAIN, 20));
c.add(txtusername);

password=new JLabel("Password :");
password.setBounds(40,150,200,30);
password.setFont(new Font("Arial", Font.BOLD, 25));
password.setForeground(Color.BLUE);
c.add(password);

txtpassword=new JTextField(20);
txtpassword.setBounds(180,150,180,30);
txtpassword.setFont(new Font("Arial", Font.PLAIN, 20));
c.add(txtpassword);

btnlogin=new JButton("Login");
btnlogin.setBounds(100,220,200,30);
btnlogin.setFont(new Font("Arial", Font.BOLD, 25));
btnlogin.setForeground(Color.BLUE);
c.add(btnlogin);

ans=new JLabel("");
ans.setBounds(100,270,200,30);
ans.setFont(new Font("Arial", Font.BOLD, 25));
ans.setForeground(Color.BLUE);
c.add(ans);

ActionListener a = (ae) -> { 
String Username=txtusername.getText();
String Password=txtpassword.getText();
try{
DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
String url="jdbc:mysql://localhost:3306/school";
String username="root";
String password="abc456";
Connection con=DriverManager.getConnection(url, username, password);
String sql="select*from login where Username='"+Username+"' and Password='"+Password+"' ";
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery(sql);
if(rs.next()){
JOptionPane.showMessageDialog(c,"Login Successfully...");
}else{
JOptionPane.showMessageDialog(c,"Invalid Username/Password...");
}
con.close();
}catch(SQLException e){
System.out.println("issue"+e);
}

 };
btnlogin.addActionListener(a);


setSize(400,450);
setLocationRelativeTo(null);
setTitle("login form...");
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public static void main(String args[])
{
Login l=new Login();
}
}