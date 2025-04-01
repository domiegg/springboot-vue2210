package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.JiechexinxiEntity;
import com.entity.view.JiechexinxiView;

import com.service.JiechexinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 借车信息
 * 后端接口
 * @author 
 * @email 
 * @date 2021-01-20 17:21:57
 */
@RestController
@RequestMapping("/jiechexinxi")
public class JiechexinxiController {
    @Autowired
    private JiechexinxiService jiechexinxiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiechexinxiEntity jiechexinxi, HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zhandianguanliyuan")) {
			jiechexinxi.setZhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			jiechexinxi.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiechexinxiEntity> ew = new EntityWrapper<JiechexinxiEntity>();
		PageUtils page = jiechexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiechexinxi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiechexinxiEntity jiechexinxi, HttpServletRequest request){
        EntityWrapper<JiechexinxiEntity> ew = new EntityWrapper<JiechexinxiEntity>();
		PageUtils page = jiechexinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiechexinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiechexinxiEntity jiechexinxi){
       	EntityWrapper<JiechexinxiEntity> ew = new EntityWrapper<JiechexinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiechexinxi, "jiechexinxi")); 
        return R.ok().put("data", jiechexinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiechexinxiEntity jiechexinxi){
        EntityWrapper< JiechexinxiEntity> ew = new EntityWrapper< JiechexinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiechexinxi, "jiechexinxi")); 
		JiechexinxiView jiechexinxiView =  jiechexinxiService.selectView(ew);
		return R.ok("查询借车信息成功").put("data", jiechexinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiechexinxiEntity jiechexinxi = jiechexinxiService.selectById(id);
        return R.ok().put("data", jiechexinxi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiechexinxiEntity jiechexinxi = jiechexinxiService.selectById(id);
        return R.ok().put("data", jiechexinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiechexinxiEntity jiechexinxi, HttpServletRequest request){
    	jiechexinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiechexinxi);

        jiechexinxiService.insert(jiechexinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiechexinxiEntity jiechexinxi, HttpServletRequest request){
    	jiechexinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiechexinxi);

        jiechexinxiService.insert(jiechexinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody JiechexinxiEntity jiechexinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiechexinxi);
        jiechexinxiService.updateById(jiechexinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiechexinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<JiechexinxiEntity> wrapper = new EntityWrapper<JiechexinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zhandianguanliyuan")) {
			wrapper.eq("zhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuming", (String)request.getSession().getAttribute("username"));
		}

		int count = jiechexinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
