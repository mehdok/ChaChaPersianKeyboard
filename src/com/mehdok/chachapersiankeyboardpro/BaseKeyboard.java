/**
 * @author mehdi sohrabi (mehdok@gmail.com)
 * @version 1.4 
 */

package com.mehdok.chachapersiankeyboardpro;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.KeyEvent;

public class BaseKeyboard 
{
	protected int keyCode;
	protected KeyEvent event;
	protected boolean shiftState;
	protected boolean fnState;
	protected SharedPreferences sharedPreferences;
	
	public BaseKeyboard(Context context)
	{
		sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
	}
	
	public void setEvent(int code, KeyEvent e, boolean shift, boolean fn)
	{
		keyCode = code;
		event = e;
		shiftState = shift;
		//TODO fnState
		fnState = fn;
	}
	
	public char getChar()
	{
		return '0';
	}
}
