package Pages.TutByPages

import geb.Page

class SearchResultsPage extends Page {
    static at = {
        title.startsWith ('TUT.BY | ПОИСК - Интернет')
    }

    static content = {
        searchResultsLinks { $ ("li[class='b-results__li'] h3 a[target='_blank']") }
        searchInput(wait: true) { $ ("#search_from_str") }
    }

    List<String> getResultLinkDescriptions() {
        searchResultsLinks.collect {it.getAttribute ("innerText")}
    }
}
