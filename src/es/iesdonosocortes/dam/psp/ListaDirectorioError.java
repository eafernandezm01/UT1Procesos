package es.iesdonosocortes.dam.psp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ListaDirectorioError {

	public static void main(String[] args) {
		System.out.println("PID main:" +ProcessHandle.current().pid());
		BufferedReader br = null;
		try {
			ProcessBuilder pb = new ProcessBuilder("ls", "-l", "/directorioQueMeInvento");
			Process p = pb.start();
			System.out.println("PID proceso ls: " + p.pid());

			InputStreamReader isr = new InputStreamReader(p.getErrorStream());
			br = new BufferedReader(isr);

			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
