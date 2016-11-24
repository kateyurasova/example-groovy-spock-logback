package Tests

import Pages.SearchResultsPage
import Pages.TutMainPage
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

    def "Search works at main page based on the criteria entered by user"() {
        when: "User user goes to the main TUT.BY page"
        TutMainPage tutMainPage = to TutMainPage

        and: "enter search criteria"
        tutMainPage.searchField << "Minsk"
        tutMainPage.searchButton.click()

        then: "Page with search results appears"
        SearchResultsPage searchResultsPage = browser.at SearchResultsPage
        and: "Search results contains word defined in the criteria"
        searchResultsPage.searchResultsLinks
       // println(searchResultsPage.searchResultsLinks.size())
        //searchResults.each(it.)

    }
}
