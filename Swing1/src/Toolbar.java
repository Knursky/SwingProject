import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener {
	
	private JButton permamentButton;
	private JButton contracotrButton;
	
	
	private StringListener textListener;
	//Konstruktor toolbaru
public Toolbar() {
	setBorder(BorderFactory.createEtchedBorder());
	permamentButton = new JButton("Permament");
	contracotrButton = new JButton("Contractor");
	
	permamentButton.addActionListener(this);
	contracotrButton.addActionListener(this);
	
	setLayout(new FlowLayout(FlowLayout.LEFT));
	
	add(permamentButton);
	add(contracotrButton);
	
	
}
public void setStringListener(StringListener listener) {
	this.textListener = listener;
	
}
@Override
public void actionPerformed(ActionEvent e) {
	JButton clicked = (JButton)e.getSource();
	
	if(clicked == permamentButton) {
		//toolbar nie wie o tym co sie znajduje w text area, jedynie referencja do Stringlistener
		if(textListener !=null) {
			//gdy naciskamy przycisk toolbar wywoluje metode textEmitted ktora tak naprawde jest anonimowa klasa z MainFrame
			textListener.textEmitted("Permement ");
			
		}
		//textPanel.appendText("Hello\n");
		
	}
	else if(clicked == contracotrButton)
		if(textListener !=null) {
			textListener.textEmitted("Contractor ");
			
		//textPanel.appendText("Goodbye\n");
}
}}

