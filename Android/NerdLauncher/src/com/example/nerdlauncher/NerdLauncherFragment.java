package com.example.nerdlauncher;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class NerdLauncherFragment extends ListFragment {

	private static final String TAG = "NerdLauncherFragment";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_LAUNCHER);

		PackageManager pm = getActivity().getPackageManager();
		List<ResolveInfo> activities = pm.queryIntentActivities(intent, 0);
		Log.i(TAG, "I've found " + activities.size() + " activities");

		Collections.sort(activities, new Comparator<ResolveInfo>() {

			@Override
			public int compare(ResolveInfo lhs, ResolveInfo rhs) {
				PackageManager pm = getActivity().getPackageManager();
				return String.CASE_INSENSITIVE_ORDER.compare(lhs.loadLabel(pm)
						.toString(), rhs.loadLabel(pm).toString());
			}

		});

		ArrayAdapter<ResolveInfo> adapter = new ArrayAdapter<ResolveInfo>(
				getActivity(), android.R.layout.simple_list_item_1, activities) {
			@Override
			public View getView(int pos, View convertView, ViewGroup parent) {
				TextView tv = (TextView) super
						.getView(pos, convertView, parent);
				tv.setText(getItem(pos).loadLabel(
						getActivity().getPackageManager()));
				return tv;
			}
		};
		setListAdapter(adapter);
	}

	@Override
	public void onListItemClick(ListView listView, View view, int pos, long id) {
		ActivityInfo info = ((ResolveInfo) listView.getAdapter().getItem(pos)).activityInfo;
		Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.setClassName(info.applicationInfo.packageName, info.name);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(intent);
	}
}
