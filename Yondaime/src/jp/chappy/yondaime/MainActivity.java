package jp.chappy.yondaime;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button[] button = new Button[6];
		button[0] = (Button)findViewById(R.id.button5);
		button[1] = (Button)findViewById(R.id.button_end);
		button[2] = (Button)findViewById(R.id.button2);
		button[3] = (Button)findViewById(R.id.button3);
		button[4] = (Button)findViewById(R.id.button4);
		button[5] = (Button)findViewById(R.id.button6);
		for(int i = 0; i < 6; i ++)button[i].setOnClickListener(this);
	}

	public void onClick(View v){
		switch(v.getId()){
		case R.id.button_end:calc(1);break;
		case R.id.button2:calc(2);break;
		case R.id.button3:calc(3);break;
		case R.id.button4:calc(4);break;
		case R.id.button5:{
			Intent intent = new  Intent(MainActivity.this, ImageActivity.class);
			startActivity(intent);
		};break;
		case R.id.button6:{
			Intent intent = new  Intent(MainActivity.this, VideoActivity.class);
			startActivity(intent);
		};break;
		}
	}

	void calc(int num){
		EditText edittext1;	EditText edittext2;
		edittext1 = (EditText)findViewById(R.id.editText1);
		edittext2 = (EditText)findViewById(R.id.editText2);
		String str1 = edittext1.getText().toString();
		String str2 = edittext2.getText().toString();


		int num1 = 0;
		int num2 = 0;
		
		try{
			num1 = Integer.parseInt(str1);
			num2 = Integer.parseInt(str2);
		}catch(NumberFormatException e){
			Toast.makeText(this, "Input Numbers!", Toast.LENGTH_SHORT).show();			
			return ;
		}
		if(num2 == 0&& num == 4){
			Toast.makeText(this, "0除算すると死ぬ", Toast.LENGTH_SHORT).show();
			return;
		}
		
		int ans = 0;
		if(num1 == 114 && num2 == 514 && num == 1){
			CallAlert();
			return;
		}
		switch(num){
		case 1:ans = num1 + num2; break;
		case 2:ans = num1 - num2; break;
		case 3:ans = num1 * num2; break;
		case 4:ans = num1 / num2; break;
		}
		Toast.makeText(this, String.valueOf(ans), Toast.LENGTH_SHORT).show();
	}
	
	public void CallAlert(){
		AlertDialog.Builder alertDlg = new AlertDialog.Builder(this);
        //alertDlg.setTitle("ダイアロタイトル");
        alertDlg.setMessage("ハッテンしますか？");
        alertDlg.setPositiveButton(
            "する",
            new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                	Uri uri = Uri.parse("http://bakusai.com/thr_res/acode=5/ctgid=149/bid=1742/tid=1602013/");
                		Intent i = new Intent(Intent.ACTION_VIEW,uri);
                		startActivity(i);
                }
            });
        alertDlg.setNegativeButton(
            "しない",
            new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    CallAlert();
                }
            });

        // 表示
        alertDlg.create().show();
	}
}
