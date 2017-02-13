package Tests.Geb

import geb.spock.GebReportingSpec

/*class Tests.Geb.GebishOrgSpec extends GebReportingSpec {

    def "can get to the current Book of Geb"() {
        when:
        to Tests.Geb.GebishOrgHomePage

        and: //hover over to expand the menu
        interact {
            moveToElement(manualsMenu.toggle)
        }

        then: //first link is for the current manual
        manualsMenu.links[0].text().endsWith("- CURRENT")

        when:
        manualsMenu.links[0].click()

        then:
        at Tests.Geb.TheBookOfGebPage
    }
}*/