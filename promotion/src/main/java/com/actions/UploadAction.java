package com.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.io.*;
import java.sql.*;

public class UploadAction extends ActionSupport {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

// The uploaded file
  private File upload;

  private String uploadContentType;

  private String uploadFileName;

  // The successfully insert count
  private int succNum;

  // The unsuccessfully insert count
  private int errorNum;

  //Db connection
  private Connection sqlConn = null;

  // Db parameters
  private String dbUrl = "jdbc:db2://localhost:50000/TEST";

  private String user = "xxx";

  private String password = "xxx";

  public File getUpload() {
    return upload;
  }

  public void setUpload(File upload) {
    this.upload = upload;
  }

  public int getSuccNum() {
    return succNum;
  }

  public void setSuccNum(int succNum) {
    this.succNum = succNum;
  }

  public int getErrorNum() {
    return errorNum;
  }

  public void setErrorNum(int errorNum) {
    this.errorNum = errorNum;
  }

  public void setUploadContentType(String uploadContentType) {
    this.uploadContentType = uploadContentType;
  }

  public String getUploadContentType() {
    return (this.uploadContentType);
  }

  public void setUploadFileName(String uploadFileName) {
    this.uploadFileName = uploadFileName;
  }

  public String getUploadFileName() {
    return (this.uploadFileName);
  }

  // Parse each row in file and insert to db
  private void parseExcel(File file){

    try{
      InputStreamReader fr = new InputStreamReader(new FileInputStream(file));
      BufferedReader br = new BufferedReader(fr);
      // A row
      String rec = br.readLine();
      // Attribute
      String[] cells = null;

      errorNum = 0;
      succNum = 0;

      // Parse each row and insert to db
      while ((rec = br.readLine()) != null) {
        cells = rec.split(",");

        // If not exist in db then insert it
        if(getClaim(cells[1]) == 0){
          succNum++;
          insertClaim(Integer.parseInt(cells[0]), cells[1], cells[2], cells[3]);  
        }else{
          errorNum++;
        }
      }
      
      br.close();
    }catch (IOException e) {
        e.printStackTrace();
    }
  }

  // Upload file
  public String upload() throws Exception{
    Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();  
    
    // Connect db
    sqlConn= java.sql.DriverManager.getConnection (dbUrl, user, password);    

    // Parse the upload file
    parseExcel(getUpload());

    sqlConn.close();

    sqlConn = null;
    return SUCCESS;
  }

  // Search a claim in db
  private int getClaim(String code) {
    Statement sqlStmt;
    ResultSet sqlRst;
    String query = "SELECT * FROM PROMO_CLAIMS where CLAIMCODE = '" + code + "'";

    try{ 
      sqlStmt=sqlConn.createStatement(); 

      sqlRst=sqlStmt.executeQuery(query); 

      if(sqlRst.next()){
        return 1;
      }

      sqlRst.close(); 
      sqlStmt.close(); 
    }
    catch (Exception e){ 
      System.out.println("Error caused by: " + e.toString()); 
      return -1; 
    }
    return 0; 
  }

  private void insertClaim(int sequence, String code, String amount, String serial) { 
    Statement sqlStmt;
    String query = "insert into promo_claims values(" + sequence +", '" + code 
        + "', '" + amount + "', '" + serial + "')";

    try{ 
      sqlStmt=sqlConn.createStatement(); 

      sqlStmt.executeUpdate(query); 

      sqlStmt.close(); 
    }
    catch (Exception e){ 
      System.out.println("Error caused by: " + e.toString()); 
    }
  }
}