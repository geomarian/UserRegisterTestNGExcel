package com.testUtil;

import java.util.ArrayList;

import com.excel1.utility.Xls_Reader;



public class testUtilities {

	 static Xls_Reader reader;
	
	
	public static ArrayList<Object[]> getDataFromExcel() { 
		
		
		ArrayList<Object[]> myData =new ArrayList<Object[]>();
		
		try{
			reader = new Xls_Reader("E:\\GEO\\Selenium Sample\\list\\src\\main\\java\\com\\testData\\TestDataOne.xlsx");
					
					//("E:\\GEO\\Selenium Sample\\list\\src\\main\\java\\com\\testData\\TestDataOne.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(int rowNum=2; rowNum <= reader.getRowCount("register"); rowNum++)
{
			String firsname = reader.getCellData("register","firstname",rowNum);
			String lastname = reader.getCellData("register","lastname",rowNum);
			String email = reader.getCellData("register","email",rowNum);
			String companyName = reader.getCellData("register","companyName",rowNum);

			
			Object obj[] = {firsname,lastname,email,companyName};
			
			myData.add(obj);
			
		
		
	}


return myData;


}
}
