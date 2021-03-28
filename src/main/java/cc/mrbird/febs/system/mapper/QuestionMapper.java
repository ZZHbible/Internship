package cc.mrbird.febs.system.mapper;

import cc.mrbird.febs.system.entity.Question;
import cc.mrbird.febs.system.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author XiaoMingliang
 *
 * 第三步
 * 此文件为interface 文件。
 * 在此文件中，定义了对数据库的查询操作的方法。
 * 并且方法的名称，与同名的 .xml中的 标签相对应
 * 注意：xml文件，需要人工撰写
 *
 * 第四步 完成 service。
 * 在service 文件夹内，建立接口文件，
 * 在impl文件夹内 接口文件的实现类。
 *
 *
 *
 *
 *
 */
public interface QuestionMapper extends BaseMapper<Question> {

    /**
     * 通过题干内容查找试题

     */
    Question findByName(String questionTitle);

    /**
     * 查找试题详细信息

     */
    List<Question> findQuestionDetail(@Param("question") Question question);


    <T> IPage<Question> findQuestionDetailPage(Page<T> page, @Param("question") Question question);

    long countQuestionDetail(@Param("question") Question question);

}
