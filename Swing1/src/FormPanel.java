import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel{
	//labels
	private JLabel nameLabel;
	private JLabel occupationLabel;
	private JTextField nameField;
	private JTextField occupationField;
	private JButton okBtn;
	private FormListener formListener;
	
	
	
	//konstruktor
	public FormPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
		
		nameLabel = new JLabel("Name: ");
		occupationLabel = new JLabel("Occupation: ");
		nameField = new JTextField(10); 
		occupationField = new JTextField(10);
		
		okBtn = new JButton("OK");
		
		//action listener guzik , kopia do glownego okna addaction listener> klasa odpala actionperformed ktory uruchamia action event ktory przesyla informacje z kotrolera (okButton) do listening class (anonimowe ponizej) 
		okBtn.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String occupation = occupationField.getText();
				
				FormEvent ev = new FormEvent(this, name, occupation);
				
				if(formListener != null) {
					formListener.formEventOccurred(ev);
				}
				
				
				
			}
			
		});
		
		Border innerBorder = BorderFactory.createTitledBorder("Add Person");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints	gc = new GridBagConstraints();
		//Ustawienie wielkosci komorek w gridzie  w x, y
		gc.gridx = 0;
		gc.gridy = 0;
		//ustawienie ile miejsca zajmie w relacji do innych komorek znaczenie ma nie wielkosc liczby a jej porownanie do liczby przypisanej do innych komponentow
	//	gc.weightx = 1;
		//gc.weighty = 1;
		
		
		////Pierwszy rzad
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		
		add(nameLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(nameField, gc);
		
		//Drugi rzad
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.gridy = 1;
		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.LINE_END;
		add(occupationLabel, gc);
		
		gc.gridy = 1;
		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(occupationField, gc);
		
		/////trzeci rzad
		gc.weightx = 1;
		gc.weighty = 2.0;
		gc.gridy = 2;
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(okBtn, gc);
		
		
	
	}
	public void setFormListener(FormListener listener) {
		this.formListener = listener;
	}

}
