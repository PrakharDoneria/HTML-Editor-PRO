package com.protecgames.htmleditor;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blogspot.atifsoftwares.animatoolib.*;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.dialog.InsetDialogOnTouchListener;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.dialog.MaterialDialogs;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.antlr.v4.runtime.*;
import org.json.*;
import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds;

public class MainActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private FloatingActionButton _fab;
	private DrawerLayout _drawer;
	private String backgroundColor = "";
	private String file = "";
	private String subtitle = "";
	private String Folder = "";
	private double position = 0;
	private double fa = 0;
	private double mode = 0;
	private String path = "";
	
	private ArrayList<String> liststring = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> File_map = new ArrayList<>();
	
	private LinearLayout linear2;
	private LinearLayout linear4;
	private TextInputLayout textinputlayout1;
	private Button button1;
	private LinearLayout linear3;
	private EditText edittext1;
	private ProgressBar progressbar1;
	private ListView listview1;
	private LinearLayout linear5;
	private ImageView imageview1;
	private TextView textview2;
	private LinearLayout _drawer_linear1;
	private LinearLayout _drawer_profile;
	private LinearLayout _drawer_linear15;
	private ScrollView _drawer_vscroll1;
	private TextView _drawer_textview1;
	private ImageView _drawer_twitter;
	private ImageView _drawer_insta;
	private ImageView _drawer_web;
	private ImageView _drawer_fb;
	private ImageView _drawer_github;
	private LinearLayout _drawer_linear7;
	private LinearLayout _drawer_account;
	private LinearLayout _drawer_faqz;
	private LinearLayout _drawer_aboutapp;
	private LinearLayout _drawer_settingz;
	private LinearLayout _drawer_feature;
	private LinearLayout _drawer_linear4;
	private LinearLayout _drawer_rate;
	private LinearLayout _drawer_YT;
	private LinearLayout _drawer_learn;
	private ImageView _drawer_imageview9;
	private TextView _drawer_textview11;
	private ImageView _drawer_imageview3;
	private TextView _drawer_textview4;
	private ImageView _drawer_imageview2;
	private TextView _drawer_textview3;
	private ImageView _drawer_imageview1;
	private TextView _drawer_textview2;
	private ImageView _drawer_imageview5;
	private TextView _drawer_textview6;
	private ImageView _drawer_imageview4;
	private TextView _drawer_textview5;
	private ImageView _drawer_imageview6;
	private TextView _drawer_textview7;
	private ImageView _drawer_imageview8;
	private TextView _drawer_textview8;
	private ImageView _drawer_imageview7;
	private TextView _drawer_textview9;
	
	private TimerTask t1;
	private TimerTask t2;
	private TimerTask t3;
	private TimerTask t4;
	private Intent i = new Intent();
	private TimerTask t;
	private SharedPreferences project_created;
	private TimerTask fat;
	private TimerTask fat2;
	private Intent activity = new Intent();
	private SharedPreferences mrm;
	private AlertDialog.Builder d;
	private AlertDialog.Builder exit_dialog;
	private SharedPreferences theme;
	
	private OnCompleteListener YouCouldMessage_onCompleteListener;
	private Intent help = new Intent();
	private Intent rate = new Intent();
	private Intent fb = new Intent();
	private Intent web = new Intent();
	private Intent twitter = new Intent();
	private Intent insta = new Intent();
	private Intent youtube = new Intent();
	private Intent git = new Intent();
	private AlertDialog.Builder update;
	private MaterialAlertDialogBuilder mat;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
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
		
		_drawer = findViewById(R.id._drawer);
		ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(MainActivity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
		_drawer.addDrawerListener(_toggle);
		_toggle.syncState();
		
		LinearLayout _nav_view = findViewById(R.id._nav_view);
		
		linear2 = findViewById(R.id.linear2);
		linear4 = findViewById(R.id.linear4);
		textinputlayout1 = findViewById(R.id.textinputlayout1);
		button1 = findViewById(R.id.button1);
		linear3 = findViewById(R.id.linear3);
		edittext1 = findViewById(R.id.edittext1);
		progressbar1 = findViewById(R.id.progressbar1);
		listview1 = findViewById(R.id.listview1);
		linear5 = findViewById(R.id.linear5);
		imageview1 = findViewById(R.id.imageview1);
		textview2 = findViewById(R.id.textview2);
		_drawer_linear1 = _nav_view.findViewById(R.id.linear1);
		_drawer_profile = _nav_view.findViewById(R.id.profile);
		_drawer_linear15 = _nav_view.findViewById(R.id.linear15);
		_drawer_vscroll1 = _nav_view.findViewById(R.id.vscroll1);
		_drawer_textview1 = _nav_view.findViewById(R.id.textview1);
		_drawer_twitter = _nav_view.findViewById(R.id.twitter);
		_drawer_insta = _nav_view.findViewById(R.id.insta);
		_drawer_web = _nav_view.findViewById(R.id.web);
		_drawer_fb = _nav_view.findViewById(R.id.fb);
		_drawer_github = _nav_view.findViewById(R.id.github);
		_drawer_linear7 = _nav_view.findViewById(R.id.linear7);
		_drawer_account = _nav_view.findViewById(R.id.account);
		_drawer_faqz = _nav_view.findViewById(R.id.faqz);
		_drawer_aboutapp = _nav_view.findViewById(R.id.aboutapp);
		_drawer_settingz = _nav_view.findViewById(R.id.settingz);
		_drawer_feature = _nav_view.findViewById(R.id.feature);
		_drawer_linear4 = _nav_view.findViewById(R.id.linear4);
		_drawer_rate = _nav_view.findViewById(R.id.rate);
		_drawer_YT = _nav_view.findViewById(R.id.YT);
		_drawer_learn = _nav_view.findViewById(R.id.learn);
		_drawer_imageview9 = _nav_view.findViewById(R.id.imageview9);
		_drawer_textview11 = _nav_view.findViewById(R.id.textview11);
		_drawer_imageview3 = _nav_view.findViewById(R.id.imageview3);
		_drawer_textview4 = _nav_view.findViewById(R.id.textview4);
		_drawer_imageview2 = _nav_view.findViewById(R.id.imageview2);
		_drawer_textview3 = _nav_view.findViewById(R.id.textview3);
		_drawer_imageview1 = _nav_view.findViewById(R.id.imageview1);
		_drawer_textview2 = _nav_view.findViewById(R.id.textview2);
		_drawer_imageview5 = _nav_view.findViewById(R.id.imageview5);
		_drawer_textview6 = _nav_view.findViewById(R.id.textview6);
		_drawer_imageview4 = _nav_view.findViewById(R.id.imageview4);
		_drawer_textview5 = _nav_view.findViewById(R.id.textview5);
		_drawer_imageview6 = _nav_view.findViewById(R.id.imageview6);
		_drawer_textview7 = _nav_view.findViewById(R.id.textview7);
		_drawer_imageview8 = _nav_view.findViewById(R.id.imageview8);
		_drawer_textview8 = _nav_view.findViewById(R.id.textview8);
		_drawer_imageview7 = _nav_view.findViewById(R.id.imageview7);
		_drawer_textview9 = _nav_view.findViewById(R.id.textview9);
		project_created = getSharedPreferences("project_created", Activity.MODE_PRIVATE);
		mrm = getSharedPreferences("mrm", Activity.MODE_PRIVATE);
		d = new AlertDialog.Builder(this);
		exit_dialog = new AlertDialog.Builder(this);
		theme = getSharedPreferences("theme", Activity.MODE_PRIVATE);
		update = new AlertDialog.Builder(this);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext1.getText().toString().equals("")) {
					textinputlayout1.setError("Field is empty. ");
				}
				else {
					if (edittext1.getText().toString().equals(".html")) {
						textinputlayout1.setError("File name should be something.html, it can't be just .html. ");
					}
					else {
						file = edittext1.getText().toString();
						_layoutanimation();
					}
					if (edittext1.getText().toString().endsWith(".html")) {
						
					}
					else {
						textinputlayout1.setError("File name doesn't end with .html. ");
					}
				}
			}
		});
		
		listview1.setOnScrollListener(new AbsListView.OnScrollListener() {
			@Override
			public void onScrollStateChanged(AbsListView abs, int _scrollState) {
				
			}
			
			@Override
			public void onScroll(AbsListView abs, int _firstVisibleItem, int _visibleItemCount, int _totalItemCount) {
				
			}
		});
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				UnityAds.show(MainActivity.this, "Interstitial_Android");
				activity.setClass(getApplicationContext(), ViewActivity.class);
				activity.putExtra("name", Uri.parse(liststring.get((int)(_position))).getLastPathSegment());
				startActivity(activity);
			}
		});
		
		listview1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				exit_dialog.setMessage("Wanna Delete this project forever?");
				exit_dialog.setPositiveButton("DELETE", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						UnityAds.show(MainActivity.this, "Interstitial_Android");
						FileUtil.deleteFile(liststring.get((int)(_position)));
						i.setClass(getApplicationContext(), MainActivity.class);
						startActivity(i);
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					}
				});
				exit_dialog.create().show();
				return true;
			}
		});
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_fan_animation();
				fat2 = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								linear4.setVisibility(View.INVISIBLE);
								linear4.setVisibility(View.GONE);
								linear2.setVisibility(View.VISIBLE);
								_fab.hide();
							}
						});
					}
				};
				_timer.schedule(fat2, (int)(700));
				project_created.edit().putString("project_created", "t").commit();
				mode = 1;
			}
		});
		
		_drawer_twitter.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				twitter.setAction(Intent.ACTION_VIEW);
				twitter.setData(Uri.parse("https://www.twitter.com/ProtectedTec"));
				startActivity(twitter);
			}
		});
		
		_drawer_insta.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				insta.setAction(Intent.ACTION_VIEW);
				insta.setData(Uri.parse("https://www.instagram.com/protecstudioofficial/"));
				startActivity(insta);
			}
		});
		
		_drawer_web.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				web.setAction(Intent.ACTION_VIEW);
				web.setData(Uri.parse("https://protecgames.godaddysites.com/"));
				startActivity(web);
			}
		});
		
		_drawer_fb.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				fb.setAction(Intent.ACTION_VIEW);
				fb.setData(Uri.parse("https://m.facebook.com/protecgames/?_rdr"));
				startActivity(fb);
			}
		});
		
		_drawer_github.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				git.setAction(Intent.ACTION_VIEW);
				git.setData(Uri.parse("https://github.com/PrakharDoneria"));
				startActivity(git);
			}
		});
		
		_drawer_account.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivity(new Intent(MainActivity.this, AccountActivity.class)); Animatoo.animateSplit(MainActivity.this);
			}
		});
		
		_drawer_faqz.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), ProjectListActivity.class);
				startActivity(i);
			}
		});
		
		_drawer_aboutapp.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				help.setAction(Intent.ACTION_VIEW);
				help.setData(Uri.parse("https://www.buymeacoffee.com/protecgame5"));
				startActivity(help);
			}
		});
		
		_drawer_settingz.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivity(new Intent(MainActivity.this, SettingActivity.class)); Animatoo.animateDiagonal(MainActivity.this);
			}
		});
		
		_drawer_feature.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), RequestActivity.class);
				startActivity(i);
			}
		});
		
		_drawer_linear4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), FeedbackActivity.class);
				startActivity(i);
			}
		});
		
		_drawer_rate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				rate.setAction(Intent.ACTION_VIEW);
				rate.setData(Uri.parse("https://apps.samsung.com/appquery/AppRating.as?appId=com.protecgames.htmleditor"));
				startActivity(rate);
			}
		});
		
		_drawer_YT.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				youtube.setClass(getApplicationContext(), ChennalActivity.class);
				startActivity(youtube);
			}
		});
		
		_drawer_learn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				insta.setAction(Intent.ACTION_VIEW);
				insta.setData(Uri.parse("https://www.instagram.com/codewithprakhar_/"));
				startActivity(insta);
			}
		});
	}
	
	private void initializeLogic() {
		FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(YouCouldMessage_onCompleteListener);
		UnityAds.initialize(this, "5122862", false, false);
		setTitle("HTML Editor PRO");
		_GradientDrawable(button1, 10, 0, 0, "#FF9800", "#FFFFFF", true, false, 0);
		linear3.setVisibility(View.INVISIBLE);
		_files();
		_list();
		fa = 0;
		linear2.setVisibility(View.INVISIBLE);
		linear2.setVisibility(View.GONE);
		linear4.setVisibility(View.VISIBLE);
		_mrmm();
		mode = 0;
		
		
		
		
		
		
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		if (theme.getString("theme", "").equals("grad")) {
			textview2.setTextColor(0xFFFFFFFF);
			linear2.setBackground(new GradientDrawable(GradientDrawable.Orientation.BR_TL, new int[] {0xFF9C27B0,0xFF000000}));
			linear4.setBackground(new GradientDrawable(GradientDrawable.Orientation.BR_TL, new int[] {0xFF9C27B0,0xFF000000}));
			textinputlayout1.setBoxBackgroundColor(0xFF9C27B0);
			linear2.setBackground(new GradientDrawable(GradientDrawable.Orientation.BR_TL, new int[] {0xFF9C27B0,0xFF000000}));
			linear5.setBackground(new GradientDrawable(GradientDrawable.Orientation.BR_TL, new int[] {0xFF9C27B0,0xFF000000}));
			button1.setTextColor(0xFFFFFFFF);
			edittext1.setTextColor(0xFFFFFFFF);
		}
		if (theme.getString("theme", "").equals("light")) {
			linear4.setBackgroundColor(Color.TRANSPARENT);
		}
		if (theme.getString("theme", "").equals("dark")) {
			textinputlayout1.setBoxBackgroundColor(0xFFFFFFFF);
			textview2.setTextColor(0xFFFFFFFF);
			edittext1.setTextColor(0xFF000000);
			button1.setTextColor(0xFFFFFFFF);
			linear2.setBackgroundColor(0xFF000000);
			linear4.setBackgroundColor(0xFF000000);
		}
		UnityAds.show(MainActivity.this, "Interstitial_Android");
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuItem menuitem1 = menu.add(Menu.NONE, 0, Menu.NONE, "Help and support. ");
		menuitem1.setIcon(R.drawable.ic_help_white);
		menuitem1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		MenuItem menuitem4 = menu.add(Menu.NONE, 3, Menu.NONE, "Rate App");
		menuitem4.setIcon(R.drawable.ic_star_white);
		menuitem4.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		MenuItem menuitem5 = menu.add(Menu.NONE, 4, Menu.NONE, "Support us");
		menuitem5.setIcon(R.drawable.ic_favorite_white);
		menuitem5.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		final int _id = item.getItemId();
		final String _title = (String) item.getTitle();
		if (_id == 0) {
			i.setClass(getApplicationContext(), HelpActivity.class);
			startActivity(i);
		}
		if (_id == 3) {
			rate.setAction(Intent.ACTION_VIEW);
			rate.setData(Uri.parse("https://apps.samsung.com/appquery/AppRating.as?appId=com.protecgames.htmleditor"));
			startActivity(rate);
		}
		if (_id == 4) {
			help.setAction(Intent.ACTION_VIEW);
			help.setData(Uri.parse("https://www.buymeacoffee.com/protecgame5"));
			startActivity(help);
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void onBackPressed() {
		if (mode == 1) {
			linear4.setVisibility(View.VISIBLE);
			linear2.setVisibility(View.GONE);
			_fab.show();
			mode = 0;
		}
		else {
			finishAffinity();
		}
	}
	
	@Override
	public void onResume() {
		super.onResume();
		_RefreshData();
	}
	
	public void _GradientDrawable(final View _view, final double _radius, final double _stroke, final double _shadow, final String _color, final String _borderColor, final boolean _ripple, final boolean _clickAnim, final double _animDuration) {
		if (_ripple) {
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor(_color));
			gd.setCornerRadius((int)_radius);
			gd.setStroke((int)_stroke,Color.parseColor(_borderColor));
			if (Build.VERSION.SDK_INT >= 21){
				_view.setElevation((int)_shadow);}
			android.content.res.ColorStateList clrb = new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{Color.parseColor("#82B1FF")});
			android.graphics.drawable.RippleDrawable ripdrb = new android.graphics.drawable.RippleDrawable(clrb , gd, null);
			_view.setClickable(true);
			_view.setBackground(ripdrb);
		}
		else {
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor(_color));
			gd.setCornerRadius((int)_radius);
			gd.setStroke((int)_stroke,Color.parseColor(_borderColor));
			_view.setBackground(gd);
			if (Build.VERSION.SDK_INT >= 21){
				_view.setElevation((int)_shadow);}
		}
		if (_clickAnim) {
			_view.setOnTouchListener(new View.OnTouchListener() {
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					switch (event.getAction()){
						case MotionEvent.ACTION_DOWN:{
							ObjectAnimator scaleX = new ObjectAnimator();
							scaleX.setTarget(_view);
							scaleX.setPropertyName("scaleX");
							scaleX.setFloatValues(0.9f);
							scaleX.setDuration((int)_animDuration);
							scaleX.start();
							
							ObjectAnimator scaleY = new ObjectAnimator();
							scaleY.setTarget(_view);
							scaleY.setPropertyName("scaleY");
							scaleY.setFloatValues(0.9f);
							scaleY.setDuration((int)_animDuration);
							scaleY.start();
							break;
						}
						case MotionEvent.ACTION_UP:{
							
							ObjectAnimator scaleX = new ObjectAnimator();
							scaleX.setTarget(_view);
							scaleX.setPropertyName("scaleX");
							scaleX.setFloatValues((float)1);
							scaleX.setDuration((int)_animDuration);
							scaleX.start();
							
							ObjectAnimator scaleY = new ObjectAnimator();
							scaleY.setTarget(_view);
							scaleY.setPropertyName("scaleY");
							scaleY.setFloatValues((float)1);
							scaleY.setDuration((int)_animDuration);
							scaleY.start();
							
							break;
						}
					}
					return false;
				}
			});
		}
	}
	
	
	public void _roundedAndRipple(final View _view, final String _backgroundColor, final String _rippleColor, final double _radius) {
		//Code from StackOverflow and adapted for Sketchware by @BOFA 
		//Please do not reupload. If you want to improve, feel free just give credit.
		
		//For colors include #
		
		if (_backgroundColor.equals("")) {
			//If you leave the background color empty, it will be set to this default color.
			backgroundColor = "#FFFFFF";
		}
		else {
			backgroundColor = _backgroundColor;
		}
		android.content.res.ColorStateList pressedStates = android.content.res.ColorStateList.valueOf(Color.parseColor(_rippleColor)); 
		//adapted for Sketchware by BOFA
		android.graphics.drawable.GradientDrawable contentDrawable = new android.graphics.drawable.GradientDrawable();
		contentDrawable.setColor(Color.parseColor(backgroundColor));
		if (!(_radius == 0)) {
			//If you leave radius empty, no radius will be added.
			contentDrawable.setCornerRadius((int)_radius);
		}
		android.graphics.drawable.RippleDrawable rippleDrawable = new android.graphics.drawable.RippleDrawable(pressedStates, contentDrawable, null);
		//
		_view.setBackground(rippleDrawable);
		
		
		
		
		
		
		
		
		
		
		
		boolean isMod1Installed = mod1InstalledOrNot("com.sketchware.mod");
		
		boolean isMod2Installed = mod2InstalledOrNot("com.sketchware.remod");
		
		boolean isMod3Installed = mod3InstalledOrNot("com.sketchware.remodindo");
		
		if(isMod1Installed || isMod2Installed || isMod3Installed) {
			
			AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
							builder.setTitle("Looks like someone is a bad boi :(")
								.setMessage("Please do not use Sketchware mods. Not only are the ILLEGAL (because they are redistributing copyrighted property), they are also STEALING ad revenue from the creators of Sketchware who have worked tirelessly developing Sketchware. The reason the Sketchware devs are no longer active is because of people like you who steal ad revenue from them.")
								.setCancelable(false)
								.setNegativeButton("I understand that what I am doing is ILLEGAL, and I will continue to preform illegal actions because I am a bad person and don't care that I am negativity affecting the real dev's lives", new DialogInterface.OnClickListener() {
										public void onClick(DialogInterface dialog, int id) {
												showMessage("Wow, you really are a bad person.");
										}
								});
							AlertDialog alert = builder.create();
							alert.show();
			
		}}
	
	private boolean mod1InstalledOrNot(String uri) { android.content.pm.PackageManager pm = getPackageManager(); try { pm.getPackageInfo(uri, android.content.pm.PackageManager.GET_ACTIVITIES); return true; } catch (android.content.pm.PackageManager.NameNotFoundException e) { } return false;
	}
	
	private boolean mod2InstalledOrNot(String uri) { android.content.pm.PackageManager pm = getPackageManager(); try { pm.getPackageInfo(uri, android.content.pm.PackageManager.GET_ACTIVITIES); return true; } catch (android.content.pm.PackageManager.NameNotFoundException e) { } return false;
	}
	
	private boolean mod3InstalledOrNot(String uri) { android.content.pm.PackageManager pm = getPackageManager(); try { pm.getPackageInfo(uri, android.content.pm.PackageManager.GET_ACTIVITIES); return true; } catch (android.content.pm.PackageManager.NameNotFoundException e) { } return false;
	}
	
	
	public void _layoutanimation() {
		final AlphaAnimation fadeIn = new AlphaAnimation(0.0f,1.0f);
		final AlphaAnimation fadeOut = new AlphaAnimation(1.0f,0.0f);
		
		linear2.startAnimation(fadeIn);
		linear2.startAnimation(fadeOut);
		fadeIn.setDuration(500);
		fadeIn.setFillAfter(true);
		fadeOut.setDuration(500);
		fadeOut.setFillAfter(true);
		fadeOut.setStartOffset(10+fadeIn.getStartOffset());
		t1 = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						textinputlayout1.setVisibility(View.GONE);
						button1.setVisibility(View.GONE);
						final AlphaAnimation fadeIn = new AlphaAnimation(1.0f,0.0f);
						final AlphaAnimation fadeOut = new AlphaAnimation(0.0f,1.0f);
						
						linear2.startAnimation(fadeIn);
						linear2.startAnimation(fadeOut);
						fadeIn.setDuration(200);
						fadeIn.setFillAfter(true);
						fadeOut.setDuration(200);
						fadeOut.setFillAfter(true);
						fadeOut.setStartOffset(10+fadeIn.getStartOffset());
						t2 = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										linear3.setVisibility(View.VISIBLE);
										t3 = new TimerTask() {
											@Override
											public void run() {
												runOnUiThread(new Runnable() {
													@Override
													public void run() {
														final AlphaAnimation fadeIn = new AlphaAnimation(1.0f,0.0f);
														final AlphaAnimation fadeOut = new AlphaAnimation(0.0f,1.0f);
														
														linear2.startAnimation(fadeIn);
														linear2.startAnimation(fadeOut);
														fadeIn.setDuration(500);
														fadeIn.setFillAfter(true);
														fadeOut.setDuration(500);
														fadeOut.setFillAfter(true);
														fadeOut.setStartOffset(10+fadeIn.getStartOffset());
														t4 = new TimerTask() {
															@Override
															public void run() {
																runOnUiThread(new Runnable() {
																	@Override
																	public void run() {
																		i.setClass(getApplicationContext(), CodeActivity.class);
																		i.putExtra("mode", "new");
																		i.putExtra("data", file);
																		startActivity(i);
																		finish();
																	}
																});
															}
														};
														_timer.schedule(t4, (int)(750));
													}
												});
											}
										};
										_timer.schedule(t3, (int)(300));
									}
								});
							}
						};
						_timer.schedule(t2, (int)(250));
					}
				});
			}
		};
		_timer.schedule(t1, (int)(550));
	}
	
	
	public void _list() {
		//* To get project lists. 
		_RefreshData();
		if (project_created.getString("project_created", "").equals("t")) {
			linear5.setVisibility(View.GONE);
			listview1.setVisibility(View.VISIBLE);
		}
		else {
			linear5.setVisibility(View.VISIBLE);
			listview1.setVisibility(View.GONE);
		}
		//* This thing, bcuz hard code suc. 
	}
	
	
	public void _RefreshData() {
		listview1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE); listview1.setItemsCanFocus(false);
		File_map.clear();
		subtitle = Folder;
		FileUtil.listDir(Folder, liststring);
		Collections.sort(liststring, String.CASE_INSENSITIVE_ORDER);
		position = 0;
		for(int _repeat14 = 0; _repeat14 < (int)(liststring.size()); _repeat14++) {
			{
				HashMap<String, Object> _item = new HashMap<>();
				_item.put("file", liststring.get((int)(position)));
				File_map.add(_item);
			}
			
			position++;
		}
		listview1.setAdapter(new Listview1Adapter(File_map));
		((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
	}
	
	
	public void _fail() {
		
	}
	
	
	public void _files() {
		Folder = FileUtil.getExternalStorageDir().concat("/ProTec Games/HTML Editor");
	}
	
	
	public void _fan_animation() {
		fat = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						fa++;
						if ((fa > 321) || (fa == 321)) {
							fa = 0;
							fat.cancel();
						}
						else {
							
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(fat, (int)(0), (int)(2));
	}
	
	
	public void _mrmm() {
		if (mrm.getString("mrm", "").equals("update")) {
			
		}
		else {
			MaterialAlertDialogBuilder mat = new MaterialAlertDialogBuilder(MainActivity.this);
			mat.setTitle("ALERT !!!!");
			mat.setMessage("Dear user,\nThanks for using our application but we are now shifting from Galaxy Store to Uptodown in order to keep your app up-to-date you will now have to dowload update versions from uptodown or can request us via email provided in Help tab.");
			mat.setPositiveButton("Learn More", (dialog, id) -> {
				         theme.edit().putString("theme", "light").commit();
				mrm.edit().putString("mrm", "update").commit();
				i.setClass(getApplicationContext(), WhatnewActivity.class);
				startActivity(i);
			});
			mat.setCancelable(false);
			mat.create().show();
		}
	}
	
	
	public void _MaterialRippleLibrary() {
		
	}
	public static class MaterialRippleLayout extends FrameLayout {
		    private static final int     DEFAULT_DURATION        = 300;
		    private static final int     DEFAULT_FADE_DURATION   = 75;
		    private static final float   DEFAULT_DIAMETER_DP     = 35;
		    private static final float   DEFAULT_ALPHA           = 0.2f;
		    private static final int     DEFAULT_COLOR           = Color.BLACK;
		    private static final int     DEFAULT_BACKGROUND      = Color.TRANSPARENT;
		    private static final boolean DEFAULT_HOVER           = true;
		    private static final boolean DEFAULT_DELAY_CLICK     = true;
		    private static final boolean DEFAULT_PERSISTENT      = false;
		    private static final boolean DEFAULT_SEARCH_ADAPTER  = false;
		    private static final boolean DEFAULT_RIPPLE_OVERLAY  = false;
		    private static final int     DEFAULT_ROUNDED_CORNERS = 3;
		    private static final int  FADE_EXTRA_DELAY = 50;
		    private static final long HOVER_DURATION   = 1000;
		    private final Paint paint  = new Paint(Paint.ANTI_ALIAS_FLAG);
		    private final Rect  bounds = new Rect();
		    private int      rippleColor;
		    private boolean  rippleOverlay;
		    private boolean  rippleHover;
		    private int      rippleDiameter;
		    private int      rippleDuration;
		    private int      rippleAlpha;
		    private boolean  rippleDelayClick;
		    private int      rippleFadeDuration;
		    private boolean  ripplePersistent;
		    private android.graphics.drawable.Drawable rippleBackground;
		    private boolean  rippleInAdapter;
		    private float    rippleRoundedCorners;
		    private float radius;
		    private AdapterView parentAdapter;
		    private View childView;
		    private AnimatorSet    rippleAnimator;
		    private ObjectAnimator hoverAnimator;
		    private Point currentCoords  = new Point();
		    private Point previousCoords = new Point();
		    private int layerType;
		    private boolean eventCancelled;
		    private boolean prepressed;
		    private int     positionInAdapter;
		    private GestureDetector   gestureDetector;
		    private PerformClickEvent pendingClickEvent;
		    private PressedEvent      pendingPressEvent;
		    public static RippleBuilder on(View view) {
				        return new RippleBuilder(view);
				    }
		    public MaterialRippleLayout(Context context) {
				        this(context, null, 0);
				    }
		    public MaterialRippleLayout(Context context, AttributeSet attrs) {
				        this(context, attrs, 0);
				    }
		    public MaterialRippleLayout(Context context, AttributeSet attrs, int defStyle) {
				        super(context, attrs, defStyle);
				        setWillNotDraw(false);
				        gestureDetector = new GestureDetector(context, longClickListener);
				        
				        rippleColor = DEFAULT_COLOR;
				        rippleDiameter =  (int) dpToPx(getResources(), DEFAULT_DIAMETER_DP);
				        rippleOverlay = DEFAULT_RIPPLE_OVERLAY;
				        rippleHover = DEFAULT_HOVER;
				        rippleDuration = DEFAULT_DURATION;
				        rippleAlpha = (int) (255 * DEFAULT_ALPHA);
				        rippleDelayClick = DEFAULT_DELAY_CLICK;
				        rippleFadeDuration = DEFAULT_FADE_DURATION;
				        rippleBackground = new android.graphics.drawable.ColorDrawable(DEFAULT_BACKGROUND);
				        ripplePersistent = DEFAULT_PERSISTENT;
				        rippleInAdapter = DEFAULT_SEARCH_ADAPTER;
				        rippleRoundedCorners = DEFAULT_ROUNDED_CORNERS;
				
				        paint.setColor(rippleColor);
				        paint.setAlpha(rippleAlpha);
				        enableClipPathSupportIfNecessary();
				    }
		    @SuppressWarnings("unchecked")
		    public <T extends View> T getChildView() {
				        return (T) childView;
				    }
		    @Override
		    public final void addView(View child, int index, ViewGroup.LayoutParams params) {
				        if (getChildCount() > 0) {
						            throw new IllegalStateException("MaterialRippleLayout can host only one child");
						        }
				        childView = child;
				        super.addView(child, index, params);
				    }
		    @Override
		    public void setOnClickListener(OnClickListener onClickListener) {
				        if (childView == null) {
						            throw new IllegalStateException("MaterialRippleLayout must have a child view to handle clicks");
						        }
				        childView.setOnClickListener(onClickListener);
				    }
		    @Override
		    public void setOnLongClickListener(OnLongClickListener onClickListener) {
				        if (childView == null) {
						            throw new IllegalStateException("MaterialRippleLayout must have a child view to handle clicks");
						        }
				        childView.setOnLongClickListener(onClickListener);
				    }
		    @Override
		    public boolean onInterceptTouchEvent(MotionEvent event) {
				        return !findClickableViewInChild(childView, (int) event.getX(), (int) event.getY());
				    }
		    @Override
		    public boolean onTouchEvent(MotionEvent event) {
				        boolean superOnTouchEvent = super.onTouchEvent(event);
				        if (!isEnabled() || !childView.isEnabled()) return superOnTouchEvent;
				        boolean isEventInBounds = bounds.contains((int) event.getX(), (int) event.getY());
				        if (isEventInBounds) {
						            previousCoords.set(currentCoords.x, currentCoords.y);
						            currentCoords.set((int) event.getX(), (int) event.getY());
						        }
				        boolean gestureResult = gestureDetector.onTouchEvent(event);
				        if (gestureResult || hasPerformedLongPress) {
						            return true;
						        } else {
						            int action = event.getActionMasked();
						            switch (action) {
								                case MotionEvent.ACTION_UP:
								                    pendingClickEvent = new PerformClickEvent();
								                    if (prepressed) {
										                        childView.setPressed(true);
										                        postDelayed(
										                            new Runnable() {
												                                @Override public void run() {
														                                    childView.setPressed(false);
														                                }
												                            }, ViewConfiguration.getPressedStateDuration());
										                    }
								                    if (isEventInBounds) {
										                        startRipple(pendingClickEvent);
										                    } else if (!rippleHover) {
										                        setRadius(0);
										                    }
								                    if (!rippleDelayClick && isEventInBounds) {
										                        pendingClickEvent.run();
										                    }
								                    cancelPressedEvent();
								                    break;
								                case MotionEvent.ACTION_DOWN:
								                    setPositionInAdapter();
								                    eventCancelled = false;
								                    pendingPressEvent = new PressedEvent(event);
								                    if (isInScrollingContainer()) {
										                        cancelPressedEvent();
										                        prepressed = true;
										                        postDelayed(pendingPressEvent, ViewConfiguration.getTapTimeout());
										                    } else {
										                        pendingPressEvent.run();
										                    }
								                    break;
								                case MotionEvent.ACTION_CANCEL:
								                    if (rippleInAdapter) {
										                        currentCoords.set(previousCoords.x, previousCoords.y);
										                        previousCoords = new Point();
										                    }
								                    childView.onTouchEvent(event);
								                    if (rippleHover) {
										                        if (!prepressed) {
												                            startRipple(null);
												                        }
										                    } else {
										                        childView.setPressed(false);
										                    }
								                    cancelPressedEvent();
								                    break;
								                case MotionEvent.ACTION_MOVE:
								                    if (rippleHover) {
										                        if (isEventInBounds && !eventCancelled) {
												                            invalidate();
												                        } else if (!isEventInBounds) {
												                            startRipple(null);
												                        }
										                    }
								                    if (!isEventInBounds) {
										                        cancelPressedEvent();
										                        if (hoverAnimator != null) {
												                            hoverAnimator.cancel();
												                        }
										                        childView.onTouchEvent(event);
										                        eventCancelled = true;
										                    }
								                    break;
								            }
						            return true;
						        }
				    }
		    private void cancelPressedEvent() {
				        if (pendingPressEvent != null) {
						            removeCallbacks(pendingPressEvent);
						            prepressed = false;
						        }
				    }
		    private boolean hasPerformedLongPress;
		    private android.view.GestureDetector.SimpleOnGestureListener longClickListener = new GestureDetector.SimpleOnGestureListener() {
				        public void onLongPress(MotionEvent e) {
						            hasPerformedLongPress = childView.performLongClick();
						            if (hasPerformedLongPress) {
								                if (rippleHover) {
										                    startRipple(null);
										                }
								                cancelPressedEvent();
								            }
						        }
				        @Override
				        public boolean onDown(MotionEvent e) {
						            hasPerformedLongPress = false;
						            return super.onDown(e);
						        }
				    };
		    private void startHover() {
				        if (eventCancelled) return;
				        if (hoverAnimator != null) {
						            hoverAnimator.cancel();
						        }
				        final float radius = (float) (Math.sqrt(Math.pow(getWidth(), 2) + Math.pow(getHeight(), 2)) * 1.2f);
				        hoverAnimator = ObjectAnimator.ofFloat(this, radiusProperty, rippleDiameter, radius)
				            .setDuration(HOVER_DURATION);
				        hoverAnimator.setInterpolator(new android.view.animation.LinearInterpolator());
				        hoverAnimator.start();
				    }
		    private void startRipple(final Runnable animationEndRunnable) {
				        if (eventCancelled) return;
				        float endRadius = getEndRadius();
				        cancelAnimations();
				        rippleAnimator = new AnimatorSet();
				        rippleAnimator.addListener(new AnimatorListenerAdapter() {
						            @Override public void onAnimationEnd(Animator animation) {
								                if (!ripplePersistent) {
										                    setRadius(0);
										                    setRippleAlpha(rippleAlpha);
										                }
								                if (animationEndRunnable != null && rippleDelayClick) {
										                    animationEndRunnable.run();
										                }
								                childView.setPressed(false);
								            }
						        });
				        ObjectAnimator ripple = ObjectAnimator.ofFloat(this, radiusProperty, radius, endRadius);
				        ripple.setDuration(rippleDuration);
				        ripple.setInterpolator(new android.view.animation.DecelerateInterpolator());
				        ObjectAnimator fade = ObjectAnimator.ofInt(this, circleAlphaProperty, rippleAlpha, 0);
				        fade.setDuration(rippleFadeDuration);
				        fade.setInterpolator(new android.view.animation.AccelerateInterpolator());
				        fade.setStartDelay(rippleDuration - rippleFadeDuration - FADE_EXTRA_DELAY);
				        if (ripplePersistent) {
						            rippleAnimator.play(ripple);
						        } else if (getRadius() > endRadius) {
						            fade.setStartDelay(0);
						            rippleAnimator.play(fade);
						        } else {
						            rippleAnimator.playTogether(ripple, fade);
						        }
				        rippleAnimator.start();
				    }
		    private void cancelAnimations() {
				        if (rippleAnimator != null) {
						            rippleAnimator.cancel();
						            rippleAnimator.removeAllListeners();
						        }
				        if (hoverAnimator != null) {
						            hoverAnimator.cancel();
						        }
				    }
		    private float getEndRadius() {
				        final int width = getWidth();
				        final int height = getHeight();
				        final int halfWidth = width / 2;
				        final int halfHeight = height / 2;
				        final float radiusX = halfWidth > currentCoords.x ? width - currentCoords.x : currentCoords.x;
				        final float radiusY = halfHeight > currentCoords.y ? height - currentCoords.y : currentCoords.y;
				        return (float) Math.sqrt(Math.pow(radiusX, 2) + Math.pow(radiusY, 2)) * 1.2f;
				    }
		    private boolean isInScrollingContainer() {
				        ViewParent p = getParent();
				        while (p != null && p instanceof ViewGroup) {
						            if (((ViewGroup) p).shouldDelayChildPressedState()) {
								                return true;
								            }
						            p = p.getParent();
						        }
				        return false;
				    }
		    private AdapterView findParentAdapterView() {
				        if (parentAdapter != null) {
						            return parentAdapter;
						        }
				        ViewParent current = getParent();
				        while (true) {
						            if (current instanceof AdapterView) {
								                parentAdapter = (AdapterView) current;
								                return parentAdapter;
								            } else {
								                try {
										                    current = current.getParent();
										                } catch (NullPointerException npe) {
										                    throw new RuntimeException("Could not find a parent AdapterView");
										                }
								            }
						        }
				    }
		    private void setPositionInAdapter() {
				        if (rippleInAdapter) {
						            positionInAdapter = findParentAdapterView().getPositionForView(MaterialRippleLayout.this);
						        }
				    }
		    private boolean adapterPositionChanged() {
				        if (rippleInAdapter) {
						            int newPosition = findParentAdapterView().getPositionForView(MaterialRippleLayout.this);
						            final boolean changed = newPosition != positionInAdapter;
						            positionInAdapter = newPosition;
						            if (changed) {
								                cancelPressedEvent();
								                cancelAnimations();
								                childView.setPressed(false);
								                setRadius(0);
								            }
						            return changed;
						        }
				        return false;
				    }
		    private boolean findClickableViewInChild(View view, int x, int y) {
				        if (view instanceof ViewGroup) {
						            ViewGroup viewGroup = (ViewGroup) view;
						            for (int i = 0; i < viewGroup.getChildCount(); i++) {
								                View child = viewGroup.getChildAt(i);
								                final Rect rect = new Rect();
								                child.getHitRect(rect);
								                final boolean contains = rect.contains(x, y);
								                if (contains) {
										                    return findClickableViewInChild(child, x - rect.left, y - rect.top);
										                }
								            }
						        } else if (view != childView) {
						            return (view.isEnabled() && (view.isClickable() || view.isLongClickable() || view.isFocusableInTouchMode()));
						        }
				        return view.isFocusableInTouchMode();
				    }
		    @Override
		    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
				        super.onSizeChanged(w, h, oldw, oldh);
				        bounds.set(0, 0, w, h);
				        rippleBackground.setBounds(bounds);
				    }
		    @Override
		    public boolean isInEditMode() {
				        return true;
				    }
		    @Override
		    public void draw(Canvas canvas) {
				        final boolean positionChanged = adapterPositionChanged();
				        if (rippleOverlay) {
						            if (!positionChanged) {
								                rippleBackground.draw(canvas);
								            }
						            super.draw(canvas);
						            if (!positionChanged) {
								                if (rippleRoundedCorners != 0) {
										                    Path clipPath = new Path();
										                    RectF rect = new RectF(0, 0, canvas.getWidth(), canvas.getHeight());
										                    clipPath.addRoundRect(rect, rippleRoundedCorners, rippleRoundedCorners, Path.Direction.CW);
										                    canvas.clipPath(clipPath);
										                }
								                canvas.drawCircle(currentCoords.x, currentCoords.y, radius, paint);
								            }
						        } else {
						            if (!positionChanged) {
								                rippleBackground.draw(canvas);
								                canvas.drawCircle(currentCoords.x, currentCoords.y, radius, paint);
								            }
						            super.draw(canvas);
						        }
				    }
		    private Property<MaterialRippleLayout, Float> radiusProperty
		        = new Property<MaterialRippleLayout, Float>(Float.class, "radius") {
				        @Override
				        public Float get(MaterialRippleLayout object) {
						            return object.getRadius();
						        }
				        @Override
				        public void set(MaterialRippleLayout object, Float value) {
						            object.setRadius(value);
						        }
				    };
		    private float getRadius() {
				        return radius;
				    }
		    public void setRadius(float radius) {
				        this.radius = radius;
				        invalidate();
				    }
		    private Property<MaterialRippleLayout, Integer> circleAlphaProperty
		        = new Property<MaterialRippleLayout, Integer>(Integer.class, "rippleAlpha") {
				        @Override
				        public Integer get(MaterialRippleLayout object) {
						            return object.getRippleAlpha();
						        }
				        @Override
				        public void set(MaterialRippleLayout object, Integer value) {
						            object.setRippleAlpha(value);
						        }
				    };
		    public int getRippleAlpha() {
				        return paint.getAlpha();
				    }
		    public void setRippleAlpha(Integer rippleAlpha) {
				        paint.setAlpha(rippleAlpha);
				        invalidate();
				    }
		    public void setRippleColor(int rippleColor) {
				        this.rippleColor = rippleColor;
				        paint.setColor(rippleColor);
				        paint.setAlpha(rippleAlpha);
				        invalidate();
				    }
		    public void setRippleOverlay(boolean rippleOverlay) {
				        this.rippleOverlay = rippleOverlay;
				    }
		    public void setRippleDiameter(int rippleDiameter) {
				        this.rippleDiameter = rippleDiameter;
				    }
		    public void setRippleDuration(int rippleDuration) {
				        this.rippleDuration = rippleDuration;
				    }
		    public void setRippleBackground(int color) {
				        rippleBackground = new android.graphics.drawable.ColorDrawable(color);
				        rippleBackground.setBounds(bounds);
				        invalidate();
				    }
		    public void setRippleHover(boolean rippleHover) {
				        this.rippleHover = rippleHover;
				    }
		    public void setRippleDelayClick(boolean rippleDelayClick) {
				        this.rippleDelayClick = rippleDelayClick;
				    }
		    public void setRippleFadeDuration(int rippleFadeDuration) {
				        this.rippleFadeDuration = rippleFadeDuration;
				    }
		    public void setRipplePersistent(boolean ripplePersistent) {
				        this.ripplePersistent = ripplePersistent;
				    }
		    public void setRippleInAdapter(boolean rippleInAdapter) {
				        this.rippleInAdapter = rippleInAdapter;
				    }
		    public void setRippleRoundedCorners(int rippleRoundedCorner) {
				        this.rippleRoundedCorners = rippleRoundedCorner;
				        enableClipPathSupportIfNecessary();
				    }
		    public void setDefaultRippleAlpha(float alpha) {
				        this.rippleAlpha = (int) (255 * alpha);
				        paint.setAlpha(rippleAlpha);
				        invalidate();
				    }
		    public void performRipple() {
				        currentCoords = new Point(getWidth() / 2, getHeight() / 2);
				        startRipple(null);
				    }
		    public void performRipple(Point anchor) {
				        currentCoords = new Point(anchor.x, anchor.y);
				        startRipple(null);
				    }
		    private void enableClipPathSupportIfNecessary() {
				        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.JELLY_BEAN_MR1) {
						            if (rippleRoundedCorners != 0) {
								                layerType = getLayerType();
								                setLayerType(LAYER_TYPE_SOFTWARE, null);
								            } else {
								                setLayerType(layerType, null);
								            }
						        }
				    }
		    private class PerformClickEvent implements Runnable {
				        @Override public void run() {
						            if (hasPerformedLongPress) return;
						            if (getParent() instanceof AdapterView) {
								                if (!childView.performClick())
								                    clickAdapterView((AdapterView) getParent());
								            } else if (rippleInAdapter) {
								                clickAdapterView(findParentAdapterView());
								            } else {
								                childView.performClick();
								            }
						        }
				        private void clickAdapterView(AdapterView parent) {
						            final int position = parent.getPositionForView(MaterialRippleLayout.this);
						            final long itemId = parent.getAdapter() != null
						                ? parent.getAdapter().getItemId(position)
						                : 0;
						            if (position != AdapterView.INVALID_POSITION) {
								                parent.performItemClick(MaterialRippleLayout.this, position, itemId);
								            }
						        }
				    }
		    private final class PressedEvent implements Runnable {
				        private final MotionEvent event;
				        public PressedEvent(MotionEvent event) {
						            this.event = event;
						        }
				        @Override
				        public void run() {
						            prepressed = false;
						            childView.setLongClickable(false);
						            childView.onTouchEvent(event);
						            childView.setPressed(true);
						            if (rippleHover) {
								                startHover();
								            }
						        }
				    }
		    static float dpToPx(android.content.res.Resources resources, float dp) {
				        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.getDisplayMetrics());
				    }
		    public static class RippleBuilder {
				        private final Context context;
				        private final View    child;
				        private int     rippleColor         = DEFAULT_COLOR;
				        private boolean rippleOverlay       = DEFAULT_RIPPLE_OVERLAY;
				        private boolean rippleHover         = DEFAULT_HOVER;
				        private float   rippleDiameter      = DEFAULT_DIAMETER_DP;
				        private int     rippleDuration      = DEFAULT_DURATION;
				        private float   rippleAlpha         = DEFAULT_ALPHA;
				        private boolean rippleDelayClick    = DEFAULT_DELAY_CLICK;
				        private int     rippleFadeDuration  = DEFAULT_FADE_DURATION;
				        private boolean ripplePersistent    = DEFAULT_PERSISTENT;
				        private int     rippleBackground    = DEFAULT_BACKGROUND;
				        private boolean rippleSearchAdapter = DEFAULT_SEARCH_ADAPTER;
				        private float   rippleRoundedCorner = DEFAULT_ROUNDED_CORNERS;
				        public RippleBuilder(View child) {
						            this.child = child;
						            this.context = child.getContext();
						        }
				        public RippleBuilder rippleColor(int color) {
						            this.rippleColor = color;
						            return this;
						        }
				        public RippleBuilder rippleOverlay(boolean overlay) {
						            this.rippleOverlay = overlay;
						            return this;
						        }
				        public RippleBuilder rippleHover(boolean hover) {
						            this.rippleHover = hover;
						            return this;
						        }
				        public RippleBuilder rippleDiameterDp(int diameterDp) {
						            this.rippleDiameter = diameterDp;
						            return this;
						        }
				        public RippleBuilder rippleDuration(int duration) {
						            this.rippleDuration = duration;
						            return this;
						        }
				        public RippleBuilder rippleAlpha(float alpha) {
						            this.rippleAlpha = alpha;
						            return this;
						        }
				        public RippleBuilder rippleDelayClick(boolean delayClick) {
						            this.rippleDelayClick = delayClick;
						            return this;
						        }
				        public RippleBuilder rippleFadeDuration(int fadeDuration) {
						            this.rippleFadeDuration = fadeDuration;
						            return this;
						        }
				        public RippleBuilder ripplePersistent(boolean persistent) {
						            this.ripplePersistent = persistent;
						            return this;
						        }
				        public RippleBuilder rippleBackground(int color) {
						            this.rippleBackground = color;
						            return this;
						        }
				        public RippleBuilder rippleInAdapter(boolean inAdapter) {
						            this.rippleSearchAdapter = inAdapter;
						            return this;
						        }
				        public RippleBuilder rippleRoundedCorners(int radiusDp) {
						            this.rippleRoundedCorner = radiusDp;
						            return this;
						        }
				        public MaterialRippleLayout create() {
						            MaterialRippleLayout layout = new MaterialRippleLayout(context);
						            layout.setRippleColor(rippleColor);
						            layout.setDefaultRippleAlpha(rippleAlpha);
						            layout.setRippleDelayClick(rippleDelayClick);
						            layout.setRippleDiameter((int) dpToPx(context.getResources(), rippleDiameter));
						            layout.setRippleDuration(rippleDuration);
						            layout.setRippleFadeDuration(rippleFadeDuration);
						            layout.setRippleHover(rippleHover);
						            layout.setRipplePersistent(ripplePersistent);
						            layout.setRippleOverlay(rippleOverlay);
						            layout.setRippleBackground(rippleBackground);
						            layout.setRippleInAdapter(rippleSearchAdapter);
						            layout.setRippleRoundedCorners((int) dpToPx(context.getResources(), rippleRoundedCorner));
						            ViewGroup.LayoutParams params = child.getLayoutParams();
						            ViewGroup parent = (ViewGroup) child.getParent();
						            int index = 0;
						            if (parent != null && parent instanceof MaterialRippleLayout) {
								                throw new IllegalStateException("MaterialRippleLayout could not be created: parent of the view already is a MaterialRippleLayout");
								            }
						            if (parent != null) {
								                index = parent.indexOfChild(child);
								                parent.removeView(child);
								            }
						            layout.addView(child, new ViewGroup.LayoutParams(android.view.ViewGroup.LayoutParams.MATCH_PARENT, android.view.ViewGroup.LayoutParams.MATCH_PARENT));
						            if (parent != null) {
								                parent.addView(layout, index, params);
								            }
						            return layout;
						        }
				    }
	}
	{
	}
	
	public class Listview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.list, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			
			textview1.setText(Uri.parse(liststring.get((int)(_position))).getLastPathSegment());
			if (theme.getString("theme", "").equals("grad")) {
				linear1.setBackground(new GradientDrawable(GradientDrawable.Orientation.BR_TL, new int[] {0xFF9C27B0,0xFF000000}));
				textview1.setTextColor(0xFFFFFFFF);
			}
			if (theme.getString("theme", "").equals("light")) {
				textview1.setTextColor(0xFF000000);
			}
			if (theme.getString("theme", "").equals("dark")) {
				linear1.setBackground(new GradientDrawable(GradientDrawable.Orientation.BR_TL, new int[] {0xFF9C27B0,0xFF9C27B0}));
				textview1.setTextColor(0xFFFFFFFF);
			}
			
			return _view;
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