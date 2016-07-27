package guerer.example;

import guerer.example.impl.BodyGeneratorImpl;
import guerer.example.impl.ColumnViewSetterImpl;
import guerer.example.impl.RowGeneratorImpl;
import guerer.example.impl.TitleGeneratorImpl;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ReportGenerator {

	private List<List<String>> getContent() {
		List<List<String>> body = new ArrayList<List<String>>();
		for (int i = 0; i < 3; i++) {
			List<String> row = new ArrayList<String>();
			for (int j = 0; j < 3; j++) {
				row.add("row: " + i + ", col" + j);
			}
			body.add(row);
		}
		return body;
	}

	public void generateReport() {
		generateReport("test.xls");
	}

	private void generateReport(String fileName) {
		FileOutputStream os = null;
		try {
			os = new FileOutputStream(fileName);
			WritableWorkbook wbook = Workbook.createWorkbook(os);
			WritableSheet wsheet = wbook.createSheet("Sheet 1", 0);

			// Generate the report
			generateReport(wsheet);

			wbook.write();
			wbook.close();
			os.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void generateReport(WritableSheet wsheet)
			throws RowsExceededException, WriteException {

		List<List<String>> list = getContent();
		String[] titles = new String[] { "Title 1", "Title 2", "Title 3" };

		// generator title with default title generator
		TitleGeneratorImpl titleGenerator = new TitleGeneratorImpl(titles);
		titleGenerator.generate(wsheet);

		// Create content with default body generator and row generator
		BodyGeneratorImpl bodyGenerator = new BodyGeneratorImpl(
				new RowGeneratorImpl());
		bodyGenerator.generate(wsheet, 1, list);

		// Set the ui of columns
		ColumnViewSetterImpl columnViewSetter = new ColumnViewSetterImpl();
		columnViewSetter.setColumnView(wsheet, titles, list);
		
		wsheet.getSettings().setShowGridLines(true);
	}

}
