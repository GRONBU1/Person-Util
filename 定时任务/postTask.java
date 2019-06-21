package cn.xiongdi.ocdm.server.controller.api.task;

import cn.xiongdi.ocdm.mapper.dao.BggDeviceMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("postTask")
public class postTask {
    @Autowired
    private BggDeviceMapper bggDeviceMapper;
    private static final Logger logger = LoggerFactory.getLogger(SchedulingRunnable.class);

    public void checkHeartTask() {
        logger.info("===========定时任务开始===========");
        if (bggDeviceMapper.updateDevice()>0){
            logger.info("*********设备失常*********");
        }
        logger.info("===========定时任务结束===========");
    }
}
