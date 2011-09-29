package callcenter.generators.labels_messages;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class LabelsAndMessagesInsertsGenerator {

    public static void main(String[] args) throws BiffException, IOException {
	generate();
    }

    public static void generate() throws BiffException, IOException {
	Workbook workbook = Workbook.getWorkbook(new File(
		"generators/data/mseLabelsAndMessages.xls"));
	int valueId = 1;
	int holderId = 1;
	String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	Sheet sheet = workbook.getSheet(0);
	String holderCode = null;
	File file = new File("sql/labels_messages/labelsAndMessages.sql");
	file.createNewFile();
	BufferedWriter out = new BufferedWriter(new FileWriter(file));

	String lineSeparator = System.getProperty("line.separator");

	out.write("delete from Value where code = 1000 or code = 1001;");
	out.write(lineSeparator);
	out.write("delete from Holder where code = 1000 or code = 1001;");
	out.write(lineSeparator);

	for (int i = 2;; i++) {
	    String code = sheet.getCell(0, i).getContents();
	    String value = sheet.getCell(1, i).getContents();
	    String descrEn = sheet.getCell(2, i).getContents() != null ? sheet
		    .getCell(2, i).getContents().replaceAll("'", "''") : "";
	    String descrBg = sheet.getCell(3, i).getContents() != null ? sheet
		    .getCell(3, i).getContents().replaceAll("'", "''") : "";
	    if (areAllCellsEmpty(code, value, descrEn, descrBg)) {
		break;
	    } else {
		if (code != null && code.length() > 0) {
		    out.write(MessageFormat
			    .format("insert into Holder values({0}, ''{1}'', {2}, ''{3}'', ''{4}'');",
				    holderId, today, code, descrBg, descrEn));
		    out.write(lineSeparator);
		    holderId++;
		    holderCode = code;
		} else {
		    out.write(MessageFormat
			    .format("insert into Value values ({0}, ''{1}'', ''{2}'', ''{3}'', ''{4}'', {5});",
				    valueId, today, descrBg, value, descrEn,
				    holderCode));
		    out.write(lineSeparator);
		    valueId++;
		}
	    }
	}
	out.flush();
	out.close();
    }

    public static boolean areAllCellsEmpty(String code, String value,
	    String descrEn, String descrBg) {
	if (code != null && code.length() > 0) {
	    return false;
	}
	if (value != null && value.length() > 0) {
	    return false;
	}
	if (descrBg != null && descrBg.length() > 0) {
	    return false;
	}
	if (descrEn != null && descrEn.length() > 0) {
	    return false;
	}
	return true;
    }
}
