/**
 * 
 */
package callcenter.generators.privileges;

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

/**
 * @author bassextremist
 * 
 */
public class PrivilegesGenerator {

    /**
     * @param args
     */
    public static void main(String[] args) throws BiffException, IOException {
	generate();

    }

    public static void generate() throws BiffException, IOException {
	Workbook workbook = Workbook.getWorkbook(new File(
		"generators/data/msePrivileges.xls"));
	int id = 1;
	String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	Sheet sheet = workbook.getSheet(0);
	File file = new File("sql/privileges/privileges.sql");
	file.createNewFile();
	BufferedWriter out = new BufferedWriter(new FileWriter(file));

	String lineSeparator = System.getProperty("line.separator");

	out.write("delete from Privilege;");
	out.write(lineSeparator);

	for (int i = 2;; i++) {
	    String code = sheet.getCell(0, i).getContents();
	    String entityArea = sheet.getCell(1, i).getContents();
	    String descrEn = sheet.getCell(2, i).getContents() != null ? sheet
		    .getCell(2, i).getContents().replaceAll("'", "''") : "";
	    String descrBg = sheet.getCell(3, i).getContents() != null ? sheet
		    .getCell(3, i).getContents().replaceAll("'", "''") : "";
	    if (areAllCellsEmpty(code, entityArea, descrEn, descrBg)) {
		break;
	    } else {
		out.write(MessageFormat
			.format("insert into Privilege(id, lastModifiedDate, code, entityArea, description, descriptionBg) "
				+ "values({0}, ''{1}'', {2}, ''{3}'', ''{4}'', ''{5}'');",
				id, today, code, entityArea, descrEn, descrBg));
		out.write(lineSeparator);
		id++;
	    }
	}
	out.flush();
	out.close();

    }

    public static boolean areAllCellsEmpty(String code, String value,
	    String descrEn, String descrBg) {
	if (code != null && code.trim().length() > 0) {
	    return false;
	}
	if (value != null && value.trim().length() > 0) {
	    return false;
	}
	if (descrBg != null && descrBg.trim().length() > 0) {
	    return false;
	}
	if (descrEn != null && descrEn.trim().length() > 0) {
	    return false;
	}
	return true;
    }

}
