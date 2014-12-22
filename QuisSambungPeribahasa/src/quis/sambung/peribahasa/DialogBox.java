package quis.sambung.peribahasa;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class DialogBox {
	public AlertDialog dialogBox;
	boolean keputusan;
	
	public void dialoBoxOKbutton(String pesan,Context konteks){
		dialogBox = new AlertDialog.Builder(konteks).setMessage(pesan).setNeutralButton("Oke", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		}).show();
	}
	
	public void dialogBoxYaTidak(String pesan, Context konteks){
		dialogBox = new AlertDialog.Builder(konteks).setMessage(pesan).setPositiveButton("Ya", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				keputusan = true;
			}
		}).setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				keputusan = false;
			}
		}).show();
	}
}
