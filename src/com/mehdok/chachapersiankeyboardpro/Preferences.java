/**
 * @author mehdi sohrabi (mehdok@gmail.com)
 * @version 1.4 
 */

package com.mehdok.chachapersiankeyboardpro;

import android.app.AlertDialog;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.Preference.OnPreferenceClickListener;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.widget.TextView;



public class Preferences extends PreferenceActivity implements OnPreferenceClickListener
{
	//private final String kMap = "shift + p  &#8212;> &#x0686;\nshift + f  &#8212;> &#x067E;\nshift + n  &#8212;> &#x0698;\nshift +  .  &#8212;> &#x06AF;\nshift + h &#8212;> &#x0622;\nshift + (&#x0637;)  &#8212;> &#x003F;\n&#x0073;&#x0068;&#x0069;&#x0066;&#x0074;&#x0020;&#x002b;&#x0020;&#x06cc;&#x0020;&#x0020;&#8212;>&#x0020;&#x0626;";
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);		
		addPreferencesFromResource(R.xml.preferences);
		
		Preference about = (Preference)this.findPreference("about");
		Preference keyMap = (Preference)this.findPreference("keys");
		about.setOnPreferenceClickListener(this);
		keyMap.setOnPreferenceClickListener(this);
	}

	@Override
	public boolean onPreferenceClick(Preference preference) 
	{
		String key = preference.getKey();
		
		if(key.equals("keys"))
		{
			AlertDialog.Builder adb1 = new AlertDialog.Builder(this);
			adb1.setIcon(R.drawable.mehdok_logo);
			adb1.setTitle(R.string.keymap);
			adb1.setCancelable(true);
			adb1.setMessage(R.string.key_combination);
			
			AlertDialog ad1 = adb1.create();
			ad1.show();
		}
		else if(key.equals("about"))//equalsIgnoreCase("about"))
		{
			final TextView message = new TextView(this);
			//message.setTextSize(R.dimen.about_text_size);
			final SpannableString s = new SpannableString(this.getText(R.string.about_me));
			Linkify.addLinks(message, Linkify.EMAIL_ADDRESSES);
			message.setText(s);
			message.setMovementMethod(LinkMovementMethod.getInstance());
			
			
			AlertDialog.Builder adb2 = new AlertDialog.Builder(this);
			adb2.setIcon(R.drawable.mehdok_logo);
			adb2.setTitle(R.string.preferences_label);
			adb2.setCancelable(true);
			adb2.setView(message);
			//adb.setMessage(R.string.about_me);
			
			AlertDialog ad2 = adb2.create();
			ad2.show();
		}
		return true;
	}

}
