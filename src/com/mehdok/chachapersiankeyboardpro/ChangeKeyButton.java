/**
 * @author mehdi sohrabi (mehdok@gmail.com)
 * @version 1.4 
 */

package com.mehdok.chachapersiankeyboardpro;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.widget.Button;

public class ChangeKeyButton extends Button 
{

	public ChangeKeyButton(Context context, AttributeSet attrs, int defStyle) 
	{
		super(context, attrs, defStyle);
		init(context);
	}
	
	public ChangeKeyButton(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		init(context);
	}
	
	public ChangeKeyButton(Context context)
	{
		super(context);
		init(context);
	}
	
	private void init(Context con)
	{
		//System.out.println(System.currentTimeMillis());
		Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "FreeFarsi-Bold.ttf");
		setTypeface(tf);
		
		CharSequence name = getText();
		//System.out.println(name);		
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(con);		
		int key = sharedPreferences.getInt((String) name, 118);		
		KeyEvent event = new KeyEvent(KeyEvent.ACTION_DOWN, key);
		char keyName =/* (char)event.getUnicodeChar(); */event.getDisplayLabel();		
		//System.out.println(keyName);
		String result = "";
		if(Character.isLetter(keyName))
			result = String.valueOf(keyName);
		else
			result = String.valueOf(key);
		setText(result);
		//System.out.println(System.currentTimeMillis());
		
	}
	

}