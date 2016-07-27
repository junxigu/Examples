package guerer.example.impl;

import guerer.example.BodyGenerator;

import java.util.List;

import jxl.write.WritableSheet;

public class BodyGeneratorImpl implements BodyGenerator {

	private RowGeneratorImpl rowGenerator = null;

	public BodyGeneratorImpl(RowGeneratorImpl rowGenerator) {
		this.rowGenerator = rowGenerator;
	}

	public void generate(WritableSheet wsheet, int rowStartIndex,
			List<List<String>> rowlist) {
		// Create content
		for (int i = 0; rowlist != null && i < rowlist.size(); i++) {
			List<String> row = rowlist.get(i);
			rowGenerator.generate(wsheet, rowStartIndex + i, row);
		}
	}

}
