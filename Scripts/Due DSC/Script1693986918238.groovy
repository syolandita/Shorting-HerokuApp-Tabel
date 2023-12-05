import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement

WebUI.openBrowser('https://the-internet.herokuapp.com/tables')

WebUI.doubleClick(findTestObject('Due Header'))

def double convertToDouble(String inputString) {
    return Double.parseDouble(inputString.replaceAll('\\$', ''))
}

List<WebElement> dataList = WebUI.findWebElements(findTestObject('Object Repository/Due data list'), 10)

double[] arrOri = new double[dataList.size()]
double[] arrSort = new double[dataList.size()]

for (int i = 0; i < dataList.size(); i++) {
    text = dataList.get(i).text

    double value = convertToDouble(text)

    arrOri[i] = value
    arrSort[i] = value
}

Arrays.sort(arrSort);

def reversedArr = new double[arrSort.length]

for (int i = 0; i < arrSort.length; i++) {
    reversedArr[i] = arrSort[arrSort.length - 1 - i]
}

assert Arrays.equals(arrOri, reversedArr)
