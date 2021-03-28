package cc.mrbird.febs.system.entity;

import cc.mrbird.febs.common.annotation.Desensitization;
import cc.mrbird.febs.common.annotation.IsMobile;
import cc.mrbird.febs.common.converter.TimeConverter;
import cc.mrbird.febs.common.entity.DesensitizationType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * @author XiaoMingliang
 * 第二步：
 * 根据在数据库中的table，及其字段，
 * 在此类中添加对应的属性。
 * 每个属性，对应table中的一个字段。
 * 属性和字段的名称，几乎一致。
 *
 * 第三步，准备建立mapper文件，
 * mapper文件分为两个部分。
 * 以 .java 结尾和 .xml结尾。
 * 两个文件同名，分别保存在不同的目录下
 *
 */
@Data
@TableName("m_question")
public class Question implements Serializable {

    private static final long serialVersionUID = -4352868070794165001L;

    /**
     * 试题 ID
     */
    @TableId(value = "question_id", type = IdType.AUTO)
    private Long questionId;

    /**
     * 题干内容
     */
    @TableField("question_title")
    private String questionTitle;

    /**
     * 试题分数
     */
    @TableField("question_score")
    private String questionScore;


    public Long getId() {
        return questionId;
    }
}
