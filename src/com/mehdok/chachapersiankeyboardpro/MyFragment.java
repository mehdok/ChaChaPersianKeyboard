/**
 * @author mehdi sohrabi (mehdok@gmail.com)
 * @version 1.4 
 */

package com.mehdok.chachapersiankeyboardpro;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyFragment extends Fragment 
{
	 public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
	 
	 //private static int mLayout;
	 
	 public static final MyFragment newInstance(int layout)
	 {
		 //mLayout = layout;
	   MyFragment f = new MyFragment();
	   Bundle bdl = new Bundle(1);
	   bdl.putInt(EXTRA_MESSAGE, layout);
	   f.setArguments(bdl);
	   return f;
	 }	 

	 @Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
	 {
		 int lay = getArguments().getInt(EXTRA_MESSAGE);
	   //String message = getArguments().getString(EXTRA_MESSAGE);
	   View v = inflater.inflate(lay, container, false);
	   //TextView messageTextView = (TextView)v.findViewById(R.id.textView);
	   //messageTextView.setText(message);	 

	   return v;
	 }
}
