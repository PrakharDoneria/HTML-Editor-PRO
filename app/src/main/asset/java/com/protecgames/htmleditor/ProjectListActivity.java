package com.protecgames.htmleditor;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
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
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
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
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
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
import java.io.File;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.antlr.v4.runtime.*;
import org.json.*;

public class ProjectListActivity extends AppCompatActivity {
	
	public final int REQ_CD_FP = 101;
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private FloatingActionButton _fab;
	private String path = "";
	private String path_name = "";
	private HashMap<String, Object> map = new HashMap<>();
	
	private ArrayList<HashMap<String, Object>> project = new ArrayList<>();
	private ArrayList<String> fileurl = new ArrayList<>();
	
	private ListView listview1;
	
	private FirebaseAuth auth;
	private OnCompleteListener<AuthResult> _auth_create_user_listener;
	private OnCompleteListener<AuthResult> _auth_sign_in_listener;
	private OnCompleteListener<Void> _auth_reset_password_listener;
	private OnCompleteListener<Void> auth_updateEmailListener;
	private OnCompleteListener<Void> auth_updatePasswordListener;
	private OnCompleteListener<Void> auth_emailVerificationSentListener;
	private OnCompleteListener<Void> auth_deleteUserListener;
	private OnCompleteListener<Void> auth_updateProfileListener;
	private OnCompleteListener<AuthResult> auth_phoneAuthListener;
	private OnCompleteListener<AuthResult> auth_googleSignInListener;
	
	private StorageReference projects = _firebase_storage.getReference("projects");
	private OnCompleteListener<Uri> _projects_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _projects_download_success_listener;
	private OnSuccessListener _projects_delete_success_listener;
	private OnProgressListener _projects_upload_progress_listener;
	private OnProgressListener _projects_download_progress_listener;
	private OnFailureListener _projects_failure_listener;
	
	private DatabaseReference fdb = _firebase.getReference("fdb");
	private ChildEventListener _fdb_child_listener;
	private Intent fp = new Intent(Intent.ACTION_GET_CONTENT);
	private Intent i = new Intent();
	private TimerTask t;
	private AlertDialog.Builder d;
	private SharedPreferences username;
	private SharedPreferences theme;
	private DatabaseReference users = _firebase.getReference("users");
	private ChildEventListener _users_child_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.project_list);
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
		
		listview1 = findViewById(R.id.listview1);
		auth = FirebaseAuth.getInstance();
		fp.setType("text/*");
		fp.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		d = new AlertDialog.Builder(this);
		username = getSharedPreferences("username", Activity.MODE_PRIVATE);
		theme = getSharedPreferences("theme", Activity.MODE_PRIVATE);
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(fp, REQ_CD_FP);
			}
		});
		
		_projects_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				final AlertDialog loading = new AlertDialog.Builder(ProjectListActivity.this).create();
				View inflate = getLayoutInflater ().inflate(R.layout.loading, null);
				loading.setView(inflate);
				loading.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
				final
				ProgressBar prog = (ProgressBar)inflate.findViewById(R.id.prog);
				final
				LinearLayout prog_bg = (LinearLayout)inflate.findViewById(R.id.prog_bg);
				{
					android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
					int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
					SketchUi.setColor(0xFFFFFFFF);
					SketchUi.setCornerRadius(d*19);
					prog_bg.setElevation(d*5);
					prog_bg.setBackground(SketchUi);
				}
				loading.show();
			}
		};
		
		_projects_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				final AlertDialog loading = new AlertDialog.Builder(ProjectListActivity.this).create();
				View inflate = getLayoutInflater ().inflate(R.layout.loading, null);
				loading.setView(inflate);
				loading.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
				final
				ProgressBar prog = (ProgressBar)inflate.findViewById(R.id.prog);
				final
				LinearLayout prog_bg = (LinearLayout)inflate.findViewById(R.id.prog_bg);
				{
					android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
					int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
					SketchUi.setColor(0xFFFFFFFF);
					SketchUi.setCornerRadius(d*19);
					prog_bg.setElevation(d*5);
					prog_bg.setBackground(SketchUi);
				}
				loading.show();
			}
		};
		
		_projects_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				map = new HashMap<>();
				map.put("File", _downloadUrl);
				map.put("FileName", path_name);
				map.put("Username", username.getString("id", ""));
				map.put("Verified", "false");
				fdb.push().updateChildren(map);
				map.clear();
				i.setClass(getApplicationContext(), ProjectListActivity.class);
				startActivity(i);
			}
		};
		
		_projects_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				d.setTitle("Success!");
				d.setMessage("Project downloaded in Downloads Folder!");
				d.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						final AlertDialog loading = new AlertDialog.Builder(ProjectListActivity.this).create();
						View inflate = getLayoutInflater ().inflate(R.layout.loading, null);
						loading.setView(inflate);
						loading.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
						final
						ProgressBar prog = (ProgressBar)inflate.findViewById(R.id.prog);
						final
						LinearLayout prog_bg = (LinearLayout)inflate.findViewById(R.id.prog_bg);
						{
							android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
							int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
							SketchUi.setColor(0xFFFFFFFF);
							SketchUi.setCornerRadius(d*19);
							prog_bg.setElevation(d*5);
							prog_bg.setBackground(SketchUi);
						}
						loading.setCancelable(true);
						loading.hide();
						i.setClass(getApplicationContext(), ProjectListActivity.class);
						startActivity(i);
					}
				});
				d.create().show();
			}
		};
		
		_projects_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_projects_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				SketchwareUtil.showMessage(getApplicationContext(), _message);
			}
		};
		
		_fdb_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				fdb.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						project = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								project.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						listview1.setAdapter(new Listview1Adapter(project));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				fdb.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						project = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								project.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						listview1.setAdapter(new Listview1Adapter(project));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		fdb.addChildEventListener(_fdb_child_listener);
		
		_users_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		users.addChildEventListener(_users_child_listener);
		
		auth_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		auth_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_auth_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		fdb.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot _dataSnapshot) {
				project = new ArrayList<>();
				try {
					GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
					for (DataSnapshot _data : _dataSnapshot.getChildren()) {
						HashMap<String, Object> _map = _data.getValue(_ind);
						project.add(_map);
					}
				}
				catch (Exception _e) {
					_e.printStackTrace();
				}
				listview1.setAdapter(new Listview1Adapter(project));
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
			}
			@Override
			public void onCancelled(DatabaseError _databaseError) {
			}
		});
		if (username.contains("id")) {
			if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
				setTitle("Projects List");
			}
			else {
				i.setClass(getApplicationContext(), AccountActivity.class);
				startActivity(i);
				finish();
			}
		}
		else {
			i.setClass(getApplicationContext(), AccountActivity.class);
			startActivity(i);
		}
		if (theme.getString("theme", "").equals("grad")) {
			listview1.setBackground(new GradientDrawable(GradientDrawable.Orientation.BR_TL, new int[] {0xFF9C27B0,0xFF000000}));
		}
		if (theme.getString("theme", "").equals("light")) {
			listview1.setBackgroundColor(Color.TRANSPARENT);
		}
		if (theme.getString("theme", "").equals("dark")) {
			listview1.setBackgroundColor(0xFF000000);
		}
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_FP:
			if (_resultCode == Activity.RESULT_OK) {
				ArrayList<String> _filePath = new ArrayList<>();
				if (_data != null) {
					if (_data.getClipData() != null) {
						for (int _index = 0; _index < _data.getClipData().getItemCount(); _index++) {
							ClipData.Item _item = _data.getClipData().getItemAt(_index);
							_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _item.getUri()));
						}
					}
					else {
						_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _data.getData()));
					}
				}
				path = _filePath.get((int)(0));
				path_name = Uri.parse(path).getLastPathSegment();
				if (path.endsWith(".html")) {
					projects.child(path_name).putFile(Uri.fromFile(new File(path))).addOnFailureListener(_projects_failure_listener).addOnProgressListener(_projects_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
						@Override
						public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
							return projects.child(path_name).getDownloadUrl();
						}}).addOnCompleteListener(_projects_upload_success_listener);
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Invalid File");
				}
			}
			else {
				
			}
			break;
			default:
			break;
		}
	}
	
	@Override
	public void onBackPressed() {
		i.setClass(getApplicationContext(), MainActivity.class);
		startActivity(i);
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
				_view = _inflater.inflate(R.layout.projects, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final ImageView imageview2 = _view.findViewById(R.id.imageview2);
			
			textview1.setText(project.get((int)(project.size() - 1) - _position).get("FileName").toString());
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					path = Uri.parse(Uri.parse(project.get((int)(project.size() - 1) - _position).get("File").toString()).getLastPathSegment()).getLastPathSegment();
					path_name = FileUtil.getPublicDir(Environment.DIRECTORY_DOWNLOADS).concat("/".concat(path));
					_firebase_storage.getReferenceFromUrl(project.get((int)(project.size() - 1) - _position).get("File").toString()).getFile(new File(path_name)).addOnSuccessListener(_projects_download_success_listener).addOnFailureListener(_projects_failure_listener).addOnProgressListener(_projects_download_progress_listener);
				}
			});
			if (project.get((int)(project.size() - 1) - _position).containsKey("Verified")) {
				if (project.get((int)(project.size() - 1) - _position).get("Verified").toString().equals("true")) {
					imageview2.setVisibility(View.VISIBLE);
				}
				else {
					imageview2.setVisibility(View.INVISIBLE);
				}
			}
			
			imageview2.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					SketchwareUtil.showMessage(getApplicationContext(), "MASTER PROJECT");
				}
			});
			linear1.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View _view) {
					SketchwareUtil.showMessage(getApplicationContext(), "A project by: ".concat(project.get((int)(project.size() - 1) - _position).get("Username").toString()));
					return true;
				}
			});
			
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