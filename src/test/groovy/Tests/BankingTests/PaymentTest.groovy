package Tests.BankingTests

import Pages.BankingPages.BankLoginPage
import Pages.TutByPages.TutMainPage
import geb.spock.GebReportingSpec

class PaymentTest extends GebReportingSpec {

    def "User perform the payment operation"() {
        when:
        def bankLoginPage = to BankLoginPage
        //bankLoginPage.login("Harry Potter")

        then:
        bankLoginPage.login("Harry Potter")
        //sleep(10000)
        //Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");

    }

}
