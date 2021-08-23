package android.CameraDemo;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.*;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import helpers.ErrorObjeto;

import java.util.Random;

public class CameraDemo extends Activity {
	Camera camera;
	Button buttonClick;
	ShutterCallback shutterCallback;
	PictureCallback rawCallback;
	PictureCallback jpegCallback;
	static int instanceCount = 1;

	public CameraDemo(int cId) throws ErrorObjeto {
		if (instanceCount == 3)
			throw new ErrorObjeto("Excepcion en: " + this.getClass().getName());
		camera = new Camera(cId);
		instanceCount++;
		onStart();
	}

	public Camera getCamera() { return camera; }

	protected void onCreate (Bundle savedInstanceState) {}
	protected void onStart() {
		System.out.println(this.getClass().getName() + ": Inicializando Camara");
	}
	protected void onStop() {}
	protected void onResume() {}
	protected void onPause() {}
	protected void onDestroy() {}
	public Boolean onCreateOptionsMenu(Menu menu) { return new Random().nextBoolean(); }
	public Boolean onOptionsItemSelected(MenuItem MenuItem) { return new Random().nextBoolean(); }
}
