package utilities;

import java.io.*;

import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utilities.*;

public class Get_data_from_Excel {
	
	public static String get_val(String row_name, String col_name) throws Throwable{
		String result_val = "";
		System.out.println("Inside get_val --->");
		try {
			String filepath = System.getProperty("user.dir") + Read_config.get_from_config("test_data_path");
			//System.out.println("filepath = " + filepath);
			FileInputStream fis = new FileInputStream(new File(filepath));
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			String sheet_name = Read_config.get_from_config("test_sheet_name");
			//System.out.println("sheet name = " + sheet_name);
			XSSFSheet ws = wb.getSheet(sheet_name);
			int no_of_rows = ws.getPhysicalNumberOfRows();
			int no_of_cols = ws.getRow(0).getPhysicalNumberOfCells();
			for(int i = 0; i < no_of_rows; i++) {
				if(ws.getRow(i).getCell(0).toString().equalsIgnoreCase(row_name)) {
					for(int j = 0; j < no_of_cols; j++) {
						if(ws.getRow(0).getCell(j).toString().equalsIgnoreCase(col_name)) {
							result_val = ws.getRow(i).getCell(j).toString();
							break;
						}
					}
					if(!result_val.equalsIgnoreCase("")) {
						break;
					}
				}
			}
			System.out.println("Excel val [" + row_name + "][" + col_name + "] = <---" + result_val + "--->");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Exited get_val --->");
		return result_val;
	}
	
	public static void main(String[] args) throws Throwable {
		get_val("test_1", "processor");
	}

}
