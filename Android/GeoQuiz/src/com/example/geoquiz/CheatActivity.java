package com.example.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends Activity {

	public static final String EXTRA_ANSWER_IS_TRUE = "com.example.geoquiz.answer_is_true";
	public static final String EXTRA_ANSWER_SHOWN = "com.example.geoquiz.answer_show";
	private boolean mAnswerIsTrue;

	private Button mShowAnswer;
	private TextView mAnswerTextView;

	private void setAnswerShownResult(boolean isAnswerShown) {
		Intent intent = new Intent();
		intent.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
		setResult(RESULT_OK, intent);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cheat);

		mAnswerIsTrue = getIntent()
				.getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

		mAnswerTextView = (TextView) findViewById(R.id.answerTextView);

		mShowAnswer = (Button) findViewById(R.id.showAnswerButton);
		mShowAnswer.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				mAnswerTextView.setText(mAnswerIsTrue ? R.string.true_button
						: R.string.false_button);
				setAnswerShownResult(true);
			}
		});

		setAnswerShownResult(false);
	}

}
