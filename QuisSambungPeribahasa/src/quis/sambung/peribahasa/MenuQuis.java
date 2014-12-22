package quis.sambung.peribahasa;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MenuQuis extends Activity {
	DialogBox tampilkan;
	Context konteks;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		konteks = this;
		tampilkan = new DialogBox();
		setBermain();
		setPengaturan();
		setTentang();
		}
	private void setBermain(){
		ImageButton bermain = (ImageButton)findViewById(R.id.imageButton1);
		bermain.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(v.getContext(),Bermain.class);
				startActivity(intent);
			}
		});
	}
	
	private void setPengaturan(){
		ImageButton pengaturan = (ImageButton)findViewById(R.id.imageButton2);
		pengaturan.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(v.getContext(),Pengaturan.class);
				startActivity(intent);
			}
		});
	}
	private void setTentang(){
		ImageButton Tentang = (ImageButton)findViewById(R.id.imageButton3);
		Tentang.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(v.getContext(),Tentang.class);
				startActivity(intent);
			}
		});
	}
	
	@Override
	public void onBackPressed() {
	    tampilkan.dialogBoxYaTidak("Apakah anda ingin keluar dari permainan ini?", konteks);
	    tampilkan.dialogBox.setOnDismissListener(new DialogInterface.OnDismissListener() {
			
			@Override
			public void onDismiss(DialogInterface dialog) {
				// TODO Auto-generated method stub
				if(tampilkan.keputusan){
					System.exit(1);
				}
			}
		});
	}
}
