package test.chappy.jp;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
		//コメント　bymmitti
		//一応解説を付けてみましたがわかりにくいと思います。
		//わかりにくい、分からない、疑問点は早めに知らせてください
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
//ActivityではViewを検索することができます
//IDはXMLで定義したものと同じ名前のものが自動生成されますのでそれを利用します
//なお、レイアウトで@+id/button3の+は新規作成の意味です。
		
		Button but = (Button)this.findViewById(R.id.button3);
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
/*		OnClickListener ocl = new MyClick();
		but.setOnClickListener(ocl);
*/

	}
	
	class MyClick implements OnClickListener{
//implementsはインターフェースを実装するという意味です。イメージとしては継承しているみたいなものです

		@Override
		public void onClick(View v) {
			//ボタンが押された時の処理
		}
		
	}


}
