package Tests

import Pages.TutMainPage
import geb.spock.GebReportingSpec;

public class TutBySpec extends GebReportingSpec {
    def "Tut Main page authorization"() {
        when:
        def tutMainPage = to TutMainPage

        buttonEnter.click()

        tutMainPage.with {
            fieldLogin = "kvadr99@tut.by"
            fieldPassword = "EpamForever"
            buttonSubmit.click()
        }

        then:
        waitFor {
            tutMainPage.spanUserName.text() == "Екатерина Юрасова"
        }
    }
}
