package com.protecgames.htmleditor;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
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
import android.widget.EditText;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
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
import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds;

public class CodeActivity extends AppCompatActivity {
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private FloatingActionButton _fab;
	private String mode = "";
	private String file = "";
	private String Folder = "";
	private String code = "";
	private boolean False = false;
	
	private EditText edittext1;
	
	private ProgressDialog prog1;
	private AlertDialog.Builder dialog;
	private Intent i = new Intent();
	private SharedPreferences f;
	private SharedPreferences theme;
	private SharedPreferences edit;
	private RequestNetwork net;
	private RequestNetwork.RequestListener _net_request_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.code);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
		} else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
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
		
		edittext1 = findViewById(R.id.edittext1);
		dialog = new AlertDialog.Builder(this);
		f = getSharedPreferences("f", Activity.MODE_PRIVATE);
		theme = getSharedPreferences("theme", Activity.MODE_PRIVATE);
		edit = getSharedPreferences("edit", Activity.MODE_PRIVATE);
		net = new RequestNetwork(this);
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.putExtra("data", edittext1.getText().toString());
				i.setClass(getApplicationContext(), DisplayActivity.class);
				startActivity(i);
			}
		});
		
		_net_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
	}
	
	private void initializeLogic() {
		UnityAds.initialize(this, "5122862", false, false);
		mode = getIntent().getStringExtra("mode");
		file = getIntent().getStringExtra("data");
		Folder = FileUtil.getExternalStorageDir().concat("ProTec Games/HTML Editor/");
		setTitle("Editor Window");
		UnityAds.show(CodeActivity.this, "Interstitial_Android");
		SimpleHighlighter syntx = new SimpleHighlighter (edittext1);
		if (theme.getString("theme", "").equals("grad")) {
			edittext1.setBackground(new GradientDrawable(GradientDrawable.Orientation.BR_TL, new int[] {0xFF9C27B0,0xFF000000}));
			edittext1.setTextColor(0xFFFFFFFF);
		}
		if (theme.getString("theme", "").equals("light")) {
			edittext1.setBackgroundColor(0xFFFFFFFF);
			edittext1.setTextColor(0xFF9E9E9E);
		}
		if (theme.getString("theme", "").equals("dark")) {
			edittext1.setBackgroundColor(0xFF000000);
			edittext1.setTextColor(0xFFFFFFFF);
		}
		edittext1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		edittext1.setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
		edittext1.setSingleLine(False);
		if (edit.contains("code")) {
			edittext1.setText(edit.getString("code", ""));
		}
		else {
			edittext1.setText("");
		}
	}
	
	@Override
	public void onBackPressed() {
		i.setClass(getApplicationContext(), MainActivity.class);
		startActivity(i);
		if (edit.contains("code")) {
			edit.edit().remove("code").commit();
		}
		else {
			FileUtil.writeFile(FileUtil.getExternalStorageDir().concat("/ProTec Games/HTML Editor/".concat(file)), edittext1.getText().toString());
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuItem menuitem1 = menu.add(Menu.NONE, 1, Menu.NONE, "Copy");
		menuitem1.setIcon(R.drawable.ic_content_copy_white);
		menuitem1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		MenuItem menuitem2 = menu.add(Menu.NONE, 2, Menu.NONE, "Save");
		menuitem2.setIcon(R.drawable.ic_save_white);
		menuitem2.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		final int _id = item.getItemId();
		final String _title = (String) item.getTitle();
		if (_id == 1) {
			UnityAds.show(CodeActivity.this, "Interstitial_Android");
			((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", edittext1.getText().toString()));
			SketchwareUtil.showMessage(getApplicationContext(), "Code copied!");
		}
		if (_id == 2) {
			UnityAds.show(CodeActivity.this, "Interstitial_Android");
			FileUtil.writeFile(FileUtil.getExternalStorageDir().concat("/ProTec Games/HTML Editor/".concat(file)), edittext1.getText().toString());
			SketchwareUtil.showMessage(getApplicationContext(), "File Saved");
		}
		return super.onOptionsItemSelected(item);
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