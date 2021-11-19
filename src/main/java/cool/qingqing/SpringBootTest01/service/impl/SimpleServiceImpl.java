package cool.qingqing.SpringBootTest01.service.impl;

import cool.qingqing.SpringBootTest01.entity.Simple;
import cool.qingqing.SpringBootTest01.mapper.SimpleMapper;
import cool.qingqing.SpringBootTest01.service.ISimpleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 测试表 服务实现类
 * </p>
 *
 * @author gaoshanqing
 * @since 2021-11-14
 */
@Service
public class SimpleServiceImpl extends ServiceImpl<SimpleMapper, Simple> implements ISimpleService {

}
