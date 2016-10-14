import geb.Page

class GebishOrgHomePage extends Page {

    //static url = "http://google.com/ncr"
    static at = { title == "Geb - Very Groovy Browser Automation" }

    static content = {
        manualsMenu { $("#header-content ul li", 0).module(MenuModule) }
    }
}
