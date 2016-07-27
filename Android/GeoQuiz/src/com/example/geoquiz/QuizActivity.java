package com.example.geoquiz;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends Activity {

	private static final String TAG = "QuizActivity";
	private static final String KEY_INDEX = "index";

	private Button mTrueButton;
	private Button mFalseButton;
	private Button mNextButton;
	private Button mCheatButton;
	private TextView mQuestionTextView;

	private TrueFalse[] mQuestionBank = new TrueFalse[] {
			new TrueFalse(R.string.question_oceans, true),
			new TrueFalse(R.string.question_mideast, false),
			new TrueFalse(R.string.question_africa, false),
			new TrueFalse(R.string.question_americas, true),
			new TrueFalse(R.string.question_asia, true), };
	private int mCurrentIndex = 0;
	private boolean mIsCheater;

	private void updateQuestion() {
		mQuestionTextView.setText(mQuestionBank[mCurrentIndex].getmQuestion());
	}

	class TrueFalseButtonClickListener implements View.OnClickListener {

		private boolean trueFlase;

		TrueFalseButtonClickListener(boolean trueFlase) {
			this.trueFlase = trueFlase;
		}

		@Override
		public void onClick(View v) {
			checkAnswer(trueFlase);
		}

		private void showToast(int toastId) {
			Toast.makeText(QuizActivity.this, toastId, Toast.LENGTH_SHORT)
					.show();
		}

		private void checkAnswer(boolean pressedTrue) {
			showToast(mIsCheater ? R.string.judgment_toast
					: (mQuestionBank[mCurrentIndex].ismTrueQuestion() == pressedTrue ? R.string.correct_toast
							: R.string.incorrect_toast));
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (data != null) {
			mIsCheater = data.getBooleanExtra(CheatActivity.EXTRA_ANSWER_SHOWN,
					false);
		}
	}

	@TargetApi(11)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate(Bundle) called");
		setContentView(R.layout.activity_quiz);

		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			ActionBar actionBar = getActionBar();
			actionBar.setSubtitle("Bodies of Water");
		}
		
		mQuestionTextView = (TextView) findViewById(R.id.question_text_view);

		mTrueButton = (Button) findViewById(R.id.true_button);

		mTrueButton.setOnClickListener(new TrueFalseButtonClickListener(true));

		mFalseButton = (Button) findViewById(R.id.false_button);
		mFalseButton
				.setOnClickListener(new TrueFalseButtonClickListener(false));

		mNextButton = (Button) findViewById(R.id.next_button);
		mNextButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
				mIsCheater = false;
				updateQuestion();
			}
		});

		mCheatButton = (Button) findViewById(R.id.cheat_button);
		mCheatButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(QuizActivity.this,
						CheatActivity.class);
				intent.putExtra(CheatActivity.EXTRA_ANSWER_IS_TRUE,
						mQuestionBank[mCurrentIndex].ismTrueQuestion());
				startActivityForResult(intent, 0);
			}
		});

		if (savedInstanceState != null) {
			mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
		}
		updateQuestion();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.quiz, menu);
		return true;
	}

	@Override
	protected void onSaveInstanceState(Bundle savedInstanceState) {
		super.onSaveInstanceState(savedInstanceState);
		Log.d(TAG, "onSaveInstanceState(Bundle) called");
		savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
	}

	@Override
	public void onStart() {
		super.onStart();
		Log.d(TAG, "onStart() called");
	}

	@Override
	public void onResume() {
		super.onResume();
		Log.d(TAG, "onResume() called");
	}

	@Override
	public void onPause() {
		super.onPause();
		Log.d(TAG, "onPause() called");
	}

	@Override
	public void onStop() {
		super.onStop();
		Log.d(TAG, "onStop() called");
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d(TAG, "onDestroy() called");
	}
}
