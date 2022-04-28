package utility;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class DataProvider {



    public static Object[][] getMyData(String filePath,String sheetName) throws IOException {

        FileInputStream fis =new FileInputStream(filePath);

        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        XSSFSheet sheet = workbook.getSheet(sheetName);

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount-1][colCount]; // rowCount =6

        for (int i=0;i<rowCount-1;i++) //
        {
            XSSFRow row = sheet.getRow(i+1);

            for(int j=0;j<colCount;j++) {
                XSSFCell cell = row.getCell(j);
                if (cell == null)
                    data[i][j] = "";
                else
                    data[i][j] = cell.toString().trim();
            }

        }

        return  data;
    }
}
