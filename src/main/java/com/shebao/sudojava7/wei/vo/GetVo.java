package com.shebao.sudojava7.wei.vo;

import lombok.Data;

import java.util.List;

/**
 * @author weidongge
 * @program shebao-fenhao
 * @description
 * @create 2020-08-22 11:34
 */
@Data
public class GetVo {

    /**
     * recordId : 48
     * questionDOList : [{"questionId":230,"question":"800090520296100080000026010012074005009680001708530290020018050900200048085049632"}]
     */

    private String recordId;
    private List<QuestionDOListBean> questionDOList;

    @Data
    public static class QuestionDOListBean {
        /**
         * questionId : 230
         * question : 800090520296100080000026010012074005009680001708530290020018050900200048085049632
         */

        private int questionId;
        private String question;
    }
}
