import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


class okno extends JFrame{
	
	private JTextArea text;
	private JLabel lab;
	double p1,p2;
	
	int oper;
	private void btnClick(JButton btn) {
		String str=btn.getText();
		if(str=="Exit") {
			System.exit(0);
		}
		else if(str=="C") {
  text.setText("");
  p1=p2=0;
		}			
		else if (str=="=") {
			p2=Integer.parseInt(text.getText());
			if(oper==1) {
				text.setText(""+(p1+p2));
			}
			if(oper==2) {
				text.setText(""+(p1-p2));
			}
			if(oper==3) {
				text.setText(""+(p1*p2));
			}
			if(oper==4) {
				text.setText(""+(p1/p2));
			}	
			if(oper==5) {
				text.setText(""+Math.sqrt(p1));
				p2=0;
			}		
			
			
		}
		else if(str=="+") {
			oper=1;
			p1=Double.parseDouble(text.getText());
			text.setText("");
		}
		else if(str=="-") {
			oper=2;
			p1=Double.parseDouble(text.getText());
			text.setText("");
		}
		else if(str=="*") {
			oper=3;
			p1=Double.parseDouble(text.getText());
			text.setText("");
		}
		else if(str=="/") {
			oper=4;
			p1=Double.parseDouble(text.getText());
			text.setText("");
		}
		else if(str=="sqrt") {
			oper=5;
			p1=Double.parseDouble(text.getText());
			text.setText("");
		}
		else {
			text.setText(""+ text.getText()+str);
		}
		
	}
	public okno() {
		panel pan=new panel();
		Container con=getContentPane();
		pan.setLayout(null);
		Font btnFont=new Font("serif",0,20);
		Font labFont=new Font("serif",1,30);
		Font textFont=new Font("serif",2,30);
		JButton[]btn=new JButton[18];
		for (int i=0;i<18;i++) {
		btn[i]=new JButton();
		btn[i].setSize(100,25);
		btn[i].setFont(btnFont);
		btn[i].setLocation(30,i*33);
		btn[i].setForeground(new Color(i*15,100,i));
        btn[i].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			btnClick((JButton)e.getSource());
			}
		});
        pan.add(btn[i]);
		}
		for (int i=0;i<10;i++) {
			btn[i].setText(""+i);
		}
		btn[10].setText("+");
		btn[11].setText("-");
		btn[12].setText("/");
		btn[13].setText("*");
		btn[14].setText("=");
		btn[15].setText("C");
		btn[16].setText("Exit");
		btn[17].setText("sqrt");
		
		text=new JTextArea();
		text.setFont(textFont);
		text.setBounds(150,50,300,35);
		text.setForeground(new Color(0,0,100));
		text.setBackground(Color.white);
		pan.add(text);
		JLabel lab=new JLabel("Результат");
		lab.setFont(labFont);
		lab.setBounds(150,0,300,50);
		lab.setForeground(Color.black);
		pan.add(lab);
		
		con.add(pan);
		setTitle("Калькунатор 2000");
		setBounds(40,40,500,700);
		setVisible(true);
	}
}
class panel extends JPanel{
	public panel() {
		
	}
}
public class pr1 {

	public static void main(String[] args) {
	okno win=new okno();

	}

}
