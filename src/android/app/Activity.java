package android.app;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Random;

public class Activity {
	protected void onCreate(Bundle state) {
		System.out.println("Activity: onCreate");
	}
	protected void onStart() {}
	protected void onStop() {}
	protected void onResume() {}
	protected void onPause() {}
	protected void onDestroy() {}
	public Boolean onCreateOptionsMenu(Menu menu) {
		return new Random().nextBoolean();
	}
	public Boolean onOptionsItemSelected(MenuItem MenuItem) {
		return new Random().nextBoolean();
	}
}
