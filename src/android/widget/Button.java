package android.widget;

public class Button {
	public Button() {
		System.out.println(getClass().getName() +  ": Creando boton");
	}

	public void onClick() {
		System.out.println(getClass().getName() + ": Clickeando boton");
	}
}
