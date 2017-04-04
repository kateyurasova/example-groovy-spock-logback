package Tests.TutByTests

import Pages.TutByPages.TutMainPage
import geb.spock.GebReportingSpec

public class TutBySpec extends GebReportingSpec {

    static final String TEST_USER_LOGIN = 'spocktest@tut.by'
    static final String TEST_USER_PASSWORD = 'EpamForever'
    static final String TEST_USER_NAME = 'Test User'

    def "Tut Main page authorization"() {

        given: "Main Page is opened"
        to TutMainPage
        when: "user logins using valid credentials"
        login (TEST_USER_LOGIN, TEST_USER_PASSWORD)

        then: "login should be successful"
        waitFor {
            userNameSpan.text () == TEST_USER_NAME
        }
    }

}
