package Pages.TutByPages

import geb.Page

class TutMainPage extends Page {
    //static url = 'http://google.com/ncr'
    static at = {
        title == 'Белорусский портал TUT.BY'
    }


    static content = {
        enterButton { $('.enter') }
        loginField { $('[name="login"]') }
        passwordField { $('[name="password"]') }
        submitButtom { $('.button.auth__enter') }
        userNameSpan { $('.uname') }
        searchField { $('#search_from_str') }
        searchButton { $ ("[name='search'") }
    }

    void login(username, password) {
        enterButton.click()
        loginField = username
        passwordField = password
        submitButtom.click()
    }

}
