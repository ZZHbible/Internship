package cc.mrbird.febs.system.service;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.system.entity.Question;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author XiaoMingliang
 *
 * 第四步
 *  参考IUserService 类，完成此接口
 *  同样也需要在impl文件夹内， 建立QuestionServiceImpl文件。
 *
 *  第五步
 *    进入 QuestionController中，添加数据请求的方法，
 *    并在该方法中，使用 IQuestionService中的查询方法
 */
public interface IQuestionService extends IService<Question> {

    /**
     * 通过题干查找题目
     */
    Question findByName(String questionTitle);
    IPage<Question> findQuestionDetailList(Question question, QueryRequest request);
    Question findQuestionDetailList(String QuestionTitle);
    /**
     * 新增题目
     */
    boolean createQuestion(Question question);
    /**
     * 删除题目
       */
    void deleteQuestions(String[] questionIDs);
    /**
     * 修改题目
     */
    void updateQuestion(Question question);
}
