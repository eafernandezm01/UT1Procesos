package es.iesdonosocortes.dam.psp;

import java.io.IOException;

public class Procesos2Paralelos {
	public static void main(String[] args) {
		System.out.println("PID main:" +ProcessHandle.current().pid());
		try {
			long inicio = System.currentTimeMillis();
		
			ProcessBuilder pb = new ProcessBuilder("sleep", "5");
			Process p1 = pb.start();
			System.out.println("Arrancado p1. PID: "+ p1.pid());
			
			ProcessBuilder pb2 = new ProcessBuilder("sleep", "3");
			Process p2 = pb2.start();
			System.out.println("Arrancado p2. PID: "+ p2.pid());
			
			p1.waitFor();
			p2.waitFor();
			
			System.out.println("Tiempo: " + ((System.currentTimeMillis() - inicio) / 1000) + " segundos");
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
