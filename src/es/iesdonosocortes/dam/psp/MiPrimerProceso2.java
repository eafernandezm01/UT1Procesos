package es.iesdonosocortes.dam.psp;

import java.io.IOException;

public class MiPrimerProceso2 {

	public static void main(String[] args) {
		lsConParametros();
	}

	private static void lsConParametros() {
		System.out.println(ProcessHandle.current().pid());

		try {
			ProcessBuilder pb = new ProcessBuilder("ls", "-l", "/home");
			Process p = pb.start();
			System.out.println("PID proceso ls: " + p.pid());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
