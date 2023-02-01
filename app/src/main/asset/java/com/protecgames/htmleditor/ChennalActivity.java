package com.protecgames.htmleditor;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.Intent;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Typeface;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blogspot.atifsoftwares.animatoolib.*;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.FirebaseApp;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerFullScreenListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerUtils;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.*;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.unity3d.ads.*;
import io.github.rosemoe.sora.*;
import io.github.rosemoe.sora.langs.base.*;
import io.github.rosemoe.sora.langs.css3.*;
import io.github.rosemoe.sora.langs.html.*;
import io.github.rosemoe.sora.langs.java.*;
import io.github.rosemoe.sora.langs.python.*;
import io.github.rosemoe.sora.langs.textmate.*;
import io.github.rosemoe.sora.langs.universal.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.antlr.v4.runtime.*;
import org.json.*;

public class ChennalActivity extends AppCompatActivity {
	
	private FloatingActionButton _fab;
	
	private LinearLayout linear1;
	private ScrollView vscroll1;
	private ImageView imageview1;
	private TextView textview1;
	private LinearLayout linear2;
	private YouTubePlayerView youtube3;
	private LinearLayout linear4;
	private YouTubePlayerView youtube4;
	private LinearLayout linear5;
	private YouTubePlayerView youtube6;
	private LinearLayout linear6;
	private YouTubePlayerView youtube5;
	
	private Intent video_add = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.chennal);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		_fab = findViewById(R.id._fab);
		
		linear1 = findViewById(R.id.linear1);
		vscroll1 = findViewById(R.id.vscroll1);
		imageview1 = findViewById(R.id.imageview1);
		textview1 = findViewById(R.id.textview1);
		linear2 = findViewById(R.id.linear2);
		youtube3 = findViewById(R.id.youtube3);
		linear4 = findViewById(R.id.linear4);
		youtube4 = findViewById(R.id.youtube4);
		linear5 = findViewById(R.id.linear5);
		youtube6 = findViewById(R.id.youtube6);
		linear6 = findViewById(R.id.linear6);
		youtube5 = findViewById(R.id.youtube5);
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				video_add.setAction(Intent.ACTION_VIEW);
				video_add.setData(Uri.parse("https://forms.gle/BDcr2sXXuXKMiUd88"));
				startActivity(video_add);
			}
		});
	}
	
	private void initializeLogic() {
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 1);
		youtube3.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
			  @Override
			  public void onReady(@NonNull YouTubePlayer youTubePlayer) {
				    String videoId = "EWooaDTR4Zw";
				    youTubePlayer.cueVideo(videoId, 0);
				     
				  }
		});
		youtube4.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
			  @Override
			  public void onReady(@NonNull YouTubePlayer youTubePlayer) {
				    String videoId = "nnBiIK_7cmE";
				    youTubePlayer.cueVideo(videoId, 0);
				     
				  }
		});
		youtube5.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
			  @Override
			  public void onReady(@NonNull YouTubePlayer youTubePlayer) {
				    String videoId = "LgbJqdxfyWo";
				    youTubePlayer.cueVideo(videoId, 0);
				     
				  }
		});
		youtube6.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
			  @Override
			  public void onReady(@NonNull YouTubePlayer youTubePlayer) {
				    String videoId = "UU_rXCZYXDE";
				    youTubePlayer.cueVideo(videoId, 0);
				     
				  }
		});
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}