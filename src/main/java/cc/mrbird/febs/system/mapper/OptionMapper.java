package cc.mrbird.febs.system.mapper;

import cc.mrbird.febs.system.entity.Option;
import cc.mrbird.febs.system.entity.Question;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OptionMapper extends BaseMapper<Option> {
    /**
     * 通过题干内容查找试题

     */
    Option findByName(String content);

    /**
     * 查找试题详细信息

     */
    List<Option> findOptionDetail(@Param("option") Option option);


    <T> IPage<Option> findOptionDetailPage(Page<T> page, @Param("option") Option option);

    long countOptionDetail(@Param("option") Option option);
}
