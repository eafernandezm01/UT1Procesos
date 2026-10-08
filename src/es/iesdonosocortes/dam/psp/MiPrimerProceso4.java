package es.iesdonosocortes.dam.psp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MiPrimerProceso4 {

	public static void main(String[] args) {
		lsConParametrosSalida();
	}

	private static void lsConParametrosSalida() {
		System.out.println(ProcessHandle.current().pid());

		try {
			ProcessBuilder pb = new ProcessBuilder("ls", "-l", "/home");
			Process p = pb.start();
			System.out.println("PID proceso ls: " + p.pid());

			InputStreamReader isr = new InputStreamReader(p.getInputStream());
			BufferedReader br = new BufferedReader(isr);

			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {

		}
	}
}
