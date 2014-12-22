package quis.sambung.peribahasa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class Soal extends Activity {
	private DB_Function aksesDB;
	private ImageButton satu, dua, tiga, empat, lima, enam, tujuh, delapan, sembilan, sepuluh, sebelas, duabelas, tigabelas, empatbelas, limabelas, enambelas, tujuhbelas, delapanbelas, sembilanbelas, duapuluh;
	private Intent inten;
	private String level;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_soal);
		aksesDB = new DB_Function(this);
		inten = this.getIntent();
		level = inten.getStringExtra("level");
		satu = (ImageButton)findViewById(R.id.imageButton1); 
		dua = (ImageButton)findViewById(R.id.imageButton2);
		tiga = (ImageButton)findViewById(R.id.imageButton3);
		empat = (ImageButton)findViewById(R.id.imageButton4);
		lima = (ImageButton)findViewById(R.id.imageButton5);
		enam = (ImageButton)findViewById(R.id.imageButton6);
		tujuh = (ImageButton)findViewById(R.id.imageButton7);
		delapan = (ImageButton)findViewById(R.id.imageButton8);
		sembilan = (ImageButton)findViewById(R.id.imageButton9);
		sepuluh = (ImageButton)findViewById(R.id.imageButton10);
		sebelas = (ImageButton)findViewById(R.id.imageButton11);
		duabelas = (ImageButton)findViewById(R.id.imageButton12);
		tigabelas = (ImageButton)findViewById(R.id.imageButton13);
		empatbelas = (ImageButton)findViewById(R.id.imageButton14);
		limabelas = (ImageButton)findViewById(R.id.imageButton15);
		enambelas = (ImageButton)findViewById(R.id.imageButton16);
		tujuhbelas = (ImageButton)findViewById(R.id.imageButton17);
		delapanbelas = (ImageButton)findViewById(R.id.imageButton18);
		sembilanbelas = (ImageButton)findViewById(R.id.imageButton19);
		duapuluh = (ImageButton)findViewById(R.id.imageButton20);
		nomoronClick(satu, "1");
		nomoronClick(dua, "2");
		nomoronClick(tiga, "3");
		nomoronClick(empat, "4");
		nomoronClick(lima, "5");
		nomoronClick(enam, "6");
		nomoronClick(tujuh, "7");
		nomoronClick(delapan, "8");
		nomoronClick(sembilan, "9");
		nomoronClick(sepuluh, "10");
		nomoronClick(sebelas, "11");
		nomoronClick(duabelas, "12");
		nomoronClick(tigabelas, "13");
		nomoronClick(empatbelas, "14");
		nomoronClick(limabelas, "15");
		nomoronClick(enambelas, "16");
		nomoronClick(tujuhbelas, "17");
		nomoronClick(delapanbelas, "18");
		nomoronClick(sembilanbelas, "19");
		nomoronClick(duapuluh, "20");
	}
	
	@Override
	protected void onStart(){
		super.onStart();
		setButtonNomor();
	}
	
	@Override
	protected void onResume(){
		super.onResume();
		setButtonNomor();
	}
	
	
	private void getNomor(ImageButton nomor){
		if(aksesDB.resultSet.getString(3).toString().equalsIgnoreCase("false")){
			nomor.setEnabled(false);
		}else{
			nomor.setEnabled(true);
		}
	}
	
	private void setButtonNomor(){
		aksesDB.ambilData("select * from "+level);
		while(aksesDB.resultSet.moveToNext()){
			switch(aksesDB.resultSet.getInt(0)){
			case 1:
				getNomor(dua);
				break;
			case 2:
				getNomor(tiga);
				break;
			case 3:
				getNomor(empat);
				break;
			case 4:
				getNomor(lima);
				break;
			case 5:
				getNomor(enam);
				break;
			case 6:
				getNomor(tujuh);
				break;
			case 7:
				getNomor(delapan);
			case 8:
				getNomor(sembilan);
				break;
			case 9:
				getNomor(sepuluh);
				break;
			case 10:
				getNomor(sebelas);
				break;
			case 11:
				getNomor(duabelas);
				break;
			case 12:
				getNomor(tigabelas);
				break;
			case 13:
				getNomor(empatbelas);
				break;
			case 14:
				getNomor(limabelas);
				break;
			case 15:
				getNomor(enambelas);
				break;
			case 16:
				getNomor(tujuhbelas);
				break;
			case 17:
				getNomor(delapanbelas);
				break;
			case 18:
				getNomor(sembilanbelas);
				break;
			case 19:
				getNomor(duapuluh);
				break;
			}
		}
	}
	private void nomoronClick(ImageButton Nomor,final String no){
		Nomor.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent soalQuis = new Intent(v.getContext(),SoalQuis.class);
				soalQuis.putExtra("level", level);
				soalQuis.putExtra("nomor", no);
				startActivity(soalQuis);
			}
		});
	}
	
}
