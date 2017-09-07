package com.company.project.adminweb.support.context;

import com.company.common.json.Jsons;
import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import com.google.common.io.CharStreams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * Json Request
 *
 * @author wangzhj
 */
public class JsonBodyRequest extends HttpServletRequestWrapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonBodyRequest.class);

    /**
     * 请求实体
     */
    private byte[] body = new byte[]{};
    /**
     * 请求参数
     */
    private Map<String, Object> param;

    public JsonBodyRequest(HttpServletRequest request) {
        super(request);
        String myBody = getBody(request);
        if (!Strings.isNullOrEmpty(myBody)) {
            //可重复读
            body = myBody.getBytes();
            //生成参数
            param = Jsons.fromJson(myBody);
        }
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream stream = new ByteArrayInputStream(body);
        return new ServletInputStream() {
            @Override
            public int read() throws IOException {
                return stream.read();
            }
        };
    }

    @Override
    public Map<String, Object> getParameterMap() {
        return this.param;
    }

    private String getBody(HttpServletRequest request) {
        String body = null;
        try {
            InputStream stream = request.getInputStream();
            InputStreamReader reader = new InputStreamReader(stream, Charsets.UTF_8);
            body = CharStreams.toString(reader);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return body;
    }
}
