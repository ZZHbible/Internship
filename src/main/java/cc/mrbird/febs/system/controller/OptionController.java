package cc.mrbird.febs.system.controller;

import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.system.entity.Option;
import cc.mrbird.febs.system.entity.Question;
import cc.mrbird.febs.system.service.IOptionService;
import cc.mrbird.febs.system.service.IQuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("option")
public class OptionController extends BaseController {
    private final IOptionService optionService;
    @GetMapping("list")
    //@RequiresPermissions("user:view")
    public FebsResponse optionList(Option option, QueryRequest request) {
        Map<String, Object> dataTable = getDataTable(this.optionService.findOptionDetailList(option, request));
        return new FebsResponse().success().data(dataTable);
    }


}
