package org.evolution.modules.website.entities;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author tanglijie
 * @since 2023-03-13
 */
@TableName("lnk_website")
public class Website extends Model<Website> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "row_id", type = IdType.INPUT)
    private Long rowId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 更新时间
     */
    private Date updateDate;
    /**
     * 版本
     */
    private String version;
    /**
     * 标题
     */
    private String title;
    /**
     * 描述
     */
    private String desc;
    /**
     * url
     */
    private String url;
    /**
     * 登录账号
     */
    private String loginAct;
    /**
     * 登录密码
     */
    private String loginPword;


    public Long getRowId() {
        return rowId;
    }

    public void setRowId(Long rowId) {
        this.rowId = rowId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLoginAct() {
        return loginAct;
    }

    public void setLoginAct(String loginAct) {
        this.loginAct = loginAct;
    }

    public String getLoginPword() {
        return loginPword;
    }

    public void setLoginPword(String loginPword) {
        this.loginPword = loginPword;
    }

    @Override
    protected Serializable pkVal() {
        return this.rowId;
    }

    @Override
    public String toString() {
        return "Website{" +
        ", rowId=" + rowId +
        ", createDate=" + createDate +
        ", updateDate=" + updateDate +
        ", version=" + version +
        ", title=" + title +
        ", desc=" + desc +
        ", url=" + url +
        ", loginAct=" + loginAct +
        ", loginPword=" + loginPword +
        "}";
    }
}
