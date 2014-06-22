package jp.chappy.yondaime;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

public class VideoActivity extends Activity implements OnClickListener {
	VideoView video;
	int count = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video);

		video = (VideoView)findViewById(R.id.videoView1);
		video.setVideoURI(Uri.parse("android.resource://" + this.getPackageName() + "/" + R.raw.pika));
		video.start();

		video.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
			@Override
			public void onCompletion(MediaPlayer mp) {
				video.seekTo(0);
				video.start();
				count++;
				if(count == 2){
					TextView text = (TextView)findViewById(R.id.hint2);
					text.setText("114 + 514 = ???");
				}
			}
		});

		Button end = (Button)findViewById(R.id.button_end);
		end.setOnClickListener(this);

	}

	public void onClick(View v){
		if(v.getId() == R.id.button_end)finish();
	}
}