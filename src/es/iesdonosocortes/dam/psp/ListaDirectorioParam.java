package es.iesdonosocortes.dam.psp;

import java.io.IOException;

public class ListaDirectorioParam {

	public static void main(String[] args) {
		System.out.println("PID main:" +ProcessHandle.current().pid());

		try {
			ProcessBuilder pb = new ProcessBuilder("ls", "-l", "/home");
			Process p = pb.start();
			System.out.println("PID proceso ls: " + p.pid());
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
