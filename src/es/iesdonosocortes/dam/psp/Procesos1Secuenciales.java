package es.iesdonosocortes.dam.psp;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Procesos1Secuenciales {
	public static void main(String[] args) {
		System.out.println("PID main:" + ProcessHandle.current().pid());
		try {
			ProcessBuilder pb = new ProcessBuilder("sleep", "3");
			Process p1 = pb.start();
			System.out.println("Arrancado p1. PID: " + p1.pid());

			System.out.println("El main sigue ejecutando hasta que se encuentra con el waitFor");
			
			p1.waitFor();

			System.out.println("Esto no se pinta hasta que termine P1. ¿Está vivo el hijo?: " + p1.isAlive());
			
			
			
			System.out.println("\n\n\n");
			
			pb = new ProcessBuilder("sleep", "10");
			Process p2 = pb.start();
			System.out.println("Arrancado p2. PID: " + p2.pid());
			
			boolean terminado = p1.waitFor(3, TimeUnit.SECONDS);

			System.out.println("Como le he dicho que solo espero 3 segundos, si el proceso hijo es un tardón yo no espero, ¿está vivo el proceso 2? " + p2.isAlive());

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
