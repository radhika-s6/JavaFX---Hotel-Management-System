
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener{
    HotelManagementSystem()
    {
//        setSize(950, 650);
//        setLocation(420, 200);
        setBounds(420, 200, 950, 650);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hotel.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 950, 650); //locationx, locationy, length, breadth
        add(image);
        
        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(15, 30, 1000, 90);  //left, up, length, breadth
        text.setForeground(Color.BLACK);
        text.setFont(new Font("serif", Font.BOLD, 30));
        image.add(text);
        
        JButton next = new JButton("Next");
        next.setBounds(400, 500, 150, 50);
        next.setBackground(Color.CYAN);
        next.setForeground(Color.BLACK);
        next.addActionListener(this);
        next.setFont(new Font("serif", Font.PLAIN, 30));
        image.add(next);
        
        setVisible(true);
        
        while(true){
            text.setVisible(false);
            try{
                Thread.sleep(500);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(600);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
    public void actionPerformed(ActionEvent ae)
        {
            setVisible(false);
            new Login();
        }

    public static void main(String[] args) {
        new HotelManagementSystem();
    }
    
}
