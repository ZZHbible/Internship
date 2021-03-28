package cc.mrbird.febs.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("m_option")
public class Option {
    private static final long serialVersionUID = -4352868070794165001L;

    /**
     * 选项 ID
     */
    @TableId(value = "mid", type = IdType.AUTO)
    private Long mId;

    /**
     * 选项内容
     */
    @TableField("content")
    private String content;


    public Long getId() {
        return mId;
    }
}
