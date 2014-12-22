package quis.sambung.peribahasa;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SoalQuis extends Activity{
	private TextView nomorSoal, soal;
	private DB_Function aksesDB;
	private String peribahasa,kataHilang,arti;
	private String[] peribahasaarray;
	private Intent inten;
	private Random acak;
	private int random;
	private Button cek;
	private EditText input;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_soalquis);
		aksesDB = new DB_Function(this);
		inten = this.getIntent();
		nomorSoal = (TextView)findViewById(R.id.textView1);
		soal = (TextView)findViewById(R.id.textView2);
		input = (EditText)findViewById(R.id.editText1);
		setNomorSoal();
		setSoal();
		setCekButton();
	}
	
	private void setCekButton(){
		cek=(Button)findViewById(R.id.button1);
		cek.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(input.getText().toString().equalsIgnoreCase(kataHilang)){
					aksesDB.ambilData("select * from "+inten.getStringExtra("level")+" where _id="+inten.getStringExtra("nomor"));
					aksesDB.resultSet.moveToFirst();
					arti = aksesDB.resultSet.getString(2);
					Toast.makeText(getApplicationContext(), "Jawaban Benar", Toast.LENGTH_SHORT).show();
		            Intent i = new Intent(SoalQuis.this, Jawaban.class);
		            i.putExtra("TextView1", inten.getStringExtra("nomor"));
		            startActivity(i);
		        	
		        }
		        else {
		        	Toast.makeText(getApplicationContext(), "Jawaban Salah", Toast.LENGTH_SHORT).show();
		        	
		        }
			}
		});
	}
	
	private void setNomorSoal(){
		nomorSoal.setText(inten.getStringExtra("nomor"));
	}
	
	private void setSoal(){
		aksesDB.ambilData("select * from "+inten.getStringExtra("level")+" where _id="+inten.getStringExtra("nomor"));
		aksesDB.resultSet.moveToFirst();
		peribahasa = aksesDB.resultSet.getString(1);
		peribahasaarray = peribahasa.split(" ");
		acak = new Random();
		random = acak.nextInt(peribahasaarray.length);
		kataHilang = peribahasaarray[random];
		peribahasaarray[random] = ".....";
		soal.setText("");
		for(int a=0;a<peribahasaarray.length;a++){
			soal.setText(soal.getText()+" "+peribahasaarray[a]);
		}
	}
}
