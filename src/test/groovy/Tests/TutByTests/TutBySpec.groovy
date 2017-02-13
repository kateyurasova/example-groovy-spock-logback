package Tests.TutByTests

import Pages.TutByPages.TutMainPage
import geb.spock.GebReportingSpec

public class TutBySpec extends GebReportingSpec {

    def "Tut Main page authorization"() {
        when:
        def tutMainPage = to TutMainPage
        tutMainPage.login("kvadr99@tut.by", "EpamForever")

        then:
        waitFor {
            tutMainPage.userNameSpan.text() == "Екатерина Юрасова"
        }
    }

}
