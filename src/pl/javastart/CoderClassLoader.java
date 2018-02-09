package pl.javastart;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CoderClassLoader extends ClassLoader {
	private int key;
	public CoderClassLoader(int key) {
		this.key=key;
	}
	@Override
protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] uncodeName=null;
			try {
				uncodeName = giveClass(name);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		Class<?> class1=defineClass(name,uncodeName, 0, uncodeName.length);
		if(class1==null)
			throw new ClassNotFoundException("Nie znaleziono klasy");
		return class1;
}
	public byte[] giveClass(String name) throws IOException
	{
			String cname=name.replace('.','/');
			System.out.println(cname);
			 byte[] tab=Files.readAllBytes(Paths.get(cname));
			System.out.println(tab);
			for(int i=0;i<tab.length;i++)
			{
				tab[i]=(byte)(tab[i] -key);
			}
		System.out.println(tab);
		return tab;
	}
}
