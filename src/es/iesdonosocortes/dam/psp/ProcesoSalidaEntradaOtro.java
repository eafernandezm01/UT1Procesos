package es.iesdonosocortes.dam.psp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ProcesoSalidaEntradaOtro {
	public static void main(String[] args) {
		try {
			Process p1 = new ProcessBuilder("ls", "src/es/iesdonosocortes/dam/psp").start();
			Process p2 = new ProcessBuilder("wc", "-l").start();

			try (
				 BufferedReader br = new BufferedReader(new InputStreamReader(p1.getInputStream()));
				 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p2.getOutputStream()))	 
			) {

				String linea;

				while ((linea = br.readLine()) != null) {
					System.out.println("Leo del proceso 1 = '" + linea + "' y se la envío al proceso 2");

					bw.write(linea);
					bw.newLine();
				}
			}
			
			p1.waitFor();
			System.out.println("P1: ¿Está vivo? " + p1.isAlive());

			try (BufferedReader br = new BufferedReader(new InputStreamReader(p2.getInputStream()))) {

				System.out.println("Total de líneas enviadas al proceso 2: " + br.readLine());
			}

			p2.waitFor();

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
