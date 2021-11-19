package cool.qingqing.SpringBootTest01.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cool.qingqing.SpringBootTest01.entity.City;
import com.baomidou.mybatisplus.extension.service.IService;
import cool.qingqing.SpringBootTest01.entity.CityVo;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gaoshanqing
 * @since 2021-11-14
 */
public interface ICityService extends IService<City> {
	public IPage<City> selectUserPage(Page<City> page, City city);
}
