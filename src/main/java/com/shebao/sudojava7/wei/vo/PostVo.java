package com.shebao.sudojava7.wei.vo;

import lombok.Data;

import java.util.List;

/**
 * @author weidongge
 * @program shebao-fenhao
 * @description
 * @create 2020-08-22 13:04
 */
@Data
public class PostVo {


    /**
     * recordId : 48
     * questionDOS : [{"questionId":230,"answer":"831497526296153487457826913312974865549682371768531294624318759973265148185749632"}]
     */

    private String recordId;
    private List<QuestionDOSBean> questionDOS;


    @Data
    public static class QuestionDOSBean {
        /**
         * questionId : 230
         * answer : 831497526296153487457826913312974865549682371768531294624318759973265148185749632
         */

        private int questionId;
        private String answer;

    }
}
