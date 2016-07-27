package guerer.example.impl;

import guerer.example.TitleGenerator;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WriteException;

public class TitleGeneratorImpl implements TitleGenerator {

	private String[] titles = null;

	public String[] getTitles() {
		return titles;
	}

	private int fontSize = 15;

	public TitleGeneratorImpl(String[] titles) {
		this.titles = titles;
	}

	private WritableCellFormat getDefaultStyle() throws WriteException {
		// Set the font and color for titles
		WritableFont wfont = new WritableFont(WritableFont.ARIAL, fontSize,
				WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
				Colour.BLACK);
		WritableCellFormat wcfFC = new WritableCellFormat(wfont);
		wcfFC.setBackground(Colour.YELLOW);
		wcfFC.setBorder(Border.ALL, BorderLineStyle.MEDIUM, Colour.GRAY_25);
		return wcfFC;
	}

	public void generate(WritableSheet wsheet) {
		try {
			WritableCellFormat wcfFC = getDefaultStyle();
			// Create the titles: label(col, row, title)
			for (int i = 0; i < titles.length; i++) {
				wsheet.addCell(new Label(i, 0, titles[i], wcfFC));
			}
		} catch (WriteException e) {
			throw new RuntimeException(e);
		}
	}

}
