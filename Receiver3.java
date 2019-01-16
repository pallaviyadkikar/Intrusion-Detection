import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
public class Receiver3 extends JFrame
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
public Receiver3()
{
super();
initializeComponent();
this.setVisible(true);
try
{
server_1=new ServerSocket(103);
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
jLabel1.setText("RECEIVER3");
jScrollPane1.setViewportView(jTextArea1);
jButton1.setBackground(new Color(255, 255, 255));
jButton1.setText("Exit");
jButton1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e)
{
jButton1_actionPerformed(e);
}
});
contentPane.setLayout(null);
contentPane.setBackground(new Color(159,96,153));
addComponent(contentPane, jLabel1, 207,6,66,18);
addComponent(contentPane, jScrollPane1, 26,37,441,341);
addComponent(contentPane, jButton1, 204,390,83,28);
this.setTitle("Receiver3 - extends JFrame");
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
}}
catch (Exception exp)
{
exp.printStackTrace();
}}
public static void main(String[] args)
{
Receiver3 r1=new Receiver3();
while(true)
{
r1.server();
}
}}
Detector code:

/*                      Detector	                            */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.lang.*;

public class Detector extends JFrame
{
private JLabel jLabel1;
private JTextArea jTextArea1;
private JScrollPane jScrollPane1;
private JButton jButton1;
private JPanel contentPane;
ServerSocket server_1;
DataOutputStream dis1;
DataOutputStream dis2;
DataInputStream dis;
Socket socket_1;
Socket client_1;
Socket client_2;
long temp;
int i=1;
int length;
public Detector()
{
super();
initializeComponent();
this.setVisible(true);
try
{
server_1=new ServerSocket(111);
}
catch (Exception exp)
{
exp.printStackTrace();
}
this.setVisible(true);
}
private void initializeComponent()
{
jLabel1 = new JLabel();
jTextArea1 = new JTextArea();
jScrollPane1 = new JScrollPane();
jButton1 = new JButton();
contentPane = (JPanel)this.getContentPane();
jLabel1.setText("INTRUSION DETECTOR");
jScrollPane1.setViewportView(jTextArea1);
jButton1.setBackground(new Color(255, 255, 255));
jButton1.setText("Exit");
jButton1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e)
{
jButton1_actionPerformed(e);
}
});
contentPane.setLayout(null);
contentPane.setBackground(new Color(159,96,153));
addComponent(contentPane, jLabel1, 172,9,133,38);
addComponent(contentPane, jScrollPane1, 26,37,441,341);
addComponent(contentPane, jButton1, 204,390,83,28);
this.setTitle("Detector - extends JFrame");
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
dis=new DataInputStream(socket_1.getInputStream());
int length=dis.readInt();
String destination=dis.readUTF();
//String ipd=destination.substring(destination.indexOf("IP://"),destination.indexOf("?//"));
//jTextArea1.append(ipd);
if(destination.equalsIgnoreCase("R-101"))
{	jTextArea1.append(dis.readUTF()+"\n");
jTextArea1.append("\t**********************************\n");
jTextArea1.append("\tTHIS IS FROM PORT I_101\n");
jTextArea1.append("\t**********************************\n");
client_1=new Socket("localhost",101);
dis1=new DataOutputStream(client_1.getOutputStream());
dis1.writeInt(length);
while(length>0)
{
rr=dis.readUTF();
jTextArea1.append("Packet "+i+"\t"+rr+" Recieved...\n");
dis1=new DataOutputStream(client_1.getOutputStream());
dis1.writeUTF(rr);
length--;
i++;
}}
else if (destination.equalsIgnoreCase("R-102"))
{
jTextArea1.append("\t**********************************\n");
jTextArea1.append("\tTHIS IS FROM PORT R_102\n");
jTextArea1.append("\t**********************************\n");
client_1=new Socket("localhost",102);
dis1=new DataOutputStream(client_1.getOutputStream());
dis1.writeInt(length);
while(length>0)
{
rr=dis.readUTF();
jTextArea1.append("Packet "+i+"\t"+rr+" Recieved...\n");
dis1=new DataOutputStream(client_1.getOutputStream());
dis1.writeUTF(rr);
length--;
i++;
}}
else if (destination.equalsIgnoreCase("R-103"))
{
jTextArea1.append("\t**********************************\n");
jTextArea1.append("\tTHIS IS FROM PORT R_103\n");
jTextArea1.append("\t**********************************\n");
client_1=new Socket("localhost",103);
dis1=new DataOutputStream(client_1.getOutputStream());
dis1.writeInt(length);

while(length>0)
{
rr=dis.readUTF();
jTextArea1.append("Packet "+i+"\t"+rr+" Recieved...\n");
dis1=new DataOutputStream(client_1.getOutputStream());
dis1.writeUTF(rr);
length--;
i++;
}}
else if (destination.equalsIgnoreCase("I-104"))
{		int big=2;
String ipd="";
jTextArea1.append("\t**********************************\n");
jTextArea1.append("\tTHIS IS FROM PORT I_104\n");
jTextArea1.append("\t**********************************\n");
while(length>0)
{
rr=dis.readUTF();
StringBuffer sb=new StringBuffer(rr);
sb.delete(7,10);
jTextArea1.append("\t\tPacket "+i+"\t"+rr.substring(4,15)+" Recieved...\n");
if(i==1)
{
ipd=rr.substring(rr.indexOf("IP:"),rr.indexOf("??"));
JOptionPane.showMessageDialog(null,"The Intruder Has Been Detected from "+ipd);
//ipd=destination.substring(sb.indexOf("IP:"),sb.indexOf("??"));
}
length--;
i++;
}
//JOptionPane.showMessageDialog(null,"This Is From Intruder Port"+ipd);
//JOptionPane.showMessageDialog(null,"The Intruder Has Been Detected"+ipd);
}}
catch (Exception exp)
{
exp.printStackTrace();
}
}
public static void main(String[] args)
{
Detector r1=new Detector();
while (true)
{
r1.server();
}
}}











