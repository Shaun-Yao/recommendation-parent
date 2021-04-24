package com.honji.recommendation.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.honji.recommendation.entity.Report;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ReportMapper extends BaseMapper<Report> {

    @Select({"<script>",
            "SELECT id, job_number, date, left(content, 10) content, left(comment, 10) comment FROM report ",
            " WHERE job_number = '${jobNumber}' and DATE_FORMAT(date, '%Y-%m') = '${month}' ",
            " ORDER BY date desc ",
            "</script>"})
    List<Report> selectForIndex(@Param("jobNumber")String jobNumber, @Param("month")String month);
}
