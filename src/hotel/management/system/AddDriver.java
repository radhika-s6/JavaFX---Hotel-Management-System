
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener{
    
    JButton add, cancel;
    JTextField tfname, tfage, tfcompany, tfmodel, tflocation;
    JComboBox typecombo, availablecombo, cleancombo, agecombo, gendercombo;
    
    AddDriver()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Drivers");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150, 10, 200, 20);
        add(heading);
        
        JLabel lbroomno = new JLabel("Name");
        lbroomno.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbroomno.setBounds(60, 70, 120, 30);
        add(lbroomno);
        
        tfname = new JTextField();
        tfname.setBounds(200, 80, 150, 30);
        add(tfname);
        
        JLabel lbavail = new JLabel("Age");
        lbavail.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbavail.setBounds(60, 130, 120, 30);
        add(lbavail);
        
        tfage = new JTextField();
        tfage.setBounds(200, 130, 150, 30);
        add(tfage);

        
        JLabel lbclean = new JLabel("Gender");
        lbclean.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbclean.setBounds(60, 170, 120, 30);
        add(lbclean);
        
        String cleanOptions[] = {"Male", "Female"};
        gendercombo = new JComboBox(cleanOptions);
        gendercombo.setBounds(200, 170, 150, 30);
        gendercombo.setBackground(Color.WHITE);
        add(gendercombo);
        
        JLabel lbprice = new JLabel("Car Company");
        lbprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbprice.setBounds(60, 210, 120, 30);
        add(lbprice);
        
        tfcompany = new JTextField();
        tfcompany.setBounds(200, 210, 150, 30);
        add(tfcompany);
        
        JLabel lbtype = new JLabel("Car Model");
        lbtype.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbtype.setBounds(60, 250, 120, 30);
        add(lbtype);
        
        tfmodel = new JTextField();
        tfmodel.setBounds(200, 250, 150, 30);
        add(tfmodel);
        
        JLabel lbavailable = new JLabel("Available");
        lbavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbavailable.setBounds(60, 290, 120, 30);
        add(lbavailable);
        
        String driverOptions[] = {"Available", "Busy"};
        availablecombo = new JComboBox(driverOptions);
        availablecombo.setBounds(200, 290, 150, 30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);
        
        JLabel lblocation = new JLabel("Location");
        lblocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblocation.setBounds(60, 330, 120, 30);
        add(lblocation);
        
        tflocation = new JTextField();
        tflocation.setBounds(200, 330, 150, 30);
        add(tflocation);
        
        add = new JButton("Add Driver");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(60, 370, 130, 30);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(220, 370, 130, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/drive.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);   //width, height
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 30, 500, 300); 
        add(image);
        
        setBounds(470, 250, 980, 470);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == add){
            String name = tfname.getText();
            String age = tfage.getText();
            String gender = (String) gendercombo.getSelectedItem();
            String company = tfcompany.getText();
            String brand = tfmodel.getText();
            String available = (String) availablecombo.getSelectedItem();
            String location = tflocation.getText();
            
            try{
                Conn conn = new Conn();
                String str = "insert into driver values('"+name+"', '"+age+"', '"+gender+"', '"+company+"', '"+brand+"', '"+available+"', '"+location+"')";
                
                conn.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "New Driver added successfuly!");
                
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
        new AddDriver();
    }
}
