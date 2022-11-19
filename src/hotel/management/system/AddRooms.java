
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener{
    
    JButton add, cancel;
    JTextField tfroom, tfprice;
    JComboBox typecombo, availablecombo, cleancombo;
    
    AddRooms()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150, 20, 200, 20);
        add(heading);
        
        JLabel lbroomno = new JLabel("Room Number");
        lbroomno.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbroomno.setBounds(60, 80, 120, 30);
        add(lbroomno);
        
        tfroom = new JTextField();
        tfroom.setBounds(200, 80, 150, 30);
        add(tfroom);
        
        JLabel lbavail = new JLabel("Available");
        lbavail.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbavail.setBounds(60, 130, 120, 30);
        add(lbavail);
        
        String availableOptions[] = {"Available", "Occupied"};
        availablecombo = new JComboBox(availableOptions);
        availablecombo.setBounds(200, 130, 150, 30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);
        
        JLabel lbclean = new JLabel("Cleaning Status");
        lbclean.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbclean.setBounds(60, 180, 120, 30);
        add(lbclean);
        
        String cleanOptions[] = {"Cleaned", "Dirty"};
        cleancombo = new JComboBox(cleanOptions);
        cleancombo.setBounds(200, 180, 150, 30);
        cleancombo.setBackground(Color.WHITE);
        add(cleancombo);
        
        JLabel lbprice = new JLabel("Price");
        lbprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbprice.setBounds(60, 230, 120, 30);
        add(lbprice);
        
        tfprice = new JTextField();
        tfprice.setBounds(200, 230, 150, 30);
        add(tfprice);
        
        JLabel lbtype = new JLabel("Bed Type");
        lbtype.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbtype.setBounds(60, 280, 120, 30);
        add(lbtype);
        
        String typeOptions[] = {"Single Bed", "Double Bed"};
        typecombo = new JComboBox(typeOptions);
        typecombo.setBounds(200, 280, 150, 30);
        typecombo.setBackground(Color.WHITE);
        add(typecombo);
        
        add = new JButton("Add Rooms");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(60, 350, 130, 30);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(220, 350, 130, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bedroom.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400, 30, 500, 300); 
        add(image);
        
        setBounds(490, 250, 940, 470);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == add){
            String roomnumber = tfroom.getText();
            String availability = (String) availablecombo.getSelectedItem();
            String status = (String) cleancombo.getSelectedItem();
            String price = (String) tfprice.getText();
            String type = (String) typecombo.getSelectedItem();
            
            try{
                Conn conn = new Conn();
                String str = "insert into room values('"+roomnumber+"', '"+availability+"', '"+status+"', '"+price+"', '"+type+"')";
                
                conn.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "New Room added successfuly!");
                
                setVisible(false);
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
        }
        else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args)
    {
        new AddRooms();
    }
}
