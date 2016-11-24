package Pages

import geb.Page

public class SearchResultsPage extends Page {
    static at = { title.startsWith('TUT.BY | ПОИСК - Интернет') }

    static content = {
        searchResultsLinks { $("li[class='b-results__li'] h3 a[target='_blank']") }
    }
}
