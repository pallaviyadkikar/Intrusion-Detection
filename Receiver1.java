import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
public class Receiver1 extends JFrame
{
private JLabel jLabel1;
private JTextArea jTextArea1;
private JScrollPane jScrollPane1;
private JButton jButton1;
private JPanel contentPane;
String Recieved1;
ServerSocket server_1;
Socket socket_1;
int i=1;
int i1;
int j1;
int k1;
int j=1;
int k=1;
int t;
public Receiver1()
{
super();
initializeComponent();
this.setVisible(true);
try
{
server_1=new ServerSocket(101);
}
catch (Exception exp)
{
exp.printStackTrace();
}}
private void initializeComponent()
{
jLabel1 = new JLabel();
jTextArea1 = new JTextArea();
jScrollPane1 = new JScrollPane();
jButton1 = new JButton();
contentPane = (JPanel)this.getContentPane();
jLabel1.setText("RECEIVER1");
jScrollPane1.setViewportView(jTextArea1);
jButton1.setBackground(new Color(255, 255, 255));
jButton1.setText("Exit");
jButton1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e)
{
jButton1_actionPerformed(e);
}});
contentPane.setLayout(null);
contentPane.setBackground(new Color(159,96,153));
addComponent(contentPane, jLabel1, 207,6,66,18);
addComponent(contentPane, jScrollPane1, 26,37,441,341);
addComponent(contentPane, jButton1, 204,390,83,28);
this.setTitle("Receiver1 - extends JFrame");
this.setLocation(new Point(0, 0));
this.setSize(new Dimension(505, 462));
}
private void addComponent(Container container,Component c,int x,int y,int width,int height)
{
c.setBounds(x,y,width,height);
container.add(c);
}
private void jButton1_actionPerformed(ActionEvent e)
{
System.out.println("\njButton1_actionPerformed(ActionEvent e) called.");
System.exit(0);
}
public void server()
{
try
{
String rr="";
socket_1=server_1.accept();
DataInputStream dis=new DataInputStream(socket_1.getInputStream());
int length=dis.readInt();
while(length>0)
{
rr=dis.readUTF();
jTextArea1.append("Packet "+i+"\t"+rr+" Recieved...\n");
length--;
i++;
}
}
catch (Exception exp)
{
exp.printStackTrace();
}}
public static void main(String[] args)
{
Receiver1 r1=new Receiver1();
while(true)
{
r1.server();
}
}}
