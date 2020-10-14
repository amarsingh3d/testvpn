package com.thestar.base;
import java.io.FileWriter;
import java.io.IOException;

public class  WriteExternalData extends ReadExternalData{
	public void WriteObjectRepositoryXML(String NewEmail) throws IOException {
        FileWriter csvWriter = new FileWriter("testUserEmails.csv",true);
        csvWriter.write(NewEmail);
        csvWriter.write("\n");
        csvWriter.flush();
        csvWriter.close();
	}
}
