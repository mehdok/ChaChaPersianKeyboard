/**
 * @author mehdi sohrabi (mehdok@gmail.com)
 * @version 1.4 
 */

package com.mehdok.chachapersiankeyboardpro;

import java.util.ArrayList;
import java.util.List;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class KeyMapActivity extends FragmentActivity
{
	MyPageAdapter pageAdapter;
	ViewPager pager;
	SharedPreferences sharedPreferences;
	//public boolean captureFlag = false;
	//public TextView globalCurrKey;
	public int globalPressedKey = 0;
	
	public View keyMapView;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keymap);
        
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        
        List<Fragment> fragments = getFragments();
	    pageAdapter = new MyPageAdapter(getSupportFragmentManager(), fragments);
	    pager = (ViewPager)findViewById(R.id.viewpager);
	    pager.setAdapter(pageAdapter);
	    
	    LinePageIndicator tilt = (LinePageIndicator)findViewById(R.id.linepager);
	    tilt.setViewPager(pager);
	    
	    keyMapView =  getLayoutInflater().inflate(R.layout.keymap_page1, null);
    }
	
	  class MyPageAdapter extends FragmentPagerAdapter
	  {
		  private List<Fragment> fragments;
		  public MyPageAdapter(FragmentManager fm, List<Fragment> fragments) 
		  {
		    super(fm);
		    this.fragments = fragments;
		  }

		  @Override 
		  public Fragment getItem(int position) 
		  {
			 // System.out.println(position);
		    return this.fragments.get(position);		    
		  }

		  @Override
		  public int getCount() 
		  {
		    return this.fragments.size();
		  }
	  }
	
	  private List<Fragment> getFragments()
	  {
		  List<Fragment> fList = new ArrayList<Fragment>(); 

		  fList.add(MyFragment.newInstance(R.layout.keymap_guide));
		  fList.add(MyFragment.newInstance(R.layout.keymap_page1));
		  fList.add(MyFragment.newInstance(R.layout.keymap_page2)); 
		  fList.add(MyFragment.newInstance(R.layout.keymap_page3));
		  fList.add(MyFragment.newInstance(R.layout.keymap_page4));
		  fList.add(MyFragment.newInstance(R.layout.keymap_page5));

		  return fList;
	  }
	
	  @Override
	  public void onBackPressed()
	  {
		  int currPosition = pager.getCurrentItem();
		  if(currPosition == 0)
			  super.onBackPressed();
		  else
			  pager.setCurrentItem(--currPosition);
	  }
	
	  @Override
	  public void onResume()
	  {
		  super.onResume();
		  overridePendingTransition(R.anim.from_middle, R.anim.to_middle);
	  }
	  
	  @Override
	  public void onPause()
	  {
		  super.onPause();
		  overridePendingTransition(R.anim.from_middle, R.anim.to_middle);
	  }
	  
	  public void changeKeyMethod(View theButton)
	  {
		  //captureFlag = true;
		  
		  Button pressedButt = (Button)theButton;
		  String pressedButtText = (String) pressedButt.getTag();
		  String pressedButtHint = (String) pressedButt.getHint();
		  //test
		  //String preftext = (String) pressedButt.geti
		  //System.out.println(pressedButtText);
		  
		  LayoutInflater lInflater = getLayoutInflater();
		  View view = lInflater.inflate(R.layout.change_key_dialog, null);
		  TextView keyToChange = (TextView)view.findViewById(R.id.keyToChange);
		  TextView currKey = (TextView)view.findViewById(R.id.currKey);
		  //globalCurrKey = currKey;
		  
		  keyToChange.setText(pressedButtHint);
		  
		  int key = sharedPreferences.getInt((String) pressedButtText, 118);		
		  KeyEvent event = new KeyEvent(KeyEvent.ACTION_DOWN, key);
		  char keyName =event.getDisplayLabel();
		  String result = "";
		  if(Character.isLetter(keyName))
			  result = String.valueOf(keyName);
		  else
			  result = String.valueOf(key);
		  currKey.setText(result);
		  
		  AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
		  dialogBuilder.setView(view);
		  //set button
		  ChangeKeyDialogButtonListener rdbl = new ChangeKeyDialogButtonListener(pressedButtText, pressedButt /*pressedKey*/);
		  dialogBuilder.setPositiveButton(R.string.ok, rdbl);
		  dialogBuilder.setNegativeButton(R.string.cancel, rdbl);
		  ChangeKeyDialogKeyListener ckdkl = new ChangeKeyDialogKeyListener(currKey);		  
		  dialogBuilder.setOnKeyListener(ckdkl);
		  AlertDialog changeKeyDialog = dialogBuilder.create();
		  changeKeyDialog.show();
	  }
	  
	  private class ChangeKeyDialogButtonListener implements android.content.DialogInterface.OnClickListener
	  {
		  private String preferencesKey = "";
		  private Button mButton;
		  
		  public ChangeKeyDialogButtonListener(String prefKey, Button butt)
		  {
			  preferencesKey = prefKey;
			  mButton = butt;
		  }

		  @Override
		  public void onClick(DialogInterface dialog, int which)
		  {
			  // TODO Auto-generated method stub
			  if(which == DialogInterface.BUTTON1)
			  {
				  //System.out.println("ok pressed");
				  sharedPreferences.edit().putInt(preferencesKey, globalPressedKey).commit();
				  //keyMapView.invalidate();
				  refreshButton(mButton);
				  //mButton.postInvalidate();
				  //System.out.println(sharedPreferences.getInt(preferencesKey, 0));
			  }
		  }		  
	  }
	  
	  private class ChangeKeyDialogKeyListener implements android.content.DialogInterface.OnKeyListener
	  {
		  private TextView textView;
		  
		  public ChangeKeyDialogKeyListener(TextView tx)
		  {
			  textView = tx;
		  }
		  @Override
		  public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) 
		  {
			  if(keyCode == KeyEvent.KEYCODE_BACK)
			  {
				  dialog.dismiss();
				  return false;
			  }
			  else 
			  {
				  //char keyName =event.getDisplayLabel();
				  //System.out.println(keyName);
				  globalPressedKey = keyCode;
				  
				  char keyName =event.getDisplayLabel();
				  String result = "";
				  if(Character.isLetter(keyName))
					  result = String.valueOf(keyName);
				  else
					  result = String.valueOf(keyCode);
				  
				  textView.setText(result);
				  return true;
				  
				  
			  }
		  }		  
	  }
	  /*
	  public boolean onKeyDown(int keyCode, KeyEvent event)
	  {
		  System.out.println("reached onkydown");
		  if(captureFlag)
		  {
			  globalPressedKey = keyCode;
			  
			  char keyName =event.getDisplayLabel();
			  String result = "";
			  if(Character.isLetter(keyName))
				  result = String.valueOf(keyName);
			  else
				  result = String.valueOf(globalPressedKey);
			  
			  //globalCurrKey.setText(event.getDisplayLabel());
			  
			  return true;
		  }
		  else
			  return false;
	  }
	  */
	  
	  public void refreshButton(Button butt)
	  {
		  //keyMapView.invalidate();
		  //int key = sharedPreferences.getInt((String) name, 118);		
		  KeyEvent event = new KeyEvent(KeyEvent.ACTION_DOWN, globalPressedKey);
		  char keyName =/* (char)event.getUnicodeChar(); */event.getDisplayLabel();		
		  //System.out.println(keyName);
		  String result = "";
		  if(Character.isLetter(keyName))
			  result = String.valueOf(keyName);
		  else
			  result = String.valueOf(globalPressedKey);
		  butt.setText(result);
	  }
	  
	  public void persianDefaultKeyMethod(View theButton)
	  {
		  SetPreferences.persianKeyDefault(this);
		  Toast.makeText(this, R.string.reset_preferences_message, Toast.LENGTH_LONG).show();
	  }
	  
	  public void specialDefaultKeyMethod(View theButton)
	  {
		  SetPreferences.specialKeyDefault(this);
		  Toast.makeText(this, R.string.reset_preferences_message, Toast.LENGTH_LONG).show();
	  }
	  
	  public void englishDefaultKeyMethod(View theButton)
	  {
		  SetPreferences.englishKeyDefault(this);
		  Toast.makeText(this, R.string.reset_preferences_message, Toast.LENGTH_LONG).show();
	  }
	  
	  public void symbolDefaultKeyMethod(View theButton)
	  {
		  SetPreferences.symbolKeyDefault(this);
		  Toast.makeText(this, R.string.reset_preferences_message, Toast.LENGTH_LONG).show();
	  }
	  
	  public void numberDefaultKeyMethod(View theButton)
	  {
		  SetPreferences.numberKeyDefault(this);
		  Toast.makeText(this, R.string.reset_preferences_message, Toast.LENGTH_LONG).show();
	  }
}
