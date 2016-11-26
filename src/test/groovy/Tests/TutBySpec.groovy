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

    def "Search works at main page based on the criteria entered by user"() {
        setup:
        def searchCriteria = "Minsk"

        when: "User  goes to the main TUT.BY page"
        TutMainPage tutMainPage = to TutMainPage

        and: "enter search criteria"
        tutMainPage.searchField << searchCriteria
        tutMainPage.searchButton.click()

        then: "Page with search results appears"
        //def searchResultsPage
        waitFor {
            at SearchResultsPage
        }

        and: "the page contains criteria previously defined in search input"
        SearchResultsPage searchResultsPage = browser.at SearchResultsPage
        waitFor {
            searchResultsPage.searchInput
        }
        assert searchResultsPage.searchInput.value() == searchCriteria

        and: "links found by the criteria actually contain criteria in name"
        println(searchResultsPage.searchResultsLinks.size())
        searchResultsPage.searchResultsLinks.each {
            println it.getAttribute("innerText").toString()
            assert it.getAttribute("innerText").contains(searchCriteria) ||
                    it.getAttribute("innerText").contains("Минск")||
                    it.getAttribute("innerText").contains("МИНСК")
        }

    }
}
