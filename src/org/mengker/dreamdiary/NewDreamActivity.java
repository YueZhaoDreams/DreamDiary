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

public class NewDreamActivity extends Activity {
	ImageButton saveImageButton;
	EditText dreamContentEditText;

	String dreamTime;
	String dreamTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_dream);

		// define widgets
		saveImageButton = (ImageButton) this.findViewById(R.id.saveImageButton);
		dreamContentEditText = (EditText) this
				.findViewById(R.id.dreamContentEditText);

		saveImageButton
				.setOnClickListener(new SaveImageButtonOnClickListener());

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

	class SaveImageButtonOnClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {

			Intent i = new Intent(NewDreamActivity.this,
					DiaryBookActivity.class);
			i.putExtra("dream_time", dreamTime);
			i.putExtra("dream_title", dreamTitle);
			startActivity(i);

		}

	}

}
