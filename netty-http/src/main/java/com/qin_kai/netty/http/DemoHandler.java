package com.qin_kai.netty.http;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author qinkai
 * @date 2023/9/20
 */
@Business("/demo")
@Slf4j
public class DemoHandler implements BusinessHandler<DemoHandler.DemoData> {

    @Data
    public static class DemoData {
        private String s;
    }

    @Override
    public JsonResult<String> handle(DemoData data) {
        log.info("s=={}", data.getS());
        return JsonResult.success("ok");
    }
}
