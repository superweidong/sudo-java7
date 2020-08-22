package com.shebao.sudojava7.wei.http;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;

/**
 * @author weidongge
 * @program sudo-java7
 * @description
 * @create 2020-08-22 16:58
 */
@Slf4j
public class OkHttpUtil {

    private static final String POST_URL = "http://hack.shebao.net/api/answerRecord/submit";

    private static final String GET_URL = "http://hack.shebao.net/api/getQuestions?group=JAVA7&quantity=";

    public static String doGet(int count){
        String url =  GET_URL + count;
        final Request request = new Request.Builder()
                .url(url)
                .build();
        System.out.println("get request params " + url);
        OkHttpClient okHttpClient = new OkHttpClient();
        final Call call = okHttpClient.newCall(request);
        String string = null;
        try {
            Response response = call.execute();
            string = response.body().string();
        }catch (Exception e){
            log.error("error", e);
        }

        return string;
    }

    public static String doPost(String body){
        OkHttpClient okHttpClient = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        String requestBody = JSON.toJSONString(body);
        System.out.println("请求 " + requestBody);
        Request request = new Request.Builder()
                .url(POST_URL)
                .post(RequestBody.create(mediaType, requestBody))
                .build();
        final String[] result = {null};
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("onFailure: " + e.getMessage());
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                result[0] = string;
                log.info("result {}", request);
            }
        });

        return result[0];
    }


}
