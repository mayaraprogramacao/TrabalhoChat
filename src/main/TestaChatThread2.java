package main;

public class TestaChatThread2 {
	public static void main(String[] args) throws InterruptedException {
		ServidorThread s2 = new ServidorThread();
		s2.setPorta(9001);
		Thread ts2 = new Thread(s2);
		ts2.start();
		
		Thread.sleep(5000);
		
		ClienteThread c1 = new ClienteThread();
		c1.setEndereco("127.0.0.1");
		c1.setPorta(9000);
		Thread t1 = new Thread(c1);
		t1.start();

	}
}