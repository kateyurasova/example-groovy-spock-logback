package Pages.BankingPages

import geb.Page

class BankLoginPage extends Page {
    static url = "http://www.way2automation.com/angularjs-protractor/banking/#/login"
    static at = { title == "Protractor practice website - Banking App" }

    static content = {
        customerLoginButton {$("button[ng-click='customer()']")}
        yourNameSelect {$("#userSelect")}
        yourNameSelectOp {"#userSelect option"}
        loginButton {$(".btn.btn-default")}
        userNameSpan {$(".fontBig.ng-binding")}
        el {$("select", name : "userSelect")}

        //searchButton { $ ("[name='search'") }
    }

    void login(username) {

        waitFor {customerLoginButton.displayed}
        customerLoginButton.click()
        waitFor {yourNameSelect.displayed}
        //yourNameSelect = username
        //$("form div").userSelect = username
        el.value(username)

        //yourNameSelect.value(username)
        //yourNameSelectOp = 2
        loginButton.click()
        waitFor {userNameSpan.text() == username}
    }
}
