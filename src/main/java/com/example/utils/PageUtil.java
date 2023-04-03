package com.example.utils;

import com.github.pagehelper.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @param <T> 此处的形参类型T与ResultVo<T>不是同一个T
 */
@Data
public class PageUtil<T> {
    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页")
    private Integer currentPage = 1;

    /**
     * 每页记录数
     */
    @ApiModelProperty(value = "每页记录数")
    private Integer pageSize = 10;

    /**
     * 总条数 ，此处类型不为Long ，方便int类型直接量向其赋值，隐式类型转换
     */
    @ApiModelProperty(value = "总条数")
    private long totalNum;

    /**
     * 总页数
     */
    @ApiModelProperty(value = "总页数")
    private long totalPage;

    /**
     * 返回结果，此处的形参类型T与ResultVo<T>不是同一个T,该T为List的泛型而已
     */
    @ApiModelProperty(value = "返回结果")
    private List<T> data;

    public PageUtil() {
        super();
    }

    public PageUtil(Integer currentPage, Integer pageSize, Long totalNum, Long totalPage, List<T> data) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalNum = totalNum;
        this.totalPage = totalPage;
        this.data = data;
    }

    public PageUtil(Integer currentPage, Integer pageSize, Long totalNum) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalNum = totalNum;
        //判断总页数的算法
        this.totalPage = (this.totalNum + this.pageSize - 1) / this.pageSize;
    }

    public PageUtil(List<T> list) {
        //使用分页，list不是null，且运行时类型为Page类或其子类
        if (list instanceof Page) {
            Page<T> page = (Page<T>) list;
            this.currentPage = page.getPageNum();
            this.pageSize = page.getPageSize();

            this.totalPage = page.getPages();
            this.data = page;
            this.totalNum = page.getTotal();
        } else if (list != null) { //不使用分页，list不为null即可，此时的只有一页，故页码为1，该页长度为list.size()
            this.currentPage = 1;
            this.pageSize = list.size();
            this.totalPage = 1;
            this.data = list;
            this.totalNum = list.size();
        }
    }
}
