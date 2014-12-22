package quis.sambung.peribahasa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Jawaban extends Activity{
	private DB_Function aksesDB;
	private Intent inten;
	private TextView jawaban;
	private Button lanjut;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jawaban);
		aksesDB = new DB_Function(this);
		inten = this.getIntent();
		jawaban = (TextView)findViewById(R.id.textView1);
		Intent inten = this.getIntent();
        jawaban.setText(inten.getStringExtra("nomor"));
		setJawaban();
		setCekButton();
		}
	
	private void setCekButton() {
		lanjut=(Button)findViewById(R.id.button1);
		lanjut.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(Jawaban.this, SoalQuis.class);
				startActivity(i);
			}
		});
		
	}
		
				
	
	private void setJawaban() {
		aksesDB.ambilData("select arti from levelsatu where _id=1");
		jawaban.setText(inten.getStringExtra("arti"));
		
	}
}
