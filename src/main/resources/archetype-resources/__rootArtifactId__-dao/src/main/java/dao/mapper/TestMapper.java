package ${package}.dao.mapper;

import ${package}.dao.entity.Test;
import ${package}.dao.entity.TestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestMapper {
    long countByExample(TestExample example);

    int deleteByExample(TestExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Test row);

    int insertSelective(Test row);

    List<Test> selectByExample(TestExample example);

    Test selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") Test row, @Param("example") TestExample example);

    int updateByExample(@Param("row") Test row, @Param("example") TestExample example);

    int updateByPrimaryKeySelective(Test row);

    int updateByPrimaryKey(Test row);
}