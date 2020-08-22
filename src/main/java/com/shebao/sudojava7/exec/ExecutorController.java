package com.shebao.sudojava7.exec;

import com.alibaba.fastjson.JSON;
import com.shebao.sudojava7.wei.vo.GetVo;
import com.shebao.sudojava7.wei.http.OkHttpUtil;
import com.shebao.sudojava7.wei.solution.Solution;
import com.shebao.sudojava7.wei.vo.PostVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weidongge
 * @program sudo-java7
 * @description
 * @create 2020-08-22 17:07
 */
@Slf4j
@Controller
public class ExecutorController {

    @GetMapping("exec")
    public String exec(int count){
        String s = OkHttpUtil.doGet(count);
        GetVo getVo = JSON.parseObject(s, GetVo.class);

        PostVo postVo = new PostVo();
        postVo.setRecordId(getVo.getRecordId());
        List<PostVo.QuestionDOSBean> questionDOSBeans = new ArrayList<>();

        for (GetVo.QuestionDOListBean questionDOListBean : getVo.getQuestionDOList()) {
            String question = questionDOListBean.getQuestion();
            System.out.println("问题 " + question);
            char[][] array = Solution.getArray(question);
            Solution.solveSudoku(array);
            System.out.println("解答 " + JSON.toJSONString(array));

            PostVo.QuestionDOSBean questionDOSBean = new PostVo.QuestionDOSBean();
            questionDOSBean.setQuestionId(questionDOListBean.getQuestionId());
            questionDOSBean.setAnswer(Solution.arrayToString(array));
            questionDOSBeans.add(questionDOSBean);
        }

        OkHttpUtil.doPost(JSON.toJSONString(postVo));
        return null;
    }
}
