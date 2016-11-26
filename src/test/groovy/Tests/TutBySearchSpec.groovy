package Tests;

import Pages.SearchResultsPage;
import Pages.TutMainPage
import geb.spock.GebReportingSpec;
import spock.lang.Issue

@Issue(["Search issue"])
public class TutBySearchSpec extends GebReportingSpec {

    def "Search works at main page based on the criteria entered by user"() {
        setup:
        def searchCriteria = "Minsk"

        when: "User  goes to the main TUT.BY page"
        TutMainPage tutMainPage = to TutMainPage

        and: "enter search criteria"
        tutMainPage.searchField << searchCriteria
        tutMainPage.searchButton.click()

        then: "Page with search results appears"
        waitFor { at SearchResultsPage }

        and: "the page contains criteria previously defined in search input"
        SearchResultsPage searchResultsPage = browser.at SearchResultsPage
        waitFor {searchResultsPage.searchInput }
        assert searchResultsPage.searchInput.value() == searchCriteria

        and: "links found by the criteria actually contain criteria in name"
        println(searchResultsPage.searchResultsLinks.size())
        searchResultsPage.searchResultsLinks.each { link->
                println link.getAttribute("innerText").toString()
            assert link.getAttribute("innerText").contains(searchCriteria) ||
                    link.getAttribute("innerText").contains("Минск")||
                    link.getAttribute("innerText").contains("МИНСК")

        }

        //driver.close()
/*        cleanup:
        Thread.sleep(2000);
        Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");*/
    }
}