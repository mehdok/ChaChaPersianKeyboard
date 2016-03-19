/**
 * @author mehdi sohrabi (mehdok@gmail.com)
 * @version 1.4 
 */

package com.mehdok.chachapersiankeyboardpro;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

public class MehdokButton extends Button 
{

	public MehdokButton(Context context, AttributeSet attrs, int defStyle) 
	{
		super(context, attrs, defStyle);
		init();
	}
	
	public MehdokButton(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		init();
	}
	
	public MehdokButton(Context context)
	{
		super(context);
		init();
	}
	
	private void init()
	{
		Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "FreeFarsi-Bold.ttf");
		setTypeface(tf);
	}
	

}