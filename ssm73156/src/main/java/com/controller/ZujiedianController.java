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

import com.entity.ZujiedianEntity;
import com.entity.view.ZujiedianView;

import com.service.ZujiedianService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 租借点
 * 后端接口
 * @author 
 * @email 
 * @date 2021-01-20 17:21:57
 */
@RestController
@RequestMapping("/zujiedian")
public class ZujiedianController {
    @Autowired
    private ZujiedianService zujiedianService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZujiedianEntity zujiedian, HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zhandianguanliyuan")) {
			zujiedian.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZujiedianEntity> ew = new EntityWrapper<ZujiedianEntity>();
		PageUtils page = zujiedianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zujiedian), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZujiedianEntity zujiedian, HttpServletRequest request){
        EntityWrapper<ZujiedianEntity> ew = new EntityWrapper<ZujiedianEntity>();
		PageUtils page = zujiedianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zujiedian), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZujiedianEntity zujiedian){
       	EntityWrapper<ZujiedianEntity> ew = new EntityWrapper<ZujiedianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zujiedian, "zujiedian")); 
        return R.ok().put("data", zujiedianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZujiedianEntity zujiedian){
        EntityWrapper< ZujiedianEntity> ew = new EntityWrapper< ZujiedianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zujiedian, "zujiedian")); 
		ZujiedianView zujiedianView =  zujiedianService.selectView(ew);
		return R.ok("查询租借点成功").put("data", zujiedianView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZujiedianEntity zujiedian = zujiedianService.selectById(id);
        return R.ok().put("data", zujiedian);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZujiedianEntity zujiedian = zujiedianService.selectById(id);
        return R.ok().put("data", zujiedian);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZujiedianEntity zujiedian, HttpServletRequest request){
    	zujiedian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zujiedian);

        zujiedianService.insert(zujiedian);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZujiedianEntity zujiedian, HttpServletRequest request){
    	zujiedian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zujiedian);

        zujiedianService.insert(zujiedian);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ZujiedianEntity zujiedian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zujiedian);
        zujiedianService.updateById(zujiedian);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zujiedianService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ZujiedianEntity> wrapper = new EntityWrapper<ZujiedianEntity>();
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

		int count = zujiedianService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
