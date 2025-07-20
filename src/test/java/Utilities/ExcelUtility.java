package Utilities;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtility {
    public static List<Object[]> getTestData (String filepath, String sheetName){
        List<Object[]> data=new ArrayList<>();
        try (FileInputStream fis=new FileInputStream(filepath);
             Workbook workbook= WorkbookFactory.create(fis)) {
            Sheet sheet=workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new RuntimeException("Sheet '" + sheetName + "' not found in file: " + filepath);
            }
//skipping the header row
            for(int i=1;i<=sheet.getLastRowNum();i++){
                Row row=sheet.getRow(i);
                String category=row.getCell(0).getStringCellValue();
                String searchName=row.getCell(1).getStringCellValue();
                String desc=row.getCell(2).getStringCellValue();
                data.add(new String[]{category,searchName,desc});

            }


            }catch (IOException E){
            E.printStackTrace();


        }
        return data;
    }
}
