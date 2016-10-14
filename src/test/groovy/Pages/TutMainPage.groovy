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

}
