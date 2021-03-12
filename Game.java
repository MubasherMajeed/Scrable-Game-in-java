/**
 * @(#)Game.java
 *
 *
 * @author 
 * @version 1.00 2019/5/28
 */

import java.awt.*;
import java.awt.event.*;
import  java.applet.*;
import javax.swing.*;

public class Game extends Applet implements ActionListener {
    
    /** Initialization method that will be called after the applet is loaded
     *  into the browser.
     */
                JButton[] btn=new JButton[16];
			JLabel lbl;
			Panel pnl = new Panel();
			Font fnt = new Font("Arial",Font.BOLD+Font.ITALIC,25);
			int count=0;
			String[] str = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",""};
    public void init() {
        // TODO start asynchronous download of heavy resources
        Featurs();
    }
    public void Featurs() {

		this.setLayout(new BorderLayout());
		pnl.setLayout(new GridLayout(4,4,10,10));
		for(int i=0;i<btn.length;i++)
		{
		 	btn[i] = new JButton(str[i]);
			pnl.add(btn[i]);
			btn[i].addActionListener(this);
			btn[i].setFont(fnt);
		}
		lbl = new JLabel("START GAME");
		lbl.setFont(fnt);
		add(pnl,BorderLayout.CENTER);
		add(lbl,BorderLayout.SOUTH);
	}
	public void actionPerformed(ActionEvent e)
	{	
		count++;
		lbl.setText("PASS: "+count);
		String s = e.getActionCommand();
		int n=Integer.parseInt(s);
		int ind=0;
		for(int c=0;c<btn.length;c++)
		{
			String check2 = btn[c].getActionCommand();
			if(check2==s)
			{
				ind =c;
				break;
			}
		}
		for(int a=0;a<btn.length;a++)
		{
			String check= btn[a].getActionCommand();
			if(check=="")
			{	
				if((a == ind+1)||(a==ind-1)||(a-4==ind)||(a+4==ind))
				{
					
					btn[a].setText(s);
					btn[ind].setText("");
					break;
				}
			}
		}

    }
   
}