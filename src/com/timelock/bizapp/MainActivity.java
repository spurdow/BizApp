package com.timelock.bizapp;

import com.timelock.serializedentity.SerializedUser;
import com.timelock.task.LoginTask;
import com.timelock.utils.AfterTextChanged;
import com.timelock.utils.Utils;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

		
	private boolean errors = false;
	private EditText txt_username;
	private EditText txt_password;
	private Button login;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		SerializedUser user = Utils.getUser(this);
		if(user.user_id > 0){
			Intent i = new Intent(this , SlidingDashboard.class);
			i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(i);
		}
		
		txt_username = (EditText) findViewById(R.id.txt_username);
		txt_password = (EditText) findViewById(R.id.txt_password);
		login = (Button) findViewById(R.id.btn_login);
		
		txt_username.addTextChangedListener(new AfterTextChanged(){

			@Override
			public void abstract_afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				if(s!= null && !s.toString().equals("") ){
					errors = false;
				}else{
					errors = true;
				}
			}
			
		});
		
		txt_password.addTextChangedListener(new AfterTextChanged(){

			@Override
			public void abstract_afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				if(s!= null && !s.toString().equals("") ){
					errors = false;
				}else{
					errors = true;
				}
			}
			
		});
		
		login.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LoginTask lTask = new LoginTask(MainActivity.this);
				lTask.execute("login" , txt_username.getText().toString() , txt_password.getText().toString() , Utils.LOGIN_URL);
			}
			
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
