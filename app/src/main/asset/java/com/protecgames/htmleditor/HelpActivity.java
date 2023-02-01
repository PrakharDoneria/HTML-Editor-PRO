package com.protecgames.htmleditor;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.Intent;
import android.content.res.*;
import android.graphics.*;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blogspot.atifsoftwares.animatoolib.*;
import com.google.android.material.appbar.AppBarLayout;
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

public class HelpActivity extends AppCompatActivity {
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	
	private LinearLayout linear4;
	private ScrollView vscroll1;
	private TextView textview10;
	private LinearLayout linear2;
	private TextView textview2;
	private TextView textview3;
	private YouTubePlayerView youtube1;
	private ImageView imageview1;
	private TextView textview4;
	private TextView textview5;
	private ImageView imageview4;
	private TextView textview6;
	private TextView textview7;
	private YouTubePlayerView share;
	private TextView textview8;
	private TextView textview9;
	private ImageView imageview5;
	private YouTubePlayerView youtube2;
	private LinearLayout linear3;
	private Button button1;
	
	private Intent i = new Intent();
	private Intent mail = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.help);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		_app_bar = findViewById(R.id._app_bar);
		_coordinator = findViewById(R.id._coordinator);
		_toolbar = findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		linear4 = findViewById(R.id.linear4);
		vscroll1 = findViewById(R.id.vscroll1);
		textview10 = findViewById(R.id.textview10);
		linear2 = findViewById(R.id.linear2);
		textview2 = findViewById(R.id.textview2);
		textview3 = findViewById(R.id.textview3);
		youtube1 = findViewById(R.id.youtube1);
		imageview1 = findViewById(R.id.imageview1);
		textview4 = findViewById(R.id.textview4);
		textview5 = findViewById(R.id.textview5);
		imageview4 = findViewById(R.id.imageview4);
		textview6 = findViewById(R.id.textview6);
		textview7 = findViewById(R.id.textview7);
		share = findViewById(R.id.share);
		textview8 = findViewById(R.id.textview8);
		textview9 = findViewById(R.id.textview9);
		imageview5 = findViewById(R.id.imageview5);
		youtube2 = findViewById(R.id.youtube2);
		linear3 = findViewById(R.id.linear3);
		button1 = findViewById(R.id.button1);
		
		linear4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setData(Uri.parse("https://www.buymeacoffee.com/protecgame5"));
				startActivity(i);
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				mail.setAction(Intent.ACTION_VIEW);
				mail.setData(Uri.parse("mailto:protecgamesofficial@gmail.com"));
				startActivity(mail);
			}
		});
	}
	
	private void initializeLogic() {
		youtube1.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
			  @Override
			  public void onReady(@NonNull YouTubePlayer youTubePlayer) {
				    String videoId = "EWooaDTR4Zw";
				    youTubePlayer.cueVideo(videoId, 0);
				     
				  }
		});
		share.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
			  @Override
			  public void onReady(@NonNull YouTubePlayer youTubePlayer) {
				    String videoId = "UU_rXCZYXDE";
				    youTubePlayer.cueVideo(videoId, 0);
				     
				  }
		});
		youtube2.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
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