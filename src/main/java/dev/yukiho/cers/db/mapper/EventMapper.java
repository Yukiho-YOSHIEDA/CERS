package dev.yukiho.cers.db.mapper;

import dev.yukiho.cers.db.model.Event;
import dev.yukiho.cers.db.model.EventExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EventMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table event
     *
     * @mbg.generated Thu Mar 19 06:14:21 JST 2020
     */
    long countByExample(EventExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table event
     *
     * @mbg.generated Thu Mar 19 06:14:21 JST 2020
     */
    int deleteByExample(EventExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table event
     *
     * @mbg.generated Thu Mar 19 06:14:21 JST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table event
     *
     * @mbg.generated Thu Mar 19 06:14:21 JST 2020
     */
    int insert(Event record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table event
     *
     * @mbg.generated Thu Mar 19 06:14:21 JST 2020
     */
    int insertSelective(Event record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table event
     *
     * @mbg.generated Thu Mar 19 06:14:21 JST 2020
     */
    List<Event> selectByExample(EventExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table event
     *
     * @mbg.generated Thu Mar 19 06:14:21 JST 2020
     */
    Event selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table event
     *
     * @mbg.generated Thu Mar 19 06:14:21 JST 2020
     */
    int updateByExampleSelective(@Param("record") Event record, @Param("example") EventExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table event
     *
     * @mbg.generated Thu Mar 19 06:14:21 JST 2020
     */
    int updateByExample(@Param("record") Event record, @Param("example") EventExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table event
     *
     * @mbg.generated Thu Mar 19 06:14:21 JST 2020
     */
    int updateByPrimaryKeySelective(Event record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table event
     *
     * @mbg.generated Thu Mar 19 06:14:21 JST 2020
     */
    int updateByPrimaryKey(Event record);
}