package guerer.example.service;

import guerer.example.domain.UploadResult;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class UploadService {

	public HashMap<String, Boolean> getCodes() throws IOException {
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		return map;
	}

	// Parse each row in file and insert to db
	public UploadResult parseAndUploadExcel(File file) throws IOException {
		UploadResult result = new UploadResult();
		int existedNum = 0;
		int succNum = 0;
		int formatErrNum = 0;
		
		HashMap<String, Boolean> codes = getCodes();

		InputStreamReader fr = new InputStreamReader(new FileInputStream(file));

		BufferedReader br = new BufferedReader(fr);
		String rec = br.readLine();
		// Attribute
		String[] cells = null;

		// Parse each row and insert to db
		while ((rec = br.readLine()) != null) {
			cells = rec.split(",");
			for (int i = 0; i < cells.length; i++) {
				cells[i] = cells[i].trim();
			}

			// Validate the format
			if (!cells[2].matches("^\\$?\\d*(\\d.\\d)?\\d*$")
					|| !cells[1].matches("^\\w{4}-\\w{6}-\\w{4}$")
					|| !cells[3].matches("^\\d{16}-\\w{3}$")) {
				formatErrNum++;
			} else {
				cells[2] = cells[2].startsWith("$") ? cells[2].substring(1)
						: cells[2];

				// If not exist in db then insert it
				if (!codes.containsKey(cells[1])) {
					succNum++;
				} else {
					existedNum++;
				}
			}

		}

		result.setSuccNum(succNum);
		result.setFormatErrNum(formatErrNum);
		result.setExistedNum(existedNum);

		br.close();
		return result;
	}
}
