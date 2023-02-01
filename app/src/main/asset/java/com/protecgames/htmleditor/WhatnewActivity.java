package com.protecgames.htmleditor;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.FirebaseApp;
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

public class WhatnewActivity extends AppCompatActivity {
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private FloatingActionButton _fab;
	
	private ScrollView vscroll1;
	private LinearLayout linear2;
	private TextView textview3;
	private TextView textview4;
	
	private SharedPreferences username;
	private SharedPreferences theme;
	private Intent update = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.whatnew);
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
		_fab = findViewById(R.id._fab);
		
		vscroll1 = findViewById(R.id.vscroll1);
		linear2 = findViewById(R.id.linear2);
		textview3 = findViewById(R.id.textview3);
		textview4 = findViewById(R.id.textview4);
		username = getSharedPreferences("username", Activity.MODE_PRIVATE);
		theme = getSharedPreferences("theme", Activity.MODE_PRIVATE);
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				update.setAction(Intent.ACTION_VIEW);
				update.setData(Uri.parse("https://com-protecgames-htmleditor.en.uptodown.com/android"));
				startActivity(update);
			}
		});
	}
	
	private void initializeLogic() {
		setTitle("What's New?");
		textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 1);
		textview4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 1);
		if (theme.getString("theme", "").equals("grad")) {
			vscroll1.setBackground(new GradientDrawable(GradientDrawable.Orientation.BR_TL, new int[] {0xFF9C27B0,0xFF000000}));
			textview3.setTextColor(0xFFFFFFFF);
			textview4.setTextColor(0xFFFFFFFF);
		}
		if (theme.getString("theme", "").equals("light")) {
			vscroll1.setBackgroundColor(Color.TRANSPARENT);
		}
		if (theme.getString("theme", "").equals("dark")) {
			vscroll1.setBackgroundColor(0xFF000000);
			textview3.setTextColor(0xFFFFFFFF);
			textview4.setTextColor(0xFFFFFFFF);
		}
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