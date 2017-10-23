package dataprovider;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldataprovider 
{
	XSSFWorkbook wb;
	public Exceldataprovider()
	{
		
		File src=new File("./ApplicationTestData/Testdata.xlsx");
		
			
		try 
		{
			FileInputStream fis=new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
			
		}
		catch (Exception e) 
		{
			System.out.println("Exception is "+e.getMessage());
		}		
	}
	
	public String Getdata(int sheetindex, int row, int column)
	{
		String data=wb.getSheetAt(sheetindex).getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	public String Getdata(String Sheetname, int row, int column)
	{
		String data=wb.getSheet(Sheetname).getRow(row).getCell(column).getStringCellValue();
		return data;
	}
}
 