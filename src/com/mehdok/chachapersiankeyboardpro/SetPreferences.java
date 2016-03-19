/**
 * @author mehdi sohrabi (mehdok@gmail.com)
 * @version 1.4 
 */

package com.mehdok.chachapersiankeyboardpro;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.KeyEvent;

public class SetPreferences 
{
	private static SharedPreferences sharedPreferences;
	
	private static void init(Context context)
	{
		sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
	}
	
	public static void setPersianKey(Context con)
	{
		init(con);
		
		//check whether it's first time running app or not
		int runNumber = sharedPreferences.getInt("RUNNING_NUMBER1", 0);
		if(runNumber == 0)
		{
			sharedPreferences.edit().putInt("RUNNING_NUMBER1", ++runNumber).commit();
			persianKeyDefault(con);
		}			
		else
			sharedPreferences.edit().putInt("RUNNING_NUMBER1", ++runNumber).commit();		
	}
	
	public static void setEnglishKey(Context con)
	{
		init(con);
		
		//check whether it's first time running app or not
		int runNumber = sharedPreferences.getInt("RUNNING_NUMBER2", 0);
		if(runNumber == 0)
		{
			sharedPreferences.edit().putInt("RUNNING_NUMBER2", ++runNumber).commit();
			englishKeyDefault(con);
		}			
		else
			sharedPreferences.edit().putInt("RUNNING_NUMBER2", ++runNumber).commit();
	}
	
	public static void setSymbolKey(Context con)
	{
		init(con);
		
		//check whether it's first time running app or not
		int runNumber = sharedPreferences.getInt("RUNNING_NUMBER3", 0);
		if(runNumber == 0)
		{
			sharedPreferences.edit().putInt("RUNNING_NUMBER3", ++runNumber).commit();
			symbolKeyDefault(con);
		}			
		else
			sharedPreferences.edit().putInt("RUNNING_NUMBER3", ++runNumber).commit();
	}
	
	public static void setNumberKey(Context con)
	{
		init(con);
		
		//check whether it's first time running app or not
		int runNumber = sharedPreferences.getInt("RUNNING_NUMBER4", 0);
		if(runNumber == 0)
		{
			sharedPreferences.edit().putInt("RUNNING_NUMBER4", ++runNumber).commit();
			numberKeyDefault(con);
		}			
		else
			sharedPreferences.edit().putInt("RUNNING_NUMBER4", ++runNumber).commit();
	}
	
	public static void setSpecialKey(Context con)
	{
		init(con);
		
		//check whether it's first time running app or not
		int runNumber = sharedPreferences.getInt("RUNNING_NUMBER5", 0);
		if(runNumber == 0)
		{
			sharedPreferences.edit().putInt("RUNNING_NUMBER5", ++runNumber).commit();
			specialKeyDefault(con);
		}			
		else
			sharedPreferences.edit().putInt("RUNNING_NUMBER5", ++runNumber).commit();
	}
	
	public static void persianKeyDefault(Context con)
	{
		init(con);
		//persian key
		sharedPreferences.edit().putInt("ZAD_FA",KeyEvent.KEYCODE_Q).commit();
		sharedPreferences.edit().putInt("SAD_FA",KeyEvent.KEYCODE_W).commit();
		sharedPreferences.edit().putInt("GHAF_FA",KeyEvent.KEYCODE_E).commit();
		sharedPreferences.edit().putInt("FAV_FA",KeyEvent.KEYCODE_R).commit();
		sharedPreferences.edit().putInt("GHEIN_FA",KeyEvent.KEYCODE_T).commit();
		sharedPreferences.edit().putInt("EEIN_FA",KeyEvent.KEYCODE_Y).commit();
		sharedPreferences.edit().putInt("HA_FA",KeyEvent.KEYCODE_U).commit();
		sharedPreferences.edit().putInt("KHE_FA",KeyEvent.KEYCODE_I).commit();
		sharedPreferences.edit().putInt("HE_FA",KeyEvent.KEYCODE_O).commit();
		sharedPreferences.edit().putInt("JIM_FA",KeyEvent.KEYCODE_P).commit();
		sharedPreferences.edit().putInt("SHIN_FA",KeyEvent.KEYCODE_A).commit();
		sharedPreferences.edit().putInt("SIN_FA",KeyEvent.KEYCODE_S).commit();
		sharedPreferences.edit().putInt("YA_FA",KeyEvent.KEYCODE_D).commit();
		sharedPreferences.edit().putInt("BE_FA",KeyEvent.KEYCODE_F).commit();
		sharedPreferences.edit().putInt("LAM_FA",KeyEvent.KEYCODE_G).commit();
		sharedPreferences.edit().putInt("ALEF_FA",KeyEvent.KEYCODE_H).commit();
		sharedPreferences.edit().putInt("TE_FA",KeyEvent.KEYCODE_J).commit();
		sharedPreferences.edit().putInt("NON_FA",KeyEvent.KEYCODE_K).commit();
		sharedPreferences.edit().putInt("MIM_FA",KeyEvent.KEYCODE_L).commit();
		sharedPreferences.edit().putInt("ZAL_FA",KeyEvent.KEYCODE_Z).commit();
		sharedPreferences.edit().putInt("DAL_FA",KeyEvent.KEYCODE_X).commit();
		sharedPreferences.edit().putInt("RE_FA",KeyEvent.KEYCODE_C).commit();
		sharedPreferences.edit().putInt("SE_FA",KeyEvent.KEYCODE_V).commit();
		sharedPreferences.edit().putInt("VAV_FA",KeyEvent.KEYCODE_B).commit();
		sharedPreferences.edit().putInt("ZE_FA",KeyEvent.KEYCODE_N).commit();
		sharedPreferences.edit().putInt("ZA_FA",KeyEvent.KEYCODE_M).commit();
		sharedPreferences.edit().putInt("TA_FA",124).commit();
		sharedPreferences.edit().putInt("KAF_FA",KeyEvent.KEYCODE_PERIOD).commit();
		sharedPreferences.edit().putInt("COMMA_FA",KeyEvent.KEYCODE_COMMA).commit();		
	}
	
	public static void englishKeyDefault(Context con)
	{
		init(con);
		//english key
		sharedPreferences.edit().putInt("Q_EN",KeyEvent.KEYCODE_Q).commit();
		sharedPreferences.edit().putInt("W_EN",KeyEvent.KEYCODE_W).commit();
		sharedPreferences.edit().putInt("E_EN",KeyEvent.KEYCODE_E).commit();
		sharedPreferences.edit().putInt("R_EN",KeyEvent.KEYCODE_R).commit();
		sharedPreferences.edit().putInt("T_EN",KeyEvent.KEYCODE_T).commit();
		sharedPreferences.edit().putInt("Y_EN",KeyEvent.KEYCODE_Y).commit();
		sharedPreferences.edit().putInt("U_EN",KeyEvent.KEYCODE_U).commit();
		sharedPreferences.edit().putInt("I_EN",KeyEvent.KEYCODE_I).commit();
		sharedPreferences.edit().putInt("O_EN",KeyEvent.KEYCODE_O).commit();
		sharedPreferences.edit().putInt("P_EN",KeyEvent.KEYCODE_P).commit();
		sharedPreferences.edit().putInt("A_EN",KeyEvent.KEYCODE_A).commit();
		sharedPreferences.edit().putInt("S_EN",KeyEvent.KEYCODE_S).commit();
		sharedPreferences.edit().putInt("D_EN",KeyEvent.KEYCODE_D).commit();
		sharedPreferences.edit().putInt("F_EN",KeyEvent.KEYCODE_F).commit();
		sharedPreferences.edit().putInt("G_EN",KeyEvent.KEYCODE_G).commit();
		sharedPreferences.edit().putInt("H_EN",KeyEvent.KEYCODE_H).commit();
		sharedPreferences.edit().putInt("J_EN",KeyEvent.KEYCODE_J).commit();
		sharedPreferences.edit().putInt("K_EN",KeyEvent.KEYCODE_K).commit();
		sharedPreferences.edit().putInt("L_EN",KeyEvent.KEYCODE_L).commit();
		sharedPreferences.edit().putInt("Z_EN",KeyEvent.KEYCODE_Z).commit();
		sharedPreferences.edit().putInt("X_EN",KeyEvent.KEYCODE_X).commit();
		sharedPreferences.edit().putInt("C_EN",KeyEvent.KEYCODE_C).commit();
		sharedPreferences.edit().putInt("V_EN",KeyEvent.KEYCODE_V).commit();
		sharedPreferences.edit().putInt("B_EN",KeyEvent.KEYCODE_B).commit();
		sharedPreferences.edit().putInt("N_EN",KeyEvent.KEYCODE_N).commit();
		sharedPreferences.edit().putInt("M_EN",KeyEvent.KEYCODE_M).commit();
		sharedPreferences.edit().putInt("QUECHAR_EN",124).commit();
		sharedPreferences.edit().putInt("PERIOD_EN",KeyEvent.KEYCODE_PERIOD).commit();
	}
	
	public static void symbolKeyDefault(Context con)
	{
		init(con);
		//symbol key
		sharedPreferences.edit().putInt("S_LEFT_PARENTHESIS",KeyEvent.KEYCODE_Q).commit();
		sharedPreferences.edit().putInt("S_N_1",KeyEvent.KEYCODE_W).commit();
		sharedPreferences.edit().putInt("S_N_2",KeyEvent.KEYCODE_E).commit();
		sharedPreferences.edit().putInt("S_N_3",KeyEvent.KEYCODE_R).commit();
		sharedPreferences.edit().putInt("S_EXCALAMATION",KeyEvent.KEYCODE_T).commit();
		sharedPreferences.edit().putInt("S_AT_SIGN",KeyEvent.KEYCODE_Y).commit();
		sharedPreferences.edit().putInt("S_DOLLAR",KeyEvent.KEYCODE_U).commit();
		sharedPreferences.edit().putInt("S_PERCENT",KeyEvent.KEYCODE_I).commit();
		sharedPreferences.edit().putInt("S_AMPERSAND",KeyEvent.KEYCODE_O).commit();
		sharedPreferences.edit().putInt("S_TILDE",KeyEvent.KEYCODE_P).commit();
		sharedPreferences.edit().putInt("S_RIGHT_PARENTHESIS",KeyEvent.KEYCODE_A).commit();
		sharedPreferences.edit().putInt("S_N_4",KeyEvent.KEYCODE_S).commit();
		sharedPreferences.edit().putInt("S_N_5",KeyEvent.KEYCODE_D).commit();
		sharedPreferences.edit().putInt("S_N_6",KeyEvent.KEYCODE_F).commit();
		sharedPreferences.edit().putInt("S_SLASH",KeyEvent.KEYCODE_G).commit();
		sharedPreferences.edit().putInt("S_UNDERLINE",KeyEvent.KEYCODE_H).commit();
		sharedPreferences.edit().putInt("S_MINUS",KeyEvent.KEYCODE_J).commit();
		sharedPreferences.edit().putInt("S_PLUS",KeyEvent.KEYCODE_K).commit();
		sharedPreferences.edit().putInt("S_EQUAL",KeyEvent.KEYCODE_L).commit();
		sharedPreferences.edit().putInt("S_N_7",KeyEvent.KEYCODE_Z).commit();
		sharedPreferences.edit().putInt("S_N_8",KeyEvent.KEYCODE_X).commit();
		sharedPreferences.edit().putInt("S_N_9",KeyEvent.KEYCODE_C).commit();
		sharedPreferences.edit().putInt("S_EURO",KeyEvent.KEYCODE_V).commit();
		sharedPreferences.edit().putInt("S_APOSTROPHE",KeyEvent.KEYCODE_B).commit();
		sharedPreferences.edit().putInt("S_QUOTATION",KeyEvent.KEYCODE_N).commit();
		sharedPreferences.edit().putInt("S_COLON",KeyEvent.KEYCODE_M).commit();
		sharedPreferences.edit().putInt("S_SEMICOLON",124).commit();
		sharedPreferences.edit().putInt("S_ASTERISK",118).commit();
		sharedPreferences.edit().putInt("S_N_0",116).commit();
		sharedPreferences.edit().putInt("S_HASHTAG",KeyEvent.KEYCODE_COMMA).commit();		
	}
	
	public static void numberKeyDefault(Context con)
	{
		init(con);
		//number key
		sharedPreferences.edit().putInt("N_1",KeyEvent.KEYCODE_W).commit();
		sharedPreferences.edit().putInt("N_2",KeyEvent.KEYCODE_E).commit();
		sharedPreferences.edit().putInt("N_3",KeyEvent.KEYCODE_R).commit();
		sharedPreferences.edit().putInt("N_4",KeyEvent.KEYCODE_S).commit();
		sharedPreferences.edit().putInt("N_5",KeyEvent.KEYCODE_D).commit();
		sharedPreferences.edit().putInt("N_6",KeyEvent.KEYCODE_F).commit();
		sharedPreferences.edit().putInt("N_7",KeyEvent.KEYCODE_Z).commit();
		sharedPreferences.edit().putInt("N_8",KeyEvent.KEYCODE_X).commit();
		sharedPreferences.edit().putInt("N_9",KeyEvent.KEYCODE_C).commit();
		sharedPreferences.edit().putInt("N_0",116).commit();
		sharedPreferences.edit().putInt("N_STAR",118).commit();
		sharedPreferences.edit().putInt("N_HASHTAG",KeyEvent.KEYCODE_COMMA).commit();
		sharedPreferences.edit().putInt("N_DOT",KeyEvent.KEYCODE_PERIOD).commit();
		sharedPreferences.edit().putInt("N_PLUS",KeyEvent.KEYCODE_K).commit();
		sharedPreferences.edit().putInt("N_MINUS",KeyEvent.KEYCODE_J).commit();
	}
	
	public static void specialKeyDefault(Context con)
	{
		init(con);
		//special key
		sharedPreferences.edit().putInt("DELETE",KeyEvent.KEYCODE_DEL).commit();
		sharedPreferences.edit().putInt("SPACE",KeyEvent.KEYCODE_SPACE).commit();
		sharedPreferences.edit().putInt("ENTER",KeyEvent.KEYCODE_ENTER).commit();
		sharedPreferences.edit().putInt("LANGUAGE",118).commit();
		sharedPreferences.edit().putInt("SHIFT",KeyEvent.KEYCODE_SHIFT_LEFT).commit();
		sharedPreferences.edit().putInt("ALT",KeyEvent.KEYCODE_ALT_LEFT).commit();
	}
}
