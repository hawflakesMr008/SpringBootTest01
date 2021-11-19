package cool.qingqing.SpringBootTest01.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cool.qingqing.SpringBootTest01.entity.City;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cool.qingqing.SpringBootTest01.entity.CityVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gaoshanqing
 * @since 2021-11-14
 */
@Mapper
public interface CityMapper extends BaseMapper<City> {
	List<City> selectPageVo(Page<?> page,City city);
}
