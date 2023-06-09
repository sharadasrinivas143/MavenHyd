package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;
import commonFunctions.PBBranchCreation;
import commonFunctions.PBBranchUpdation;
import commonFunctions.PBBranches;
import commonFunctions.PBLogin;
import commonFunctions.PBLogout;
import config.AppUtil;
import utilities.ExcelFileUtil;

public class AppTest extends AppUtil {
       String inputpath ="./FileInput/DataEngine.xlsx";
		String outputpath ="./FileOutput/HyybridResults.xlsx";
		String TCSheet ="TestCases";
		String TSSheet ="TestSteps";
		@Test
       public void startTest()throws Throwable
		{
        boolean res = false;
		String tcres ="";
		//create reference object for excel file util class
		ExcelFileUtil xl = new ExcelFileUtil(inputpath);
		int TCCount =xl.rowcount(TCSheet);
		int TSCount =xl.rowcount(TSSheet);
		Reporter.log("No of rows in TCSheet::"+TCCount+" "+"No of rows in TSSheet::"+TSCount,true);
		//iterate all rows in TCSheet
		for(int i=1;i<=TCCount;i++)
         {
		//read cell
		String Executionstatus=xl.getCellData(TCSheet, i, 2);
		if(Executionstatus.equalsIgnoreCase("Y"))
		{
		//read tcid cell
		String TCid =xl.getCellData(TCSheet, i, 0);
		//iterate all rows in TSSheet
		for(int j=1;j<=TSCount;j++)
		{
		//read tsid cell data
			String TSid = xl.getCellData(TSSheet, j, 0);
			if(TCid.equalsIgnoreCase(TSid))
			{
			//read keyword cell
			String keyword = xl.getCellData(TSSheet, j, 3);
			if(keyword.equalsIgnoreCase("adminLogin"))
			{
			//call login page class
			PBLogin login =PageFactory.initElements(driver, PBLogin.class);
			String Para1 =xl.getCellData(TSSheet, j, 5);
			String Para2 = xl.getCellData(TSSheet, j, 6);
			res = login.verify_Login(Para1, Para2);
			}
			else if(keyword.equalsIgnoreCase("branchCreate"))
			{
			//call branch button and branch creation page class
			PBBranches branch =PageFactory.initElements(driver, PBBranches.class);
			PBBranchCreation newbranch =PageFactory.initElements(driver, PBBranchCreation.class);
			String Para1 =xl.getCellData(TSSheet, j, 5);
			String Para2 =xl.getCellData(TSSheet, j, 6);
			String Para3 =xl.getCellData(TSSheet, j, 7);
			String Para4 =xl.getCellData(TSSheet, j, 8);
			String Para5 =xl.getCellData(TSSheet, j, 9);
			String Para6 =xl.getCellData(TSSheet, j, 10);
			String Para7 =xl.getCellData(TSSheet, j, 11);
			String Para8 =xl.getCellData(TSSheet, j, 12);
			String Para9 =xl.getCellData(TSSheet, j, 13);
			branch.branchesClick();
			res =newbranch.verify_BranchCreate(Para1, Para2, Para3, Para4, Para5, Para6, Para7, Para8, Para9);
			}
			else if(keyword.equalsIgnoreCase("branchUpdate"))
			{
			PBBranches branch =PageFactory.initElements(driver, PBBranches.class);
			PBBranchUpdation branchupdate =PageFactory.initElements(driver, PBBranchUpdation.class);
			String para1 =xl.getCellData(TSSheet, j, 5);
			String para2 =xl.getCellData(TSSheet, j, 6);
			String para3 =xl.getCellData(TSSheet, j, 9);
			String para4 =xl.getCellData(TSSheet, j, 10);
			branch.branchesClick();
			res =branchupdate.verify_Updatebranch(para1, para2, para3, para4);
			}
			else if(keyword.equalsIgnoreCase("adminLogout"))
			{
			PBLogout logout =PageFactory.initElements(driver, PBLogout.class);
			res =logout.verify_Logout();
			}
			String tsres="";
			if(res)
			{
			//if res is true write as pass into status cell in TSsheet
			tsres="Pass";
			xl.setcelldata(TSSheet, j, 4, tsres, outputpath);
			}
			else
			{
			//if res is false write as fail into status cell in TSsheet
			tsres="Fail";
			xl.setcelldata(TSSheet, j, 4, tsres, outputpath);
			}
			tcres=tsres;
			}
			}
			//write as tcres into TCSheet
		xl.setcelldata(TCSheet, i, 3, tcres, outputpath);
		}
		else 
          {
       //write as blocked in TCSheet which flaged to N
		xl.setcelldata(TCSheet, i, 3, "Blocked", outputpath);

		}

		}

		}

		}






		
		
		
		
		
		
		
		
		


			
			
			
			


			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			



