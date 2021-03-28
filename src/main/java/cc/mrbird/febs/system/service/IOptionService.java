package cc.mrbird.febs.system.service;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.system.entity.Option;
import cc.mrbird.febs.system.entity.Question;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IOptionService extends IService<Option> {
    /**
     * 通过题干查找题目
     */
    Option findByName(String content);
    IPage<Option> findOptionDetailList(Option option, QueryRequest request);
    Option findOptionDetailList(String content);
    /**
     * 新增题目
     */
    boolean createOption(Option option);
    /**
     * 删除题目
     */
    void deleteOptions(String[] optionIDs);
    /**
     * 修改题目
     */
    void updateOption(Option option);
}
