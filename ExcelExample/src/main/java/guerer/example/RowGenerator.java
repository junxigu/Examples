package guerer.example;

import java.util.List;

import jxl.write.WritableSheet;

public interface RowGenerator {

	void generate(WritableSheet wsheet, int rowIndex, List<String> row);
	
}
