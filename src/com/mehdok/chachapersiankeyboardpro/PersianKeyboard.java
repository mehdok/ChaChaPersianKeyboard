/**
 * @author mehdi sohrabi (mehdok@gmail.com)
 * @version 1.4 
 */

package com.mehdok.chachapersiankeyboardpro;

import android.content.Context;
import android.view.KeyEvent;

public class PersianKeyboard extends BaseKeyboard
{
	private int ZAD_FA = 0;
	private int SAD_FA = 0;
	private int GHAF_FA = 0;
	private int FAV_FA = 0;
	private int GHEIN_FA = 0;
	private int EEIN_FA = 0;
	private int HA_FA = 0;
	private int KHE_FA = 0;
	private int HE_FA = 0;
	private int JIM_FA = 0;
	private int SHIN_FA = 0;
	private int SIN_FA = 0;
	private int YA_FA = 0;
	private int BE_FA = 0;
	private int LAM_FA = 0;
	private int ALEF_FA = 0;
	private int TE_FA = 0;
	private int NON_FA = 0;
	private int MIM_FA = 0;
	private int ZAL_FA = 0;
	private int DAL_FA = 0;
	private int RE_FA = 0;
	private int SE_FA = 0;
	private int WAW_FA = 0;
	private int ZE_FA = 0;
	private int ZA_FA = 0;
	private int TA_FA = 0;
	private int KAF_FA = 0;
	private int COMMA_FA = 0;
	
	private int S_LEFT_PARENTHESIS = 0; //(
	private int S_N_1 = 0; //1
	private int S_N_2 = 0; //2
	private int S_N_3 = 0; //3
	private int S_EXCLAMATION = 0; //!
	private int S_AT_SIGN = 0; //@
	private int S_DOLLAR = 0; //$
	private int S_PERCENT = 0; //%
	private int S_AMPERSAND = 0; //&
	private int S_TILDE = 0; //~
	private int S_RIGHT_PARENTHESIS = 0; //)
	private int S_N_4 = 0; //4
	private int S_N_5 = 0; //5
	private int S_N_6 = 0; //6
	private int S_SLASH = 0; // /
	private int S_UNDERLINE = 0; // _
	private int S_MINUS = 0; //-
	private int S_PLUS = 0; //+
	private int S_EQUAL = 0; //=
	private int S_N_7 = 0; //7
	private int S_N_8 = 0; //8
	private int S_N_9 = 0; //9
	private int S_EURO = 0;
	private int S_APOSTROPHE = 0; //'
	private int S_QUOTATION = 0; //"
	private int S_COLON = 0; //:
	private int S_SEMICOLON = 0; //;
	private int S_ASTERISK = 0; //*
	private int S_N_0 = 0; //0
	private int S_HASHTAG = 0; //#
	
	
	public PersianKeyboard(Context context) 
	{
		super(context);
		// TODO Auto-generated constructor stub
		ZAD_FA = sharedPreferences.getInt("ZAD_FA",KeyEvent.KEYCODE_Q);
		SAD_FA = sharedPreferences.getInt("SAD_FA",KeyEvent.KEYCODE_W);
		GHAF_FA = sharedPreferences.getInt("GHAF_FA",KeyEvent.KEYCODE_E);
		FAV_FA = sharedPreferences.getInt("FAV_FA",KeyEvent.KEYCODE_R);
		GHEIN_FA = sharedPreferences.getInt("GHEIN_FA",KeyEvent.KEYCODE_T);
		EEIN_FA = sharedPreferences.getInt("EEIN_FA",KeyEvent.KEYCODE_Y);
		HA_FA = sharedPreferences.getInt("HA_FA",KeyEvent.KEYCODE_U);
		KHE_FA = sharedPreferences.getInt("KHE_FA",KeyEvent.KEYCODE_I);
		HE_FA = sharedPreferences.getInt("HE_FA",KeyEvent.KEYCODE_O);
		JIM_FA = sharedPreferences.getInt("JIM_FA",KeyEvent.KEYCODE_P);
		SHIN_FA = sharedPreferences.getInt("SHIN_FA",KeyEvent.KEYCODE_A);
		SIN_FA = sharedPreferences.getInt("SIN_FA",KeyEvent.KEYCODE_S);
		YA_FA = sharedPreferences.getInt("YA_FA",KeyEvent.KEYCODE_D);
		BE_FA = sharedPreferences.getInt("BE_FA",KeyEvent.KEYCODE_F);
		LAM_FA = sharedPreferences.getInt("LAM_FA",KeyEvent.KEYCODE_G);
		ALEF_FA = sharedPreferences.getInt("ALEF_FA",KeyEvent.KEYCODE_H);
		TE_FA = sharedPreferences.getInt("TE_FA",KeyEvent.KEYCODE_J);
		NON_FA = sharedPreferences.getInt("NON_FA",KeyEvent.KEYCODE_K);
		MIM_FA = sharedPreferences.getInt("MIM_FA",KeyEvent.KEYCODE_L);
		ZAL_FA = sharedPreferences.getInt("ZAL_FA",KeyEvent.KEYCODE_Z);
		DAL_FA = sharedPreferences.getInt("DAL_FA",KeyEvent.KEYCODE_X);
		RE_FA = sharedPreferences.getInt("RE_FA",KeyEvent.KEYCODE_C);
		SE_FA = sharedPreferences.getInt("SE_FA",KeyEvent.KEYCODE_V);
		WAW_FA = sharedPreferences.getInt("VAV_FA",KeyEvent.KEYCODE_B);		
		ZE_FA = sharedPreferences.getInt("ZE_FA",KeyEvent.KEYCODE_N);
		ZA_FA = sharedPreferences.getInt("ZA_FA",KeyEvent.KEYCODE_M);
		TA_FA = sharedPreferences.getInt("TA_FA",124);
		KAF_FA = sharedPreferences.getInt("KAF_FA",KeyEvent.KEYCODE_PERIOD);
		COMMA_FA = sharedPreferences.getInt("COMMA_FA", KeyEvent.KEYCODE_COMMA);
		
		S_LEFT_PARENTHESIS = sharedPreferences.getInt("S_LEFT_PARENTHESIS",KeyEvent.KEYCODE_Q);
		S_N_1 = sharedPreferences.getInt("S_N_1",KeyEvent.KEYCODE_W);
		S_N_2 = sharedPreferences.getInt("S_N_2",KeyEvent.KEYCODE_E);
		S_N_3 = sharedPreferences.getInt("S_N_3",KeyEvent.KEYCODE_R);
		S_EXCLAMATION = sharedPreferences.getInt("S_EXCALAMATION",KeyEvent.KEYCODE_T);
		S_AT_SIGN = sharedPreferences.getInt("S_AT_SIGN",KeyEvent.KEYCODE_Y);
		S_DOLLAR = sharedPreferences.getInt("S_DOLLAR",KeyEvent.KEYCODE_U);
		S_PERCENT = sharedPreferences.getInt("S_PERCENT",KeyEvent.KEYCODE_I);
		S_AMPERSAND = sharedPreferences.getInt("S_AMPERSAND",KeyEvent.KEYCODE_O);
		S_TILDE = sharedPreferences.getInt("S_TILDE",KeyEvent.KEYCODE_P);
		S_RIGHT_PARENTHESIS = sharedPreferences.getInt("S_RIGHT_PARENTHESIS",KeyEvent.KEYCODE_A);
		S_N_4 = sharedPreferences.getInt("S_N_4",KeyEvent.KEYCODE_S);
		S_N_5 = sharedPreferences.getInt("S_N_5",KeyEvent.KEYCODE_D);
		S_N_6 = sharedPreferences.getInt("S_N_6",KeyEvent.KEYCODE_F);
		S_SLASH = sharedPreferences.getInt("S_SLASH",KeyEvent.KEYCODE_G);
		S_UNDERLINE = sharedPreferences.getInt("S_UNDERLINE",KeyEvent.KEYCODE_H);
		S_MINUS = sharedPreferences.getInt("S_MINUS",KeyEvent.KEYCODE_J);
		S_PLUS = sharedPreferences.getInt("S_PLUS",KeyEvent.KEYCODE_K);
		S_EQUAL = sharedPreferences.getInt("S_EQUAL",KeyEvent.KEYCODE_L);
		S_N_7 = sharedPreferences.getInt("S_N_7",KeyEvent.KEYCODE_Z);
		S_N_8 = sharedPreferences.getInt("S_N_8",KeyEvent.KEYCODE_X);
		S_N_9 = sharedPreferences.getInt("S_N_9",KeyEvent.KEYCODE_C);
		S_EURO = sharedPreferences.getInt("S_EURO", KeyEvent.KEYCODE_V);
		S_APOSTROPHE = sharedPreferences.getInt("S_APOSTROPHE",KeyEvent.KEYCODE_B);
		S_QUOTATION = sharedPreferences.getInt("S_QUOTATION",KeyEvent.KEYCODE_N);
		S_COLON = sharedPreferences.getInt("S_COLON",KeyEvent.KEYCODE_M);
		S_SEMICOLON = sharedPreferences.getInt("S_SEMICOLON", 124);
		S_ASTERISK = sharedPreferences.getInt("S_ASTERISK", 118);
		S_N_0 = sharedPreferences.getInt("S_N_0", 116);
		S_HASHTAG = sharedPreferences.getInt("S_HASHTAG",KeyEvent.KEYCODE_COMMA);
		
	}

	@Override
	public char getChar()
	{
		if(fnState)
		{
			if(keyCode == S_LEFT_PARENTHESIS)
			{
				return ('\u0028');
			}
			else if(keyCode == S_N_1)
			{
				return ('\u0031');
			}
			else if(keyCode == S_N_2)
			{
				return ('\u0032');
			}
			else if(keyCode == S_N_3)
			{
				return ('\u0033');
			}
			else if(keyCode == S_EXCLAMATION)
			{
				return ('\u0021');
			}
			else if(keyCode == S_AT_SIGN)
			{
				return ('\u0040');
			}
			else if(keyCode == S_DOLLAR)
			{
				return ('\u0024');
			}
			else if(keyCode == S_PERCENT)
			{
				return ('\u0025');
			}
			else if(keyCode == S_AMPERSAND)
			{
				return ('\u0026');
			}
			else if(keyCode == S_TILDE)
			{
				return ('\u007E');
			}
			else if(keyCode == S_RIGHT_PARENTHESIS)
			{
				return ('\u0029');
			}
			else if(keyCode == S_N_4)
			{
				return ('\u0034');
			}
			else if(keyCode == S_N_5)
			{
				return ('\u0035');
			}
			else if(keyCode == S_N_6)
			{
				return ('\u0036');
			}
			else if(keyCode == S_SLASH)
			{
				return ('\u002F');
			}
			else if(keyCode == S_UNDERLINE)
			{
				return ('\u005F');
			}
			else if(keyCode == S_MINUS)
			{
				return ('\u002D');
			}
			else if(keyCode == S_PLUS)
			{
				return ('\u002B');
			}
			else if(keyCode == S_EQUAL)
			{
				return ('\u003D');
			}
			else if(keyCode == S_N_7)
			{
				return ('\u0037');
			}
			else if(keyCode == S_N_8)
			{
				return ('\u0038');
			}
			else if(keyCode == S_N_9)
			{
				return ('\u0039');
			}
			else if(keyCode == S_EURO)
			{
				return('\u007C');
			}
			else if(keyCode == S_APOSTROPHE)
			{
				return ('\'');
			}
			else if(keyCode == S_QUOTATION)
			{
				return ('\u0022');
			}
			else if(keyCode == S_COLON)
			{
				return ('\u003A');
			}
			else if(keyCode == S_SEMICOLON)
			{
				//if(PersianIME.preKeyboard.getClass().isInstance(PersianIME.pKeyboard))
					return('\u061B');
				//else
				//	return ('\u003B');
			}
			else if(keyCode == S_ASTERISK)
			{
				return ('\u002A');
			}
			else if(keyCode == S_N_0)
			{
				return ('\u0030');
			}
			else if(keyCode == S_HASHTAG)
			{
				return('\u0023');
			}
			else
			{
				return('\u0000');
			}	
		}
		else
		{
			if(keyCode == ZAD_FA)
			{
				return ('\u0636');
			}
			else if(keyCode == SAD_FA)
			{
				return ('\u0635');
			}
			else if(keyCode == GHAF_FA)
			{
				return ('\u0642');
			}
			else if(keyCode == FAV_FA)
			{
				return ('\u0641');
			}
			else if(keyCode == GHEIN_FA)
			{
				return ('\u063A');
			}
			else if(keyCode == EEIN_FA)
			{
				return ('\u0639');
			}
			else if(keyCode == HA_FA)
			{
				return ('\u0647');
			}
			else if(keyCode == KHE_FA)
			{
				return ('\u062E');
			}
			else if(keyCode == HE_FA)
			{
				return ('\u062D');
			}
			else if(keyCode == JIM_FA)
			{
				if(shiftState)
					return('\u0686');
				else
					return ('\u062C');
			}
			else if(keyCode == SHIN_FA)
			{
				return ('\u0634');
			}
			else if(keyCode == SIN_FA)
			{
				return ('\u0633');
			}
			else if (keyCode == YA_FA)
			{
				if(shiftState)
					return ('\u0626');
				else
					return ('\u06CC');
			}
			else if(keyCode == BE_FA)
			{
				if(shiftState)
					return ('\u067E');
				else
					return ('\u0628');
			}
			else if(keyCode == LAM_FA)
			{
				return ('\u0644');
			}
			else if(keyCode == ALEF_FA)
			{
				if(shiftState)
					return ('\u0622');
				else
					return ('\u0627');
			}
			else if(keyCode == TE_FA)
			{
				return ('\u062A');
			}
			else if(keyCode == NON_FA)
			{
				return ('\u0646');
			}
			else if(keyCode == MIM_FA)
			{
				return ('\u0645');
			}
			else if(keyCode == ZAL_FA)
			{
				return ('\u0630');
			}
			else if(keyCode == DAL_FA)
			{
				return ('\u062F');
			}
			else if(keyCode == RE_FA)
			{
				return ('\u0631');
			}
			else if(keyCode == SE_FA)
			{
				return ('\u062B');
			}
			else if(keyCode == WAW_FA)
			{
				if(shiftState)
					return('\u0624');
				else
					return ('\u0648');
			}
			else if( keyCode == ZE_FA)
			{
				if(shiftState)
					return('\u0698');
				else
					return ('\u0632');
			}
			else if(keyCode == ZA_FA)
			{
				return ('\u0638');
			}
			//TODO put ? in separate key
			else if(keyCode == TA_FA)
			{
				if(shiftState)
					return('\u061F');
				else
					return ('\u0637');
			}
			else if(keyCode == KAF_FA)
			{
				if(shiftState)
					return ('\u06AF');
				else
					return ('\u0643');
			}
			else if(keyCode == COMMA_FA)
			{
				return('\u060C');
			}
			else 
			{
				return('\u0000');
			}
		}
		
	}
	
	
}
