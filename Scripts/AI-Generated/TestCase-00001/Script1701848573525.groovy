import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling
import internal.GlobalVariable as GlobalVariable
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

'Initialize test session: Open browser and set view port'

@com.kms.katalon.core.annotation.SetUp
def setup() {
	WebUI.openBrowser('')
	WebUI.setViewPortSize(1920, 1080)	
}

'step 1: Navigate to Page home'

WebUI.navigateToUrl(GlobalVariable.application_domain + '')

'step 2: Login at Page home --> navigate to Page inventory-item html'

CustomKeywords.'katalon.truetest.Authenticate.basic_auth'(
	GlobalVariable.application_domain + '/',
	GlobalVariable.username,
	GlobalVariable.password,
)

'step 3: Navigate to Page inventory-item html'

WebUI.navigateToUrl(GlobalVariable.application_domain + '/inventory-item.html')

'step 4: Login at Page inventory-item html'

CustomKeywords.'katalon.truetest.Authenticate.basic_auth'(
	GlobalVariable.application_domain + '/inventory-item.html',
	GlobalVariable.username,
	GlobalVariable.password,
)

'step 5: At Page inventory-item html click on button add to cart item not found'

testObj = findTestObject('AI-Generated/Page_inventory-item_html/button_add_to_cart_item_not_found')

WebUI.delay(3)

WebUI.takeScreenshot()

WebUI.verifyElementPresent(testObj, 20, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyMatch(WebUI.getUrl(), '.*/inventory-item.html/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(testObj)

'step 6: Login at Page inventory-item html'

CustomKeywords.'katalon.truetest.Authenticate.basic_auth'(
	GlobalVariable.application_domain + '/inventory-item.html',
	GlobalVariable.username,
	GlobalVariable.password,
)

'step 7: Add visual checkpoint at Page inventory-item html'

WebUI.takeFullPageScreenshotAsCheckpoint('TestCase-00001_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}
