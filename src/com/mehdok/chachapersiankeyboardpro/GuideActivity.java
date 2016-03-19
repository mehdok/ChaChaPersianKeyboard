/**
 * @author mehdi sohrabi (mehdok@gmail.com)
 * @version 1.4 
 */

package com.mehdok.chachapersiankeyboardpro;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
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
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GuideActivity extends FragmentActivity 
{
	MyPageAdapter pageAdapter;
	ViewPager pager;
	
	//View page4View;
	//Button aButt;
	
	//SharedPreferences sharedPreferences;
	/*
	String page11;
	String page12;
	String page13;
	String page14;
	
	TextView page11T;
	TextView page12T;
	TextView page13T;
	TextView page14T;
	*/
	
	@Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        
        //sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        
       // LayoutInflater li = getLayoutInflater();
       // page4View = li.inflate(R.layout.page4, null);
        //aButt = (Button)page4View.findViewById(R.id.aButt);
        
        //int key = sharedPreferences.getInt("B_EN", 0);
		//KeyEvent event = new KeyEvent(KeyEvent.ACTION_DOWN, key);
		//String keyName = event.getCharacters();
		//aButt.setText(keyName);
        
        
        /*
        page11 = getResources().getString(R.string.page1_step1);
        page12 = getResources().getString(R.string.page1_step2);
        page13 = getResources().getString(R.string.page1_step3);
        page14 = getResources().getString(R.string.page1_lastStep);
        */
        
        List<Fragment> fragments = getFragments();
	    pageAdapter = new MyPageAdapter(getSupportFragmentManager(), fragments);
	    pager = (ViewPager)findViewById(R.id.viewpager);
	    pager.setAdapter(pageAdapter);
	    
	    LinePageIndicator tilt = (LinePageIndicator)findViewById(R.id.linepager);
	    tilt.setViewPager(pager);
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

		  fList.add(MyFragment.newInstance(R.layout.page1));
		  fList.add(MyFragment.newInstance(R.layout.page2)); 
		  fList.add(MyFragment.newInstance(R.layout.page3));
		  //fList.add(MyFragment.newInstance(R.layout.page4));
		  //fList.add(MyFragment.newInstance(R.layout.page5));

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
	  
	  public void openLangSettingMethod(View theButton)
	  {
		  startActivity(new Intent(android.provider.Settings.ACTION_INPUT_METHOD_SETTINGS));
	  }
	  
	  /*
	  @Override
	  public boolean onKeyDown(int keyCode, KeyEvent event)
	  {
		  return false;
	  }
	  
	  public void aKeyButtonMethod(View theButton)
	  {
		  System.out.println("clicked");
		  aButt.setVisibility(View.INVISIBLE);
		  
	  }
	  */
	  
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

}
