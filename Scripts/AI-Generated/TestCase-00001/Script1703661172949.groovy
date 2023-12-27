import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

'Initialize test session: Open browser and set view port'

@com.kms.katalon.core.annotation.SetUp
def setup() {
	WebUI.openBrowser('')
	WebUI.setViewPortSize(1920, 1080)	
}

'step 1: Navigate to Page ofile'

WebUI.navigateToUrl(GlobalVariable.application_domain + '')

'step 2: Login at Page ofile --> navigate to Page home'

CustomKeywords.'katalon.truetest.Authenticate.basic_auth'(
	GlobalVariable.application_domain + 'login_profile_0',
	GlobalVariable.username,
	GlobalVariable.password,
)

'step 3: Navigate to Page home --> navigate to Page checkout-step-two html'

WebUI.navigateToUrl(GlobalVariable.application_domain + '/checkout-step-two.html')

'step 4: Login at Page checkout-step-two html --> navigate to Page home'

CustomKeywords.'katalon.truetest.Authenticate.basic_auth'(
	GlobalVariable.application_domain + '/checkout-step-two.html',
	GlobalVariable.username,
	GlobalVariable.password,
)

'step 5: Add visual checkpoint at Page home'

WebUI.takeFullPageScreenshotAsCheckpoint('TestCase-00001_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}
