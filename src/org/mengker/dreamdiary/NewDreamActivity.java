package org.mengker.dreamdiary;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class NewDreamActivity extends Activity {
	ImageView saveImageButton;
	EditText dreamContentEditText;

	String dreamTime = "dreamTime";
	String dreamTitle = "dreamTitle";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_dream);

		// define widgets
		saveImageButton = (ImageView) this.findViewById(R.id.saveImageView);
		dreamContentEditText = (EditText) this
				.findViewById(R.id.dreamContentEditText);

		saveImageButton
				.setOnClickListener(new SaveImageViewOnClickListener());

		Calendar dreamTimeCalendar = new GregorianCalendar();
		dreamTimeCalendar.setTime(new Date());
		dreamTime = dreamTimeCalendar.get(Calendar.YEAR) + "/"
				+ dreamTimeCalendar.get(Calendar.MONTH) + "/"
				+ dreamTimeCalendar.get(Calendar.DAY_OF_MONTH) + " "
				+ dreamTimeCalendar.get(Calendar.HOUR_OF_DAY) + ": "
				+ dreamTimeCalendar.get(Calendar.MINUTE);
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_dream, menu);
		return true;
	}

	class SaveImageViewOnClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			dreamTitle = dreamContentEditText.getText().toString();
			if(dreamTitle.length() > 10){
				dreamTitle = dreamTitle.substring(0, 10);
			}
			Intent i = new Intent(NewDreamActivity.this,
					DiaryBookActivity.class);
			i.putExtra("dream_time", dreamTime);
			i.putExtra("dream_title", dreamTitle);
			startActivity(i);
			finish();
		}

	}

}
