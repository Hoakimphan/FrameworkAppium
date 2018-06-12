package com.datas;

import java.io.IOException;

public class ReadDataUntils {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ReadFileExcel re = new ReadFileExcel("/DataExcel/DataTest.xlsx");
		System.out.println(re.readData("Sheet1", "Age",2));
	}

}
