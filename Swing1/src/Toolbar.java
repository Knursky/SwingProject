import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener {
	
	private JButton helloButton;
	private JButton goodbyeButton;
	
	
	private StringListener textListener;
	
public Toolbar() {
	helloButton = new JButton("Hello");
	goodbyeButton = new JButton("Goodbye");
	
	helloButton.addActionListener(this);
	goodbyeButton.addActionListener(this);
	
	setLayout(new FlowLayout(FlowLayout.LEFT));
	
	add(helloButton);
	add(goodbyeButton);
	
	
}
public void setStringListener(StringListener listener) {
	this.textListener = listener;
	
}
@Override
public void actionPerformed(ActionEvent e) {
	JButton clicked = (JButton)e.getSource();
	
	if(clicked == helloButton) {
		//toolbar nie wie o tym co sie znajduje w text area, jedynie referencja do Stringlistener
		if(textListener !=null) {
			//gdy naciskamy przycisk toolbar wywoluje metode textEmitted ktora tak naprawde jest anonimowa klasa z MainFrame
			textListener.textEmitted("Hello\n");
			
		}
		//textPanel.appendText("Hello\n");
		
	}
	else if(clicked == goodbyeButton)
		if(textListener !=null) {
			textListener.textEmitted("Goodbye\n");
			
		//textPanel.appendText("Goodbye\n");
}
}}

