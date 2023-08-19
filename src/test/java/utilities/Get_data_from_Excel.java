package utilities;

import java.io.*;
import java.util.List;

import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import tech.tablesaw.api.Table;
import tech.tablesaw.io.xlsx.XlsxReadOptions;
import tech.tablesaw.io.xlsx.XlsxReader;
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
	
	public static String fetch_val(String filepath, String sheet_name, String row_name, String col_name)throws Throwable{
		String res_val = "";
		try {
			XlsxReadOptions options = XlsxReadOptions.builder(filepath).build();
			XlsxReader xlsxReader = new XlsxReader();
			List<Table> tables=  xlsxReader.readMultiple(options);
			Table test_data_table = null;
			for(int i = 0; i < tables.size(); i++) {
				if(tables.get(i).name().toString().contains(sheet_name)) {
					test_data_table = tables.get(i);
					break;
				}
			}
			for(int i = 0; i < test_data_table.rowCount(); i++) {
				if(test_data_table.get(i, 0).toString().equalsIgnoreCase(row_name)) {
					res_val = test_data_table.getString(i, col_name);
					break;
				}
			}
			System.out.println("Value from [" + filepath.split("/")[filepath.split("/").length - 1] + 
					"][" + sheet_name + "][" +row_name + "][" + col_name + "] = <---" + res_val + "--->");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return res_val;
	}
	
	public static void main(String[] args) throws Throwable {
//		get_val("test_1", "processor");
		String file_path = (System.getProperty("user.dir") + Read_config.get_from_config("test_data_path"));
		System.out.println("file_path = " + file_path);
		fetch_val(System.getProperty("user.dir") + Read_config.get_from_config("test_data_path"), 
				Read_config.get_from_config("test_sheet_name"), "test_1", "product_name");
	}

}
