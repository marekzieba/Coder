package pl.javastart;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.lang.reflect.Method;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javafx.event.ActionEvent;

public class FrameClass extends JFrame {
private JLabel labelName=new JLabel("Name");
private JLabel labelNumeber=new JLabel("Number");
private JTextField nameField=new JTextField();
private JTextField numberField=new JTextField();
private JButton button=new JButton();
public FrameClass() {
	setLayout(new GridLayout());
	add(labelName);
	add(nameField);
	add(labelNumeber);
	add(numberField);
	add(button);
	button.addActionListener(event->runClass(nameField.getText(),numberField.getText()));
	pack();
}
public void runClass(String text,String number)
{
	ClassLoader loader=new CoderClassLoader(Integer.parseInt(number));
		Class<?> class1;
		try {
			class1 = loader.loadClass(text);
			Method method=class1.getMethod("main", String[].class);
			method.invoke(null, (Object) new String[]{});
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

}
}
