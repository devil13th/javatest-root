package com.thd.bi.cfg;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * com.lenovo.dqm.bi.cfg.RtfCfg
 *
 * @author: wanglei62
 * @DATE: 2020/2/4 10:22
 **/
@ConfigurationProperties(prefix = "rtf")
@Component
@Data
public class RtfCfg {
    private String rtfTemplateFolderPath;
    private String targetFolderPath;
    private String xdoFilePath;
    private String fontFolderPath;
    private String tempFolderPath;
}
