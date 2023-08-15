package utilities;

import java.io.*;

import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utilities.*;

public class Get_data_from_Excel {
	
	public String get(String row_name, String col_name) throws Throwable{
		String result_val = "";
		try {
			FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir") + Read_config.get_from_config("test_data_path")));
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet ws = wb.getSheet(Read_config.get_from_config("test_sheet_name"));
			int no_of_rows = ws.getPhysicalNumberOfRows();
			int no_of_cols = ws.getRow(0).getPhysicalNumberOfCells();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result_val;
	}

}
