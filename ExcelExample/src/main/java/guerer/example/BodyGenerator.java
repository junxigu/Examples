package guerer.example;

import java.util.List;

import jxl.write.WritableSheet;

public interface BodyGenerator {

	void generate(WritableSheet wsheet, int rowStartIndex,
			List<List<String>> rowlist);

}
