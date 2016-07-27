package guerer.example.impl;

import java.util.List;

import jxl.write.WritableSheet;
import guerer.example.ColumnViewSetter;

public class ColumnViewSetterImpl implements ColumnViewSetter {

	public void setColumnView(WritableSheet wsheet, String[] titles,
			List<List<String>> list) {
		int columLen[] = new int[titles.length];

		for (int i = 0; i < titles.length; i++) {
			columLen[i] = columLen[i] < titles[i].length() ? titles[i].length()
					: columLen[i];
		}

		for (List<String> row : list) {
			for (int i = 0; i < row.size(); i++) {
				columLen[i] = columLen[i] < row.get(i).length() ? row.get(i)
						.length() : columLen[i];
			}
		}

		for (int i = 0; i < titles.length; i++) {
			wsheet.setColumnView(i, columLen[i] * 1);
		}
	}

}
