package com.example.remotecontrol;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class RemoteControlFragment extends Fragment {

	private TextView selectedTextView;
	private TextView workingTextView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_remote_control, parent,
				false);

		selectedTextView = (TextView) view
				.findViewById(R.id.fragment_remote_control_selectedTextView);
		workingTextView = (TextView) view
				.findViewById(R.id.fragment_remote_control_workingTextView);

		View.OnClickListener numberClickListener = new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String text = ((TextView) v).getText().toString();
				String working = workingTextView.getText().toString();
				workingTextView.setText(working.equals("0") ? text : working
						+ text);
			}
		};

		TableLayout tableLayout = (TableLayout) view
				.findViewById(R.id.fragment_remote_control_tableLayout);
		int number = 1;
		for (int i = 2; i < tableLayout.getChildCount() - 1; i++) {
			TableRow row = (TableRow) tableLayout.getChildAt(i);
			for (int j = 0; j < row.getChildCount(); j++) {
				Button btn = (Button) row.getChildAt(j);
				btn.setText(String.valueOf(number));
				btn.setOnClickListener(numberClickListener);
				number++;
			}
		}

		Button deleteButton = (Button) ((TableRow) tableLayout
				.getChildAt(tableLayout.getChildCount() - 1)).getChildAt(0);
		deleteButton.setText("Delete");
		deleteButton.setTextAppearance(getActivity(), R.style.RemoteButton_BoldText);
		deleteButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				workingTextView.setText("0");
			}
		});

		Button zeroButton = (Button) ((TableRow) tableLayout
				.getChildAt(tableLayout.getChildCount() - 1)).getChildAt(1);
		zeroButton.setText("0");
		zeroButton.setOnClickListener(numberClickListener);

		Button enterButton = (Button) ((TableRow) tableLayout
				.getChildAt(tableLayout.getChildCount() - 1)).getChildAt(2);
		enterButton.setText("Enter");
		enterButton.setTextAppearance(getActivity(), R.style.RemoteButton_BoldText);
		enterButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				CharSequence working = workingTextView.getText();
				if (working.length() > 0) {
					selectedTextView.setText(working);
				}
				workingTextView.setText("0");
			}
		});

		return view;
	}
}
