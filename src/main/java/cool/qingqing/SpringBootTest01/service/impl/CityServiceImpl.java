package cool.qingqing.SpringBootTest01.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cool.qingqing.SpringBootTest01.entity.City;
import cool.qingqing.SpringBootTest01.entity.CityVo;
import cool.qingqing.SpringBootTest01.mapper.CityMapper;
import cool.qingqing.SpringBootTest01.service.ICityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gaoshanqing
 * @since 2021-11-14
 */
@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements ICityService {
@Autowired
CityMapper cityMapper;

	@Override
	public IPage<City> selectUserPage(Page<City> page, City city) {
		List<City> list= cityMapper.selectPageVo(page,city);

		return page.setRecords(list);
	}
}
