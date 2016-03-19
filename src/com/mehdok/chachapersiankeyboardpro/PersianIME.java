/**
 * @author mehdi sohrabi (mehdok@gmail.com)
 * @version 1.4 
 */

package com.mehdok.chachapersiankeyboardpro;

import android.inputmethodservice.InputMethodService;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

public class PersianIME extends InputMethodService 
{
	private final int NOTIFY_TIMEOUT = 10 * 1000;// 10 second
	private final int START_KEYBOARD_NOTIFY = 21;
	private final int CANCEL_KEYBOARD_NOTIFY = 22;
	private final int CHANGE_KEYBOARD_NOTIFY = 11;
	public static final int LANGUAGE_PERSIAN = 1;
	public static final int LANGUAGE_ENGLISH = 2;
	public static int PREVIOUS_KEYBOARD;
	static final int KEYCODE_ENTER = '\n';
    static final int KEYCODE_SPACE = ' ';
    static final int KEYCODE_PERIOD = '.';
    
    public static long notifyStartTime = 0;
    
    private boolean shiftPressed = false;
	private boolean shiftToggle = false;
	
	private boolean altPressed = false;//it's Fn
	private boolean altToggle = false;//it's Fn
	
	private boolean nullEditor = false;
	
	private String mWordSeparators;
	private InputMethodManager mInputMethodManager;
	
	int currLanguage = LANGUAGE_PERSIAN;
	
	private StringBuilder mComposing = new StringBuilder();
	
	public static BaseKeyboard currKeyboard;
	//public static BaseKeyboard preKeyboard;
	public static PersianKeyboard pKeyboard;
	public static EnglishKeyboard eKeyboard;
	//public static SymbolKeyboard sKeyboard;
	public static NumberKeyboard nKeyboard;
	
	NotificationManager mgr;
	Notification langChange;
	
	public SharedPreferences sharedPreferences;
	
	public int deleteKey = 0;
	public int spaceKey = 0;
	public int enterKey = 0;
	public int languageKey = 0;
	public int shiftKey = 0;
	public int altKey = 0;
	
	public void onCreate()
	{
		super.onCreate();
		//Toast.makeText(this, "start IME", Toast.LENGTH_LONG).show();
		
		//TODO may be not needed
		mInputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
		mgr = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		//TODO create string resource
		//mWordSeparators = getResources().getString(R.string.word_separators);
		
		currKeyboard = new BaseKeyboard(this);
		pKeyboard = new PersianKeyboard(this);
		eKeyboard = new EnglishKeyboard(this);
		//sKeyboard = new SymbolKeyboard(this);
		nKeyboard = new NumberKeyboard(this);	
		
		//prefered language or may be not needed
		//TODO remember last language from preferences
		//preKeyboard = pKeyboard;
		currKeyboard = pKeyboard;
		PREVIOUS_KEYBOARD = LANGUAGE_PERSIAN;
		
		sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
		
		deleteKey = sharedPreferences.getInt("DELETE", KeyEvent.KEYCODE_DEL);
		spaceKey = sharedPreferences.getInt("SPACE", KeyEvent.KEYCODE_SPACE);
		enterKey = sharedPreferences.getInt("ENTER", KeyEvent.KEYCODE_ENTER);
		languageKey = sharedPreferences.getInt("LANGUAGE", 118);
		shiftKey = sharedPreferences.getInt("SHIFT", KeyEvent.KEYCODE_SHIFT_LEFT);
		altKey = sharedPreferences.getInt("ALT", KeyEvent.KEYCODE_ALT_LEFT);
	}
	/*
	@Override
	public void onDestroy()
	{
		super.onDestroy();
		Toast.makeText(this, "end IME", Toast.LENGTH_LONG).show();
	}
	*/
	
	 @Override
	 public void onStartInput(EditorInfo attribute, boolean restarting) 
	 {
		 //Toast.makeText(this, "start IME", Toast.LENGTH_LONG).show();
		 
		 switch (attribute.inputType & EditorInfo.TYPE_MASK_CLASS) 
		 {
         case EditorInfo.TYPE_CLASS_NUMBER:
         case EditorInfo.TYPE_CLASS_DATETIME:
         case EditorInfo.TYPE_CLASS_PHONE:
        	 nullEditor = false;
        	 //preKeyboard = currKeyboard;
        	 currKeyboard = nKeyboard;
        	 break;
        	 
         case EditorInfo.TYPE_CLASS_TEXT:
        	 nullEditor = false;
        	 if(currLanguage == LANGUAGE_PERSIAN)
        	 {
        		 //preKeyboard = currKeyboard;
        		 currKeyboard = pKeyboard;
        	 }
        		 
        	 else
        	 {
        		 //preKeyboard = currKeyboard;
        		 currKeyboard = eKeyboard;
        	 }
        		 
        	 break;
       
         case EditorInfo.TYPE_NULL:
        	 nullEditor = true;
        	 break;
        	 
         default:
        	 nullEditor = false;
        	 if(currLanguage == LANGUAGE_PERSIAN)
        	 {
        		 //preKeyboard = currKeyboard;
        		 currKeyboard = pKeyboard;
        	 }
        		 
        	 else
        	 {
        		 //preKeyboard = currKeyboard;
        		 currKeyboard = eKeyboard;
        	 }
		 }
		 
		 mComposing.setLength(0);
		 
		 //handleNotify(START_KEYBOARD_NOTIFY);
		 //update shift & alt state
	 }
	 
	 @Override
	 public void onFinishInput() 
	 {
	        super.onFinishInput();
	        
	        handleNotify(CANCEL_KEYBOARD_NOTIFY);
	        //Toast.makeText(this, "end IME", Toast.LENGTH_LONG).show();
	 }
	 
	 private void commitTyped(InputConnection inputConnection) 
	 {
		 if (mComposing.length() > 0) 
		 {
             if (inputConnection != null) 
             {
                 inputConnection.commitText(mComposing, 1);
                 mComposing.setLength(0);
             }
		 }
	 }
	 
	 private boolean isAlphabet(int code) 
	 {
	        if (Character.isLetter(code)) 
	        {
	            return true;
	        } 
	        else 
	        {
	            return false;
	        }
	 }
	 
	 private void handleBackspace() 
	 {
		 //System.out.println("handle backspace");
		 InputConnection ic = getCurrentInputConnection();
	     if (ic == null) 
	    	 return;
	     
	     ic.beginBatchEdit();
	     final int length = mComposing.length();
	     if (length > 0) 
	     {
             mComposing.delete(length - 1, length);
             ic.setComposingText(mComposing, 1);
	     }
	     else 
	     {
	    	 //TODO needs consideration
             ic.deleteSurroundingText(1, 0);
	     }
	     
	     ic.endBatchEdit();
	 }
	 
	 private void handleCharacter(int primaryCode, int[] keyCodes) 
	 {
		 /*
		 if (isAlphabet(primaryCode))
		 {
			 mComposing.setLength(0);
		 }
		 */
		 
		 sendKeyChar((char)primaryCode);
	 }
	 
	 private void handleSeparator(int primaryCode) 
	 {
		 sendKeyChar((char)primaryCode);
	 }
	 
	 protected String getWordSeparators() 
	 {
		 return mWordSeparators;
	 }
	 
	 public boolean isWordSeparator(int code)
	 {
		 String separators = getWordSeparators();
	     return separators.contains(String.valueOf((char)code));
	 }
	 
	 private void sendSpace() 
	 {/*
		 if(shiftPressed || shiftToggle)
		 {
			 InputConnection ic = getCurrentInputConnection();
			 if(ic != null)
			 {
				 mComposing.append("\u002e");
		 		 ic.setComposingText(mComposing, 1);
	         	 commitTyped(ic);
			 }			 
		 }
		 else	*/		 
			 sendKeyChar((char)KEYCODE_SPACE);
	     //updateShiftKeyState(getCurrentInputEditorInfo());
	     //onKey(KEY_SPACE[0], KEY_SPACE);
	 }
	 
	 private void sendEnter()
	 {
		 sendKeyChar((char)KEYCODE_ENTER);
	 }
	 
	 private void toggleLanguage()
	 {	
		 //System.out.println("language");
		 if(currKeyboard.getClass().isInstance(pKeyboard))
		 {
			 currLanguage = LANGUAGE_ENGLISH;
			 //preKeyboard = currKeyboard;
			 currKeyboard = eKeyboard;			 
		 }
			 
		 else if(currKeyboard.getClass().isInstance(eKeyboard))
		 {
			 currLanguage = LANGUAGE_PERSIAN;
			 //preKeyboard = currKeyboard;
			 currKeyboard = pKeyboard;			
		 }
		 
		 handleNotify(START_KEYBOARD_NOTIFY);
			 
	 }
	 
	 @Override 
	 public boolean onKeyUp(int keyCode, KeyEvent event) 		
	 {
		 if((keyCode == shiftKey) || (keyCode == altKey))
		 {
			 
		 }
		 else
		 {
			 if(shiftPressed)
				 shiftPressed = false;
			 if(altPressed)
			 {
				 altPressed = false;
				 //currKeyboard = preKeyboard;
			 }			 
		 }
		 
		 return super.onKeyUp(keyCode, event);
		 /*
		switch(keyCode)
		{
		case(KeyEvent.KEYCODE_SHIFT_LEFT):
		case(KeyEvent.KEYCODE_ALT_LEFT):
			break;
			
		default:
			if(shiftPressed)
				shiftPressed = false;
			if(altPressed)
			{
				altPressed = false;
				currKeyboard = preKeyboard;
			}				
		} 
	       return super.onKeyUp(keyCode, event);
	       */
	 }
	 
	 @Override 
		public boolean onKeyDown(int keyCode, KeyEvent event) 
		{
		 
		 	Log.d("onKeyDown", "keyCode: " + keyCode);
		 	int meta = event.getMetaState();
		 	Log.d("onKeyDown", "meta is: " + meta);
		 	
		 	
		 	
		 	if(meta == KeyEvent.META_ALT_MASK)
		 		Log.w("onKeyDown", "ALT MASK IS DOWN");
		 	else if(meta == KeyEvent.META_SHIFT_MASK)
		 		Log.w("onKeyDown", "SHIFT MASK IS ON");
		 	else if(meta == KeyEvent.META_ALT_ON)
		 		Log.w("onKeyDown", "ALT IS ON");
		 	else if(meta == KeyEvent.META_SHIFT_ON)
		 		Log.w("onKeyDown", "SHIFT IS ON");
		 	else if(meta == KeyEvent.META_CAPS_LOCK_ON)
		 		Log.w("onKeyDown", "CAPSLOCK ON");
		 	else if(event.isAltPressed())
		 		Log.w("onKeyDown", "ALT PRESSED");
		 	else if(event.isShiftPressed())
		 		Log.w("onKeyDown", "SHIFT PRESSED");
		 	
		 	
		 	InputConnection ic = getCurrentInputConnection();
		 	if(nullEditor)
		 	{
		 		return false;
		 	}
		 	
		 	if(keyCode == shiftKey)
		 	{
		 		handlePhysicalShift();
            	return true;//break;//return true or false
		 	}
		 	
		 	else if(keyCode == altKey)
		 	{
		 		handlePhysicalAlt();
            	return true;//break;//return true or flase
		 	}
		 	
		 	else if(keyCode == deleteKey)
		 	{
		 		onKeyUp(keyCode, event);
		 		handleBackspace();		 		
		 		return true;
		 	}
		 	else if(keyCode == spaceKey)
		 	{
		 		//System.out.println("space pressed");
		 		
		 		if(shiftPressed || shiftToggle)
		 		{
		 			//System.out.println("shift + space pressed");
		 			mComposing.append("\u002e");
		 			ic.setComposingText(mComposing, 1);
                	commitTyped(ic);
		 		}
		 		else
		 		{
		 			onKeyUp(keyCode, event);
		 			sendSpace();
		 		}	
		 		
		 		return true;
		 	}
		 	else if(keyCode == enterKey)
		 	{
		 		onKeyUp(keyCode, event);
		 		sendEnter();		 		
		 		return true;
		 	}
		 	//reset meta by pressingfn + space
		 	else if(keyCode == 126)
		 	{
		 		System.out.println("meta reset");
		 		altPressed = false;
		 		altToggle = false;
		 		//currKeyboard = preKeyboard;
		 		
		 		shiftPressed = false;
		 		shiftToggle = false;
		 		
		 		return true;
		 	}
		 	
		 	currKeyboard.setEvent(keyCode, event, shiftPressed || shiftToggle, altPressed || altToggle);
		 	char pressedChar = currKeyboard.getChar();
		 	if(ic != null)
		 	{
		 		if(checkCharValidity(pressedChar))
		 		{
		 			mComposing.append(pressedChar);
		 			ic.setComposingText(mComposing, 1);
                	commitTyped(ic); ////new
                	return true;
		 		}	
		 	}
		 	


		 	if(keyCode == languageKey)
		 	{
		 		//onkeyup
		 		toggleLanguage();
		 		return true;
		 	}
		 	
		 	
		 	else
		 		return false;
		 	
		 	
		 	
		 }
	 
		
	 
	 private boolean checkCharValidity(char ch)
	 {
		 if (ch == '\u0000')
			 return false;
		 else 
			 return true;
	 }
	 
	 private void handlePhysicalShift()
		{
			if(shiftToggle)
			{
				shiftToggle = false;
			}
			else if(!shiftPressed)
			{
				shiftPressed = true;
			}
			else if(shiftPressed)
			{
				shiftToggle = true;
				shiftPressed = false;
			}
		}
		
		private void handlePhysicalAlt()
		{
			if(altToggle)
			{
				altToggle = false;
				//currKeyboard = preKeyboard;
			}
			else if(!altPressed)
			{
				altPressed = true;
				//preKeyboard = currKeyboard;
				//currKeyboard = sKeyboard;
			}
			else if(altPressed)
			{
				altToggle = true;
				altPressed = false;
			}				
		}
		
		/*
	Handler notifyHandler = new Handler();
	Runnable notifyRunnable = new Runnable()
		{
			@Override
			public void run()
			{
				mgr.cancel(CHANGE_KEYBOARD_NOTIFY);
			}
		};
		
		*/
	private void handleNotify(int notifyState)
	{
		if(notifyState == START_KEYBOARD_NOTIFY)
		{
			if(currLanguage == LANGUAGE_PERSIAN)
			{
				notifyStartTime = System.currentTimeMillis();
				langChange = new Notification(R.drawable.fa, "", notifyStartTime);
				langChange.setLatestEventInfo(this, "Persian Keyboard", "Persian Keyboard for HTC CHACHA by MEHDOK", PendingIntent.getActivity(getApplicationContext(), 0, new Intent(), 0));
				langChange.flags |= Notification.FLAG_AUTO_CANCEL;
				
				mgr.notify(CHANGE_KEYBOARD_NOTIFY, langChange);
			}
			else
			{
				notifyStartTime = System.currentTimeMillis();
				langChange = new Notification(R.drawable.en, "", notifyStartTime);
				langChange.setLatestEventInfo(this, "English Keyboard", "English Keyboard for HTC CHACHA by MEHDOK", PendingIntent.getActivity(getApplicationContext(), 0, new Intent(), 0));
				langChange.flags |= Notification.FLAG_AUTO_CANCEL;
				mgr.notify(CHANGE_KEYBOARD_NOTIFY, langChange);
			}
			
			/*
			boolean timeFlag = true;
			while(timeFlag)
			{
				if((System.currentTimeMillis() - notifyStartTime) > NOTIFY_TIMEOUT)
				{
					mgr.cancel(CHANGE_KEYBOARD_NOTIFY);
					timeFlag = false;
				}				
			}
			*/
			//notifyHandler.postDelayed(notifyRunnable, NOTIFY_TIMEOUT);
		}
		else if(notifyState == CANCEL_KEYBOARD_NOTIFY)
		{
			mgr.cancel(CHANGE_KEYBOARD_NOTIFY);
			/*
			boolean timeFlag = true;
			while(timeFlag)
			{
				if((System.currentTimeMillis() - notifyStartTime) > NOTIFY_TIMEOUT)
				{
					mgr.cancel(CHANGE_KEYBOARD_NOTIFY);
					timeFlag = false;
				}				
			}
			*/
			//notifyHandler.postDelayed(notifyRunnable, NOTIFY_TIMEOUT);
			/*
			new Handler().postDelayed(new Runnable()
	        {
	        	@Override
	        	public void run() 
	        	{
	        		mgr.cancel(CHANGE_KEYBOARD_NOTIFY);		        		
	        	}
	        }, NOTIFY_TIMEOUT);
			*/
			/*
			long notifyTime = System.currentTimeMillis() - notifyStartTime;
			if(notifyTime > NOTIFY_TIMEOUT)
				mgr.cancel(CHANGE_KEYBOARD_NOTIFY);
			else
			{
				new Handler().postDelayed(new Runnable()
		        {
		        	@Override
		        	public void run() 
		        	{
		        		mgr.cancel(CHANGE_KEYBOARD_NOTIFY);		        		
		        	}
		        }, notifyTime);
			}
			*/
		}
	}
	/*
	@Override
	public void onStartInputView(EditorInfo attribute, boolean restarting)
	{
		handleNotify(START_KEYBOARD_NOTIFY);
	}
	*/
	
	/*
	@Override
	public void onBindInput()
	{		
		System.out.println("BIND");
		handleNotify(START_KEYBOARD_NOTIFY);
	}
	*/
	/*
	@Override
	public void onUnbindInput()
	{
		System.out.println("UNBIND");
		//handleNotify(CANCEL_KEYBOARD_NOTIFY);
		mgr.cancel(CHANGE_KEYBOARD_NOTIFY);
	}
	*/
}
	 
