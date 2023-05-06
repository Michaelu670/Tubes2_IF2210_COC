package org.app.Report;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@AllArgsConstructor
public class SalesReport extends AbstractReport {
    private final static String fileName = "SalesReport.pdf";
    private final static String title = "Sales Report";

    public void writeReport()
            throws DocumentException, IOException {
        Document salesReport = initFile(fileName);
        salesReport.open();
        addMetaData(salesReport,title);
        initTitle(salesReport,title);
        for (int i = 0; i < listOfReport.size(); i++){
            addBill(salesReport,i);
        }
        salesReport.close();
    }






}
