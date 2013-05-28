package com.kjlink.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class ExcelImport {

	public static List<List<String>> excelToList(File filePath) throws Exception {

		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(filePath));

		HSSFSheet sheet = workbook.getSheetAt(0);

		int rows = sheet.getLastRowNum(); // 获得数据总行

		List<List<String>> finalResultList = new ArrayList<List<String>>();// 得到的数据结果
		if (rows > 0 && rows >= 1) {// 行数大于0且大于等于标题行
			HSSFRow row = null; // 每行记录数
			int lastcell = 0;

			row = sheet.getRow(1 - 1);// 找到标题行
			lastcell = row.getLastCellNum();// 得到最后标题行的单元格数，以这行单元格的个数为参照。其他行单元格大于该行将不读，小于该行将缺少的单元格设置为空字符串

			for (int r = 0; r <= rows; r++) {
				row = sheet.getRow(r);
				if (row != null) {
					List<String> tempList = new ArrayList<String>();// 存放一行单元格的数据

					for (int i = 0; i < lastcell; i++) {
						tempList.add("");
					}

					int cellnum = row.getLastCellNum();

					for (int c = 0; c < cellnum; c++) {
						if (c < lastcell) {
							if(row.getCell(c) == null){
								tempList.set(c,"");
							}else{
								row.getCell(c).setCellType(Cell.CELL_TYPE_STRING);
								tempList.set(c,row.getCell(c).toString());
							}
						}
					}

					finalResultList.add(tempList);
				}
			}
		}
		return finalResultList;
	}
}
