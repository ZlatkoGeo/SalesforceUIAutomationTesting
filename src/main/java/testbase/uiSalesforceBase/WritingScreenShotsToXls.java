package testbase.uiSalesforceBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.ClientAnchor.AnchorType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class WritingScreenShotsToXls extends BasePage{
	
	public void screenShotToExcel(int setSheet, int setColon, int setRow) throws IOException {
		
		Date currentdate = new Date();
		String screenshotfilename = currentdate.toString().replace(" ", "-").replace(":", "-");

		String projectPath = System.getProperty("user.dir");
		String excelFilePath = projectPath + "\\src\\test\\resources\\8.1-TEMPLATE-TestCase.xlsx";

		// Load existing Excel document
		FileInputStream fis = new FileInputStream(excelFilePath);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheetAt(setSheet); // Get the first sheet
		
		// Example test steps
		Row row = sheet.getRow(0);
		Cell actualResultCell1 = row.createCell(0); 

		// Take a screenshot
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = ".\\ScreenShots\\" + screenshotfilename + ".png"; // Save path for screenshots
		Files.copy(screenshot.toPath(), Paths.get(screenshotPath));

		// Update Excel with screenshot path
		actualResultCell1.setCellValue("Check Screenshot: " + screenshotPath);

		// Add image to Excel (if required)
		// Load the image
		FileInputStream imageStream = new FileInputStream(screenshotPath);
		byte[] bytes = imageStream.readAllBytes();
		int pictureIdx = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
		imageStream.close();

		//.readAllBytes

		// Create the drawing and anchor
		CreationHelper helper = workbook.getCreationHelper();
		Drawing<?> drawing = sheet.createDrawingPatriarch();
		ClientAnchor anchor = helper.createClientAnchor();
		anchor.setCol1(setColon);
		anchor.setRow1(setRow);
		anchor.setAnchorType(AnchorType.MOVE_AND_RESIZE);
		
		// Create the picture
		Picture picture = drawing.createPicture(anchor, pictureIdx);
		picture.resize(0.13, 0.08);
		
		// Write back to Excel file
		fis.close();
		FileOutputStream fos = new FileOutputStream(excelFilePath);
		workbook.write(fos);
		fos.close();
		workbook.close();

		log.info("Excel file updated successfully!");
	}
}
