package test.chappy.jp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
		//コメント　bymmitti
		//一応解説を付けてみましたがわかりにくいと思います。
		//わかりにくい、分からない、疑問点は早めに知らせてください
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		//演算用ボタン
		Button[] button = new Button[5];
		button[0] = (Button)this.findViewById(R.id.button0);
		button[1] = (Button)this.findViewById(R.id.button1);
		button[2] = (Button)this.findViewById(R.id.button2);
		button[3] = (Button)this.findViewById(R.id.button3);
		button[4] = (Button)this.findViewById(R.id.button4);
		
		button[0].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,ImageActivity.class);
				startActivity(intent);
			}
		});
		
		button[1].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				calc(1);
			}
		});
		button[2].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				calc(2);
			}
		});
		button[3].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				calc(3);
			}
		});
		button[4].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				calc(4);
			}
		});
	}
	
	void calc(int ope){
		//数値入力フォーム
		final EditText[] edit = new EditText[3];
		edit[1] = (EditText)this.findViewById(R.id.editText1);
		edit[2] = (EditText)this.findViewById(R.id.editText2);
		String str1 = edit[1].getText().toString();
		String str2 = edit[2].getText().toString();
		int ans = 0;
		switch(ope){
		case 1:
			ans = Integer.parseInt(str1) + Integer.parseInt(str2);break;
		case 2:
			ans = Integer.parseInt(str1) - Integer.parseInt(str2);break;
		case 3:
			ans = Integer.parseInt(str1) * Integer.parseInt(str2);break;
		case 4:
			ans = Integer.parseInt(str1) / Integer.parseInt(str2);break;
			
		}
		Toast.makeText(MainActivity.this, String.valueOf(ans), Toast.LENGTH_LONG).show();
	}
}


		
//ActivityではViewを検索することができます
//IDはXMLで定義したものと同じ名前のものが自動生成されますのでそれを利用します
//なお、レイアウトで@+id/button3の+は新規作成の意味です。
		
		/*Button but = (Button)this.findViewById(R.id.button3);
		but.setText("ハズレ");
		
		but.setOnClickListener(new OnClickListener() {
//これは無名クラス　内部クラスと呼ばれるものです
//本来クラス名が必要ですがクラス名なしにその場で定義して渡すことができます

			@Override
			public void onClick(View v) {
				((Button)v).setText("アタリ");
				Toast.makeText(MainActivity.this, "テスト", Toast.LENGTH_LONG).show();
//このThisはちょっとややこしいですがthisそのものはThisポインターと同じものです
//しかし、ここでThisを使うとこのクラス　つまりOnClickListerを継承した無名のクラスを指してしまいます。
//その外側のThis特別するためMainActivity.thisを使います
			}
		});

//上のコードは下のコードと同じ意味です(class MyClickは下を参照
		OnClickListener ocl = new MyClick();
		but.setOnClickListener(ocl);


	}
	
	class MyClick implements OnClickListener{
//implementsはインターフェースを実装するという意味です。イメージとしては継承しているみたいなものです

		@Override
		public void onClick(View v) {
			//ボタンが押された時の処理
		}
		
	}*/
