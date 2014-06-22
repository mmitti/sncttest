package jp.chappy.yondaime;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class ImageActivity extends Activity implements OnClickListener{
	int count = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image);

		ImageButton button = (ImageButton)findViewById(R.id.imageButton1);
		button.setOnClickListener(this);
	}

	public void onClick(View v){
		if(v.getId() == R.id.imageButton1){
			ImageButton button = (ImageButton)v;
			switch(count){
			case 0:button.setImageResource(R.drawable.img_7g569d_down);break;
			case 1:button.setImageResource(R.drawable.img_7g569d_left);break;
			case 2:button.setImageResource(R.drawable.img_7g569d_right);break;
			case 3:button.setImageResource(R.drawable.img_7g569d_up);break;
			}
			count++;
			if(count == 4){
				TextView text = (TextView)findViewById(R.id.hint1);
				text.setText("0で割れ");
			}
			if(count == 5)finish();
		}
	}
}