package org.app.Report;


import com.itextpdf.text.DocumentException;

import java.io.IOException;

public interface ReportWriter {
    void writeReport () throws DocumentException, IOException;
}
