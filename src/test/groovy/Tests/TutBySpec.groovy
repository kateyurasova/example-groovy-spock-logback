package Tests

import Pages.SearchResultsPage
import Pages.TutMainPage
import geb.spock.GebReportingSpec
import org.gradle.api.logging.*;

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
