package Tests.TutByTests

import Pages.TutByPages.SearchResultsPage
import Pages.TutByPages.TutMainPage;
import geb.spock.GebReportingSpec
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Issue
import spock.lang.Unroll

@Issue(["Search issue"])
class TutBySearchSpec extends GebReportingSpec {
    final static Logger log = LoggerFactory.getLogger(TutBySearchSpec.class)
    @Unroll
    def "Search works at main page based on the criteria: #searchCriterion"(String searchCriterion, List resultFragments) {

        given: "Main page is opened"
        report("=== TUT MAIN PAGE ===")
        to TutMainPage

        when: "enter search criteria"
        log.debug("=== SEARCH CRITERIA ===")
        search (searchCriterion)

        then: "Page with search results appears"
        at SearchResultsPage

        and: "the page contains criteria previously defined in search input"
        searchInput.value () == searchCriterion

        and: "links found by the criteria actually contain criteria in name"
        getResultLinkDescriptions ().each { description ->
            assert resultFragments.any { description.contains (it) },
                    "Description [$description] doesn't contain any fragment"
        }

        where:
        searchCriterion | resultFragments
        'Minsk'         | ['Minsk', "Минск", "МИНСК"]
    }
}