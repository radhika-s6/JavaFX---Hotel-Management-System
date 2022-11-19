/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    Dashboard()
    {
        setBounds(180, 15, 1550, 1000);
//        setLayout(null);
        
//Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hotelview.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);   //width, height
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(180, 15, 1550, 1000); 
        add(image);
        
        JLabel text = new JLabel("THE TAJ GROUP WELCOMES YOU");
        text.setBounds(400, 80, 1000, 50);  //left, up, length, breadth
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Tahoma", Font.BOLD, 45));
        image.add(text);
        
        //Menu Bar
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 1550, 30);
        image.add(mb);
        
        //Menus
        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.RED);
        mb.add(hotel);
        
        //Menu Item (Dropdown)
        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);
        
        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.BLUE);
        admin.addActionListener(this);
        mb.add(admin);
        
        JMenuItem addemp = new JMenuItem("ADD EMPLOYEE");
        addemp.addActionListener(this);
        admin.add(addemp);
        
        JMenuItem addrooms = new JMenuItem("ADD ROOMS");
        addrooms.addActionListener(this);
        admin.add(addrooms);
        
        JMenuItem adddrivers = new JMenuItem("ADD DRIVERS");
        adddrivers.addActionListener(this);
        admin.add(adddrivers);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getActionCommand().equals("ADD EMPLOYEE"))
        {
            new AddEmployee();
        }
        else if(ae.getActionCommand().equals("ADD ROOMS")){
            new AddRooms();
        }
        else if(ae.getActionCommand().equals("ADD DRIVERS"))
        {
            new AddDriver();
        }
        else if(ae.getActionCommand().equals("RECEPTION"))
        {
            new Reception();
        }
    }
   
    
    public static void main(String[] args)
    {
        new Dashboard();
    }
}
