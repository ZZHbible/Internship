package cc.mrbird.febs.system.service.impl;


import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.SortUtil;
import cc.mrbird.febs.system.entity.Option;
import cc.mrbird.febs.system.mapper.OptionMapper;
import cc.mrbird.febs.system.service.IOptionService;
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

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class OptionServiceImpl extends ServiceImpl<OptionMapper, Option> implements IOptionService {
    @Override
    public Option findByName(String content) {
        return this.baseMapper.findByName(content);
    }

    @Override
    public IPage<Option> findOptionDetailList(Option option, QueryRequest request) {

        Page<Option> page = new Page<>(request.getPageNum(), request.getPageSize());
        page.setSearchCount(false);
        page.setTotal(baseMapper.countOptionDetail(option));
        SortUtil.handlePageSort(request, page, "mId", FebsConstant.ORDER_ASC, false);
        return this.baseMapper.findOptionDetailPage(page, option);
    }

    @Override
    public Option findOptionDetailList(String content) {
        Option param = new Option();
        param.setContent(content);
        List<Option> Options = this.baseMapper.findOptionDetail(param);
        return CollectionUtils.isNotEmpty(Options) ? Options.get(0) : null;
    }



    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean createOption(Option Option) {
        if(save(Option)){return true;}
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteOptions(String[] mIds) {
        List<String> list = Arrays.asList(mIds);
        // 删除用户
        this.removeByIds(list);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateOption(Option Option) {
        String content = Option.getContent();
        // 更新用户
        updateById(Option);

    }
}
