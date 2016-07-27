package guerer.example;

import java.util.List;

import jxl.write.WritableSheet;

public interface ColumnViewSetter {

	void setColumnView(WritableSheet wsheet, String[] titles,
			List<List<String>> list);
	
}
