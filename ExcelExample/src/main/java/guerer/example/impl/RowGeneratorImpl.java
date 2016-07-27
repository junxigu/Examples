package guerer.example.impl;

import guerer.example.RowGenerator;

import java.util.List;

import jxl.write.Label;
import jxl.write.WritableSheet;

public class RowGeneratorImpl implements RowGenerator {

	public void generate(WritableSheet wsheet, int rowIndex, List<String> row) {
		// Create content
		for (int j = 0; j < row.size(); j++) {
			try {
				wsheet.addCell(new Label(j, rowIndex, row.get(j)));
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

}
