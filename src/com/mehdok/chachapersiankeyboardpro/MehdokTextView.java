/**
 * @author mehdi sohrabi (mehdok@gmail.com)
 * @version 1.4 
 */

package com.mehdok.chachapersiankeyboardpro;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class MehdokTextView extends TextView
{

	public MehdokTextView(Context context, AttributeSet attrs, int defStyle) 
	{
        super(context, attrs, defStyle);
        init();
    }
	
	public MehdokTextView(Context context, AttributeSet attrs) 
	{
        super(context, attrs);
        init();
    }

    public MehdokTextView(Context context) 
    {
        super(context);
        init();
    }
    
    private void init() 
    {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "FreeFarsi.ttf");
        setTypeface(tf);
    	//setText(PersianReshape.reshape(getText().toString()));
        
    }

}
