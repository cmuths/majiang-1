package com.hejinwei.majiang.dal.mybatis.mapper;

import com.hejinwei.majiang.dal.mybatis.model.SmsTemplate;
import com.hejinwei.majiang.dal.mybatis.model.SmsTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsTemplateMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_template
     *
     * @mbggenerated Fri Nov 13 11:44:16 CST 2015
     */
    int countByExample(SmsTemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_template
     *
     * @mbggenerated Fri Nov 13 11:44:16 CST 2015
     */
    int deleteByExample(SmsTemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_template
     *
     * @mbggenerated Fri Nov 13 11:44:16 CST 2015
     */
    int deleteByPrimaryKey(String templateId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_template
     *
     * @mbggenerated Fri Nov 13 11:44:16 CST 2015
     */
    int insert(SmsTemplate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_template
     *
     * @mbggenerated Fri Nov 13 11:44:16 CST 2015
     */
    int insertSelective(SmsTemplate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_template
     *
     * @mbggenerated Fri Nov 13 11:44:16 CST 2015
     */
    List<SmsTemplate> selectByExample(SmsTemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_template
     *
     * @mbggenerated Fri Nov 13 11:44:16 CST 2015
     */
    SmsTemplate selectByPrimaryKey(String templateId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_template
     *
     * @mbggenerated Fri Nov 13 11:44:16 CST 2015
     */
    int updateByExampleSelective(@Param("record") SmsTemplate record, @Param("example") SmsTemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_template
     *
     * @mbggenerated Fri Nov 13 11:44:16 CST 2015
     */
    int updateByExample(@Param("record") SmsTemplate record, @Param("example") SmsTemplateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_template
     *
     * @mbggenerated Fri Nov 13 11:44:16 CST 2015
     */
    int updateByPrimaryKeySelective(SmsTemplate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_template
     *
     * @mbggenerated Fri Nov 13 11:44:16 CST 2015
     */
    int updateByPrimaryKey(SmsTemplate record);
}