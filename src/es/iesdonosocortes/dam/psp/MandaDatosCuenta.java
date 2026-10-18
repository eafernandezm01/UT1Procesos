package es.iesdonosocortes.dam.psp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MandaDatosCuenta {
	public static void main(String[] args) {
		System.out.println("PID main:" +ProcessHandle.current().pid());
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			ProcessBuilder pb = new ProcessBuilder("wc", "-l");
			Process p = pb.start();
			bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));

			bw.write("Hola desde Java");
			bw.newLine();
			bw.write("Soy Eva");
			bw.newLine();
			
			bw.close(); // Lo cierra para indicar que ya no le va a mandar más datos.

			br = new BufferedReader(new InputStreamReader(p.getInputStream()));

			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println("Total de líneas: " + linea);
			}

			p.waitFor();

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (bw != null)
					bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
