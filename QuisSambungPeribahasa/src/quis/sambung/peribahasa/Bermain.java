package quis.sambung.peribahasa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Bermain extends Activity {
	private DB_Function aksesDB;
	ImageButton levelsatu;
	ImageButton leveldua;
	ImageButton leveltiga;
	ImageButton levelempat;
	ImageButton levellima;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_level);
		aksesDB = new DB_Function(this);
		levelsatu = (ImageButton)findViewById(R.id.imageButton1);
		leveldua = (ImageButton)findViewById(R.id.imageButton2);
		leveltiga = (ImageButton)findViewById(R.id.imageButton3);
		levelempat = (ImageButton)findViewById(R.id.imageButton4);
		levellima = (ImageButton)findViewById(R.id.imageButton5);
		levelonClick(levelsatu,"levelsatu");
		levelonClick(leveldua,"leveldua");
		levelonClick(leveltiga,"leveltiga");
		levelonClick(levelempat,"levelempat");
		levelonClick(levellima,"levellima");
	}
	
	@Override
	protected void onStart(){
		super.onStart();
		setButtonLevel();
	}
	
	@Override
	protected void onResume(){
		super.onResume();
		setButtonLevel();
	}
	
	private void getLevel(ImageButton level){
		if(aksesDB.resultSet.getString(1).toString().equalsIgnoreCase("false")){
			level.setEnabled(false);
		}else{
			level.setEnabled(true);
		}
	}
	
	private void setButtonLevel(){
		aksesDB.ambilData("select * from level where _id>1");
		while(aksesDB.resultSet.moveToNext()){
			switch(aksesDB.resultSet.getInt(0)){
			case 2:
				getLevel(leveldua);
				break;
			case 3:
				getLevel(leveltiga);
				break;
			case 4:
				getLevel(levelempat);
				break;
			case 5:
				getLevel(levellima);
				break;
			}
		}
	}
	
	private void levelonClick(ImageButton level, final String lv){
		level.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(v.getContext(),Soal.class);
				intent.putExtra("level", lv);
				startActivity(intent);
			}
		});
	}
}
