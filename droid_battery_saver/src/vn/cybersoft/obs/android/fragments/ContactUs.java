package vn.cybersoft.obs.android.fragments;

import com.ksk.droidbatterybooster.R;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ContactUs extends Activity implements OnClickListener{
	
	private Button   btnSubmit;
    private EditText etSubject;
    private EditText etMessage;
    
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.contactus);  

		btnSubmit  = (Button)   findViewById(R.id.btnSubmit);
        etSubject  = (EditText) findViewById(R.id.etSubject);
        etMessage  = (EditText) findViewById(R.id.etMessage);

      btnSubmit. setOnClickListener(this);
    
    }

	
	public void onClick(View v) {
		 switch(v.getId()){
            case R.id.btnSubmit:
                sendMail();
                break;
		}
	}
	
	//sending mail
	private void sendMail(){
        String emailID = "weavebytes@gmail.com";
        String sub       = "Droid Battery Booster: " + etSubject.getText() ;
        String message   = "" + etMessage.getText() + "\n Send from android" ;
        Intent email     = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{emailID});
        email.putExtra(Intent.EXTRA_SUBJECT, sub);
        email.putExtra(Intent.EXTRA_TEXT, message);
        email.setType("message/rfc822");
        startActivity(Intent.createChooser(email, "Choose an Email client :"));
    }
			
}/*ContactUS*/
	
