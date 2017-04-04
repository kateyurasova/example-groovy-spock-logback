package util

import com.google.common.io.BaseEncoding
import geb.report.ReportState
import geb.report.Reporter
import geb.report.ReportingListener
import geb.report.ScreenshotReporter
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import static com.google.common.io.Resources.asByteSource

class RpScreenshotListener implements  ReportingListener{
    @Override
    void onReport(Reporter reporter, ReportState reportState, List<File> reportFiles) {
        final Logger log = LoggerFactory.getLogger(RpScreenshotListener.class)
        if (reporter instanceof ScreenshotReporter) {
            def content =  asByteSource(reportFiles.first().toURI().toURL()).read();
            //def file = BaseEncoding.base64().encode(content);
            log.debug("RP_MESSAGE#BASE64#${BaseEncoding.base64().encode(content)}#${reportState.label}");
        }
    }
}
