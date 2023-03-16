package tap_2023_1.robot;

import java.awt.Robot;

public class Robo {
	public static void main(String[] args) throws Exception {
		Robot r = new Robot();
		for (int i = 0; i < 10; i++) {
			int x = (int) Math.random() * 1024;
			int y = (int) Math.random() * 768;
			r.mouseMove(x, y);
			r.delay(1000);
		}
	}
}
