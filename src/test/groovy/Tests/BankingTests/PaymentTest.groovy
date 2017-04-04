package Tests.BankingTests

import Pages.BankingPages.BankLoginPage
import Pages.TutByPages.TutMainPage
import geb.spock.GebReportingSpec
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class PaymentTest extends GebReportingSpec {
    final static Logger log = LoggerFactory.getLogger(PaymentTest.class)
    def "User perform the payment operation"() {
        when:
        log.debug("=== SETUP PAYMENT ===")
        def bankLoginPage = to BankLoginPage
        //bankLoginPage.login("Harry Potter")

        then:
        bankLoginPage.login("Harry Potter")
        //sleep(10000)
        //Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");

    }

}
