package com.protecgames.htmleditor;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.DialogInterface;
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

public class SettingActivity extends AppCompatActivity {
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	
	private LinearLayout linear1;
	private TextView textview1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private TextView textview6;
	private LinearLayout linear4;
	private TextView textview9;
	private LinearLayout linear5;
	private LinearLayout linear7;
	private TextView textview2;
	private TextView textview3;
	private TextView textview4;
	private TextView textview5;
	private TextView textview7;
	private TextView textview8;
	private TextView textview10;
	private TextView textview11;
	private TextView textview12;
	private TextView textview13;
	
	private AlertDialog.Builder version;
	private AlertDialog.Builder changelog;
	private Intent i = new Intent();
	private AlertDialog.Builder d;
	private SharedPreferences theme;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.setting);
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
		linear1 = findViewById(R.id.linear1);
		textview1 = findViewById(R.id.textview1);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		textview6 = findViewById(R.id.textview6);
		linear4 = findViewById(R.id.linear4);
		textview9 = findViewById(R.id.textview9);
		linear5 = findViewById(R.id.linear5);
		linear7 = findViewById(R.id.linear7);
		textview2 = findViewById(R.id.textview2);
		textview3 = findViewById(R.id.textview3);
		textview4 = findViewById(R.id.textview4);
		textview5 = findViewById(R.id.textview5);
		textview7 = findViewById(R.id.textview7);
		textview8 = findViewById(R.id.textview8);
		textview10 = findViewById(R.id.textview10);
		textview11 = findViewById(R.id.textview11);
		textview12 = findViewById(R.id.textview12);
		textview13 = findViewById(R.id.textview13);
		version = new AlertDialog.Builder(this);
		changelog = new AlertDialog.Builder(this);
		d = new AlertDialog.Builder(this);
		theme = getSharedPreferences("theme", Activity.MODE_PRIVATE);
		
		linear2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), AccountActivity.class);
				startActivity(i);
			}
		});
		
		linear3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				UnityAds.show(SettingActivity.this, "Interstitial_Android");
				d.setTitle("Theme");
				d.setIcon(R.drawable.ic_brightness_4_grey);
				d.setPositiveButton("Dark", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						theme.edit().putString("theme", "dark").commit();
						i.setClass(getApplicationContext(), SettingActivity.class);
						startActivity(i);
					}
				});
				d.setNegativeButton("Light", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						theme.edit().putString("theme", "light").commit();
						i.setClass(getApplicationContext(), SettingActivity.class);
						startActivity(i);
					}
				});
				d.setNeutralButton("Gradient (BETA)", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						theme.edit().putString("theme", "grad").commit();
						i.setClass(getApplicationContext(), SettingActivity.class);
						startActivity(i);
					}
				});
				d.create().show();
			}
		});
		
		linear4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setAction(Intent.ACTION_VIEW);
				i.setData(Uri.parse("mailto:protecgamesofficial@gmail.com"));
				startActivity(i);
			}
		});
		
		linear7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), WhatnewActivity.class);
				startActivity(i);
			}
		});
	}
	
	private void initializeLogic() {
		UnityAds.initialize(this, "5122862", false, false);
		setTitle("Settings");
		
		
		
		
		
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview9.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview8.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview10.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview11.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview12.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview13.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		if (theme.getString("theme", "").equals("grad")) {
			linear1.setBackground(new GradientDrawable(GradientDrawable.Orientation.BR_TL, new int[] {0xFF9C27B0,0xFF000000}));
			textview1.setTextColor(0xFFFFFFFF);
			textview4.setTextColor(0xFFFFFFFF);
			textview7.setTextColor(0xFFFFFFFF);
			textview2.setTextColor(0xFFFFFFFF);
		}
		if (theme.getString("theme", "").equals("light")) {
			linear1.setBackgroundColor(Color.TRANSPARENT);
		}
		if (theme.getString("theme", "").equals("dark")) {
			linear1.setBackgroundColor(0xFF000000);
			textview1.setTextColor(0xFFFFFFFF);
			textview4.setTextColor(0xFFFFFFFF);
			textview7.setTextColor(0xFFFFFFFF);
			textview10.setTextColor(0xFFFFFFFF);
			textview12.setTextColor(0xFFFFFFFF);
			textview2.setTextColor(0xFFFFFFFF);
		}
	}
	
	@Override
	public void onBackPressed() {
		i.setClass(getApplicationContext(), MainActivity.class);
		startActivity(i);
		finish();
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