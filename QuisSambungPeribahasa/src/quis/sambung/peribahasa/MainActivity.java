package quis.sambung.peribahasa;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends ActionBarActivity {
	private DB_Function aksesDB;
	private DialogBox tampilkan;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		aksesDB = new DB_Function(this);
		tampilkan = new DialogBox();
		try{
			aksesDB.createDataBase();
		}catch(Exception e){
			tampilkan.dialoBoxOKbutton(e.toString(), this);
		}
		try{
			aksesDB.openDataBase();
		}catch(Exception e){
			tampilkan.dialoBoxOKbutton(e.toString(), this);
		}
		setGambaronClick();
	}
	
	private void setGambaronClick(){
		ImageButton gambar = (ImageButton)findViewById(R.id.imageButton1);
		gambar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(v.getContext(),MenuQuis.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
