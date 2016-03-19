/**
 * @author mehdi sohrabi (mehdok@gmail.com)
 * @version 1.4 
 */

package com.mehdok.chachapersiankeyboardpro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

public class MainActivity extends FragmentActivity 
{	
	@Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); 
        
        //set preferences
        SetPreferences.setPersianKey(this);
        SetPreferences.setEnglishKey(this);
        SetPreferences.setSymbolKey(this);
        SetPreferences.setNumberKey(this);
        SetPreferences.setSpecialKey(this);
    }
	
	public void guideButtonMethod(View theButton)
	{
		Intent guideIntent = new Intent(MainActivity.this, GuideActivity.class);
		guideIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		MainActivity.this.startActivity(guideIntent);
	}
	
	public void keyMapButtonMethod(View theButton)
	{
		Intent keymapIntent = new Intent(MainActivity.this, KeyMapActivity.class);
		keymapIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		MainActivity.this.startActivity(keymapIntent);
	}
	
	public void aboutButtonMethod(View theButton)
	{
		Intent aboutIntent = new Intent(MainActivity.this, AboutActivity.class);
		aboutIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		MainActivity.this.startActivity(aboutIntent);
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
}