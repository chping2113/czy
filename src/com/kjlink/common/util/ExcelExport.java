package com.kjlink.common.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;

import com.kjlink.ahpips.Constants;

public class ExcelExport {
	public String sheetname="";
	public String filename="";
	public HSSFWorkbook _wb=null;
	public HSSFSheet st = null;	
	public int sheetcount=0;
	public int headlines=2;
	public int nextline=0;
	public String excelpath="";
	public String excelname="";
	public List dateList;//需要显示的数据列表
	
	/**打印调试语句*/
	public void out(Object object){
		//System.out.println(object);
	}
	public ExcelExport(){
		
		_wb=new HSSFWorkbook();
		out("构造");
	}
	public List<List> changeSqlToList(String sql) throws Exception {
		/*DBOperator db=new DBOperator();
		return db.ExecuteSelect(true, sql);*/
		return null;
	}


	public HSSFSheet creationSheet()
			throws Exception {
		return _wb.createSheet(sheetname);
	}

	public HSSFSheet setBody(List<List> list) throws Exception {
		int lines=headlines;
		for(int i=0;i<list.size();i++){
				HSSFRow row = st.createRow(lines++);
				List headList=(List)list.get(i);
				for(int j=0;j<headList.size();j++){
					HSSFCell cell = row.createCell(j);
					if(j>0){
						cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
						cell.setCellValue(Double.parseDouble(headList.get(j).toString()));
					}else {
						cell.setCellType(HSSFCell.CELL_TYPE_STRING);
						cell.setCellValue(headList.get(j).toString());
					}
				}
		}
		out("表体");
		return st;
		 
	}
	public HSSFCellStyle setHeadCss(){
		HSSFFont font = _wb.createFont();
		HSSFCellStyle cellStyle = _wb.createCellStyle();
		font.setColor(HSSFFont.COLOR_NORMAL);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//
		cellStyle.setFont(font);
		return cellStyle;
	}
	public String setDataListGetExcel(List<List> list, String filename)
			throws Exception {
		writeExcel(list,filename);
		out("调用");
		getExcel();
		return getExcelPath();
	}
	public void writeExcel(List<List> list, String filename) throws Exception {
		if("".equals(sheetname)){
			this.sheetname=filename;
		}
		dateList=list;
		this.filename=filename;
		st=creationSheet();
		setColumnWidth(st);
		st=setHead(list);
		st=setBody(list);
		st=setEnd(list);
		out("生成poi文件");
	}
	private void setColumnWidth(HSSFSheet st) {
		st.setColumnWidth((short)   0,   (short)   7000);
		st.setColumnWidth((short)   1,   (short)   4000);
		st.setColumnWidth((short)   2,   (short)   4000);
		st.setColumnWidth((short)   3,   (short)   4000);
		st.setColumnWidth((short)   4,   (short)   4000);
		st.setColumnWidth((short)   5,   (short)   4000);
		st.setColumnWidth((short)   6,   (short)   4000);
		st.setColumnWidth((short)   7,   (short)   4000);
		st.setColumnWidth((short)   8,   (short)   4000);
		st.setColumnWidth((short)   9,   (short)   4000);
		st.setColumnWidth((short)   10,   (short)   4000);
		st.setColumnWidth((short)   11,   (short)   4000);
		st.setColumnWidth((short)   12,   (short)   4000);
	}

	public String setDataListGetExcel(List<List>[] list, String filename,
			String[] sheetname) throws Exception {
		for (int i = 0; i < list.length; i++) {
			if(i<=sheetname.length&sheetname[i]!=null){
				this.sheetname=sheetname[i];
			}else{
				this.sheetname="sheet"+String.valueOf(i);
			}
			sheetcount=list.length;
			writeExcel(list[i],filename);
			
		}
		getExcel();
		return getExcelPath();
	}

	public HSSFSheet setEnd(List<List> list) throws Exception {
		// TODO Auto-generated method stub
		return st;
	}

	public String getExcelPath() throws Exception {
		// TODO Auto-generated method stub
		return this.excelpath;
	}

	public HSSFSheet setHead(List<List> list) throws Exception {
		HSSFRow row = st.createRow(0);
		HSSFCell cell = row.createCell(0);
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellStyle(this.setHeadCss());
		cell.setCellValue("项目信息和信用信息公开进度统计 ");
		Region region = new Region(0,(short)0,0,(short)12);
		st.addMergedRegion(region);
		
		
		/*row = st.createRow(1);
		cell = row.createCell(0);
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellStyle(this.setHeadCss());
		cell.setCellValue("导出时间：");
		cell = row.createCell(1);
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		HSSFCellStyle cellStyle=this.setHeadCss();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);//
		cell.setCellStyle(cellStyle);
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String dateString=sdf.format(new Date()); 
		cell.setCellValue(dateString); 
		region = new Region(1,(short)1,1,(short)6);
		st.addMergedRegion(region);*/ 
		
		row = st.createRow(1);
		cell = row.createCell(0);
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellStyle(this.setHeadCss());
		cell.setCellValue("发布单位");
		cell = row.createCell(1);
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellStyle(this.setHeadCss());
		cell.setCellValue("项目审批信息"); 
		cell = row.createCell(2);
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellStyle(this.setHeadCss());
		cell.setCellValue("建设管理信息"); 
		cell = row.createCell(3);
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellStyle(this.setHeadCss());
		cell.setCellValue("土地权信息"); 
		cell = row.createCell(4);
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellStyle(this.setHeadCss());
		cell.setCellValue("矿业权信息"); 
		cell = row.createCell(5);
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellStyle(this.setHeadCss());
		cell.setCellValue("招投标信息"); 
		cell = row.createCell(6);
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellStyle(this.setHeadCss());
		cell.setCellValue("单位信用等级公告"); 
		cell = row.createCell(7);
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellStyle(this.setHeadCss());
		cell.setCellValue("单位基本信息"); 
		cell = row.createCell(8);
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellStyle(this.setHeadCss());
		cell.setCellValue("单位资质信息"); 
		cell = row.createCell(9);
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellStyle(this.setHeadCss());
		cell.setCellValue("个人资质信息"); 
		cell = row.createCell(10);
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellStyle(this.setHeadCss());
		cell.setCellValue("单位良好信息"); 
		cell = row.createCell(11);
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellStyle(this.setHeadCss());
		cell.setCellValue("单位不良信息"); 
		cell = row.createCell(12);
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellStyle(this.setHeadCss());
		cell.setCellValue("总数"); 
		out("表头");
		return st;
	}

	public String setSqlGetExcel(String sql, String filename) throws Exception {
		List list =changeSqlToList(sql);
		out(list);
		setDataListGetExcel(list,filename);
		return getExcelPath();
	}

	public String setSqlGetExcel(String[] sql, String filename,
			String[] sheetname) throws Exception {
		for (int i = 0; i < sql.length; i++) {
			if(i<=sheetname.length&sheetname[i]!=null){
				this.sheetname=sheetname[i];
			}else{
				this.sheetname="sheet"+String.valueOf(i);
			}
			sheetcount=sql.length;
			setSqlGetExcel(sql[i],filename);
		}
		getExcel();
		return getExcelPath();
	}

	public void getExcel() throws Exception {
		out(filename);
		String path = "";
		
		//之前的"/"被置换成File.separator,以适应不同操作系统下的分隔符不同
		path = this.getClass().getResource(File.separator).getPath();
		path = path.substring(0, path.lastIndexOf("W") - 1);
		path = path + File.separator+Constants.UPLOAD_FILE;
		path=path.replace("%20", " ");
		FileOutputStream fileOut = new FileOutputStream(path+ File.separator + "" + filename+".xls");
		_wb.write(fileOut);// 把Workbook对象输出到文件workbook.xls中
		fileOut.close();
		this.excelpath=path+ File.separator + "" + filename+".xls";
		this.excelname=filename+".xls";
	}
	

	public static void main(String[] args) {
		ExcelExport export=new ExcelExport();
		List[] list1 =new List[3];
		String[] a={"测试","是","啊","单元格限制测试"};
		for(int j=0;j<3;j++){
			List list =new ArrayList();
			for(int i=0;i<100;i++){
				List list_ =new ArrayList();
				list_.add("省发改委"+i);
				list_.add(333);
				list_.add(666666666);
				list_.add(2222);
				list_.add(2222);
				list_.add(7777);
				list_.add(8888);
				list_.add(2222);
				list_.add(2222);
				list_.add(3333);
				list_.add(5555);
				list_.add(4444);
				list_.add(9999);
				list.add(list_);
			}
			list1[j]=list;
		}
		try {
			
			export.setDataListGetExcel(list1, "导出测试", a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getExcelName() throws Exception {
		// TODO Auto-generated method stub
		return this.excelname;
	}
}
