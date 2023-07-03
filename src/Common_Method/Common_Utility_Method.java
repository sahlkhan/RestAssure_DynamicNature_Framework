package Common_Method;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;

public class Common_Utility_Method {
	public static void Evidencecreator(String FileName, String RequestBody, String ResponseBody, int statuscode)
			throws IOException {
		File TextFile = new File("D:\\mssquare class recording\\RestAssure\\Evidense\\" + FileName + ".txt");
		System.out.println("New blank text file of name :" + TextFile.getName());
		// if want write already existing file we use FileWritter
		FileWriter Data = new FileWriter(TextFile);
		//
		Data.write("RequestBody is :" + RequestBody + "/n/n");
		Data.write("ResponseBody is :" + ResponseBody + "/n/n");
		Data.write("statuscode is :" + statuscode + "/n/n");
		// close and save the file
		Data.close();
		System.out.println("RequestBody and ResponseBody is written in textfile" + TextFile.getName());
	}

	public static ArrayList<String> ReadExcelData(String Sheetname, String TestCaseName) throws IOException {
		ArrayList<String> ArrayData = new ArrayList<String>();
		// create the object FileInputStream For Locate the File
		FileInputStream Fis = new FileInputStream(
				"D:\\mssquare class recording\\RestAssure\\Selenium\\SahilRestAssure.xlsx");
		// create a object XSSFWorkbook to open the excel file
		XSSFWorkbook WorkBook = new XSSFWorkbook(Fis);
		// Open the desired sheet
		int countsheet = WorkBook.getNumberOfSheets();
		for (int i = 0; i < countsheet; i++) {
			String sheetname = WorkBook.getSheetName(i);
			if (sheetname.equalsIgnoreCase(Sheetname)) {
				XSSFSheet Sheet = WorkBook.getSheetAt(i);
				// Create iterator to iterate through rows and find out in which column the test
				// case names are found
				Iterator<Row> Rows = Sheet.iterator();
				Row FirstRow = Rows.next();
				// iterate through Cell of first row find out which cell contain TestCaseName
				Iterator<Cell> CellOfFirstRow = FirstRow.cellIterator();
				int k = 0;
				int TC_coloumn = 0;
				while (CellOfFirstRow.hasNext()) {
					Cell CellValue = CellOfFirstRow.next();
					if (CellValue.getStringCellValue().equalsIgnoreCase("TestCaseName")) {
						TC_coloumn = k;
						break;
					}
					k++;
				}
				while(Rows.hasNext())
				{
					Row DataRow=Rows.next();
					String TCName=DataRow.getCell(TC_coloumn).getStringCellValue();
					if(TCName.equalsIgnoreCase(TestCaseName))
					{
						Iterator<Cell>CellValue=DataRow.cellIterator();
						while(CellValue.hasNext())
						{
							String Data=CellValue.next().getStringCellValue();
							ArrayData.add(Data);
						}
						break;
					}
					
				}

			}
	}
		return ArrayData;
}
}