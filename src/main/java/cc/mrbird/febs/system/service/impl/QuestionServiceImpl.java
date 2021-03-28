package cc.mrbird.febs.system.service.impl;


import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.SortUtil;
import cc.mrbird.febs.system.entity.Question;
import cc.mrbird.febs.system.mapper.QuestionMapper;
import cc.mrbird.febs.system.service.IQuestionService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Arrays;
import java.util.List;

/**
 * @author MrBird
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements IQuestionService {


    @Override
    public Question findByName(String questionTitle) {
        return this.baseMapper.findByName(questionTitle);
    }

    @Override
    public IPage<Question> findQuestionDetailList(Question Question, QueryRequest request) {

        Page<Question> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(baseMapper.countQuestionDetail(Question));
        SortUtil.handlePageSort(request, page, "QuestionId", FebsConstant.ORDER_ASC, false);
        return this.baseMapper.findQuestionDetailPage(page, Question);
    }

    @Override
    public Question findQuestionDetailList(String Questionname) {
        Question param = new Question();
        param.setQuestionTitle(Questionname);
        List<Question> Questions = this.baseMapper.findQuestionDetail(param);
        return CollectionUtils.isNotEmpty(Questions) ? Questions.get(0) : null;
    }



    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean createQuestion(Question Question) {
           if(save(Question)){return true;}
           return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteQuestions(String[] QuestionIds) {
        List<String> list = Arrays.asList(QuestionIds);
        // 删除用户
        this.removeByIds(list);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateQuestion(Question Question) {
        String questionTitle = Question.getQuestionTitle();
        // 更新用户
        updateById(Question);

    }


}
