/**
 * @author mehdi sohrabi (mehdok@gmail.com)
 * @version 1.4 
 */

package com.mehdok.chachapersiankeyboardpro;

import android.content.Context;
import android.view.KeyEvent;

public class EnglishKeyboard extends BaseKeyboard
{
	private int Q_EN = 0;
	private int W_EN = 0;
	private int E_EN = 0;
	private int R_EN = 0;
	private int T_EN = 0;
	private int Y_EN = 0;
	private int U_EN = 0;
	private int I_EN = 0;
	private int O_EN = 0;
	private int P_EN = 0;
	private int A_EN = 0;
	private int S_EN = 0;
	private int D_EN = 0;
	private int F_EN = 0;
	private int G_EN = 0;
	private int H_EN = 0;
	private int J_EN = 0;
	private int K_EN = 0;
	private int L_EN = 0;
	private int Z_EN = 0;
	private int X_EN = 0;
	private int C_EN = 0;
	private int V_EN = 0;
	private int B_EN = 0;
	private int N_EN = 0;
	private int M_EN = 0;
	private int QUECHAR_EN = 0;
	private int PERIOD_EN = 0;
	
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
	
	public EnglishKeyboard(Context context) 
	{
		super(context);
		// TODO Auto-generated constructor stub
		Q_EN = sharedPreferences.getInt("Q_EN",KeyEvent.KEYCODE_Q);
		W_EN = sharedPreferences.getInt("W_EN",KeyEvent.KEYCODE_W);
		E_EN = sharedPreferences.getInt("E_EN",KeyEvent.KEYCODE_E);
		R_EN = sharedPreferences.getInt("R_EN",KeyEvent.KEYCODE_R);
		T_EN = sharedPreferences.getInt("T_EN",KeyEvent.KEYCODE_T);
		Y_EN = sharedPreferences.getInt("Y_EN",KeyEvent.KEYCODE_Y);
		U_EN = sharedPreferences.getInt("U_EN",KeyEvent.KEYCODE_U);
		I_EN = sharedPreferences.getInt("I_EN",KeyEvent.KEYCODE_I);
		O_EN = sharedPreferences.getInt("O_EN",KeyEvent.KEYCODE_O);
		P_EN = sharedPreferences.getInt("P_EN",KeyEvent.KEYCODE_P);
		A_EN = sharedPreferences.getInt("A_EN",KeyEvent.KEYCODE_A);
		S_EN = sharedPreferences.getInt("S_EN",KeyEvent.KEYCODE_S);
		D_EN = sharedPreferences.getInt("D_EN",KeyEvent.KEYCODE_D);
		F_EN = sharedPreferences.getInt("F_EN",KeyEvent.KEYCODE_F);
		G_EN = sharedPreferences.getInt("G_EN",KeyEvent.KEYCODE_G);
		H_EN = sharedPreferences.getInt("H_EN",KeyEvent.KEYCODE_H);
		J_EN = sharedPreferences.getInt("J_EN",KeyEvent.KEYCODE_J);
		K_EN = sharedPreferences.getInt("K_EN",KeyEvent.KEYCODE_K);
		L_EN = sharedPreferences.getInt("L_EN",KeyEvent.KEYCODE_L);
		Z_EN = sharedPreferences.getInt("Z_EN",KeyEvent.KEYCODE_Z);
		X_EN = sharedPreferences.getInt("X_EN",KeyEvent.KEYCODE_X);
		C_EN = sharedPreferences.getInt("C_EN",KeyEvent.KEYCODE_C);
		V_EN = sharedPreferences.getInt("V_EN",KeyEvent.KEYCODE_V);
		B_EN = sharedPreferences.getInt("B_EN",KeyEvent.KEYCODE_B);		
		N_EN = sharedPreferences.getInt("N_EN",KeyEvent.KEYCODE_N);
		M_EN = sharedPreferences.getInt("M_EN",KeyEvent.KEYCODE_M);
		QUECHAR_EN = sharedPreferences.getInt("QUECHAR_EN",124);
		PERIOD_EN = sharedPreferences.getInt("PERIOD_EN",KeyEvent.KEYCODE_PERIOD);		
		
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
				//	return('\u061B');
				//else
					return ('\u003B');
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
			if(keyCode == Q_EN)
			{
				if(shiftState)
					return ('\u0051');
				else
					return ('\u0071');
			}
			else if(keyCode == W_EN)
			{
				if(shiftState)
					return ('\u0057');
				else
					return ('\u0077');
			}
			else if(keyCode == E_EN)
			{
				if(shiftState)
					return ('\u0045');
				else
					return ('\u0065');
			}
			else if(keyCode == R_EN)
			{
				if(shiftState)
					return ('\u0052');
				else
					return ('\u0072');
			}
			else if(keyCode == T_EN)
			{
				if(shiftState)
					return ('\u0054');
				else
					return ('\u0074');
			}
			else if(keyCode == Y_EN)
			{
				if(shiftState)
					return ('\u0059');
				else
					return ('\u0079');
			}
			else if(keyCode == Y_EN)
			{
				if(shiftState)
					return ('\u0055');
				else
					return ('\u0075');
			}
			else if(keyCode == U_EN)
			{
				if(shiftState)
					return('\u0055');
				else
					return('\u0075');
			}
			else if(keyCode == I_EN)
			{
				if(shiftState)
					return ('\u0049');
				else
					return ('\u0069');
			}
			else if(keyCode == O_EN)
			{
				if(shiftState)
					return ('\u004F');
				else
					return ('\u006F');
			}
			else if(keyCode == P_EN)
			{
				if(shiftState)
					return ('\u0050');
				else
					return ('\u0070');
			}
			else if(keyCode == A_EN)
			{
				if(shiftState)
					return ('\u0041');
				else
					return ('\u0061');
			}
			else if(keyCode == S_EN)
			{
				if(shiftState)
					return ('\u0053');
				else
					return ('\u0073');
			}
			else if(keyCode == D_EN)
			{
				if(shiftState)
					return ('\u0044');
				else
					return ('\u0064');
			}
			else if(keyCode == F_EN)
			{
				if(shiftState)
					return ('\u0046');
				else
					return ('\u0066');
			}
			else if(keyCode == G_EN)
			{
				if(shiftState)
					return ('\u0047');
				else
					return ('\u0067');
			}
			else if(keyCode == H_EN)
			{
				if(shiftState)
					return ('\u0048');
				else
					return ('\u0068');
			}
			else if(keyCode == J_EN)
			{
				if(shiftState)
					return ('\u004A');
				else
					return ('\u006A');
			}
			else if(keyCode == K_EN)
			{
				if(shiftState)
					return ('\u004B');
				else
					return ('\u006B');
			}
			else if(keyCode == L_EN)
			{
				if(shiftState)
					return ('\u004C');
				else
					return ('\u006C');
			}
			else if(keyCode == Z_EN)
			{
				if(shiftState)
					return ('\u005A');
				else
					return ('\u007A');
			}
			else if(keyCode == X_EN)
			{
				if(shiftState)
					return ('\u0058');
				else
					return ('\u0078');
			}
			else if(keyCode == C_EN)
			{
				if(shiftState)
					return ('\u0043');
				else
					return ('\u0063');
			}
			else if(keyCode == V_EN)
			{
				if(shiftState)
					return ('\u0056');
				else
					return ('\u0076');	
			}
			else if(keyCode == B_EN)
			{
				if(shiftState)
					return ('\u0042');
				else
					return ('\u0062');
			}
			else if(keyCode == N_EN)
			{
				if(shiftState)
					return ('\u004E');
				else
					return ('\u006E');
			}
			else if(keyCode == M_EN)
			{
				if(shiftState)
					return ('\u004D');
				else
					return ('\u006D');
			}
			else if(keyCode == QUECHAR_EN)
			{
				return ('\u003F');
			}
			else if(keyCode == PERIOD_EN)
			{
				return ('\u002E');
			}
			else
			{
				return ('\u0000');
			}		
		}
		
	}
}
