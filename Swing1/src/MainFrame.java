import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	private TextPanel textPanel;
	private Toolbar toolbar;
	private FormPanel formPanel;
	
	public MainFrame() {
		super("Hello World");
	
		setLayout(new BorderLayout());
		
		
	//kontroler ktory monitoruje ponizsze i przekazuje innym komponentom co robic gdy pokaze sie wiadomosc
		toolbar = new Toolbar();
		textPanel = new TextPanel();
		formPanel = new FormPanel();
		//Komponent listener ktory dziala i interpretuje gdy toolbar wykrywa wywolywanie metod z toolbar
		toolbar.setStringListener(new StringListener() {
			
			//anonimowa klasa  wywolujaca textpanel i przypisujaca mozliwosc wpisywania w niego textu
			public void textEmitted(String text) {
				textPanel.appendText(text);
			}
		});
//klasa pobiera z formevent dane i wstawia do panelu z tekstem, form event przechowuje name i occupation dzieki swing eventobject class
		formPanel.setFormListener(new FormListener() {
			public void formEventOccurred(FormEvent e) {
				String name = e.getName();
				String occupation = e.getOccupation();
				
				textPanel.appendText(name + ": " + occupation +"\n");
			}
		});
		
	
		add(formPanel, BorderLayout.WEST);
		add(toolbar, BorderLayout.NORTH);
		add(textPanel, BorderLayout.CENTER);

	
	
	
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
}
}