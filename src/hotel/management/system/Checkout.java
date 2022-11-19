/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Checkout extends JFrame implements ActionListener{
    
    Choice ccustomer;
    JLabel lbroomnumber, lbcheckintime, lbcheckouttime;
    JButton checkout, back;
    
    Checkout()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Checkout");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setForeground(Color.BLUE);
        text.setBounds(100, 20, 100, 30);
        add(text);
        
        JLabel lbid = new JLabel("Customer Id");
        lbid.setBounds(30, 80, 100, 30);
        add(lbid);
        
        ccustomer = new Choice();
        ccustomer.setBounds(150, 80, 150, 25);
        add(ccustomer);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);   //width, height
        ImageIcon i3= new ImageIcon(i2);
        JLabel tick = new JLabel(i3);
        tick.setBounds(310, 80, 20, 20); 
        add(tick);
        
        JLabel lbroom = new JLabel("Room Number");
        lbroom.setBounds(30, 130, 100, 30);
        add(lbroom);
        
        lbroomnumber = new JLabel();
        lbroomnumber.setBounds(150, 130, 100, 30);
        add(lbroomnumber);
        
        JLabel lbcheckin = new JLabel("Checkin Time");
        lbcheckin.setBounds(30, 180, 100, 30);
        add(lbcheckin);
        
        lbcheckintime = new JLabel();
        lbcheckintime.setBounds(150, 180, 100, 30);
        add(lbcheckintime);
        
        JLabel lbcheckout = new JLabel("Checkout Time");
        lbcheckout.setBounds(30, 230, 100, 30);
        add(lbcheckout);
        
        Date date = new Date();
        lbcheckouttime = new JLabel("" + date);
        lbcheckouttime.setBounds(150, 230, 150, 30);
        add(lbcheckouttime);
        
        checkout = new JButton("checkout");
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setBounds(30, 280, 120, 30);
        checkout.addActionListener(this);
        add(checkout);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(170, 280, 120, 30);
        back.addActionListener(this);
        add(back);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                ccustomer.add(rs.getString("number"));
                lbroomnumber.setText(rs.getString("room"));
                lbcheckintime.setText(rs.getString("checkintime"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/checkout.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);   //width, height
        ImageIcon i6= new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(350, 50, 400, 250); 
        add(image);
        
        setBounds(570, 300, 800, 400);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == checkout){
            String query1 = "delete from customer where number = '"+ccustomer.getSelectedItem()+"'";
            String query2 = "update room set availability = 'Available' where roomnumber = '"+lbroomnumber.getText()+"'";
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Checkout done");
                
                setVisible(false);
                new Reception();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args)
    {
        new Checkout();
    }
}
