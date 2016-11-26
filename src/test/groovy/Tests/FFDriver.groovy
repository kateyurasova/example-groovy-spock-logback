package Tests

import org.openqa.selenium.firefox.FirefoxDriver

class FFDriver extends FirefoxDriver {

    @Override
    void quit() {
        Thread.sleep(2000);
        Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
    }
}
