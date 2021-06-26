package main;

public class TestaChatThread1 {
	public static void main(String[] args) throws InterruptedException {
		ServidorThread s1 = new ServidorThread();
		s1.setPorta(9000);
		Thread ts1 = new Thread(s1);
		ts1.start();
		
		Thread.sleep(5000);
		
		ClienteThread c2 = new ClienteThread();
		c2.setEndereco("127.0.0.1");
		c2.setPorta(9001);
		Thread t2 = new Thread(c2);
		t2.start();

	}
}