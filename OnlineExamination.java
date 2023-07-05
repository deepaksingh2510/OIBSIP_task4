import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  
import java.lang.Exception; 
import java.util.Timer;
import java.util.TimerTask; 
class login extends JFrame implements ActionListener  
{  
    JButton b1;  
    JPanel newPanel;  
    JLabel userLabel, passLabel;  
    final JTextField  textField1, textField2;  
    login()  
    {     
        userLabel = new JLabel();  
        userLabel.setText("    Username :");      
        textField1 = new JTextField(15);      
        passLabel = new JLabel();  
        passLabel.setText("    Password :");        
        textField2 = new JPasswordField(8);     
        b1 = new JButton("   SUBMIT   ");  
        newPanel = new JPanel(new GridLayout(3, 1));  
        newPanel.add(userLabel);     
        newPanel.add(textField1);  
        newPanel.add(passLabel);    
        newPanel.add(textField2);   
        newPanel.add(b1);          
        add(newPanel, BorderLayout.CENTER);  
        b1.addActionListener(this);    
        setTitle("Login Form ");         
    }   
    public void actionPerformed(ActionEvent ae)     
    {  
        String userValue = textField1.getText();        
        String passValue = textField2.getText();       
        if(!passValue.equals(""))
            new OnlineTestBegin(userValue); 
        else{
            textField2.setText("Enter Password");
            actionPerformed(ae);
        }
    }     
}  
class OnlineTestBegin extends JFrame implements ActionListener  
{  
    JLabel l;  
    JLabel l1;  
    JRadioButton jb[]=new JRadioButton[6];  
    JButton b1,b2,log;  
    ButtonGroup bg;  
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];  
    Timer timer = new Timer();  
    OnlineTestBegin(String s)  
    {      
        super(s); 
        l=new JLabel();
        l1 = new JLabel();  
        add(l);
        add(l1);  
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            add(jb[i]);  
            bg.add(jb[i]);  
        }  
        b1=new JButton("Save and Next");  
        b2=new JButton("Save for later");  
        b1.addActionListener(this);  
        b2.addActionListener(this);  
        add(b1);add(b2);  
        set();  
        l.setBounds(30,40,450,20);
        l1.setBounds(20,20,450,20);
        jb[0].setBounds(50,80,100,20);  
        jb[1].setBounds(50,110,100,20);  
        jb[2].setBounds(50,140,100,20);  
        jb[3].setBounds(50,170,100,20);  
        b1.setBounds(95,240,140,30);  
        b2.setBounds(270,240,150,30);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(600,350);     
        timer.scheduleAtFixedRate(new TimerTask() {
            int i = 600;
            public void run() {  
                l1.setText("Time left: " + i);
                i--;   
                if (i < 0) {
                    timer.cancel();
                    l1.setText("Time Out");                     
                } 
            }
        }, 0, 1000);        
    }  
    public void actionPerformed(ActionEvent e)  
    {          
        if(e.getSource()==b1)  
        {  
            if(check())  
                count=count+1;  
            current++;  
            set();    
            if(current==9)  
            {  
                b1.setEnabled(false);  
                b2.setText("Result");  
            }  
        }  
        if(e.getActionCommand().equals("Save for later"))  
        {  
            JButton bk=new JButton("Review"+x);  
            bk.setBounds(480,20+30*x,100,30);  
            add(bk);  
            bk.addActionListener(this);  
            m[x]=current;  
            x++;  
            current++;  
            set();    
            if(current==9)  
                b2.setText("Result");  
            setVisible(false);  
            setVisible(true);  
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals("Review"+y))  
        {  
            if(check())  
                count=count+1;  
            now=current;  
            current=m[y];  
            set();  
            ((JButton)e.getSource()).setEnabled(false);  
            current=now;  
        }  
        }      
        if(e.getActionCommand().equals("Result"))  
        {  
            if(check())  
                count=count+1;  
            current++;  
            JOptionPane.showMessageDialog(this,"Score ="+count);  
            System.exit(0);  
        }  
    }  
    void set()  
    {  
        jb[4].setSelected(true);  
        if (current == 0) {
        l.setText("Que1: Which city is the capital of India?");
        jb[0].setText("Mumbai");
        jb[1].setText("New Delhi");
        jb[2].setText("Kolkata");
        jb[3].setText("Chennai");
    } else if (current == 1) {
        l.setText("Que2: Who is known as the 'Father of the Nation' in India?");
        jb[0].setText("Mahatma Gandhi");
        jb[1].setText("Jawaharlal Nehru");
        jb[2].setText("B.R. Ambedkar");
        jb[3].setText("Subhash Chandra Bose");
    } else if (current == 2) {
        l.setText("Que3: Which river is known as the 'Ganges' in India?");
        jb[0].setText("Yamuna");
        jb[1].setText("Brahmaputra");
        jb[2].setText("Godavari");
        jb[3].setText("Ganga");
    } else if (current == 3) {
        l.setText("Que4: Which festival is celebrated during the spring season in India?");
        jb[0].setText("Diwali");
        jb[1].setText("Holi");
        jb[2].setText("Eid");
        jb[3].setText("Christmas");
    } else if (current == 4) {
        l.setText("Que5: Which is the national animal of India?");
        jb[0].setText("Lion");
        jb[1].setText("Elephant");
        jb[2].setText("Tiger");
        jb[3].setText("Leopard");
    } else if (current == 5) {
        l.setText("Que6: Who composed the Indian national anthem, 'Jana Gana Mana'?");
        jb[0].setText("Rabindranath Tagore");
        jb[1].setText("Bankim Chandra Chattopadhyay");
        jb[2].setText("Sarojini Naidu");
        jb[3].setText("Mohandas Karamchand Gandhi");
    } else if (current == 6) {
        l.setText("Que7: Which state in India is known as the 'Land of Spices'?");
        jb[0].setText("Kerala");
        jb[1].setText("Gujarat");
        jb[2].setText("West Bengal");
        jb[3].setText("Karnataka");
    } else if (current == 7) {
        l.setText("Que8: What is the national flower of India?");
        jb[0].setText("Rose");
        jb[1].setText("Lotus");
        jb[2].setText("Sunflower");
        jb[3].setText("Tulip");
    } else if (current == 8) {
        l.setText("Que9: Which Indian city is known as the 'Pink City'?");
        jb[0].setText("Jaipur");
        jb[1].setText("Agra");
        jb[2].setText("Varanasi");
        jb[3].setText("Mysore");
    } else if (current == 9) {
        l.setText("Que10: Who was the first Prime Minister of India?");
        jb[0].setText("Indira Gandhi");
        jb[1].setText("Rajiv Gandhi");
        jb[2].setText("Jawaharlal Nehru");
        jb[3].setText("Mahatma Gandhi");
        else if (current == 10) {
        l.setText("Que8: Who was the first female Prime Minister of India?");
        jb[0].setText("Indira Gandhi");
        jb[1].setText("Sonia Gandhi");
        jb[2].setText("Pratibha Patil");
        jb[3].setText("Sushma Swaraj");
    }
        l.setBounds(30,40,450,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);  
    }  
    boolean check()  
    {  
        if(current==0)  
            return(jb[1].isSelected());  
        if(current==1)  
            return(jb[1].isSelected());  
        if(current==2)  
            return(jb[2].isSelected());  
        if(current==3)  
            return(jb[0].isSelected());  
        if(current==4)  
            return(jb[2].isSelected());  
        if(current==5)  
            return(jb[3].isSelected());  
        if(current==6)  
            return(jb[1].isSelected());  
        if(current==7)  
            return(jb[3].isSelected());  
        if(current==8)  
            return(jb[2].isSelected());  
        if(current==9)  
            return(jb[2].isSelected());  
        return false;  
    }    
} 
class OnlineExamination 
{  
    public static void main(String args[])  
    {  
        try  
        {  
            login form = new login();  
            form.setSize(400,150);  
            form.setVisible(true);  
        }  
        catch(Exception e)  
        {     
            JOptionPane.showMessageDialog(null, e.getMessage());  
        }  
    }  
} 