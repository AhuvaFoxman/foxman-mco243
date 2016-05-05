package foxman.deadlock;

public class Philosopher extends Thread {

	private Fork f1;
	private Fork f2;
	private String name;

	public Philosopher(String name, Fork f1, Fork f2) {
		this.name = name;
		this.f1 = f1;
		this.f2 = f2;

	}

	public void run() {

		while (true) {
			think();
			eat();
		}
	}

	public void eat() {
		synchronized (f1) {
			synchronized (f2) {
				waitAFewSeconds(10);
			}
		}
	}

	public void think() {
		waitAFewSeconds(10);
	}

	public void waitAFewSeconds(int sec) {
		try {
			Thread.sleep((long) (sec * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
