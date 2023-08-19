package rough;

import java.util.List;

import tech.tablesaw.api.Table;
import tech.tablesaw.io.xlsx.XlsxReadOptions;
import tech.tablesaw.io.xlsx.XlsxReader;

public class roughwork {
	
	public static void main(String[] args) {
		try {
			XlsxReadOptions options = XlsxReadOptions.builder("D:\\IT\\java_practice\\framework_build_project\\test_dev_project\\test_data\\driver_excel.xlsx").build();
			XlsxReader xlsxReader = new XlsxReader();
			String sheet_name = "test_sheet_1";
			List<Table> tables=  xlsxReader.readMultiple(options);
			//Table test_dat_table = xlsxReader.read(options);
			Table test_data_table = null;
			for(int i = 0; i < tables.size(); i++) {
				if(tables.get(i).name().toString().contains(sheet_name)) {
					test_data_table = tables.get(i);
					break;
				}
			}
			String data = "";
			for(int i = 0; i < test_data_table.rowCount(); i++) {
				if(test_data_table.get(i, 0).toString().equalsIgnoreCase("test_1")) {
					data = test_data_table.getString(i, "product_name");
					break;
				}
			}
			System.out.println("data = " + data);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
		

}
