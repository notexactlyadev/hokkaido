package Main;

import android.CameraDemo.CameraDemo;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void detenerPantalla() {
		System.out.println("Presione una tecla para continuar...");
		sc.nextLine();
	}

	public static void limpiarPantalla() throws IOException, InterruptedException {
		final String osName = System.getProperty("os.name").toLowerCase();
		if (osName.contains("win"))
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                else new ProcessBuilder("sh", "-c", "clear").inheritIO().start().waitFor();
	}

	public static int obtenerInt() throws Exception {
		int opt = 0;
		try {
			opt = Integer.parseInt(sc.nextLine());
		} catch (Exception nfe) {
			limpiarPantalla();
			System.out.println("Entrada invalida, intente nuevamente...");
			detenerPantalla();
		}
		return opt;
	}

	public static void main(String[] args) throws Exception {

		ArrayList<CameraDemo> camList = new ArrayList<>();
                
		boolean shouldExit = false;
		int opt = 0;
		while (!shouldExit) {
			System.out.println("************************************************************");
			System.out.println("*      TAREA DE IMPLEMENTACION O.O. * *        Pablo Luna  *");
			System.out.println("************************************************************");
			//
			System.out.println("*  Ingrese el numero indicado para seleccionar una opcion  *");
			System.out.println("*1) Crear camara                                           *");
			System.out.println("*2) Mostrar camaras                                        *");
			System.out.println("*3) Tomar foto                                             *");
			System.out.println("*4) Salir                                                  *");
			System.out.println("************************************************************");
			System.out.print("Ingrese su eleccion: ");

			opt = obtenerInt();

			switch (opt) {
				default: {
					System.out.println("Opcion invalida, intente nuevamente...");
					detenerPantalla();
					limpiarPantalla();
					break;
				}
				case 4: {
					limpiarPantalla();
					shouldExit = true;
					break;
				}
				// Crear camara
				case 1: {
					while (true) {
						System.out.print("Ingrese el id de la Camara, o -1 para volver: ");
						int ccId = 0;
						try {
							ccId = Integer.parseInt(sc.nextLine());
							if (ccId == -1) break;
						} catch (Exception nfe) {
							limpiarPantalla();
							System.out.println("Entrada invalida, intente nuevamente...");
							detenerPantalla();
							break;
						}

						camList.add(new CameraDemo(ccId));
					}
					break;
				}

				// Mostrar Camaras
				case 2: {
					camList.forEach((KK) -> System.out.println("Camara " + KK.getCamera().getcId()));
					detenerPantalla();
					limpiarPantalla();
					break;
				}

				case 3: {
					while (true) {
						System.out.print("Ingrese el id de la Camara, o -1 para volver: ");
						int ccId = 0;
						try {
							ccId = Integer.parseInt(sc.nextLine());
							if (ccId == -1) {
								break;
							}
						} catch (Exception nfe) {
							limpiarPantalla();
							System.out.println("Entrada invalida, intente nuevamente...");
							detenerPantalla();
							break;
						}

						boolean found = false;
						try {
							for (CameraDemo elem : camList) {
								if (elem.getCamera().getcId() == ccId) {
									found = true;
									elem.getCamera().takePicture(null, null, null, null);
									break;
								} else {
									found = false;
								}
							}
							if (!found) {
								limpiarPantalla();
								System.out.println("No se encuentra la camara, intente nuevamente...");
								detenerPantalla();
							}

						} catch (Exception ex) {
							break;
						}
					}
					break;
				}
			}
		}
	}
}
