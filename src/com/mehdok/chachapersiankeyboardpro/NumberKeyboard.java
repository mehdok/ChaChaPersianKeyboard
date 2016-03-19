/**
 * @author mehdi sohrabi (mehdok@gmail.com)
 * @version 1.4 
 */

package com.mehdok.chachapersiankeyboardpro;

import android.content.Context;
import android.view.KeyEvent;

public class NumberKeyboard extends BaseKeyboard
{
	private int N_1 = 0;
	private int N_2 = 0;
	private int N_3 = 0;
	private int N_4 = 0;
	private int N_5 = 0;
	private int N_6 = 0;
	private int N_7 = 0;
	private int N_8 = 0;
	private int N_9 = 0;
	private int N_0 = 0;
	private int N_STAR = 0;
	private int N_HASHTAG = 0;
	private int N_DOT = 0;
	private int N_PLUS = 0;
	private int N_MINUS = 0;
	
	public NumberKeyboard(Context context) 
	{
		super(context);
		// TODO Auto-generated constructor "stub
		N_1 = sharedPreferences.getInt("N_1", KeyEvent.KEYCODE_W);
		N_2 = sharedPreferences.getInt("N_2", KeyEvent.KEYCODE_E);
		N_3 = sharedPreferences.getInt("N_3", KeyEvent.KEYCODE_R);
		N_4 = sharedPreferences.getInt("N_4", KeyEvent.KEYCODE_S);
		N_5 = sharedPreferences.getInt("N_5", KeyEvent.KEYCODE_D);
		N_6 = sharedPreferences.getInt("N_6", KeyEvent.KEYCODE_F);
		N_7 = sharedPreferences.getInt("N_7", KeyEvent.KEYCODE_Z);
		N_8 = sharedPreferences.getInt("N_8", KeyEvent.KEYCODE_X);
		N_9 = sharedPreferences.getInt("N_9", KeyEvent.KEYCODE_C);
		N_0 = sharedPreferences.getInt("N_0", 116);
		N_STAR = sharedPreferences.getInt("N_STAR", 118);
		N_HASHTAG = sharedPreferences.getInt("N_HASHTAG", KeyEvent.KEYCODE_COMMA);
		N_DOT = sharedPreferences.getInt("N_DOT", KeyEvent.KEYCODE_PERIOD);
		N_PLUS = sharedPreferences.getInt("N_PLUS", KeyEvent.KEYCODE_K);
		N_MINUS = sharedPreferences.getInt("N_MINUS", KeyEvent.KEYCODE_J);
	}

	@Override
	public char getChar()
	{
		if(keyCode == N_1)
		{
			return ('\u0031');
		}
		else if(keyCode == N_2)
		{
			return ('\u0032');
		}
		else if(keyCode == N_3)
		{
			return ('\u0033');
		}
		else if(keyCode == N_4)
		{
			return ('\u0034');
		}
		else if(keyCode == N_5)
		{
			return ('\u0035');
		}
		else if(keyCode == N_6)
		{
			return('\u0036');
		}
		else if(keyCode == N_7)
		{
			return('\u0037');
		}
		else if(keyCode == N_8)
		{
			return ('\u0038');
		}
		else if(keyCode == N_9)
		{
			return ('\u0039');
		}
		else if(keyCode == N_0)
		{
			return ('\u0030');
		}
		else if(keyCode == N_STAR)
		{
			return ('\u002A');
		}
		else if(keyCode == N_HASHTAG)
		{
			return('\u0023');
		}
		else if(keyCode == N_DOT)
		{
			return ('\u002E');
		}
		else if(keyCode == N_PLUS)
		{
			return ('\u002B');
		}
		else if(keyCode == N_MINUS)
		{
			return ('\u002D');
		}
		else
		{
			return ('\u0000');
		}
	}
}
