package cool.qingqing.SpringBootTest01.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cool.qingqing.SpringBootTest01.entity.City;
import cool.qingqing.SpringBootTest01.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gaoshanqing
 * @since 2021-11-14
 */
@Controller
@RequestMapping("/SpringBootTest01/city")
public class CityController {
	@Autowired
	ICityService cityService;



	@GetMapping("/all")
	@ResponseBody
	public List<City> getAll(){
	return cityService.list();
	}

	@PostMapping("/getWhere/{current}/{size}")
	@ResponseBody
	public IPage<City> getWhere(@PathVariable("current") long current,
								@PathVariable("size") long size,
								@RequestBody City city){
		Page<City> page=new Page<>();
		page.setCurrent(current);
		page.setSize(size);
		return cityService.selectUserPage(page,city);
	}
}
