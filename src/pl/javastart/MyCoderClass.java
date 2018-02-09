package pl.javastart;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class MyCoderClass {
public static void main(String[] args) {
	EventQueue.invokeLater(()->{
		JFrame frame=new FrameClass();
		frame.setTitle("Code Program");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	});
}
}
