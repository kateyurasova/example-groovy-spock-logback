package Pages

import geb.Page

class TutMainPage extends Page {
    //static url = 'http://google.com/ncr'
    static at = {
        title ==  'Белорусский портал TUT.BY'
    }


    static content = {
        buttonEnter  {$('.enter')}
        fieldLogin  {$('[name="login"]')}
        fieldPassword {$('[name="password"]')}
        buttonSubmit  {$('.button.auth__enter')}
        spanUserName {$('.uname')}
    }

    void login(username, password) {
        buttonEnter.click()
        fieldLogin = username
        fieldPassword = password
        buttonSubmit.click()
}

}
